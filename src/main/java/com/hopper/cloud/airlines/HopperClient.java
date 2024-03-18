package com.hopper.cloud.airlines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;
import com.hopper.cloud.airlines.api.SessionsApi;
import com.hopper.cloud.airlines.api.AnalyticsApi;
import com.hopper.cloud.airlines.model.*;
import com.hopper.cloud.airlines.model.tokenization.*;
import com.hopper.cloud.airlines.model.tokenization.PaymentMethod;
import kong.unirest.HttpResponse;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

import java.util.*;


public class HopperClient {
    private CancelForAnyReasonCfarApi cfarApi;
    private SessionsApi sessionsApi;
    private AnalyticsApi analyticsApi;
    private String paymentUrl;
    private String paymentUsername;
    private String paymentPassword;

    public HopperClient(String url, String clientId, String clientSecret, Boolean debugging) {
        this.initHopperClient(url, clientId, clientSecret, null, null, null, debugging);
    }

    public HopperClient(String url, String clientId, String clientSecret, String paymentUrl, String paymentUsername, String paymentPassword, Boolean debugging) {
        this.initHopperClient(url, clientId, clientSecret, paymentUrl, paymentUsername, paymentPassword, debugging);
    }

    private void initHopperClient(String url, String clientId, String clientSecret, String paymentUrl, String paymentUsername, String paymentPassword, Boolean debugging) {
        this.paymentUrl = paymentUrl;
        this.paymentUsername = paymentUsername;
        this.paymentPassword = paymentPassword;
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

        analyticsApi = new AnalyticsApi(apiClient);
        analyticsApi.getApiClient().setDebugging(debugging);
        analyticsApi.getApiClient().setBasePath(url);
        analyticsApi.getApiClient().setConnectTimeout(60000);
        analyticsApi.getApiClient().setReadTimeout(60000);
        analyticsApi.getApiClient().setWriteTimeout(60000);

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
        return cfarApi.postCfarContracts(createCfarContractRequest, sessionId);
    }

    public CreateSessionOffersContractsResponse createSessionOffersAndContracts(CreateAirlineSessionRequest createAirlineSessionRequest, CreateCfarOfferRequest createCfarOfferRequest) throws ApiException {
        // Create Session
        AirlineSession airlineSession = createSession(createAirlineSessionRequest);
        String sessionId = airlineSession.getId();

        // Create offers
        List<CfarOffer> cfarOffers = createOffers(sessionId, createCfarOfferRequest);

        // Create a contract for each offers created
        List<CfarContract> cfarContracts = new ArrayList<>();
        if (cfarOffers != null && !cfarOffers.isEmpty()) {
            for (CfarOffer offer : cfarOffers) {
                CreateCfarContractRequest createCfarContractRequest = new CreateCfarContractRequest();
                createCfarContractRequest.setOfferIds(Collections.singletonList(offer.getId()));
                createCfarContractRequest.setItinerary(offer.getItinerary());

                CfarContract cfarContract = createCfarContract(sessionId, createCfarContractRequest);
                cfarContracts.add(cfarContract);
            }
        }

        CreateSessionOffersContractsResponse response = new CreateSessionOffersContractsResponse();
        response.setAirlineSession(airlineSession);
        response.setOffers(cfarOffers);
        response.setContracts(cfarContracts);
        return response;
    }

    /**
     * It has to be called after the payment details have been transferred, to confirm the contract.
     *
     * @param sessionId                 The current session IO
     * @param contractReference         The contract reference
     * @param updateCfarContractRequest The request with the update information
     * @return The updated contract
     * @throws ApiException
     */
    public CfarContract updateCfarContractStatus(String sessionId, String contractReference, UpdateCfarContractRequest updateCfarContractRequest) throws ApiException {
        return cfarApi.putCfarContractsIdUpdateStatus(contractReference, updateCfarContractRequest, sessionId);
    }

