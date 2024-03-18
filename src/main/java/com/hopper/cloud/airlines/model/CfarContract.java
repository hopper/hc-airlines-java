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

import java.util.Objects;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hopper.cloud.airlines.model.CfarContractExercise;
import com.hopper.cloud.airlines.model.CfarStatus;
import com.hopper.cloud.airlines.model.CfarItinerary;
import com.hopper.cloud.airlines.model.CfarOffer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import com.hopper.cloud.airlines.JSON;

/**
 * A CFAR contract
 */
@ApiModel(description = "A CFAR contract")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
public class CfarContract {
    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;

    public static final String SERIALIZED_NAME_REFERENCE = "reference";
    @SerializedName(SERIALIZED_NAME_REFERENCE)
    private String reference;

    public static final String SERIALIZED_NAME_OFFERS = "offers";
    @SerializedName(SERIALIZED_NAME_OFFERS)
    private List<CfarOffer> offers = new ArrayList<>();

    public static final String SERIALIZED_NAME_ITINERARY = "itinerary";
    @SerializedName(SERIALIZED_NAME_ITINERARY)
    private CfarItinerary itinerary;

    public static final String SERIALIZED_NAME_COVERAGE_PERCENTAGE = "coverage_percentage";
    @SerializedName(SERIALIZED_NAME_COVERAGE_PERCENTAGE)
    private String coveragePercentage;

    public static final String SERIALIZED_NAME_COVERAGE = "coverage";
    @SerializedName(SERIALIZED_NAME_COVERAGE)
    private String coverage;

    public static final String SERIALIZED_NAME_PREMIUM = "premium";
    @SerializedName(SERIALIZED_NAME_PREMIUM)
    private String premium;

    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    public static final String SERIALIZED_NAME_TAXES_TOTAL = "taxes_total";
    @SerializedName(SERIALIZED_NAME_TAXES_TOTAL)
    private String taxesTotal;

    public static final String SERIALIZED_NAME_TAXES = "taxes";
    @SerializedName(SERIALIZED_NAME_TAXES)
    private List<CfarTax> taxes = new ArrayList<>();

    public static final String SERIALIZED_NAME_CFAR_PRICES = "cfarPrices";
    @SerializedName(SERIALIZED_NAME_CFAR_PRICES)
    private List<CfarPrice> cfarPrices = new ArrayList<>();

    public static final String SERIALIZED_NAME_CREATED_DATE_TIME = "created_date_time";
    @SerializedName(SERIALIZED_NAME_CREATED_DATE_TIME)
    private OffsetDateTime createdDateTime;

    public static final String SERIALIZED_NAME_EXPIRY_DATE_TIME = "expiry_date_time";
    @SerializedName(SERIALIZED_NAME_EXPIRY_DATE_TIME)
    private OffsetDateTime expiryDateTime;

    public static final String SERIALIZED_NAME_STATUS = "status";
    @SerializedName(SERIALIZED_NAME_STATUS)
    private CfarStatus status;

    public static final String SERIALIZED_NAME_CONFIRMED_DATE_TIME = "confirmed_date_time";
    @SerializedName(SERIALIZED_NAME_CONFIRMED_DATE_TIME)
    private OffsetDateTime confirmedDateTime;

    public static final String SERIALIZED_NAME_PNR_REFERENCE = "pnr_reference";
    @SerializedName(SERIALIZED_NAME_PNR_REFERENCE)
    private String pnrReference;

    public static final String SERIALIZED_NAME_EXT_ATTRIBUTES = "ext_attributes";
    @SerializedName(SERIALIZED_NAME_EXT_ATTRIBUTES)
    private Map<String, String> extAttributes = new HashMap<>();

    public CfarContract() {
    }

    public CfarContract id(String id) {

        this.id = id;
        return this;
    }

