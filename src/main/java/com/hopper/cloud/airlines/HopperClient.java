package com.hopper.cloud.airlines;

import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;
import com.hopper.cloud.airlines.api.SessionsApi;
import com.hopper.cloud.airlines.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HopperClient {
    private final CancelForAnyReasonCfarApi cfarApi;
    private final SessionsApi sessionsApi;

    public HopperClient(String url, String clientId, String clientSecret, Boolean debugging) {

        Map<String, String> params = new HashMap<>();
        params.put("audience", "https://airlines-api.development.hopper.com");
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

    }

    /**
     * It has to be called after the payment details have been transferred, to confirm the contract.
     * @param contractId the contract ID
     * @param updateCfarContractRequest The request with the update information
     * @param sessionId The current session IO
     * @return The contract updated
     * @throws ApiException
     */
    public CfarContract updateCfarContractStatus(String contractId, UpdateCfarContractRequest updateCfarContractRequest, String sessionId) throws ApiException {
        return cfarApi.putCfarContractsIdUpdateStatus(contractId, updateCfarContractRequest, sessionId);
    }

    /**
     * It has to be called each time an end-customer begins shopping on the AC website.
     * The returned sessionId will then be required in all subsequent calls to the API from the backend
     * @param createAirlineSessionRequest information to create session
     * @return the session ID
     * @throws ApiException
     */
    public AirlineSession createSession(CreateAirlineSessionRequest createAirlineSessionRequest) throws ApiException {
        return sessionsApi.postSessions(createAirlineSessionRequest);
    }

    public List<CfarOffer> createOffers(CreateCfarOfferRequest createCfarOfferRequest, String sessionId) throws ApiException {
        return cfarApi.postCfarOffers(createCfarOfferRequest,sessionId);
    }

    public CfarContract createCfarContract(CreateCfarContractRequest createCfarContractRequest, String sessionId) throws ApiException {
        return cfarApi.postCfarContracts(createCfarContractRequest,sessionId,false);
    }

    public CfarContract getContract(String contractId, String sessionId) throws ApiException {
        return cfarApi.getCfarContractsId(contractId, sessionId);
    }

    public CfarContractExercise creatCfarContractExercise(CreateCfarContractExerciseRequest createCfarContractExerciseRequest, String sessionId) throws ApiException {
        return cfarApi.postCfarContractExercises(createCfarContractExerciseRequest,sessionId);
    }

    public CfarContractExercise completeCfarContractExercise(MarkCfarContractExerciseCompleteRequest markCfarContractExerciseCompleteRequest, String contractId, String sessionId) throws ApiException {
        return cfarApi.putCfarContractExercisesIdMarkCompleted(contractId,markCfarContractExerciseCompleteRequest,sessionId);
    }
}
