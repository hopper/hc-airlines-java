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
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * An object detailing a tax associated with a passenger
 */
@ApiModel(description = "An object detailing a tax associated with a passenger")
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

    /**
     * Code of the tax
     * @return code
     **/
    @javax.annotation.Nonnull
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
     * Currency of the tax
     *
     * @return currency
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "USD", required = true, value = "Currency of the tax")
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
        CfarPassengerTax cfarPassengerTax = (CfarPassengerTax) o;
        return Objects.equals(this.code, cfarPassengerTax.code) &&
                Objects.equals(this.amount, cfarPassengerTax.amount) &&
                Objects.equals(this.currency, cfarPassengerTax.currency);
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
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CfarPassengerTax given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CfarPassengerTax
     * @throws IOException if the JSON string is invalid with respect to CfarPassengerTax
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

