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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hopper.cloud.airlines.model.CfarItinerary;
import com.hopper.cloud.airlines.model.PaymentMethod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import com.hopper.cloud.airlines.JSON;

/**
 * A create CFAR contract request
 */
@ApiModel(description = "A create CFAR contract request")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
@JsonInclude(JsonInclude.Include. NON_NULL)
public class CreateCfarContractRequest {
  public static final String SERIALIZED_NAME_OFFER_IDS = "offer_ids";
  @SerializedName(SERIALIZED_NAME_OFFER_IDS)
  private List<String> offerIds = new ArrayList<>();

  public static final String SERIALIZED_NAME_ITINERARY = "itinerary";
  @SerializedName(SERIALIZED_NAME_ITINERARY)
  private CfarItinerary itinerary;

  public static final String SERIALIZED_NAME_EXT_ATTRIBUTES = "ext_attributes";
  @SerializedName(SERIALIZED_NAME_EXT_ATTRIBUTES)
  private Map<String, String> extAttributes = new HashMap<>();

  public static final String SERIALIZED_NAME_PNR_REFERENCE = "pnr_reference";
  @SerializedName(SERIALIZED_NAME_PNR_REFERENCE)
  private String pnrReference;

  public CreateCfarContractRequest() { 
  }

  public CreateCfarContractRequest offerIds(List<String> offerIds) {
    
    this.offerIds = offerIds;
    return this;
  }

  public CreateCfarContractRequest addOfferIdsItem(String offerIdsItem) {
    this.offerIds.add(offerIdsItem);
    return this;
  }

   /**
   * Get offerIds
   * @return offerIds
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public List<String> getOfferIds() {
    return offerIds;
  }


  public void setOfferIds(List<String> offerIds) {
    this.offerIds = offerIds;
  }


  public CreateCfarContractRequest itinerary(CfarItinerary itinerary) {
    
    this.itinerary = itinerary;
    return this;
  }

   /**
   * Get itinerary
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


  public CreateCfarContractRequest extAttributes(Map<String, String> extAttributes) {
    
    this.extAttributes = extAttributes;
    return this;
  }

  public CreateCfarContractRequest putExtAttributesItem(String key, String extAttributesItem) {
    this.extAttributes.put(key, extAttributesItem);
    return this;
  }

   /**
   * Get extAttributes
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


  public CreateCfarContractRequest pnrReference(String pnrReference) {
    
    this.pnrReference = pnrReference;
    return this;
  }

   /**
   * Get pnrReference
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



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCfarContractRequest createCfarContractRequest = (CreateCfarContractRequest) o;
    return Objects.equals(this.offerIds, createCfarContractRequest.offerIds) &&
        Objects.equals(this.itinerary, createCfarContractRequest.itinerary) &&
        Objects.equals(this.extAttributes, createCfarContractRequest.extAttributes) &&
        Objects.equals(this.pnrReference, createCfarContractRequest.pnrReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offerIds, itinerary, extAttributes, pnrReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCfarContractRequest {\n");
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

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateCfarContractRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateCfarContractRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateCfarContractRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateCfarContractRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateCfarContractRequest>() {
           @Override
           public void write(JsonWriter out, CreateCfarContractRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CreateCfarContractRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CreateCfarContractRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CreateCfarContractRequest
  * @throws IOException if the JSON string is invalid with respect to CreateCfarContractRequest
  */
  public static CreateCfarContractRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateCfarContractRequest.class);
  }

 /**
  * Convert an instance of CreateCfarContractRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

