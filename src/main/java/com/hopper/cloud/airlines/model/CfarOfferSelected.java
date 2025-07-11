/*
 * Airline API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.hopper.cloud.airlines.model;

import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hopper.cloud.airlines.JSON;

/**
 * The user has selected the offer(s)
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-19T17:27:15.383558719Z[Etc/UTC]", comments = "Generator version: 7.10.0")
public class CfarOfferSelected {
    public static final String SERIALIZED_NAME_OCCURRED_DATE_TIME = "occurred_date_time";
    @SerializedName(SERIALIZED_NAME_OCCURRED_DATE_TIME)
    @javax.annotation.Nonnull
    private OffsetDateTime occurredDateTime;

    public static final String SERIALIZED_NAME_CFAR_OFFERS_IDS = "cfar_offers_ids";
    @SerializedName(SERIALIZED_NAME_CFAR_OFFERS_IDS)
    @javax.annotation.Nonnull
    private List<String> cfarOffersIds;

    public static final String SERIALIZED_NAME_TYPE = "type";
    @SerializedName(SERIALIZED_NAME_TYPE)
    @javax.annotation.Nonnull
    private String type;

    public CfarOfferSelected() {
    }

    public CfarOfferSelected occurredDateTime(@javax.annotation.Nonnull OffsetDateTime occurredDateTime) {
        this.occurredDateTime = occurredDateTime;
        return this;
    }

    /**
     * A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime;  the date and time at which an event occurred on a client device
     *
     * @return occurredDateTime
     */
    @javax.annotation.Nonnull
    public OffsetDateTime getOccurredDateTime() {
        return occurredDateTime;
    }

    public void setOccurredDateTime(@javax.annotation.Nonnull OffsetDateTime occurredDateTime) {
        this.occurredDateTime = occurredDateTime;
    }


    public CfarOfferSelected cfarOffersIds(@javax.annotation.Nonnull List<String> cfarOffersIds) {
        this.cfarOffersIds = cfarOffersIds;
        return this;
    }

    public CfarOfferSelected addCfarOffersIdsItem(String cfarOffersIdsItem) {
        if (this.cfarOffersIds == null) {
            this.cfarOffersIds = new ArrayList<>();
        }
        this.cfarOffersIds.add(cfarOffersIdsItem);
        return this;
    }

    /**
     * Get cfarOffersIds
     *
     * @return cfarOffersIds
     */
    @javax.annotation.Nonnull
    public List<String> getCfarOffersIds() {
        return cfarOffersIds;
    }

    public void setCfarOffersIds(@javax.annotation.Nonnull List<String> cfarOffersIds) {
        this.cfarOffersIds = cfarOffersIds;
    }


    public CfarOfferSelected type(@javax.annotation.Nonnull String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     */
    @javax.annotation.Nonnull
    public String getType() {
        return type;
    }

    public void setType(@javax.annotation.Nonnull String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CfarOfferSelected cfarOfferSelected = (CfarOfferSelected) o;
        return Objects.equals(this.occurredDateTime, cfarOfferSelected.occurredDateTime) &&
                Objects.equals(this.cfarOffersIds, cfarOfferSelected.cfarOffersIds) &&
                Objects.equals(this.type, cfarOfferSelected.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(occurredDateTime, cfarOffersIds, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CfarOfferSelected {\n");
        sb.append("    occurredDateTime: ").append(toIndentedString(occurredDateTime)).append("\n");
        sb.append("    cfarOffersIds: ").append(toIndentedString(cfarOffersIds)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

    static {
        // a set of all properties/fields (JSON key names)
        openapiFields = new HashSet<String>();
        openapiFields.add("occurred_date_time");
        openapiFields.add("cfar_offers_ids");
        openapiFields.add("type");
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!CfarOfferSelected.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'CfarOfferSelected' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CfarOfferSelected> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(CfarOfferSelected.class));

            return (TypeAdapter<T>) new TypeAdapter<CfarOfferSelected>() {
                @Override
                public void write(JsonWriter out, CfarOfferSelected value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CfarOfferSelected read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CfarOfferSelected given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CfarOfferSelected
     * @throws IOException if the JSON string is invalid with respect to CfarOfferSelected
     */
    public static CfarOfferSelected fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CfarOfferSelected.class);
    }

    /**
     * Convert an instance of CfarOfferSelected to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

