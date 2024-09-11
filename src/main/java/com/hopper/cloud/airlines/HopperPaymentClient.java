package com.hopper.cloud.airlines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hopper.cloud.airlines.model.*;
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
            throw new ApiException("Unable to create this specific token, response : " + response.getStatus());
        }
    }
}
