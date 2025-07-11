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
import com.hopper.cloud.airlines.model.DgItinerary;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * A create DG contract request
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-02T18:35:20.974206513Z[Etc/UTC]", comments = "Generator version: 7.10.0")
public class CreateDgContractRequest {
  public static final String SERIALIZED_NAME_OFFER_IDS = "offer_ids";
  @SerializedName(SERIALIZED_NAME_OFFER_IDS)
  @javax.annotation.Nonnull
  private List<String> offerIds;

  public static final String SERIALIZED_NAME_ITINERARY = "itinerary";
  @SerializedName(SERIALIZED_NAME_ITINERARY)
  @javax.annotation.Nonnull
  private DgItinerary itinerary;

  public static final String SERIALIZED_NAME_EXT_ATTRIBUTES = "ext_attributes";
  @SerializedName(SERIALIZED_NAME_EXT_ATTRIBUTES)
  @javax.annotation.Nonnull
  private Map<String, String> extAttributes;

  public static final String SERIALIZED_NAME_PNR_REFERENCE = "pnr_reference";
  @SerializedName(SERIALIZED_NAME_PNR_REFERENCE)
  @javax.annotation.Nullable
  private String pnrReference;

  public CreateDgContractRequest() {
  }

  public CreateDgContractRequest offerIds(@javax.annotation.Nonnull List<String> offerIds) {
    this.offerIds = offerIds;
    return this;
  }

  public CreateDgContractRequest addOfferIdsItem(String offerIdsItem) {
    if (this.offerIds == null) {
      this.offerIds = new ArrayList<>();
    }
    this.offerIds.add(offerIdsItem);
    return this;
  }

  /**
   * Identifier of the offer(s) for which the contract is created
   * @return offerIds
   */
  @javax.annotation.Nonnull
  public List<String> getOfferIds() {
    return offerIds;
  }

  public void setOfferIds(@javax.annotation.Nonnull List<String> offerIds) {
    this.offerIds = offerIds;
  }


  public CreateDgContractRequest itinerary(@javax.annotation.Nonnull DgItinerary itinerary) {
    this.itinerary = itinerary;
    return this;
  }

  /**
   * Get itinerary
   * @return itinerary
   */
  @javax.annotation.Nonnull
  public DgItinerary getItinerary() {
    return itinerary;
  }

  public void setItinerary(@javax.annotation.Nonnull DgItinerary itinerary) {
    this.itinerary = itinerary;
  }


  public CreateDgContractRequest extAttributes(@javax.annotation.Nonnull Map<String, String> extAttributes) {
    this.extAttributes = extAttributes;
    return this;
  }

  public CreateDgContractRequest putExtAttributesItem(String key, String extAttributesItem) {
    if (this.extAttributes == null) {
      this.extAttributes = new HashMap<>();
    }
    this.extAttributes.put(key, extAttributesItem);
    return this;
  }

  /**
   * Get extAttributes
   * @return extAttributes
   */
  @javax.annotation.Nonnull
  public Map<String, String> getExtAttributes() {
    return extAttributes;
  }

  public void setExtAttributes(@javax.annotation.Nonnull Map<String, String> extAttributes) {
    this.extAttributes = extAttributes;
  }


  public CreateDgContractRequest pnrReference(@javax.annotation.Nullable String pnrReference) {
    this.pnrReference = pnrReference;
    return this;
  }

  /**
   * Reference of the PNR in the airline system
   * @return pnrReference
   */
  @javax.annotation.Nullable
  public String getPnrReference() {
    return pnrReference;
  }

  public void setPnrReference(@javax.annotation.Nullable String pnrReference) {
    this.pnrReference = pnrReference;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDgContractRequest createDgContractRequest = (CreateDgContractRequest) o;
    return Objects.equals(this.offerIds, createDgContractRequest.offerIds) &&
        Objects.equals(this.itinerary, createDgContractRequest.itinerary) &&
        Objects.equals(this.extAttributes, createDgContractRequest.extAttributes) &&
        Objects.equals(this.pnrReference, createDgContractRequest.pnrReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offerIds, itinerary, extAttributes, pnrReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDgContractRequest {\n");
    sb.append("    offerIds: ").append(toIndentedString(offerIds)).append("\n");
    sb.append("    itinerary: ").append(toIndentedString(itinerary)).append("\n");
    sb.append("    extAttributes: ").append(toIndentedString(extAttributes)).append("\n");
    sb.append("    pnrReference: ").append(toIndentedString(pnrReference)).append("\n");
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
    openapiFields.add("offer_ids");
    openapiFields.add("itinerary");
    openapiFields.add("ext_attributes");
    openapiFields.add("pnr_reference");
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateDgContractRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateDgContractRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateDgContractRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateDgContractRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateDgContractRequest>() {
           @Override
           public void write(JsonWriter out, CreateDgContractRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CreateDgContractRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of CreateDgContractRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CreateDgContractRequest
   * @throws IOException if the JSON string is invalid with respect to CreateDgContractRequest
   */
  public static CreateDgContractRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateDgContractRequest.class);
  }

  /**
   * Convert an instance of CreateDgContractRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

