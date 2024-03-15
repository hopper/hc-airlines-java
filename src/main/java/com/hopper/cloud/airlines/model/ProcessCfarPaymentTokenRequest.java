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

    public static HashSet<String> openapiFields;
    public static HashSet<String> openapiRequiredFields;

    static {
        // a set of all properties/fields (JSON key names)
        openapiFields = new HashSet<String>();
        openapiFields.add("payment_method_token");
        openapiFields.add("pnr_reference");
        openapiFields.add("email_address");
        openapiFields.add("first_name");
        openapiFields.add("last_name");
        openapiFields.add("address_line1");
        openapiFields.add("address_line2");
        openapiFields.add("city");
        openapiFields.add("postal_code");
        openapiFields.add("state_or_province");
        openapiFields.add("country");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiFields.add("payment_method_token");
        openapiFields.add("first_name");
        openapiFields.add("last_name");
        openapiFields.add("pnr_reference");
        openapiFields.add("email_address");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj JSON Object
     * @throws IOException if the JSON Object is invalid with respect to ProcessCfarPaymentTokenRequest
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (ProcessCfarPaymentTokenRequest.openapiRequiredFields.isEmpty()) {
                return;
            } else { // has required fields
                throw new IllegalArgumentException(String.format("The required field(s) %s in ProcessCfarPaymentTokenRequest is not found in the empty JSON string", ProcessCfarPaymentTokenRequest.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!ProcessCfarPaymentTokenRequest.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ProcessCfarPaymentTokenRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : ProcessCfarPaymentTokenRequest.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
            }
        }
        if (jsonObj.get("payment_method_token") != null && !jsonObj.get("payment_method_token").isJsonPrimitive() && !jsonObj.get("payment_method_token").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `payment_method_token` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payment_method_token").toString()));
        }
        if (jsonObj.get("pnr_reference") != null && !jsonObj.get("pnr_reference").isJsonPrimitive() && !jsonObj.get("pnr_reference").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `pnr_reference` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pnr_reference").toString()));
        }
        if (jsonObj.get("email_address") != null && !jsonObj.get("email_address").isJsonPrimitive() && !jsonObj.get("email_address").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `email_address` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email_address").toString()));
        }
        if (jsonObj.get("first_name") != null && !jsonObj.get("first_name").isJsonPrimitive() && !jsonObj.get("first_name").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `first_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("first_name").toString()));
        }
        if (jsonObj.get("last_name") != null && !jsonObj.get("last_name").isJsonPrimitive() && !jsonObj.get("last_name").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `last_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("last_name").toString()));
        }
        if (jsonObj.get("address_line1") != null && !jsonObj.get("address_line1").isJsonPrimitive() && !jsonObj.get("address_line1").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `address_line1` to be a primitive type in the JSON string but got `%s`", jsonObj.get("address_line1").toString()));
        }
        if (jsonObj.get("address_line2") != null && !jsonObj.get("address_line2").isJsonPrimitive() && !jsonObj.get("address_line2").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `address_line2` to be a primitive type in the JSON string but got `%s`", jsonObj.get("address_line2").toString()));
        }
        if (jsonObj.get("city") != null && !jsonObj.get("city").isJsonPrimitive() && !jsonObj.get("city").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `city` to be a primitive type in the JSON string but got `%s`", jsonObj.get("city").toString()));
        }
        if (jsonObj.get("state_or_province") != null && !jsonObj.get("state_or_province").isJsonPrimitive() && !jsonObj.get("state_or_province").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `state_or_province` to be a primitive type in the JSON string but got `%s`", jsonObj.get("state_or_province").toString()));
        }
        if (jsonObj.get("postal_code") != null && !jsonObj.get("postal_code").isJsonPrimitive() && !jsonObj.get("postal_code").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `postal_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("postal_code").toString()));
        }
        if (jsonObj.get("country") != null && !jsonObj.get("country").isJsonPrimitive() && !jsonObj.get("country").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `country` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country").toString()));
        }
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
                    validateJsonObject(jsonObj);
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



