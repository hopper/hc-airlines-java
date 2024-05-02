/*
 * Airline API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.hopper.cloud.airlines.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;

import com.google.gson.reflect.TypeToken;

import com.hopper.cloud.airlines.JSON;

/**
 * Update CFAR contract request
 */
@ApiModel(description = "Update CFAR contract request")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateCfarContractRequest {
    public static final String SERIALIZED_NAME_PNR_REFERENCE = "pnr_reference";
    @SerializedName(SERIALIZED_NAME_PNR_REFERENCE)
    private String pnrReference;

    public static final String SERIALIZED_NAME_EMAIL_ADDRESS = "email_address";
    @SerializedName(SERIALIZED_NAME_EMAIL_ADDRESS)
    private String emailAddress;

    public static final String SERIALIZED_NAME_STATUS = "status";
    @SerializedName(SERIALIZED_NAME_STATUS)
    private CfarContractStatus status;

    public static final String SERIALIZED_NAME_PHONE_NUMBER = "phone_number";
    @SerializedName(SERIALIZED_NAME_PHONE_NUMBER)
    private String phoneNumber;

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

    public static final String SERIALIZED_NAME_TAXES_TOTAL = "taxes_total";
    @SerializedName(SERIALIZED_NAME_TAXES_TOTAL)
    private String taxesTotal;

    public static final String SERIALIZED_NAME_TAXES = "taxes";
    @SerializedName(SERIALIZED_NAME_TAXES)
    private List<CfarTax> taxes = new ArrayList<>();

    public static final String SERIALIZED_NAME_ITINERARY_PRICING = "itinerary_pricing";
    @SerializedName(SERIALIZED_NAME_ITINERARY_PRICING)
    private CfarItineraryPricing itineraryPricing;

    public UpdateCfarContractRequest() {
    }

    public UpdateCfarContractRequest pnrReference(String pnrReference) {

        this.pnrReference = pnrReference;
        return this;
    }

    /**
     * Get pnrReference
     *
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


    public UpdateCfarContractRequest emailAddress(String emailAddress) {

        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Get emailAddress
     *
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


    public UpdateCfarContractRequest status(CfarContractStatus status) {

        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public CfarContractStatus getStatus() {
        return status;
    }


    public void setStatus(CfarContractStatus status) {
        this.status = status;
    }

    /**
     * Phone number of the customer
     *
     * @return phoneNumber
     **/
    @ApiModelProperty(example = "12345678900", value = "Phone number of the customer")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UpdateCfarContractRequest firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * First name of the cardholder
     *
     * @return firstName
     **/
    @ApiModelProperty(example = "John", value = "First name of the cardholder")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UpdateCfarContractRequest lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Last name of the cardholder
     *
     * @return lastName
     **/
    @ApiModelProperty(example = "Smith", value = "Last name of the cardholder")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UpdateCfarContractRequest addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    /**
     * Address of the cardholder (first line)
     *
     * @return addressLine1
     **/
    @ApiModelProperty(example = "123 12th St", value = "Address of the cardholder (first line)")
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public UpdateCfarContractRequest addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    /**
     * Address of the cardholder (second line)
     *
     * @return addressLine2
     **/
    @ApiModelProperty(example = "Building B", value = "Address of the cardholder (second line)")
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public UpdateCfarContractRequest city(String city) {
        this.city = city;
        return this;
    }

    /**
     * City of the cardholder
     *
     * @return city
     **/
    @ApiModelProperty(example = "Quebec City", value = "City of the cardholder")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UpdateCfarContractRequest stateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
        return this;
    }

    /**
     * State or province of the cardholder
     *
     * @return stateOrProvince
     **/
    @ApiModelProperty(example = "QC", value = "State or province of the cardholder")
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public UpdateCfarContractRequest postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Postal code  of the cardholder
     *
     * @return postalCode
     **/
    @ApiModelProperty(example = "G1R 4S9", value = "Postal code  of the cardholder")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public UpdateCfarContractRequest country(String country) {
        this.country = country;
        return this;
    }

    /**
     * Country of the cardholder
     *
     * @return country
     **/
    @ApiModelProperty(example = "CA", value = "Country of the cardholder")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTaxesTotal() {
        return taxesTotal;
    }

    public void setTaxesTotal(String taxesTotal) {
        this.taxesTotal = taxesTotal;
    }

    public UpdateCfarContractRequest taxes(List<CfarTax> taxes) {

        this.taxes = taxes;
        return this;
    }

    public UpdateCfarContractRequest addCfarTaxItem(CfarTax cfarTaxItem) {
        if (this.taxes != null) {
            this.taxes.add(cfarTaxItem);
        }
        return this;
    }

    public List<CfarTax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<CfarTax> taxes) {
        this.taxes = taxes;
    }

    public UpdateCfarContractRequest itineraryPricing(CfarItineraryPricing itineraryPricing) {
        this.itineraryPricing = itineraryPricing;
        return this;
    }

    public CfarItineraryPricing getItineraryPricing() {
        return itineraryPricing;
    }

    public void setItineraryPricing(CfarItineraryPricing itineraryPricing) {
        this.itineraryPricing = itineraryPricing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateCfarContractRequest updateCfarContractRequest = (UpdateCfarContractRequest) o;
        return Objects.equals(this.pnrReference, updateCfarContractRequest.pnrReference) &&
                Objects.equals(this.emailAddress, updateCfarContractRequest.emailAddress) &&
                Objects.equals(this.status, updateCfarContractRequest.status) &&
                Objects.equals(this.phoneNumber, updateCfarContractRequest.phoneNumber) &&
                Objects.equals(this.firstName, updateCfarContractRequest.firstName) &&
                Objects.equals(this.lastName, updateCfarContractRequest.lastName) &&
                Objects.equals(this.addressLine1, updateCfarContractRequest.addressLine1) &&
                Objects.equals(this.addressLine2, updateCfarContractRequest.addressLine2) &&
                Objects.equals(this.city, updateCfarContractRequest.city) &&
                Objects.equals(this.stateOrProvince, updateCfarContractRequest.stateOrProvince) &&
                Objects.equals(this.postalCode, updateCfarContractRequest.postalCode) &&
                Objects.equals(this.country, updateCfarContractRequest.country) &&
                Objects.equals(this.taxesTotal, updateCfarContractRequest.taxesTotal) &&
                Objects.equals(this.taxes, updateCfarContractRequest.taxes) &&
                Objects.equals(this.itineraryPricing, updateCfarContractRequest.itineraryPricing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, pnrReference, emailAddress, phoneNumber, firstName, lastName, addressLine1, addressLine2, city, stateOrProvince, postalCode, country, taxesTotal, taxes, itineraryPricing);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateCfarContractRequest {\n");

        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    pnrReference: ").append(toIndentedString(pnrReference)).append("\n");
        sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
        sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
        sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
        sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    taxesTotal: ").append(toIndentedString(taxesTotal)).append("\n");
        sb.append("    taxes: ").append(toIndentedString(taxes)).append("\n");
        sb.append("    itineraryPricing: ").append(toIndentedString(itineraryPricing)).append("\n");
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
            if (!UpdateCfarContractRequest.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'UpdateCfarContractRequest' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<UpdateCfarContractRequest> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(UpdateCfarContractRequest.class));

            return (TypeAdapter<T>) new TypeAdapter<UpdateCfarContractRequest>() {
                @Override
                public void write(JsonWriter out, UpdateCfarContractRequest value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public UpdateCfarContractRequest read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of UpdateCfarContractRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of UpdateCfarContractRequest
     * @throws IOException if the JSON string is invalid with respect to UpdateCfarContractRequest
     */
    public static UpdateCfarContractRequest fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, UpdateCfarContractRequest.class);
    }

    /**
     * Convert an instance of UpdateCfarContractRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