    /**
     * Create an event
     * @param sessionId     The current session IO
     * @param event         The event with its type
     * @throws ApiException
     */
    public void createEvent(String sessionId, Event event) throws ApiException {
        analyticsApi.postEvents(event, sessionId);
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
            TokenizationRequest tokenizationRequest = new TokenizationRequest();
            tokenizationRequest.setPaymentMethod(new PaymentMethod());
            tokenizationRequest.getPaymentMethod().setCreditCard(new CreditCard());
            tokenizationRequest.getPaymentMethod().getCreditCard().setFirstName(processCfarPaymentRequest.getFirstName());
            tokenizationRequest.getPaymentMethod().getCreditCard().setLastName(processCfarPaymentRequest.getLastName());

            // Map test credit cards to an accepted one on staging environment
            if (cfarApi.getApiClient().getBasePath().contains("staging") && Arrays.asList("371449635398431", "5454545454545454").contains(processCfarPaymentRequest.getNumber())) {
                tokenizationRequest.getPaymentMethod().getCreditCard().setNumber("4111111111111111");
            } else {
                tokenizationRequest.getPaymentMethod().getCreditCard().setNumber(processCfarPaymentRequest.getNumber());
            }

            tokenizationRequest.getPaymentMethod().getCreditCard().setVerificationValue(processCfarPaymentRequest.getVerificationValue());
            tokenizationRequest.getPaymentMethod().getCreditCard().setMonth(processCfarPaymentRequest.getMonth());
            tokenizationRequest.getPaymentMethod().getCreditCard().setYear(processCfarPaymentRequest.getYear());
            tokenizationRequest.getPaymentMethod().getCreditCard().setAddress1(processCfarPaymentRequest.getAddressLine1());
            tokenizationRequest.getPaymentMethod().getCreditCard().setAddress2(processCfarPaymentRequest.getAddressLine2());
            tokenizationRequest.getPaymentMethod().getCreditCard().setCity(processCfarPaymentRequest.getCity());
            tokenizationRequest.getPaymentMethod().getCreditCard().setState(processCfarPaymentRequest.getStateOrProvince());
            tokenizationRequest.getPaymentMethod().getCreditCard().setZip(processCfarPaymentRequest.getPostalCode());
            tokenizationRequest.getPaymentMethod().getCreditCard().setCountry(processCfarPaymentRequest.getCountry());
            tokenizationRequest.getPaymentMethod().setEmail(processCfarPaymentRequest.getEmailAddress());
            HttpResponse<TokenizationResponse> response = getTokenizedPaymentHttpResponse(tokenizationRequest);

            if (response.getStatus() == 201) {
                ProcessCfarPaymentTokenRequest processCfarPaymentTokenRequest = new ProcessCfarPaymentTokenRequest();
                processCfarPaymentTokenRequest.setPaymentMethodToken(response.getBody().getTransaction().getPaymentMethod().getToken());
                processCfarPaymentTokenRequest.setFirstName(processCfarPaymentRequest.getFirstName());
                processCfarPaymentTokenRequest.setLastName(processCfarPaymentRequest.getLastName());
                processCfarPaymentTokenRequest.setAddressLine1(processCfarPaymentRequest.getAddressLine1());
                processCfarPaymentTokenRequest.setAddressLine2(processCfarPaymentRequest.getAddressLine2());
                processCfarPaymentTokenRequest.setCity(processCfarPaymentRequest.getCity());
                processCfarPaymentTokenRequest.setPostalCode(processCfarPaymentRequest.getPostalCode());
                processCfarPaymentTokenRequest.setStateOrProvince(processCfarPaymentRequest.getStateOrProvince());
                processCfarPaymentTokenRequest.setCountry(processCfarPaymentRequest.getCountry());
                processCfarPaymentTokenRequest.setPnrReference(processCfarPaymentRequest.getPnrReference());
                processCfarPaymentTokenRequest.setEmailAddress(processCfarPaymentRequest.getEmailAddress());
                ProcessCfarPayment processCfarPayment = cfarApi.postCfarContractsIdProcessPayment(contractId, processCfarPaymentTokenRequest, sessionId);
                return processCfarPayment.isSucceeded();
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private HttpResponse<TokenizationResponse> getTokenizedPaymentHttpResponse(TokenizationRequest tokenizationRequest) throws ApiException {
        if (StringUtil.isEmpty(paymentUrl) || StringUtil.isEmpty(paymentUsername) || StringUtil.isEmpty(paymentPassword)) {
            throw new ApiException("Missing credentials for payment");
        }
        return Unirest.post(paymentUrl)
                .basicAuth(paymentUsername, paymentPassword)
                .header("Content-Type", "application/json")
                .body(tokenizationRequest)
                .asObject(TokenizationResponse.class);
    }

    public CfarContractExercise createCfarContractExercise(String sessionId, CreateCfarContractExerciseRequest createCfarContractExerciseRequest) throws ApiException {
        return cfarApi.postCfarContractExercises(createCfarContractExerciseRequest, sessionId);
    }

    public CfarContractExercise completeCfarContractExercise(String sessionId, MarkCfarContractExerciseCompleteRequest markCfarContractExerciseCompleteRequest, String exerciseId) throws ApiException {
        return cfarApi.putCfarContractExercisesIdMarkCompleted(exerciseId, markCfarContractExerciseCompleteRequest, sessionId);
    }
}
