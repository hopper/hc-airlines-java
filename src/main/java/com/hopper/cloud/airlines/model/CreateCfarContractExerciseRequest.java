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
import com.hopper.cloud.airlines.model.AirlineRefundMethod;
import com.hopper.cloud.airlines.model.CfarItinerary;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.HashMap;
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
 * A create CFAR contract exercise request
 */
@ApiModel(description = "A create CFAR contract exercise request")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
public class CreateCfarContractExerciseRequest {
  public static final String SERIALIZED_NAME_CONTRACT_ID = "contract_id";
  @SerializedName(SERIALIZED_NAME_CONTRACT_ID)
  private String contractId;

  public static final String SERIALIZED_NAME_EXERCISE_INITIATED_DATE_TIME = "exercise_initiated_date_time";
  @SerializedName(SERIALIZED_NAME_EXERCISE_INITIATED_DATE_TIME)
  private OffsetDateTime exerciseInitiatedDateTime;

  public static final String SERIALIZED_NAME_ITINERARY = "itinerary";
  @SerializedName(SERIALIZED_NAME_ITINERARY)
  private CfarItinerary itinerary;

  public static final String SERIALIZED_NAME_PNR_REFERENCE = "pnr_reference";
  @SerializedName(SERIALIZED_NAME_PNR_REFERENCE)
  private String pnrReference;

  public static final String SERIALIZED_NAME_AIRLINE_REFUND_ALLOWANCE = "airline_refund_allowance";
  @SerializedName(SERIALIZED_NAME_AIRLINE_REFUND_ALLOWANCE)
  private String airlineRefundAllowance;

  public static final String SERIALIZED_NAME_AIRLINE_REFUND_METHOD = "airline_refund_method";
  @SerializedName(SERIALIZED_NAME_AIRLINE_REFUND_METHOD)
  private AirlineRefundMethod airlineRefundMethod;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_EXT_ATTRIBUTES = "ext_attributes";
  @SerializedName(SERIALIZED_NAME_EXT_ATTRIBUTES)
  private Map<String, String> extAttributes = new HashMap<>();

  public CreateCfarContractExerciseRequest() { 
  }

  public CreateCfarContractExerciseRequest contractId(String contractId) {
    
    this.contractId = contractId;
    return this;
  }

