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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hopper.cloud.airlines.JSON;
import io.swagger.annotations.ApiModel;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * An object detailing a passenger tax
 */
@ApiModel(description = "An object detailing a passenger tax")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CfarPassengerTax {
    public static final String SERIALIZED_NAME_CODE = "code";
    @SerializedName(SERIALIZED_NAME_CODE)
    private String code;
    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private String amount;
    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    public CfarPassengerTax() {
    }

    public CfarPassengerTax code(String code) {
        this.code = code;
        return this;
    }

    @javax.annotation.Nonnull
    public String getCode() {
        return code;
    }

    public void setCode(String name) {
        this.code = code;
    }

    public CfarPassengerTax amount(String amount) {
        this.amount = amount;
        return this;
    }

    @javax.annotation.Nonnull
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public CfarPassengerTax currency(String currency) {

        this.currency = currency;
        return this;
    }

    /**
     * The currency code
     *
     * @return currencyCode
     **/
    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CfarPassengerTax passengerTax = (CfarPassengerTax) o;
        return Objects.equals(this.code, passengerTax.code) &&
                Objects.equals(this.amount, passengerTax.amount) &&
                Objects.equals(this.currency, passengerTax.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, amount, currency);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CfarPassengerTax {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
        openapiFields.add("code");
        openapiFields.add("amount");
        openapiFields.add("currency");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("code");
        openapiRequiredFields.add("amount");
        openapiRequiredFields.add("currency");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj JSON Object
     * @throws IOException if the JSON Object is invalid with respect to CfarTax
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (CfarPassengerTax.openapiRequiredFields.isEmpty()) {
                return;
            } else { // has required fields
                throw new IllegalArgumentException(String.format("The required field(s) %s in CfarPassengerTax is not found in the empty JSON string", CfarPassengerTax.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CfarPassengerTax.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CfarPassengerTax` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : CfarPassengerTax.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
            }
        }
        if (jsonObj.get("code") != null && !jsonObj.get("code").isJsonPrimitive() && !jsonObj.get("code").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("code").toString()));
        }
        if (jsonObj.get("amount") != null && !jsonObj.get("amount").isJsonPrimitive() && !jsonObj.get("amount").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `amount` to be a primitive type in the JSON string but got `%s`", jsonObj.get("amount").toString()));
        }
        if (jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonPrimitive() && !jsonObj.get("currency").isJsonNull()) {
            throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!CfarPassengerTax.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'CfarPassengerTax' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CfarPassengerTax> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(CfarPassengerTax.class));

            return (TypeAdapter<T>) new TypeAdapter<CfarPassengerTax>() {
                @Override
                public void write(JsonWriter out, CfarPassengerTax value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CfarPassengerTax read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CfarPassengerTax given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CfarTax
     * @throws IOException if the JSON string is invalid with respect to CfarTax
     */
    public static CfarPassengerTax fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CfarPassengerTax.class);
    }

    /**
     * Convert an instance of CfarPassengerTax to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

