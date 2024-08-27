package com.hopper.cloud.airlines.model;

import java.util.Objects;

public class PaymentCardDetail {
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
    private String emailAddress;

    public PaymentCardDetail() {
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
        PaymentCardDetail processCfarPayment = (PaymentCardDetail) o;
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
                Objects.equals(this.emailAddress, processCfarPayment.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, verificationValue, month, year, firstName, lastName, addressLine1, addressLine2, postalCode, city, stateOrProvince, country, emailAddress);
    }

}