    /**
     * Unique identifier for a contract
     *
     * @return id
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "9f4f2f2b-adfd-4f02-83ad-da336ed57ce0", required = true, value = "Unique identifier for a contract")

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public CfarContract reference(String reference) {

        this.reference = reference;
        return this;
    }

    /**
     * Unique reference for a contract
     *
     * @return reference
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "MCNZZABRTYFEUAAL", required = true, value = "Unique reference for a contract")

    public String getReference() {
        return reference;
    }


    public void setReference(String reference) {
        this.reference = reference;
    }


    public CfarContract offers(List<CfarOffer> offers) {

        this.offers = offers;
        return this;
    }

    public CfarContract addOffersItem(CfarOffer offersItem) {
        this.offers.add(offersItem);
        return this;
    }

    /**
     * An offer associated with this contract
     *
     * @return offers
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "60a128e4-a12d-42bf-b977-b6329392282d", required = true, value = "An offer associated with this contract")

    public List<CfarOffer> getOffers() {
        return offers;
    }


    public void setOffers(List<CfarOffer> offers) {
        this.offers = offers;
    }


    public CfarContract itinerary(CfarItinerary itinerary) {

        this.itinerary = itinerary;
        return this;
    }

    /**
     * Get itinerary
     *
     * @return itinerary
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public CfarItinerary getItinerary() {
        return itinerary;
    }


    public void setItinerary(CfarItinerary itinerary) {
        this.itinerary = itinerary;
    }


    public CfarContract coveragePercentage(String coveragePercentage) {

        this.coveragePercentage = coveragePercentage;
        return this;
    }

    /**
     * Percentage of the amount to be refunded to customer compared to flight tickets price
     * @return coveragePercentage
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "80.0", required = true, value = "Percentage of the amount to be refunded to customer compared to flight tickets price")

    public String getCoveragePercentage() {
        return coveragePercentage;
    }


    public void setCoveragePercentage(String coveragePercentage) {
        this.coveragePercentage = coveragePercentage;
    }


    public CfarContract coverage(String coverage) {

        this.coverage = coverage;
        return this;
    }

    /**
     * Total amount to be refunded to user upon CFAR exercise
     *
     * @return coverage
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "361.20", required = true, value = "Total amount to be refunded to user upon CFAR exercise")

    public String getCoverage() {
        return coverage;
    }


    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }


    public CfarContract premium(String premium) {

        this.premium = premium;
        return this;
    }

    /**
     * Get premium
     *
     * @return premium
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public String getPremium() {
        return premium;
    }


    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getTaxesTotal() {
        return taxesTotal;
    }

    public void setTaxesTotal(String taxesTotal) {
        this.taxesTotal = taxesTotal;
    }

    public CfarContract taxes(List<CfarTax> taxes) {

        this.taxes = taxes;
        return this;
    }

    public CfarContract addCfarTaxItem(CfarTax cfarTaxItem) {
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


    public CfarContract cfarPrices(List<CfarPrice> cfarPrices) {

        this.cfarPrices = cfarPrices;
        return this;
    }

    public CfarContract addSlicesItem(CfarPrice cfarPricesItem) {
        this.cfarPrices.add(cfarPricesItem);
        return this;
    }

    /**
     * List of prices associated to the contract
     * @return cfarPrices
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "List of prices associated to the contract")
    public List<CfarPrice> getCfarPrices() {
        return cfarPrices;
    }


    public void setCfarPrices(List<CfarPrice> cfarPrices) {
        this.cfarPrices = cfarPrices;
    }

    public CfarContract currency(String currency) {

        this.currency = currency;
        return this;
    }

    /**
     * Currency of the contract
     *
     * @return currency
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "CAD", required = true, value = "Currency of the contract")

    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public CfarContract createdDateTime(OffsetDateTime createdDateTime) {

        this.createdDateTime = createdDateTime;
        return this;
    }

    /**
     * A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which the contract was created
     *
     * @return createdDateTime
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "2020-11-02T18:34:30Z", required = true, value = "A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which the contract was created")

    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }


    public void setCreatedDateTime(OffsetDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }


    public CfarContract expiryDateTime(OffsetDateTime expiryDateTime) {

        this.expiryDateTime = expiryDateTime;
        return this;
    }

    /**
     * Get expiryDateTime
     *
     * @return expiryDateTime
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public OffsetDateTime getExpiryDateTime() {
        return expiryDateTime;
    }


    public void setExpiryDateTime(OffsetDateTime expiryDateTime) {
        this.expiryDateTime = expiryDateTime;
    }


    public CfarContract status(CfarStatus status) {

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

    public CfarStatus getStatus() {
        return status;
    }


    public void setStatus(CfarStatus status) {
        this.status = status;
    }


    public CfarContract confirmedDateTime(OffsetDateTime confirmedDateTime) {

        this.confirmedDateTime = confirmedDateTime;
        return this;
    }

    /**
     * Get confirmedDateTime
     *
     * @return confirmedDateTime
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public OffsetDateTime getConfirmedDateTime() {
        return confirmedDateTime;
    }


    public void setConfirmedDateTime(OffsetDateTime confirmedDateTime) {
        this.confirmedDateTime = confirmedDateTime;
    }

    /**
     * Get pnrReference
     *
     * @return pnrReference
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public String getPnrReference() {
        return pnrReference;
    }


    public void setPnrReference(String pnrReference) {
        this.pnrReference = pnrReference;
    }


    public CfarContract extAttributes(Map<String, String> extAttributes) {

        this.extAttributes = extAttributes;
        return this;
    }

    public CfarContract putExtAttributesItem(String key, String extAttributesItem) {
        this.extAttributes.put(key, extAttributesItem);
        return this;
    }

    /**
     * Get extAttributes
     *
     * @return extAttributes
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public Map<String, String> getExtAttributes() {
        return extAttributes;
    }


    public void setExtAttributes(Map<String, String> extAttributes) {
        this.extAttributes = extAttributes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CfarContract cfarContract = (CfarContract) o;
        return Objects.equals(this.id, cfarContract.id) &&
                Objects.equals(this.reference, cfarContract.reference) &&
                Objects.equals(this.offers, cfarContract.offers) &&
                Objects.equals(this.itinerary, cfarContract.itinerary) &&
                Objects.equals(this.coverage, cfarContract.coverage) &&
                Objects.equals(this.coveragePercentage, cfarContract.coveragePercentage) &&
                Objects.equals(this.premium, cfarContract.premium) &&
                Objects.equals(this.taxesTotal, cfarContract.taxesTotal) &&
                Objects.equals(this.taxes, cfarContract.taxes) &&
                Objects.equals(this.cfarPrices, cfarContract.taxes) &&
                Objects.equals(this.currency, cfarContract.currency) &&
                Objects.equals(this.createdDateTime, cfarContract.createdDateTime) &&
                Objects.equals(this.expiryDateTime, cfarContract.expiryDateTime) &&
                Objects.equals(this.status, cfarContract.status) &&
                Objects.equals(this.confirmedDateTime, cfarContract.confirmedDateTime) &&
                Objects.equals(this.pnrReference, cfarContract.pnrReference) &&
                Objects.equals(this.extAttributes, cfarContract.extAttributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offers, reference, itinerary, coverage, coveragePercentage, premium, taxesTotal, taxes, cfarPrices, currency, createdDateTime, expiryDateTime, status, confirmedDateTime, pnrReference, extAttributes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CfarContract {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    offers: ").append(toIndentedString(offers)).append("\n");
        sb.append("    itinerary: ").append(toIndentedString(itinerary)).append("\n");
        sb.append("    coverage: ").append(toIndentedString(coverage)).append("\n");
        sb.append("    coveragePercentage: ").append(toIndentedString(coveragePercentage)).append("\n");
        sb.append("    premium: ").append(toIndentedString(premium)).append("\n");
        sb.append("    taxes_total: ").append(toIndentedString(taxesTotal)).append("\n");
        sb.append("    taxes: ").append(toIndentedString(taxes)).append("\n");
        sb.append("    cfarPrices: ").append(toIndentedString(cfarPrices)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    createdDateTime: ").append(toIndentedString(createdDateTime)).append("\n");
        sb.append("    expiryDateTime: ").append(toIndentedString(expiryDateTime)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    confirmedDateTime: ").append(toIndentedString(confirmedDateTime)).append("\n");
        sb.append("    pnrReference: ").append(toIndentedString(pnrReference)).append("\n");
        sb.append("    extAttributes: ").append(toIndentedString(extAttributes)).append("\n");
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
        openapiFields.add("id");
        openapiFields.add("reference");
        openapiFields.add("offers");
        openapiFields.add("itinerary");
        openapiFields.add("coverage");
        openapiFields.add("coverage_percentage");
        openapiFields.add("premium");
        openapiFields.add("taxes_total");
        openapiFields.add("taxes");
        openapiFields.add("cfar_prices");
        openapiFields.add("currency");
        openapiFields.add("created_date_time");
        openapiFields.add("expiry_date_time");
        openapiFields.add("status");
        openapiFields.add("confirmed_date_time");
        openapiFields.add("voided_date_time");
        openapiFields.add("charged_back_date_time");
        openapiFields.add("pnr_reference");
        openapiFields.add("ext_attributes");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("id");
        openapiRequiredFields.add("reference");
        openapiRequiredFields.add("offers");
        openapiRequiredFields.add("itinerary");
        openapiRequiredFields.add("coverage");
        openapiRequiredFields.add("coverage_percentage");
        openapiRequiredFields.add("premium");
        openapiRequiredFields.add("currency");
        openapiRequiredFields.add("cfar_prices");
        openapiRequiredFields.add("created_date_time");
        openapiRequiredFields.add("expiry_date_time");
        openapiRequiredFields.add("status");
        openapiRequiredFields.add("ext_attributes");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj JSON Object
     * @throws IOException if the JSON Object is invalid with respect to CfarContract
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (CfarContract.openapiRequiredFields.isEmpty()) {
                return;
            } else { // has required fields
                throw new IllegalArgumentException(String.format("The required field(s) %s in CfarContract is not found in the empty JSON string", CfarContract.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CfarContract.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CfarContract` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : CfarContract.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
            }
        }
        if (jsonObj.get("id") != null && !jsonObj.get("id").isJsonPrimitive() && !jsonObj.get("id").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
        }
        if (jsonObj.get("reference") != null && !jsonObj.get("reference").isJsonPrimitive() && !jsonObj.get("reference").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `reference` to be a primitive type in the JSON string but got `%s`", jsonObj.get("reference").toString()));
        }
        JsonArray jsonArrayOffers = jsonObj.getAsJsonArray("offers");
        if (jsonArrayOffers != null) {
            // ensure the json data is an array
            if (!jsonObj.get("offers").isJsonArray()) {
                throw new IllegalArgumentException(String.format("Expected the field `offers` to be an array in the JSON string but got `%s`", jsonObj.get("offers").toString()));
            }

            // validate the optional field `offers` (array)
            for (int i = 0; i < jsonArrayOffers.size(); i++) {
                CfarOffer.validateJsonObject(jsonArrayOffers.get(i).getAsJsonObject());
            }
            ;
        }
        // validate the optional field `itinerary`
        if (jsonObj.getAsJsonObject("itinerary") != null) {
            CfarItinerary.validateJsonObject(jsonObj.getAsJsonObject("itinerary"));
        }
        if (jsonObj.get("coverage") != null && !jsonObj.get("coverage").isJsonPrimitive() && !jsonObj.get("coverage").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `coverage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("coverage").toString()));
        }
        if (jsonObj.get("coverage_percentage") != null && !jsonObj.get("coverage_percentage").isJsonPrimitive() && !jsonObj.get("coverage_percentage").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `coverage_percentage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("coverage_percentage").toString()));
        }
        if (jsonObj.get("premium") != null && !jsonObj.get("premium").isJsonPrimitive() && !jsonObj.get("premium").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `premium` to be a primitive type in the JSON string but got `%s`", jsonObj.get("premium").toString()));
        }
        if (jsonObj.get("taxes_total") != null && !jsonObj.get("taxes_total").isJsonPrimitive() && !jsonObj.get("taxes_total").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `taxes_total` to be a primitive type in the JSON string but got `%s`", jsonObj.get("taxes_total").toString()));
        }
        if (jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonPrimitive() && !jsonObj.get("currency").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
        }

        if (jsonObj.get("pnr_reference") != null && !jsonObj.get("pnr_reference").isJsonPrimitive() && !jsonObj.get("pnr_reference").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `pnr_reference` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pnr_reference").toString()));
        }

        // validate the optional list `taxes`
        if (jsonObj.get("taxes") != null && !jsonObj.get("taxes").isJsonNull()) {
            JsonArray jsonArrayTaxes = jsonObj.getAsJsonArray("taxes");
            if (jsonArrayTaxes != null) {
                // ensure the json data is an array
                if (!jsonObj.get("taxes").isJsonArray()) {
                    throw new IllegalArgumentException(String.format("Expected the field `taxes` to be an array in the JSON string but got `%s`", jsonObj.get("taxes").toString()));
                }

                // validate the optional field `taxes` (array)
                for (int i = 0; i < jsonArrayTaxes.size(); i++) {
                    CfarTax.validateJsonObject(jsonArrayTaxes.get(i).getAsJsonObject());
                }
                ;
            }
        }

        // validate the optional NonEmptyList `cfarPrices`
        JsonArray jsonArrayCfarPrices = jsonObj.getAsJsonArray("cfar_prices");
        if (jsonArrayCfarPrices != null) {
            // ensure the json data is an array
            if (!jsonObj.get("cfar_prices").isJsonArray()) {
                throw new IllegalArgumentException(String.format("Expected the field `cfar_prices` to be an array in the JSON string but got `%s`", jsonObj.get("cfar_prices").toString()));
            }

            // ensure the json data is a non empty array
            if (jsonArrayCfarPrices.isEmpty()) {
                throw new IllegalArgumentException(String.format("Expected the field `cfar_prices` to be a non empty array in the JSON string"));
            }

            // validate the optional field `cfar_prices` (array)
            for (int i = 0; i < jsonArrayCfarPrices.size(); i++) {
                CfarPrice.validateJsonObject(jsonArrayCfarPrices.get(i).getAsJsonObject());
            };
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!CfarContract.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'CfarContract' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CfarContract> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(CfarContract.class));

            return (TypeAdapter<T>) new TypeAdapter<CfarContract>() {
                @Override
                public void write(JsonWriter out, CfarContract value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CfarContract read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CfarContract given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CfarContract
     * @throws IOException if the JSON string is invalid with respect to CfarContract
     */
    public static CfarContract fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CfarContract.class);
    }

    /**
     * Convert an instance of CfarContract to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

