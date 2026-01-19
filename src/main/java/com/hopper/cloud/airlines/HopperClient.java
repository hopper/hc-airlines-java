package com.hopper.cloud.airlines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;
import com.hopper.cloud.airlines.api.DisruptionGuaranteeDgApi;
import com.hopper.cloud.airlines.api.SessionsApi;
import com.hopper.cloud.airlines.api.AnalyticsApi;
import com.hopper.cloud.airlines.model.*;
import com.hopper.cloud.airlines.model.tokenization.*;
import com.hopper.cloud.airlines.model.tokenization.PaymentMethod;
import com.hopper.cloud.airlines.transformer.CfarItineraryTransformer;
import kong.unirest.HttpResponse;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class HopperClient {
    final Logger logger = LoggerFactory.getLogger(HopperClient.class);
    private CancelForAnyReasonCfarApi cfarApi;
    private DisruptionGuaranteeDgApi dgApi;
    private SessionsApi sessionsApi;
    private AnalyticsApi analyticsApi;
    private HopperPaymentClient hopperPaymentClient;
    private int timeout = 60000;

    public HopperClient(String url, String clientId, String clientSecret, Boolean debugging) {
        this.initHopperClient(url, clientId, clientSecret, debugging);
    }

    public HopperClient(String url, String clientId, String clientSecret, String paymentUrl, String paymentUsername, String paymentPassword, Boolean debugging) {
        this(url, clientId, clientSecret, debugging);
        hopperPaymentClient = new HopperPaymentClient(paymentUrl, paymentUsername, paymentPassword);
    }

    public HopperClient(String url, String clientId, String clientSecret, String paymentUrl, String paymentUsername, String paymentPassword, String encryptionKeyId, String encryptionPublicKey, int timeout, Boolean debugging) {
        this(url, clientId, clientSecret, debugging);
        this.timeout = timeout;
        hopperPaymentClient = new HopperPaymentClient(paymentUrl, paymentUsername, paymentPassword, encryptionKeyId, encryptionPublicKey);
    }

    private void initHopperClient(String url, String clientId, String clientSecret, Boolean debugging) {
        Map<String, String> params = new HashMap<>();
        params.put("audience", String.join("/", Arrays.asList(url.split("/")).subList(0, 3)));
        params.put("grant_type", "client_credentials");

        ApiClient apiClient = new ApiClient(clientId, clientSecret, params);
        apiClient.setBasePath(url);

        cfarApi = new CancelForAnyReasonCfarApi(apiClient);
        cfarApi.getApiClient().setDebugging(debugging);
        cfarApi.getApiClient().setBasePath(url);
        cfarApi.getApiClient().setConnectTimeout(timeout);
        cfarApi.getApiClient().setReadTimeout(timeout);
        cfarApi.getApiClient().setWriteTimeout(timeout);

        dgApi = new DisruptionGuaranteeDgApi(apiClient);
        dgApi.getApiClient().setDebugging(debugging);
        dgApi.getApiClient().setBasePath(url);
        dgApi.getApiClient().setConnectTimeout(timeout);
        dgApi.getApiClient().setReadTimeout(timeout);
        dgApi.getApiClient().setWriteTimeout(timeout);

        sessionsApi = new SessionsApi(apiClient);
        sessionsApi.getApiClient().setDebugging(debugging);
        sessionsApi.getApiClient().setBasePath(url);
        sessionsApi.getApiClient().setConnectTimeout(timeout);
        sessionsApi.getApiClient().setReadTimeout(timeout);
        sessionsApi.getApiClient().setWriteTimeout(timeout);

        analyticsApi = new AnalyticsApi(apiClient);
        analyticsApi.getApiClient().setDebugging(debugging);
        analyticsApi.getApiClient().setBasePath(url);
        analyticsApi.getApiClient().setConnectTimeout(timeout);
        analyticsApi.getApiClient().setReadTimeout(timeout);
        analyticsApi.getApiClient().setWriteTimeout(timeout);

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
        }).connectTimeout(60000);

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
        if (FlowType.EXERCISE.equals(createAirlineSessionRequest.getFlowType())) {
            createAirlineSessionRequest.setProduct(Product.CFAR);
        }
        return sessionsApi.postSessions(createAirlineSessionRequest);
    }

    public List<CfarOffer> createOffers(String sessionId, CreateCfarOfferRequest createCfarOfferRequest) throws ApiException {
        return cfarApi.postCfarOffers(createCfarOfferRequest, sessionId);
    }

    public CfarContract createCfarContract(String sessionId, CreateCfarContractRequest createCfarContractRequest) throws ApiException {
        return cfarApi.postCfarContracts(createCfarContractRequest);
    }

    public List<CreateDgOfferItemResponse> createDgOffers(String sessionId, CreateDgOffersRequest createDgOffersRequest) throws ApiException {
        return dgApi.postDgOffers(createDgOffersRequest, sessionId);
    }

    public Tuple2<String, List<CreateDgOfferItemResponse>> createDgOffers(CreateDgOffersRequest createDgOffersRequest) throws ApiException {
        ApiResponse<List<CreateDgOfferItemResponse>> response = dgApi.postDgOffersWithHttpInfo(createDgOffersRequest, null);
        return new Tuple2<>(response.getHeaders().get("hts-session-id").get(0), response.getData());
    }

    public DgContract createDgContract(CreateDgContractRequest createDgContractRequest) throws ApiException {
        return dgApi.postDgContracts(createDgContractRequest);
    }


    public CreateSessionOffersContractsResponse createSessionOffersAndContracts(CreateAirlineSessionRequest createAirlineSessionRequest, CreateCfarOfferRequest createCfarOfferRequest) throws ApiException {
        // Create Session
        AirlineSession airlineSession = createSession(createAirlineSessionRequest);
        String sessionId = airlineSession.getId();

        // Create offers
        List<CfarOffer> cfarOffers = createOffers(sessionId, createCfarOfferRequest);

        // Create a contract for each offer created
        List<CfarContract> cfarContracts = new ArrayList<>();
        if (cfarOffers != null && !cfarOffers.isEmpty()) {
            for (int i = 0; i < cfarOffers.size(); i++) {
                CreateCfarContractRequest createCfarContractRequest = new CreateCfarContractRequest();
                createCfarContractRequest.setOfferIds(Collections.singletonList(cfarOffers.get(i).getId()));
                createCfarContractRequest.setItinerary(CfarItineraryTransformer.toCfarItinerary(createCfarOfferRequest.getItinerary().get(0)));
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
     * It has to be called after the payment details have been transferred, to confirm the contract.
     *
     * @param contractId                    The contract id
     * @param updateDgContractStatusRequest The request with the update information
     * @return The updated contract
     * @throws ApiException
     */
    public DgContract updateDgContractStatus(String contractId, UpdateDgContractStatusRequest updateDgContractStatusRequest, PaymentCardDetails paymentCardDetails) throws ApiException {
        if (!ListUtil.isEmpty(updateDgContractStatusRequest.getFormsOfPayment())) {
            List<FormOfPayment> apiFormsOfPayment = new ArrayList<>();
            for (FormOfPayment formOfPaymentRequest : updateDgContractStatusRequest.getFormsOfPayment()) {
                if (formOfPaymentRequest.getActualInstance() instanceof PaymentCard && (paymentCardDetails == null && ((PaymentCard) formOfPaymentRequest.getActualInstance()).getToken() == null)) {
                    throw new ApiException("Missing credentials for payment");
                } else {
                    FormOfPayment apiFormOfPayment = updateFormOfPayment(formOfPaymentRequest, paymentCardDetails);
                    apiFormsOfPayment.add(apiFormOfPayment);
                }
            }
            updateDgContractStatusRequest.setFormsOfPayment(apiFormsOfPayment);
        }
        return dgApi.putDgContractsIdUpdateStatus(contractId, updateDgContractStatusRequest);
    }

    /**
     * Create an event
     * @param sessionId     The current session IO
     * @param event         The event with its type
     * @throws ApiException
     */
    public void createEvent(String sessionId, Event event) throws ApiException {
        analyticsApi.postEvents(sessionId, event);
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

    /**
     * Called to update itinerary slices of a CFAR contract.
     *
     * @param sessionId         The current session ID
     * @param contractId        The contract ID
     * @param request           The request containing itinerary slices to update
     * @return The updated contract
     * @throws ApiException
     */
    public CfarContract updateCfarContractItinerarySlices(String sessionId, String contractId, UpdateCfarContractItinerarySlicesRequest request) throws ApiException {
        return cfarApi.putCfarContractsIdItinerarySlices(contractId, request, sessionId);
    }

    /**
     * Called to update forms of payment that are linked with a contract.
     *
     * @param sessionId                         The current session IO
     * @param contractReference                 The contract reference
     * @param updateCfarContractFormsOfPaymentRequest    The request with the update information
     * @return The updated contract
     * @throws ApiException
     */
    public CfarContract updateCfarContractFormsOfPayment(String sessionId, String contractReference, UpdateCfarContractFormsOfPaymentRequest updateCfarContractFormsOfPaymentRequest, PaymentCardDetails paymentCardDetails) throws ApiException {
        try {
            if (ListUtil.isEmpty(updateCfarContractFormsOfPaymentRequest.getFormsOfPayment())) {
                throw new ApiException("Missing forms of payment"); // must we return the contract instead?
            } else {
                if (paymentCardDetails == null && hopperPaymentClient == null && updateCfarContractFormsOfPaymentRequest.getFormsOfPayment().stream().anyMatch(formOfPayment -> formOfPayment.getPaymentCard() != null && formOfPayment.getPaymentCard().getToken() == null)) {
                    throw new ApiException("Missing credentials for payment");
                }

                UpdateCfarFormOfPaymentRequest updateCfarContractFormsOfPaymentApiRequest = new UpdateCfarFormOfPaymentRequest();
                List<FormOfPayment> apiFormsOfPayment = new ArrayList<>();
                for (FormOfPayment formOfPaymentRequest : updateCfarContractFormsOfPaymentRequest.getFormsOfPayment()) {
                    FormOfPayment apiFormOfPayment = updateFormOfPayment(formOfPaymentRequest, paymentCardDetails);
                    apiFormsOfPayment.add(apiFormOfPayment);
                }
                updateCfarContractFormsOfPaymentApiRequest.setFormsOfPayment(apiFormsOfPayment);
                return cfarApi.putCfarContractsIdFormsOfPayment(contractReference, updateCfarContractFormsOfPaymentApiRequest, sessionId);
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    @NotNull
    private FormOfPayment updateFormOfPayment(FormOfPayment formOfPaymentRequest, PaymentCardDetails paymentCardDetails) throws ApiException {
        FormOfPayment apiFormOfPayment = new FormOfPayment();
        Object formOfPaymentRequestObject = formOfPaymentRequest.getActualInstance();
        if (formOfPaymentRequestObject instanceof PaymentCard) {
            PaymentCard fopRequest = (PaymentCard) formOfPaymentRequestObject;
            if (paymentCardDetails != null && fopRequest.getToken() == null) {
                // Adjust the credit card number
                paymentCardDetails.setNumber(prepareCreditCardNumberForSpreedly(paymentCardDetails.getNumber()));
                // Retrieve the required token from Spreedly
                String token = hopperPaymentClient.tokenizePaymentCreditCardWithEncryption(paymentCardDetails);
                fopRequest.setToken(token);
            }
            apiFormOfPayment = new FormOfPayment(fopRequest);
        } else if (formOfPaymentRequestObject instanceof Cash) {
            Cash fopRequest = (Cash) formOfPaymentRequestObject;
            apiFormOfPayment = new FormOfPayment(fopRequest);
        } else if (formOfPaymentRequestObject instanceof NonCash) {
            NonCash fopRequest = (NonCash) formOfPaymentRequestObject;
            apiFormOfPayment.setActualInstance(fopRequest);
        } else if (formOfPaymentRequestObject instanceof Points) {
            Points fopRequest = (Points) formOfPaymentRequestObject;
            apiFormOfPayment = new FormOfPayment(fopRequest);
        } else {
            throw new ApiException("Unknown form of payment");
        }
        return apiFormOfPayment;
    }

    public boolean processCfarPayment(String sessionId, String contractId, ProcessCfarPaymentRequest processCfarPaymentRequest) throws ApiException {
        try {
            if (hopperPaymentClient == null) {
                throw new ApiException("Missing credentials for payment");
            }
            TokenizationRequest tokenizationRequest = new TokenizationRequest();
            PaymentMethod paymentMethod = new PaymentMethod();
            CreditCard creditCard = new CreditCard();
            creditCard.setFirstName(processCfarPaymentRequest.getFirstName());
            creditCard.setLastName(processCfarPaymentRequest.getLastName());
            creditCard.setAddress1(processCfarPaymentRequest.getAddressLine1());
            creditCard.setAddress2(processCfarPaymentRequest.getAddressLine2());
            creditCard.setCity(processCfarPaymentRequest.getCity());
            creditCard.setState(processCfarPaymentRequest.getStateOrProvince());
            creditCard.setZip(processCfarPaymentRequest.getPostalCode());
            creditCard.setCountry(processCfarPaymentRequest.getCountry());
            paymentMethod.setCreditCard(creditCard);
            paymentMethod.setEmail(processCfarPaymentRequest.getEmailAddress());
            tokenizationRequest.setPaymentMethod(paymentMethod);

            HttpResponse<TokenizationResponse> response = hopperPaymentClient.getTokenizedPaymentHttpResponse(tokenizationRequest);

            if (response.getStatus() == 201) {
                ProcessCfarPaymentRequest processCfarPaymentTokenRequest = new ProcessCfarPaymentRequest();
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
                CfarPayment processCfarPayment = cfarApi.postCfarContractsIdPayment(contractId, processCfarPaymentTokenRequest, sessionId);

                return processCfarPayment.getSucceeded();
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    /**
     * Before calling Spreedly API in order to get a payment token, supply credit card number with the right one according to the environment
     * @param inputCardNumber
     * @return Accurate card number that will be used when calling Spreedly
     */
    private String prepareCreditCardNumberForSpreedly(String inputCardNumber) {
        String spreedlyCardNumber = inputCardNumber;
        // Map test credit cards to an accepted one on staging environment
        if (cfarApi.getApiClient().getBasePath().contains("staging") && Arrays.asList("371449635398431", "5454545454545454").contains(inputCardNumber)) {
            spreedlyCardNumber = "4111111111111111";
        }
        return spreedlyCardNumber;
    }

    public CfarContractExercise createCfarContractExercise(String sessionId, CreateCfarContractExerciseRequest createCfarContractExerciseRequest) throws ApiException {
        return cfarApi.postCfarContractExercises(createCfarContractExerciseRequest, sessionId);
    }

    public CfarContractExercise completeCfarContractExercise(String sessionId, MarkCfarContractExerciseCompleteRequest markCfarContractExerciseCompleteRequest, String exerciseId) throws ApiException {
        return cfarApi.putCfarContractExercisesIdMarkCompleted(exerciseId, markCfarContractExerciseCompleteRequest, sessionId);
    }
}
