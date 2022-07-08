package com.hopper.cloud.airlines.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ProcessCfarPaymentRequest {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String number;
    @JsonProperty("verification_value")
    private String verificationValue;
    private String month;
    private String year;
    @JsonProperty("pnr_reference")
    private String pnrReference;
    @JsonProperty("email_address")
    private String emailAddress;

    public ProcessCfarPaymentRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPnrReference() {
        return pnrReference;
    }

    public void setPnrReference(String pnrReference) {
        this.pnrReference = pnrReference;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
        ProcessCfarPaymentRequest processCfarPayment = (ProcessCfarPaymentRequest) o;
        return Objects.equals(this.lastName, processCfarPayment.lastName) &&
                Objects.equals(this.firstName, processCfarPayment.firstName) &&
                Objects.equals(this.verificationValue, processCfarPayment.verificationValue) &&
                Objects.equals(this.number, processCfarPayment.number) &&
                Objects.equals(this.year, processCfarPayment.year) &&
                Objects.equals(this.month, processCfarPayment.month) &&
                Objects.equals(this.pnrReference, processCfarPayment.pnrReference) &&
                Objects.equals(this.emailAddress, processCfarPayment.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, number, verificationValue, month, year,pnrReference,emailAddress);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessCfarPaymentRequest {\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    number: ").append(toIndentedString(number)).append("\n");
        sb.append("    verificationValue: ").append(toIndentedString(verificationValue)).append("\n");
        sb.append("    month: ").append(toIndentedString(month)).append("\n");
        sb.append("    year: ").append(toIndentedString(year)).append("\n");
        sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
        sb.append("    pnrReference: ").append(toIndentedString(pnrReference)).append("\n");
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

