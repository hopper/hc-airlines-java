package com.hopper.cloud.airlines.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hopper.cloud.airlines.JSON;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ProcessCfarPaymentTokenRequest {

    public static final String SERIALIZED_NAME_PAYMENT_METHOD_TOKEN = "payment_method_token";
    @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD_TOKEN)
    private String paymentMethodToken;

    public static final String SERIALIZED_NAME_FIRST_NAME = "first_name";
    @SerializedName(SERIALIZED_NAME_FIRST_NAME)
    private String firstName;

    public static final String SERIALIZED_NAME_LAST_NAME = "last_name";
    @SerializedName(SERIALIZED_NAME_LAST_NAME)
    private String lastName;

    public static final String SERIALIZED_NAME_ADDRESS_LINE_1 = "address_line1";
    @SerializedName(SERIALIZED_NAME_ADDRESS_LINE_1)
    private String addressLine1;

    public static final String SERIALIZED_NAME_ADDRESS_LINE_2 = "address_line2";
    @SerializedName(SERIALIZED_NAME_ADDRESS_LINE_2)
    private String addressLine2;

    public static final String SERIALIZED_NAME_CITY = "city";
    @SerializedName(SERIALIZED_NAME_CITY)
    private String city;

    public static final String SERIALIZED_NAME_STATE_OR_PROVINCE = "state_or_province";
    @SerializedName(SERIALIZED_NAME_STATE_OR_PROVINCE)
    private String stateOrProvince;

    public static final String SERIALIZED_NAME_POSTAL_CODE = "postal_code";
    @SerializedName(SERIALIZED_NAME_POSTAL_CODE)
    private String postalCode;

    public static final String SERIALIZED_NAME_COUNTRY = "country";
    @SerializedName(SERIALIZED_NAME_COUNTRY)
    private String country;

    public static final String SERIALIZED_NAME_PNR_REFERENCE = "pnr_reference";
    @SerializedName(SERIALIZED_NAME_PNR_REFERENCE)
    private String pnrReference;

    public static final String SERIALIZED_NAME_EMAIL_ADDRESS = "email_address";
    @SerializedName(SERIALIZED_NAME_EMAIL_ADDRESS)
    private String emailAddress;

    public ProcessCfarPaymentTokenRequest() {
    }

    public ProcessCfarPaymentTokenRequest paymentMethodToken(String paymentMethodToken) {

        this.paymentMethodToken = paymentMethodToken;
        return this;
    }

    /**
     * The Token of the Form of Payment used to pay for the CFAR fee
     * @return paymentMethodToken
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "The Token of the Form of Payment used to pay for the CFAR fee")

    public String getPaymentMethodToken() {
        return paymentMethodToken;
    }


    public void setPaymentMethodToken(String paymentMethodToken) {
        this.paymentMethodToken = paymentMethodToken;
    }

    public ProcessCfarPaymentTokenRequest pnrReference(String pnrReference) {

        this.pnrReference = pnrReference;
        return this;
    }

    /**
     * Get pnrReference
     * @return pnrReference
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public String getPnrReference() {
        return pnrReference;
    }


    public void setPnrReference(String pnrReference) {
        this.pnrReference = pnrReference;
    }


    public ProcessCfarPaymentTokenRequest emailAddress(String emailAddress) {

        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Get emailAddress
     * @return emailAddress
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public String getEmailAddress() {
        return emailAddress;
    }


    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ProcessCfarPaymentTokenRequest firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * First name of the cardholder
     * @return firstName
     **/
    @ApiModelProperty(example = "John", required = true, value = "First name of the cardholder")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ProcessCfarPaymentTokenRequest lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Last name of the cardholder
     * @return lastName
     **/
    @ApiModelProperty(example = "Smith", required = true, value = "Last name of the cardholder")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ProcessCfarPaymentTokenRequest addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    /**
     * Address of the cardholder (first line)
     * @return addressLine1
     **/
    @ApiModelProperty(example = "123 12th St", value = "Address of the cardholder (first line)")
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public ProcessCfarPaymentTokenRequest addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    /**
     * Address of the cardholder (second line)
     * @return addressLine2
     **/
    @ApiModelProperty(example = "Building B", value = "Address of the cardholder (second line)")
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public ProcessCfarPaymentTokenRequest city(String city) {
        this.city = city;
        return this;
    }

    /**
     * City of the cardholder
     * @return city
     **/
    @ApiModelProperty(example = "Quebec City", value = "City of the cardholder")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ProcessCfarPaymentTokenRequest stateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
        return this;
    }

    /**
     * State or province of the cardholder
     * @return stateOrProvince
     **/
    @ApiModelProperty(example = "QC", value = "State or province of the cardholder")
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public ProcessCfarPaymentTokenRequest postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Postal code  of the cardholder
     * @return postalCode
     **/
    @ApiModelProperty(example = "G1R 4S9", value = "Postal code  of the cardholder")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public ProcessCfarPaymentTokenRequest country(String country) {
        this.country = country;
        return this;
    }

    /**
     * Country of the cardholder
     * @return country
     **/
    @ApiModelProperty(example = "CA", value = "Country of the cardholder")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;


        ProcessCfarPaymentTokenRequest processCfarPaymentTokenRequest = (ProcessCfarPaymentTokenRequest) o;
        return Objects.equals(this.paymentMethodToken, processCfarPaymentTokenRequest.paymentMethodToken) &&
                Objects.equals(this.pnrReference, processCfarPaymentTokenRequest.pnrReference) &&
                Objects.equals(this.emailAddress, processCfarPaymentTokenRequest.emailAddress) &&
                Objects.equals(this.firstName, processCfarPaymentTokenRequest.firstName) &&
                Objects.equals(this.lastName, processCfarPaymentTokenRequest.lastName) &&
                Objects.equals(this.addressLine1, processCfarPaymentTokenRequest.addressLine1) &&
                Objects.equals(this.addressLine2, processCfarPaymentTokenRequest.addressLine2) &&
                Objects.equals(this.city, processCfarPaymentTokenRequest.city) &&
                Objects.equals(this.stateOrProvince, processCfarPaymentTokenRequest.stateOrProvince) &&
                Objects.equals(this.postalCode, processCfarPaymentTokenRequest.postalCode) &&
                Objects.equals(this.country, processCfarPaymentTokenRequest.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentMethodToken, pnrReference, emailAddress, firstName, lastName, addressLine1, addressLine2, city, stateOrProvince, postalCode, country);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessCfarPaymentRequest {\n");

        sb.append("    paymentMethodToken: ").append(toIndentedString(paymentMethodToken)).append("\n");
        sb.append("    pnrReference: ").append(toIndentedString(pnrReference)).append("\n");
        sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
        sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
        sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
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



