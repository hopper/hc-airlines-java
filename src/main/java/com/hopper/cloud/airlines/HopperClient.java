package com.hopper.cloud.airlines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;
import com.hopper.cloud.airlines.api.SessionsApi;
import com.hopper.cloud.airlines.auth.OAuth;
import com.hopper.cloud.airlines.auth.RetryingOAuth;
import com.hopper.cloud.airlines.model.*;
import kong.unirest.HttpResponse;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

import java.io.IOException;
import java.util.*;


public class HopperClient {
    private final CancelForAnyReasonCfarApi cfarApi;
    private final SessionsApi sessionsApi;
    private final String pciProxyUrl;

    public HopperClient(String url, String clientId, String clientSecret, String pciProxyUrl, Boolean debugging) {
        this.pciProxyUrl = pciProxyUrl;
        Map<String, String> params = new HashMap<>();
        params.put("audience", String.join("/", Arrays.asList(url.split("/")).subList(0, 3)));
        params.put("grant_type", "client_credentials");
        ApiClient apiClient = new ApiClient(clientId, clientSecret, params);
        cfarApi = new CancelForAnyReasonCfarApi(apiClient);
        cfarApi.getApiClient().setDebugging(debugging);
        cfarApi.getApiClient().setBasePath(url);
        cfarApi.getApiClient().setConnectTimeout(60000);
        cfarApi.getApiClient().setReadTimeout(60000);
        cfarApi.getApiClient().setWriteTimeout(60000);

        sessionsApi = new SessionsApi(apiClient);
        sessionsApi.getApiClient().setDebugging(debugging);
        sessionsApi.getApiClient().setBasePath(url);
        sessionsApi.getApiClient().setConnectTimeout(60000);
        sessionsApi.getApiClient().setReadTimeout(60000);
        sessionsApi.getApiClient().setWriteTimeout(60000);


        Unirest.config().setObjectMapper(new ObjectMapper() {
            com.fasterxml.jackson.databind.ObjectMapper mapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public String writeValue(Object value) {
                try {
                    return mapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return mapper.readValue(value, valueType);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        }).connectTimeout(60000).socketTimeout(60000);

    }

    /**
     * It has to be called after the payment details have been transferred, to confirm the contract.
     *
     * @param sessionId                 The current session IO
     * @param contractId                the contract ID
     * @param updateCfarContractRequest The request with the update information
     * @return The contract updated
     * @throws ApiException
     */
    public CfarContract updateCfarContractStatus(String sessionId, String contractId, UpdateCfarContractRequest updateCfarContractRequest) throws ApiException {
        return cfarApi.putCfarContractsIdUpdateStatus(contractId, updateCfarContractRequest, sessionId);
    }

    /**
     * It has to be called each time an end-customer begins shopping on the AC website.
     * The returned sessionId will then be required in all subsequent calls to the API from the backend
     *
     * @param createAirlineSessionRequest information to create session
     * @return the session ID
     * @throws ApiException
     */
    public AirlineSession createSession(CreateAirlineSessionRequest createAirlineSessionRequest) throws ApiException {
        return sessionsApi.postSessions(createAirlineSessionRequest);
    }

    public List<CfarOffer> createOffers(String sessionId, CreateCfarOfferRequest createCfarOfferRequest) throws ApiException {
        return cfarApi.postCfarOffers(createCfarOfferRequest, sessionId);
    }

    public CfarContract createCfarContract(String sessionId, CreateCfarContractRequest createCfarContractRequest) throws ApiException {
        return cfarApi.postCfarContracts(createCfarContractRequest, sessionId, false);
    }

    /**
     * Called to retrieve details of a contract in order to update the shopping cart with the right amount
     * Parameters
     *
     * @param sessionId  The current session IO
     * @param contractId the contract Id
     * @return The corresponding contract
     * @throws ApiException
     */
    public CfarContract getContract(String sessionId, String contractId) throws ApiException {
        return cfarApi.getCfarContractsId(contractId, sessionId);
    }

    public boolean processCfarPayment(String sessionId, String contractId, ProcessCfarPaymentRequest processCfarPaymentRequest) throws ApiException {
        try {
            HttpResponse<ProcessCfarPayment> response = getProcessCfarPaymentHttpResponse(sessionId, contractId, processCfarPaymentRequest);
            if (response.getStatus() == 401) {
                refreshAuthentificationToken();
                response = getProcessCfarPaymentHttpResponse(sessionId, contractId, processCfarPaymentRequest);
            }
            if (response.getStatus() == 200) {
                return response.getBody().isSucceeded();
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }

    }

    private void refreshAuthentificationToken() throws IOException {
        RetryingOAuth partnerAuth = (RetryingOAuth) (cfarApi.getApiClient().getAuthentication("PartnerAuth"));
        String currentToken = partnerAuth.getAccessToken();
        partnerAuth.updateAccessToken(currentToken);
    }

    private HttpResponse<ProcessCfarPayment> getProcessCfarPaymentHttpResponse(String sessionId, String contractId, ProcessCfarPaymentRequest processCfarPaymentRequest) {
        Map<String, String> headers = new HashMap<>();
        headers.put("HC-Session-ID", sessionId);
        headers.put("Content-Type", "application/json");
        OAuth partnerAuth = (RetryingOAuth) (cfarApi.getApiClient().getAuthentication("PartnerAuth"));
        headers.put("Authorization", "Bearer " + partnerAuth.getAccessToken());
        return Unirest.post(pciProxyUrl + contractId + "/payment")
                .headers(headers)
                .body(processCfarPaymentRequest)
                .asObject(ProcessCfarPayment.class);
    }

    public CfarContractExercise createCfarContractExercise(String sessionId, CreateCfarContractExerciseRequest createCfarContractExerciseRequest) throws ApiException {
        return cfarApi.postCfarContractExercises(createCfarContractExerciseRequest, sessionId);
    }

    public CfarContractExercise completeCfarContractExercise(String sessionId, MarkCfarContractExerciseCompleteRequest markCfarContractExerciseCompleteRequest, String contractId) throws ApiException {
        return cfarApi.putCfarContractExercisesIdMarkCompleted(contractId, markCfarContractExerciseCompleteRequest, sessionId);
    }
}
