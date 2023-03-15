package com.hopper.cloud.airlines.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hopper.cloud.airlines.JSON;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ProcessCfarPaymentTokenRequest {
    @SerializedName("payment_method_token")
    private String paymentMethodToken;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("address_line1")
    private String addressLine1;
    @SerializedName("address_line2")
    private String addressLine2;
    @SerializedName("city")
    private String city;
    @SerializedName("postal_code")
    private String postalCode;
    @SerializedName("state_or_province")
    private String stateOrProvince;
    @SerializedName("country")
    private String country;
    @SerializedName("pnr_reference")
    private String pnrReference;
    @SerializedName("email_address")
    private String emailAddress;

    public ProcessCfarPaymentTokenRequest() {
    }

    public String getPaymentMethodToken() {
        return paymentMethodToken;
    }

    public void setPaymentMethodToken(String paymentMethodToken) {
        this.paymentMethodToken = paymentMethodToken;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessCfarPaymentTokenRequest that = (ProcessCfarPaymentTokenRequest) o;
        return Objects.equals(paymentMethodToken, that.paymentMethodToken) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(addressLine1, that.addressLine1) && Objects.equals(addressLine2, that.addressLine2) && Objects.equals(city, that.city) && Objects.equals(postalCode, that.postalCode) && Objects.equals(stateOrProvince, that.stateOrProvince) && Objects.equals(country, that.country) && Objects.equals(pnrReference, that.pnrReference) && Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentMethodToken, firstName, lastName, addressLine1, addressLine2, city, postalCode, stateOrProvince, country, pnrReference, emailAddress);
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

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!ProcessCfarPaymentTokenRequest.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'ProcessCfarPaymentTokenRequest' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<ProcessCfarPaymentTokenRequest> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(ProcessCfarPaymentTokenRequest.class));

            return (TypeAdapter<T>) new TypeAdapter<ProcessCfarPaymentTokenRequest>() {
                @Override
                public void write(JsonWriter out, ProcessCfarPaymentTokenRequest value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public ProcessCfarPaymentTokenRequest read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of ProcessCfarPaymentTokenRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ProcessCfarPaymentTokenRequest
     * @throws IOException if the JSON string is invalid with respect to ProcessCfarPaymentTokenRequest
     */
    public static ProcessCfarPaymentTokenRequest fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, ProcessCfarPaymentTokenRequest.class);
    }

    /**
     * Convert an instance of ProcessCfarPaymentTokenRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}



