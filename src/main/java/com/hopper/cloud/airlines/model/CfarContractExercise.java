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
 * An object containing exercise information for a contract
 */
@ApiModel(description = "An object containing exercise information for a contract")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
public class CfarContractExercise {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_CONTRACT_ID = "contract_id";
  @SerializedName(SERIALIZED_NAME_CONTRACT_ID)
  private String contractId;

  public static final String SERIALIZED_NAME_EXERCISE_INITIATED_DATE_TIME = "exercise_initiated_date_time";
  @SerializedName(SERIALIZED_NAME_EXERCISE_INITIATED_DATE_TIME)
  private OffsetDateTime exerciseInitiatedDateTime;

  public static final String SERIALIZED_NAME_EXERCISE_COMPLETED_DATE_TIME = "exercise_completed_date_time";
  @SerializedName(SERIALIZED_NAME_EXERCISE_COMPLETED_DATE_TIME)
  private OffsetDateTime exerciseCompletedDateTime;

  public static final String SERIALIZED_NAME_EXCHANGE_RATE = "exchange_rate";
  @SerializedName(SERIALIZED_NAME_EXCHANGE_RATE)
  private String exchangeRate;

  public static final String SERIALIZED_NAME_HOPPER_REFUND = "hopper_refund";
  @SerializedName(SERIALIZED_NAME_HOPPER_REFUND)
  private String hopperRefund;

  public static final String SERIALIZED_NAME_HOPPER_REFUND_METHOD = "hopper_refund_method";
  @SerializedName(SERIALIZED_NAME_HOPPER_REFUND_METHOD)
  private AirlineRefundMethod hopperRefundMethod;

  public static final String SERIALIZED_NAME_EXT_ATTRIBUTES = "ext_attributes";
  @SerializedName(SERIALIZED_NAME_EXT_ATTRIBUTES)
  private Map<String, String> extAttributes = new HashMap<>();

  public static final String SERIALIZED_NAME_AIRLINE_REFUND_ALLOWANCE = "airline_refund_allowance";
  @SerializedName(SERIALIZED_NAME_AIRLINE_REFUND_ALLOWANCE)
  private String airlineRefundAllowance;

  public static final String SERIALIZED_NAME_AIRLINE_REFUND_METHOD = "airline_refund_method";
  @SerializedName(SERIALIZED_NAME_AIRLINE_REFUND_METHOD)
  private AirlineRefundMethod airlineRefundMethod;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public CfarContractExercise() { 
  }