   /**
   * A unique identifier for a CFAR contract
   * @return contractId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "bf3291e3-5098-4bb1-90d0-0d4ebb25fe46", required = true, value = "A unique identifier for a CFAR contract")

  public String getContractId() {
    return contractId;
  }


  public void setContractId(String contractId) {
    this.contractId = contractId;
  }


  public CreateCfarContractExerciseRequest exerciseInitiatedDateTime(OffsetDateTime exerciseInitiatedDateTime) {
    
    this.exerciseInitiatedDateTime = exerciseInitiatedDateTime;
    return this;
  }

   /**
   * A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which a contract exercise was initiated
   * @return exerciseInitiatedDateTime
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "2020-11-02T18:34:30Z", required = true, value = "A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which a contract exercise was initiated")

  public OffsetDateTime getExerciseInitiatedDateTime() {
    return exerciseInitiatedDateTime;
  }


  public void setExerciseInitiatedDateTime(OffsetDateTime exerciseInitiatedDateTime) {
    this.exerciseInitiatedDateTime = exerciseInitiatedDateTime;
  }


  public CreateCfarContractExerciseRequest itinerary(CfarItinerary itinerary) {
    
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


  public CreateCfarContractExerciseRequest pnrReference(String pnrReference) {
    
    this.pnrReference = pnrReference;
    return this;
  }

   /**
   * Get pnrReference
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


  public CreateCfarContractExerciseRequest airlineRefundAllowance(String airlineRefundAllowance) {
    
    this.airlineRefundAllowance = airlineRefundAllowance;
    return this;
  }

   /**
   * Get airlineRefundAllowance
   * @return airlineRefundAllowance
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getAirlineRefundAllowance() {
    return airlineRefundAllowance;
  }


  public void setAirlineRefundAllowance(String airlineRefundAllowance) {
    this.airlineRefundAllowance = airlineRefundAllowance;
  }


  public CreateCfarContractExerciseRequest airlineRefundMethod(AirlineRefundMethod airlineRefundMethod) {
    
    this.airlineRefundMethod = airlineRefundMethod;
    return this;
  }

   /**
   * Get airlineRefundMethod
   * @return airlineRefundMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public AirlineRefundMethod getAirlineRefundMethod() {
    return airlineRefundMethod;
  }


  public void setAirlineRefundMethod(AirlineRefundMethod airlineRefundMethod) {
    this.airlineRefundMethod = airlineRefundMethod;
  }


  public CreateCfarContractExerciseRequest currency(String currency) {
    
    this.currency = currency;
    return this;
  }

   /**
   * Get currency
   * @return currency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "CAD", value = "")

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    this.currency = currency;
  }


  public CreateCfarContractExerciseRequest extAttributes(Map<String, String> extAttributes) {
    
    this.extAttributes = extAttributes;
    return this;
  }

  public CreateCfarContractExerciseRequest putExtAttributesItem(String key, String extAttributesItem) {
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



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCfarContractExerciseRequest createCfarContractExerciseRequest = (CreateCfarContractExerciseRequest) o;
    return Objects.equals(this.contractId, createCfarContractExerciseRequest.contractId) &&
        Objects.equals(this.exerciseInitiatedDateTime, createCfarContractExerciseRequest.exerciseInitiatedDateTime) &&
        Objects.equals(this.itinerary, createCfarContractExerciseRequest.itinerary) &&
        Objects.equals(this.pnrReference, createCfarContractExerciseRequest.pnrReference) &&
        Objects.equals(this.airlineRefundAllowance, createCfarContractExerciseRequest.airlineRefundAllowance) &&
        Objects.equals(this.airlineRefundMethod, createCfarContractExerciseRequest.airlineRefundMethod) &&
        Objects.equals(this.currency, createCfarContractExerciseRequest.currency) &&
        Objects.equals(this.extAttributes, createCfarContractExerciseRequest.extAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contractId, exerciseInitiatedDateTime, itinerary, pnrReference, airlineRefundAllowance, airlineRefundMethod, currency, extAttributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCfarContractExerciseRequest {\n");
    sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
    sb.append("    exerciseInitiatedDateTime: ").append(toIndentedString(exerciseInitiatedDateTime)).append("\n");
    sb.append("    itinerary: ").append(toIndentedString(itinerary)).append("\n");
    sb.append("    pnrReference: ").append(toIndentedString(pnrReference)).append("\n");
    sb.append("    airlineRefundAllowance: ").append(toIndentedString(airlineRefundAllowance)).append("\n");
    sb.append("    airlineRefundMethod: ").append(toIndentedString(airlineRefundMethod)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
    openapiFields.add("contract_id");
    openapiFields.add("exercise_initiated_date_time");
    openapiFields.add("itinerary");
    openapiFields.add("pnr_reference");
    openapiFields.add("airline_refund_allowance");
    openapiFields.add("airline_refund_method");
    openapiFields.add("currency");
    openapiFields.add("ext_attributes");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("contract_id");
    openapiRequiredFields.add("exercise_initiated_date_time");
    openapiRequiredFields.add("itinerary");
    openapiRequiredFields.add("pnr_reference");
    openapiRequiredFields.add("ext_attributes");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CreateCfarContractExerciseRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (CreateCfarContractExerciseRequest.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in CreateCfarContractExerciseRequest is not found in the empty JSON string", CreateCfarContractExerciseRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!CreateCfarContractExerciseRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CreateCfarContractExerciseRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CreateCfarContractExerciseRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("contract_id") != null && !jsonObj.get("contract_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `contract_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("contract_id").toString()));
      }
      // validate the optional field `itinerary`
      if (jsonObj.getAsJsonObject("itinerary") != null) {
        CfarItinerary.validateJsonObject(jsonObj.getAsJsonObject("itinerary"));
      }
      if (jsonObj.get("pnr_reference") != null && !jsonObj.get("pnr_reference").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `pnr_reference` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pnr_reference").toString()));
      }
      if (jsonObj.get("airline_refund_allowance") != null && !jsonObj.get("airline_refund_allowance").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `airline_refund_allowance` to be a primitive type in the JSON string but got `%s`", jsonObj.get("airline_refund_allowance").toString()));
      }
      if (jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateCfarContractExerciseRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateCfarContractExerciseRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateCfarContractExerciseRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateCfarContractExerciseRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateCfarContractExerciseRequest>() {
           @Override
           public void write(JsonWriter out, CreateCfarContractExerciseRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CreateCfarContractExerciseRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CreateCfarContractExerciseRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CreateCfarContractExerciseRequest
  * @throws IOException if the JSON string is invalid with respect to CreateCfarContractExerciseRequest
  */
  public static CreateCfarContractExerciseRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateCfarContractExerciseRequest.class);
  }

 /**
  * Convert an instance of CreateCfarContractExerciseRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

