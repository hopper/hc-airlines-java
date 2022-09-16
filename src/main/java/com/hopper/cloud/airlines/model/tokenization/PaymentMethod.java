package com.hopper.cloud.airlines.model.tokenization;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PaymentMethod {
    @JsonProperty("credit_card")
    private CreditCard creditCard;
    private String email;

    public PaymentMethod() {
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentMethod paymentMethod = (PaymentMethod) o;
        return Objects.equals(this.creditCard, paymentMethod.creditCard) &&
                Objects.equals(this.email, paymentMethod.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditCard, email);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentMethod {\n");
        sb.append("    creditCard: ").append(toIndentedString(creditCard)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

