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
public class CreateCfarContractRequest {
  public static final String SERIALIZED_NAME_OFFER_IDS = "offer_ids";
  @SerializedName(SERIALIZED_NAME_OFFER_IDS)
  private List<String> offerIds = new ArrayList<>();

  public static final String SERIALIZED_NAME_ITINERARY = "itinerary";
  @SerializedName(SERIALIZED_NAME_ITINERARY)
  private CfarItinerary itinerary;

  public static final String SERIALIZED_NAME_PAYMENT_METHOD = "payment_method";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD)
  private PaymentMethod paymentMethod;

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


  public CreateCfarContractRequest paymentMethod(PaymentMethod paymentMethod) {
    
    this.paymentMethod = paymentMethod;
    return this;
  }

   /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }


  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
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
        Objects.equals(this.paymentMethod, createCfarContractRequest.paymentMethod) &&
        Objects.equals(this.extAttributes, createCfarContractRequest.extAttributes) &&
        Objects.equals(this.pnrReference, createCfarContractRequest.pnrReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offerIds, itinerary, paymentMethod, extAttributes, pnrReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCfarContractRequest {\n");
    sb.append("    offerIds: ").append(toIndentedString(offerIds)).append("\n");
    sb.append("    itinerary: ").append(toIndentedString(itinerary)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
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
    openapiFields.add("payment_method");
    openapiFields.add("ext_attributes");
    openapiFields.add("pnr_reference");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("offer_ids");
    openapiRequiredFields.add("itinerary");
    openapiRequiredFields.add("payment_method");
    openapiRequiredFields.add("ext_attributes");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CreateCfarContractRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (CreateCfarContractRequest.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in CreateCfarContractRequest is not found in the empty JSON string", CreateCfarContractRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!CreateCfarContractRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CreateCfarContractRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CreateCfarContractRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      // ensure the json data is an array
      if (jsonObj.get("offer_ids") != null && !jsonObj.get("offer_ids").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `offer_ids` to be an array in the JSON string but got `%s`", jsonObj.get("offer_ids").toString()));
      }
      // validate the optional field `itinerary`
      if (jsonObj.getAsJsonObject("itinerary") != null) {
        CfarItinerary.validateJsonObject(jsonObj.getAsJsonObject("itinerary"));
      }
      // validate the optional field `payment_method`
      if (jsonObj.getAsJsonObject("payment_method") != null) {
        PaymentMethod.validateJsonObject(jsonObj.getAsJsonObject("payment_method"));
      }
      if (jsonObj.get("pnr_reference") != null && !jsonObj.get("pnr_reference").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `pnr_reference` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pnr_reference").toString()));
      }
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
             validateJsonObject(jsonObj);
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

