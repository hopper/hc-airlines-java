package com.hopper.cloud.airlines.model.tokenization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenizationResponse {
    private Transaction transaction;

    public TokenizationResponse() {
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TokenizationResponse tokenizationResponse = (TokenizationResponse) o;
        return Objects.equals(this.transaction, tokenizationResponse.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TokenizationResponse {\n");
        sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
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

