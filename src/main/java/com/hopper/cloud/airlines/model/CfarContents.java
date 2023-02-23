
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
import java.util.*;
import java.util.Map.Entry;

/**
 * An object detailing the contents for an offer
 */
@ApiModel(description = "An object detailing the contents for an offer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CfarContents {
    public static final String SERIALIZED_NAME_BULLET_POINTS = "bullet_points";
    @SerializedName(SERIALIZED_NAME_BULLET_POINTS)
    private List<String> bulletPoints;

    public static final String SERIALIZED_NAME_LABELS = "labels";
    @SerializedName(SERIALIZED_NAME_LABELS)
    private Map<String,String> labels;

    public CfarContents() {
    }

    public CfarContents bulletPoints(List<String> bulletPoints) {
        this.bulletPoints = bulletPoints;
        return this;
    }

    public List<String> getBulletPoints() {
        return bulletPoints;
    }

    public void setBulletPoints(List<String> bulletPoints) {
        this.bulletPoints = bulletPoints;
    }

    public CfarContents addBulletPointsItem(String bulletPoint) {
        if (this.bulletPoints != null) {
            this.bulletPoints.add(bulletPoint);
        }
        return this;
    }
    public CfarContents labels(Map<String,String> labels) {
        this.labels = labels;
        return this;
    }

    public Map<String,String> getLabels() {
        return labels;
    }

    public CfarContents putLabelsItem(String key, String value) {
        this.labels.put(key, value);
        return this;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CfarContents cfarContents = (CfarContents) o;
        return Objects.equals(this.labels, cfarContents.labels) &&
                Objects.equals(this.bulletPoints, cfarContents.bulletPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labels, bulletPoints);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CfarContents {\n");
        sb.append("    bullet_points: ").append(toIndentedString(bulletPoints)).append("\n");
        sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
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
        openapiFields.add("labels");
        openapiFields.add("bullet_points");
        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("labels");
        openapiRequiredFields.add("bullet_points");
    }

    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj JSON Object
     * @throws IOException if the JSON Object is invalid with respect to CfarContents
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
        if (jsonObj == null) {
            if (CfarContents.openapiRequiredFields.isEmpty()) {
                return;
            } else { // has required fields
                throw new IllegalArgumentException(String.format("The required field(s) %s in CfarContents is not found in the empty JSON string", CfarContents.openapiRequiredFields.toString()));
            }
        }

        Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
        // check to see if the JSON string contains additional fields
        for (Entry<String, JsonElement> entry : entries) {
            if (!CfarContents.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CfarContents` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : CfarContents.openapiRequiredFields) {
            if (jsonObj.get(requiredField) == null) {
                throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
            }
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!CfarContents.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'CfarContents' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CfarContents> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(CfarContents.class));

            return (TypeAdapter<T>) new TypeAdapter<CfarContents>() {
                @Override
                public void write(JsonWriter out, CfarContents value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CfarContents read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    validateJsonObject(jsonObj);
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CfarContents given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CfarContents
     * @throws IOException if the JSON string is invalid with respect to CfarContents
     */
    public static CfarContents fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CfarContents.class);
    }

    /**
     * Convert an instance of CfarContents to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

