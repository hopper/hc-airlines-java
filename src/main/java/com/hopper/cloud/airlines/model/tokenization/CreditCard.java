package com.hopper.cloud.airlines.model.tokenization;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CreditCard {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String number;
    @JsonProperty("verification_value")
    private String verificationValue;
    private String month;
    private String year;

    public CreditCard() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVerificationValue() {
        return verificationValue;
    }

    public void setVerificationValue(String verificationValue) {
        this.verificationValue = verificationValue;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreditCard creditCard = (CreditCard) o;
        return Objects.equals(this.firstName, creditCard.firstName) &&
                Objects.equals(this.lastName, creditCard.lastName) &&
                Objects.equals(this.number, creditCard.number) &&
                Objects.equals(this.verificationValue, creditCard.verificationValue) &&
                Objects.equals(this.month, creditCard.month) &&
                Objects.equals(this.year, creditCard.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, number, verificationValue, month, year);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreditCard {\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    number: ").append(toIndentedString(number)).append("\n");
        sb.append("    verificationValue: ").append(toIndentedString(verificationValue)).append("\n");
        sb.append("    month: ").append(toIndentedString(month)).append("\n");
        sb.append("    year: ").append(toIndentedString(year)).append("\n");
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