  public CfarContractExercise id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for a CFAR exercise
   * @return id
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "8ef454c6-74a5-48cf-972e-fac72d05e59c", required = true, value = "Unique identifier for a CFAR exercise")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public CfarContractExercise contractId(String contractId) {
    
    this.contractId = contractId;
    return this;
  }

   /**
   * Unique identifier for a contract
   * @return contractId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "9f4f2f2b-adfd-4f02-83ad-da336ed57ce0", required = true, value = "Unique identifier for a contract")

  public String getContractId() {
    return contractId;
  }


  public void setContractId(String contractId) {
    this.contractId = contractId;
  }


  public CfarContractExercise exerciseInitiatedDateTime(OffsetDateTime exerciseInitiatedDateTime) {
    
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


  public CfarContractExercise exerciseCompletedDateTime(OffsetDateTime exerciseCompletedDateTime) {
    
    this.exerciseCompletedDateTime = exerciseCompletedDateTime;
    return this;
  }

   /**
   * A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which a contract exercise was completed
   * @return exerciseCompletedDateTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2020-11-02T18:34:30Z", value = "A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which a contract exercise was completed")

  public OffsetDateTime getExerciseCompletedDateTime() {
    return exerciseCompletedDateTime;
  }


  public void setExerciseCompletedDateTime(OffsetDateTime exerciseCompletedDateTime) {
    this.exerciseCompletedDateTime = exerciseCompletedDateTime;
  }


  public CfarContractExercise exchangeRate(String exchangeRate) {
    
    this.exchangeRate = exchangeRate;
    return this;
  }

   /**
   * USD Exchange rate for currency where 1 of &lt;currency&gt; &#x3D;&#x3D; X USD; e.g. 1CAD &#x3D;&#x3D; 0.79USD at the date time CFAR exercise was completed
   * @return exchangeRate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0.79", value = "USD Exchange rate for currency where 1 of <currency> == X USD; e.g. 1CAD == 0.79USD at the date time CFAR exercise was completed")

  public String getExchangeRate() {
    return exchangeRate;
  }


  public void setExchangeRate(String exchangeRate) {
    this.exchangeRate = exchangeRate;
  }


  public CfarContractExercise hopperRefund(String hopperRefund) {
    
    this.hopperRefund = hopperRefund;
    return this;
  }

   /**
   * The partner&#39;s share of the amount refunded to the customer to complete the CFAR contract exercise
   * @return hopperRefund
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "123.45", required = true, value = "The partner's share of the amount refunded to the customer to complete the CFAR contract exercise")

  public String getHopperRefund() {
    return hopperRefund;
  }


  public void setHopperRefund(String hopperRefund) {
    this.hopperRefund = hopperRefund;
  }


  public CfarContractExercise hopperRefundMethod(AirlineRefundMethod hopperRefundMethod) {
    
    this.hopperRefundMethod = hopperRefundMethod;
    return this;
  }

   /**
   * Get hopperRefundMethod
   * @return hopperRefundMethod
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public AirlineRefundMethod getHopperRefundMethod() {
    return hopperRefundMethod;
  }


  public void setHopperRefundMethod(AirlineRefundMethod hopperRefundMethod) {
    this.hopperRefundMethod = hopperRefundMethod;
  }


  public CfarContractExercise extAttributes(Map<String, String> extAttributes) {
    
    this.extAttributes = extAttributes;
    return this;
  }

  public CfarContractExercise putExtAttributesItem(String key, String extAttributesItem) {
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


  public CfarContractExercise airlineRefundAllowance(String airlineRefundAllowance) {
    
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


  public CfarContractExercise airlineRefundMethod(AirlineRefundMethod airlineRefundMethod) {
    
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


  public CfarContractExercise currency(String currency) {
    
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



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CfarContractExercise cfarContractExercise = (CfarContractExercise) o;
    return Objects.equals(this.id, cfarContractExercise.id) &&
        Objects.equals(this.contractId, cfarContractExercise.contractId) &&
        Objects.equals(this.exerciseInitiatedDateTime, cfarContractExercise.exerciseInitiatedDateTime) &&
        Objects.equals(this.exerciseCompletedDateTime, cfarContractExercise.exerciseCompletedDateTime) &&
        Objects.equals(this.exchangeRate, cfarContractExercise.exchangeRate) &&
        Objects.equals(this.hopperRefund, cfarContractExercise.hopperRefund) &&
        Objects.equals(this.hopperRefundMethod, cfarContractExercise.hopperRefundMethod) &&
        Objects.equals(this.extAttributes, cfarContractExercise.extAttributes) &&
        Objects.equals(this.airlineRefundAllowance, cfarContractExercise.airlineRefundAllowance) &&
        Objects.equals(this.airlineRefundMethod, cfarContractExercise.airlineRefundMethod) &&
        Objects.equals(this.currency, cfarContractExercise.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, contractId, exerciseInitiatedDateTime, exerciseCompletedDateTime, exchangeRate, hopperRefund, hopperRefundMethod, extAttributes, airlineRefundAllowance, airlineRefundMethod, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CfarContractExercise {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
    sb.append("    exerciseInitiatedDateTime: ").append(toIndentedString(exerciseInitiatedDateTime)).append("\n");
    sb.append("    exerciseCompletedDateTime: ").append(toIndentedString(exerciseCompletedDateTime)).append("\n");
    sb.append("    exchangeRate: ").append(toIndentedString(exchangeRate)).append("\n");
    sb.append("    hopperRefund: ").append(toIndentedString(hopperRefund)).append("\n");
    sb.append("    hopperRefundMethod: ").append(toIndentedString(hopperRefundMethod)).append("\n");
    sb.append("    extAttributes: ").append(toIndentedString(extAttributes)).append("\n");
    sb.append("    airlineRefundAllowance: ").append(toIndentedString(airlineRefundAllowance)).append("\n");
    sb.append("    airlineRefundMethod: ").append(toIndentedString(airlineRefundMethod)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("contract_id");
    openapiFields.add("exercise_initiated_date_time");
    openapiFields.add("exercise_completed_date_time");
    openapiFields.add("exchange_rate");
    openapiFields.add("hopper_refund");
    openapiFields.add("hopper_refund_method");
    openapiFields.add("ext_attributes");
    openapiFields.add("airline_refund_allowance");
    openapiFields.add("airline_refund_method");
    openapiFields.add("currency");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("contract_id");
    openapiRequiredFields.add("exercise_initiated_date_time");
    openapiRequiredFields.add("hopper_refund");
    openapiRequiredFields.add("hopper_refund_method");
    openapiRequiredFields.add("ext_attributes");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CfarContractExercise
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (CfarContractExercise.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in CfarContractExercise is not found in the empty JSON string", CfarContractExercise.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!CfarContractExercise.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CfarContractExercise` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CfarContractExercise.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("id") != null && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (jsonObj.get("contract_id") != null && !jsonObj.get("contract_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `contract_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("contract_id").toString()));
      }
      if (jsonObj.get("exchange_rate") != null && !jsonObj.get("exchange_rate").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `exchange_rate` to be a primitive type in the JSON string but got `%s`", jsonObj.get("exchange_rate").toString()));
      }
      if (jsonObj.get("hopper_refund") != null && !jsonObj.get("hopper_refund").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `hopper_refund` to be a primitive type in the JSON string but got `%s`", jsonObj.get("hopper_refund").toString()));
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
       if (!CfarContractExercise.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CfarContractExercise' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CfarContractExercise> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CfarContractExercise.class));

       return (TypeAdapter<T>) new TypeAdapter<CfarContractExercise>() {
           @Override
           public void write(JsonWriter out, CfarContractExercise value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CfarContractExercise read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CfarContractExercise given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CfarContractExercise
  * @throws IOException if the JSON string is invalid with respect to CfarContractExercise
  */
  public static CfarContractExercise fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CfarContractExercise.class);
  }

 /**
  * Convert an instance of CfarContractExercise to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

