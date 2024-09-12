package com.hopper.cloud.airlines.model.tokenization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hopper.cloud.airlines.model.CreditCardDetail;
import com.hopper.cloud.airlines.model.PaymentCardDetail;

import java.util.Objects;

public class TokenizationRequest {
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;

    public TokenizationRequest() {
    }

    public TokenizationRequest(PaymentCardDetail paymentCardDetail) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setEmail(paymentCardDetail.getEmailAddress());
        CreditCard creditCard = new CreditCard();
        creditCard.setVerificationValue(paymentCardDetail.getVerificationValue());
        creditCard.setMonth(paymentCardDetail.getMonth());
        creditCard.setYear(paymentCardDetail.getYear());
        creditCard.setAddress1(paymentCardDetail.getAddressLine1());
        creditCard.setAddress2(paymentCardDetail.getAddressLine2());
        creditCard.setCity(paymentCardDetail.getCity());
        creditCard.setState(paymentCardDetail.getStateOrProvince());
        creditCard.setZip(paymentCardDetail.getPostalCode());
        creditCard.setCountry(paymentCardDetail.getCountry());
        creditCard.setLastName(paymentCardDetail.getLastName());
        creditCard.setFirstName(paymentCardDetail.getFirstName());
        creditCard.setNumber(paymentCardDetail.getNumber());
        paymentMethod.setCreditCard(creditCard);
        this.setPaymentMethod(paymentMethod);
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TokenizationRequest tokenizationRequest = (TokenizationRequest) o;
        return Objects.equals(this.paymentMethod, tokenizationRequest.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentMethod);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TokenizationRequest {\n");
        sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

