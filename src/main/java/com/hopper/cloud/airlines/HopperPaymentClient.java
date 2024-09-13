package com.hopper.cloud.airlines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hopper.cloud.airlines.helper.RsaHelper;
import com.hopper.cloud.airlines.model.*;
import com.hopper.cloud.airlines.model.tokenization.CreditCard;
import com.hopper.cloud.airlines.model.tokenization.PaymentMethod;
import com.hopper.cloud.airlines.model.tokenization.TokenizationRequest;
import com.hopper.cloud.airlines.model.tokenization.TokenizationResponse;
import kong.unirest.HttpResponse;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

public class HopperPaymentClient {
    private String paymentUrl;
    private String paymentUsername;
    private String paymentPassword;
    private String encryptionKeyId;
    private String encryptionPublicKey;

    public HopperPaymentClient(String paymentUrl, String paymentUsername, String paymentPassword) {
        this(paymentUrl, paymentUsername, paymentPassword, null, null);
    }

    public HopperPaymentClient(String paymentUrl, String paymentUsername, String paymentPassword, String encryptionKeyId, String encryptionPublicKey) {
        this.initHopperPaymentClient(paymentUrl, paymentUsername, paymentPassword, encryptionKeyId, encryptionPublicKey);
    }


    private void initHopperPaymentClient(String paymentUrl, String paymentUsername, String paymentPassword, String encryptionKeyId, String encryptionPublicKey) {
        this.paymentUrl = paymentUrl;
        this.paymentUsername = paymentUsername;
        this.paymentPassword = paymentPassword;
        this.encryptionKeyId = encryptionKeyId;
        this.encryptionPublicKey = encryptionPublicKey;

        Unirest.config().setObjectMapper(new ObjectMapper() {
            final com.fasterxml.jackson.databind.ObjectMapper mapper
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


    public HttpResponse<TokenizationResponse> getTokenizedPaymentHttpResponse(TokenizationRequest tokenizationRequest) throws ApiException {
        if (StringUtil.isEmpty(paymentUrl) || StringUtil.isEmpty(paymentUsername) || StringUtil.isEmpty(paymentPassword)) {
            throw new ApiException("Missing credentials for payment");
        }
        return Unirest.post(paymentUrl)
                .basicAuth(paymentUsername, paymentPassword)
                .header("Content-Type", "application/json")
                .body(tokenizationRequest)
                .asObject(TokenizationResponse.class);
    }

    public String tokenizePaymentCard(PaymentCardDetail paymentCardDetail) throws ApiException {
        HttpResponse<TokenizationResponse> response = getTokenizedPaymentHttpResponse(new TokenizationRequest(paymentCardDetail));
        if (response.getStatus() == 201) {
            return response.getBody().getTransaction().getPaymentMethod().getToken();
        } else {
            throw new ApiException("Unable to create a token, response : " + response.getStatus());
        }
    }

    /**
     * Perform credit card tokenization by encrypting some fields
     * @param creditCardDetail
     * @return The token if it was successfully retrieved, else null
     */
    public String tokenizePaymentCreditCardWithEncryption(CreditCardDetail creditCardDetail) {
        String token = null;
        if (StringUtil.isEmpty(encryptionKeyId) || StringUtil.isEmpty(encryptionPublicKey)) {
            // Log the error message
            //logger.error("Missing Encryption parameters for payment");
        } else {
            HttpResponse<TokenizationResponse> response = null;
            try {
                response = getTokenizedPaymentHttpResponse(buildTokenizationRequestWithEncryption(creditCardDetail, encryptionKeyId, encryptionPublicKey));
            } catch (Exception e) {
                // Log the error message
                //logger.error("Unable to initialize the request object for tokenization : " + e.getLocalizedMessage());
            }
            if (response != null && response.getStatus() == 201) {
                token = response.getBody().getTransaction().getPaymentMethod().getToken();
            } else {
                // Log the error message
                //logger.error("Unable to create a token, response : " + response.getStatus());
            }
        }
        return token;
    }

    private TokenizationRequest buildTokenizationRequestWithEncryption(CreditCardDetail paymentCardDetail, String encryptionKeyId, String encryptionPublicKey) throws Exception {
        TokenizationRequest tokenizationRequest = new TokenizationRequest();

        com.hopper.cloud.airlines.model.tokenization.PaymentMethod paymentMethod = new PaymentMethod();
        CreditCard creditCard = new CreditCard();
        creditCard.setMonth(RsaHelper.encryptDataUsingRSA(paymentCardDetail.getExpirationMonth(), encryptionPublicKey));
        creditCard.setYear(RsaHelper.encryptDataUsingRSA(paymentCardDetail.getExpirationYear(), encryptionPublicKey));
        creditCard.setLastName(RsaHelper.encryptDataUsingRSA(paymentCardDetail.getLastName(), encryptionPublicKey));
        creditCard.setFirstName(RsaHelper.encryptDataUsingRSA(paymentCardDetail.getFirstName(), encryptionPublicKey));
        creditCard.setNumber(RsaHelper.encryptDataUsingRSA(paymentCardDetail.getNumber(), encryptionPublicKey));
        paymentMethod.setCreditCard(creditCard);
        paymentMethod.setEncryptionCertificateToken(encryptionKeyId);
        paymentMethod.setEncryptedFields("number,month,year,first_name,last_name");
        tokenizationRequest.setPaymentMethod(paymentMethod);
        return tokenizationRequest;
    }
}
