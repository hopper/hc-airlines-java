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
 * An object detailing a passenger
 */
@ApiModel(description = "An object detailing a fare rule")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FareRule {
    public static final String SERIALIZED_NAME_MODIFICATION_TYPE = "modification_type";
    @SerializedName(SERIALIZED_NAME_MODIFICATION_TYPE)
    private ModificationType modificationType;

    public static final String SERIALIZED_NAME_MODIFICATION_TIME = "modification_time";
    @SerializedName(SERIALIZED_NAME_MODIFICATION_TIME)
    private ModificationTime modificationTime;

    public static final String SERIALIZED_NAME_ALLOWED = "allowed";
    @SerializedName(SERIALIZED_NAME_ALLOWED)
    private Boolean allowed = null;

    public static final String SERIALIZED_NAME_FEE = "fee";
    @SerializedName(SERIALIZED_NAME_FEE)
    private String fee = null;

    public static final String SERIALIZED_NAME_PERCENTAGE = "percentage";
    @SerializedName(SERIALIZED_NAME_PERCENTAGE)
    private String percentage = null;

    public static final String SERIALIZED_NAME_REFUND_METHOD = "refundMethod";
    @SerializedName(SERIALIZED_NAME_REFUND_METHOD)
    private AirlineRefundMethod refundMethod = null;

    public FareRule() {
    }

    public FareRule modificationType(ModificationType modificationType) {
        this.modificationType = modificationType;
        return this;
    }

    /**
     * Get modificationType
     * @return modificationType
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public ModificationType getModificationType() {
        return modificationType;
    }

    public void setModificationType(ModificationType modificationType) {
        this.modificationType = modificationType;
    }

    public FareRule modificationTime(ModificationTime modificationTime) {
        this.modificationTime = modificationTime;
        return this;
    }

    /**
     * Get modificationTime
     * @return modificationTime
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    public ModificationTime getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(ModificationTime modificationTime) {
        this.modificationTime = modificationTime;
    }

    public FareRule allowed(Boolean allowed) {
        this.allowed = allowed;
        return this;
    }

    /**
     * Determines if that type of modifications at this time is allowed
     * @return allowed
     **/
    @ApiModelProperty(required = true, value = "Determines if that type of modifications at this time is allowed")
    public Boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(Boolean allowed) {
        this.allowed = allowed;
    }

    public FareRule fee(String fee) {
        this.fee = fee;
        return this;
    }

    /**
     * Amount to be paid as penalty fee to perform the modification
     * @return fee
     **/
    @ApiModelProperty(value = "Amount to be paid as penalty fee to perform the modification")
    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public FareRule percentage(String percentage) {
        this.percentage = percentage;
        return this;
    }

    /**
     * Percentage of the fare to be paid as penalty to perform the modification
     * @return percentage
     **/
    @ApiModelProperty(value = "Percentage of the fare to be paid as penalty to perform the modification")
    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public FareRule refundMethod(AirlineRefundMethod refundMethod) {
        this.refundMethod = refundMethod;
        return this;
    }

    /**
     * Get refundMethod
     * @return refundMethod
     **/
    @ApiModelProperty(value = "")
    public AirlineRefundMethod getRefundMethod() {
        return refundMethod;
    }

    public void setRefundMethod(AirlineRefundMethod refundMethod) {
        this.refundMethod = refundMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FareRule fareRule = (FareRule) o;
        return Objects.equals(this.modificationType, fareRule.modificationType) &&
                Objects.equals(this.modificationTime, fareRule.modificationTime) &&
                Objects.equals(this.allowed, fareRule.allowed) &&
                Objects.equals(this.fee, fareRule.fee) &&
                Objects.equals(this.percentage, fareRule.percentage) &&
                Objects.equals(this.refundMethod, fareRule.refundMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modificationType, modificationTime, allowed, fee, percentage, refundMethod);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FareRule {\n");

        sb.append("    modificationType: ").append(toIndentedString(modificationType)).append("\n");
        sb.append("    modificationTime: ").append(toIndentedString(modificationTime)).append("\n");
        sb.append("    allowed: ").append(toIndentedString(allowed)).append("\n");
        sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
        sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
        sb.append("    refundMethod: ").append(toIndentedString(refundMethod)).append("\n");
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
            if (!FareRule.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'FareRule' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<FareRule> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(FareRule.class));

            return (TypeAdapter<T>) new TypeAdapter<FareRule>() {
                @Override
                public void write(JsonWriter out, FareRule value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public FareRule read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of FareRule given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of FareRule
     * @throws IOException if the JSON string is invalid with respect to FareRule
     */
    public static FareRule fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, FareRule.class);
    }

    /**
     * Convert an instance of FareRule to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

