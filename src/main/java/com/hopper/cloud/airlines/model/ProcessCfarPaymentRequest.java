package com.hopper.cloud.airlines.model;

import java.util.Objects;

public class ProcessCfarPaymentRequest {
    private String number;
    private String verificationValue;
    private String month;
    private String year;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String stateOrProvince;
    private String country;
    private String pnrReference;
    private String emailAddress;

    public ProcessCfarPaymentRequest() {
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

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessCfarPaymentRequest processCfarPayment = (ProcessCfarPaymentRequest) o;
        return Objects.equals(this.number, processCfarPayment.number) &&
                Objects.equals(this.verificationValue, processCfarPayment.verificationValue) &&
                Objects.equals(this.month, processCfarPayment.month) &&
                Objects.equals(this.year, processCfarPayment.year) &&
                Objects.equals(this.firstName, processCfarPayment.firstName) &&
                Objects.equals(this.lastName, processCfarPayment.lastName) &&
                Objects.equals(this.addressLine1, processCfarPayment.addressLine1) &&
                Objects.equals(this.addressLine2, processCfarPayment.addressLine2) &&
                Objects.equals(this.postalCode, processCfarPayment.postalCode) &&
                Objects.equals(this.city, processCfarPayment.city) &&
                Objects.equals(this.stateOrProvince, processCfarPayment.stateOrProvince) &&
                Objects.equals(this.country, processCfarPayment.country) &&
                Objects.equals(this.pnrReference, processCfarPayment.pnrReference) &&
                Objects.equals(this.emailAddress, processCfarPayment.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, verificationValue, month, year, firstName, lastName, addressLine1, addressLine2, postalCode, city, stateOrProvince, country, pnrReference, emailAddress);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessCfarPaymentRequest {\n");
        sb.append("    number: ").append(toIndentedString(number)).append("\n");
        sb.append("    verificationValue: ").append(toIndentedString(verificationValue)).append("\n");
        sb.append("    month: ").append(toIndentedString(month)).append("\n");
        sb.append("    year: ").append(toIndentedString(year)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
        sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
        sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
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

