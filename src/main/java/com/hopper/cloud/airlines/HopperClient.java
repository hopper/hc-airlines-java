package com.hopper.cloud.airlines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;
import com.hopper.cloud.airlines.api.SessionsApi;
import com.hopper.cloud.airlines.api.AnalyticsApi;
import com.hopper.cloud.airlines.api.model.UpdateCfarContractFormOfPaymentApiRequest;
import com.hopper.cloud.airlines.api.model.*;
import com.hopper.cloud.airlines.model.*;
import com.hopper.cloud.airlines.model.tokenization.*;
import com.hopper.cloud.airlines.model.tokenization.PaymentMethod;
import kong.unirest.HttpResponse;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class HopperClient {
    final Logger logger = LoggerFactory.getLogger(HopperClient.class);
    private CancelForAnyReasonCfarApi cfarApi;
    private SessionsApi sessionsApi;
    private AnalyticsApi analyticsApi;
    private HopperPaymentClient hopperPaymentClient;

    public HopperClient(String url, String clientId, String clientSecret, Boolean debugging) {
        this.initHopperClient(url, clientId, clientSecret, debugging);
    }

    public HopperClient(String url, String clientId, String clientSecret, String paymentUrl, String paymentUsername, String paymentPassword, Boolean debugging) {
        this(url, clientId, clientSecret, debugging);
        hopperPaymentClient = new HopperPaymentClient(paymentUrl, paymentUsername, paymentPassword);
    }

    public HopperClient(String url, String clientId, String clientSecret, String paymentUrl, String paymentUsername, String paymentPassword, String encryptionKeyId, String encryptionPublicKey, Boolean debugging) {
        this(url, clientId, clientSecret, debugging);
        hopperPaymentClient = new HopperPaymentClient(paymentUrl, paymentUsername, paymentPassword, encryptionKeyId, encryptionPublicKey);
    }

    private void initHopperClient(String url, String clientId, String clientSecret, Boolean debugging) {
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
        return cfarApi.postCfarContracts(createCfarContractRequest, sessionId);
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
            for (CfarOffer offer : cfarOffers) {
                CreateCfarContractRequest createCfarContractRequest = new CreateCfarContractRequest();
                createCfarContractRequest.setOfferIds(Collections.singletonList(offer.getId()));
                createCfarContractRequest.setItinerary(createCfarOfferRequest.getItinerary().get(0));
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

    /**
     * Called to update forms of payment that are linked with a contract.
     *
     * @param sessionId                         The current session IO
     * @param contractReference                 The contract reference
     * @param updateCfarContractFormsOfPaymentRequest    The request with the update information
     * @return The updated contract
     * @throws ApiException
     */
    public CfarContract updateCfarContractFormsOfPayment(String sessionId, String contractReference, UpdateCfarContractFormsOfPaymentRequest updateCfarContractFormsOfPaymentRequest) throws ApiException {
        try {
            if (ListUtil.isEmpty(updateCfarContractFormsOfPaymentRequest.getFormsOfPayment())) {
                throw new ApiException("Missing forms of payment"); // must we return the contract instead?
            } else {
                if (hopperPaymentClient == null) {
                    throw new ApiException("Missing credentials for payment");
                }

                UpdateCfarContractFormOfPaymentApiRequest updateCfarContractFormsOfPaymentApiRequest = new UpdateCfarContractFormOfPaymentApiRequest();
                List<ApiFormOfPayment> apiFormsOfPayment = new ArrayList<>();
                for (FormOfPayment formOfPaymentRequest : updateCfarContractFormsOfPaymentRequest.getFormsOfPayment()) {
                    ApiFormOfPayment apiFormOfPayment = null;
                    if (formOfPaymentRequest instanceof FormOfPayment.PaymentCard) {
                        FormOfPayment.PaymentCard creditCardRequest = (FormOfPayment.PaymentCard)formOfPaymentRequest;
                        PaymentCardDetails paymentCardDetails = creditCardRequest.getCreditCardDetail();
                        if (paymentCardDetails != null) {
                            // Adjust the credit card number
                            paymentCardDetails.setNumber(prepareCreditCardNumberForSpreedly(paymentCardDetails.getNumber()));
                            // Retrieve the required token from Spreedly
                            String token = hopperPaymentClient.tokenizePaymentCreditCardWithEncryption(paymentCardDetails);
                            apiFormOfPayment = new ApiFormOfPayment.PaymentCard(creditCardRequest.getAmount(), creditCardRequest.getCurrency(), token);
                        } else {
                            apiFormOfPayment = new ApiFormOfPayment.PaymentCard(creditCardRequest.getAmount(), creditCardRequest.getCurrency(), null);
                        }
                    } else if (formOfPaymentRequest instanceof FormOfPayment.TokenizedPaymentCard) {
                        FormOfPayment.TokenizedPaymentCard fopRequest = (FormOfPayment.TokenizedPaymentCard)formOfPaymentRequest;
                        apiFormOfPayment = new ApiFormOfPayment.PaymentCard(fopRequest.getAmount(), fopRequest.getCurrency(), fopRequest.getToken());
                    } else if (formOfPaymentRequest instanceof FormOfPayment.Cash) {
                        FormOfPayment.Cash fopRequest = (FormOfPayment.Cash)formOfPaymentRequest;
                        apiFormOfPayment = new ApiFormOfPayment.Cash(fopRequest.getAmount(), fopRequest.getCurrency());
                    } else if (formOfPaymentRequest instanceof FormOfPayment.NonCash) {
                        FormOfPayment.NonCash fopRequest = (FormOfPayment.NonCash)formOfPaymentRequest;
                        apiFormOfPayment = new ApiFormOfPayment.NonCash(fopRequest.getAmount(), fopRequest.getCurrency());
                    } else if (formOfPaymentRequest instanceof FormOfPayment.Points) {
                        FormOfPayment.Points fopRequest = (FormOfPayment.Points)formOfPaymentRequest;
                        apiFormOfPayment = new ApiFormOfPayment.Points(fopRequest.getAmount());
                    } else {
                        throw new ApiException("Unknown form of payment");
                    }
                    apiFormsOfPayment.add(apiFormOfPayment);
                }

                updateCfarContractFormsOfPaymentApiRequest.setFormsOfPayment(apiFormsOfPayment);
                return cfarApi.putCfarContractsIdFormsOfPayment(contractReference, updateCfarContractFormsOfPaymentApiRequest, sessionId);
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
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
            creditCard.setNumber(prepareCreditCardNumberForSpreedly(processCfarPaymentRequest.getNumber()));
            creditCard.setVerificationValue(processCfarPaymentRequest.getVerificationValue());
            creditCard.setMonth(processCfarPaymentRequest.getMonth());
            creditCard.setYear(processCfarPaymentRequest.getYear());
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
