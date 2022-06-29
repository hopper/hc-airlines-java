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
import com.hopper.cloud.airlines.model.PassengerCount;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

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
 * PassengerPricing
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
public class PassengerPricing {
  public static final String SERIALIZED_NAME_PASSENGER_COUNT = "passenger_count";
  @SerializedName(SERIALIZED_NAME_PASSENGER_COUNT)
  private PassengerCount passengerCount;

  public static final String SERIALIZED_NAME_INDIVIDUAL_PRICE = "individual_price";
  @SerializedName(SERIALIZED_NAME_INDIVIDUAL_PRICE)
  private String individualPrice;

  public PassengerPricing() { 
  }

  public PassengerPricing passengerCount(PassengerCount passengerCount) {
    
    this.passengerCount = passengerCount;
    return this;
  }

   /**
   * Get passengerCount
   * @return passengerCount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public PassengerCount getPassengerCount() {
    return passengerCount;
  }


  public void setPassengerCount(PassengerCount passengerCount) {
    this.passengerCount = passengerCount;
  }


  public PassengerPricing individualPrice(String individualPrice) {
    
    this.individualPrice = individualPrice;
    return this;
  }

   /**
   * Price per passenger
   * @return individualPrice
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "20.55", value = "Price per passenger")

  public String getIndividualPrice() {
    return individualPrice;
  }


  public void setIndividualPrice(String individualPrice) {
    this.individualPrice = individualPrice;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PassengerPricing passengerPricing = (PassengerPricing) o;
    return Objects.equals(this.passengerCount, passengerPricing.passengerCount) &&
        Objects.equals(this.individualPrice, passengerPricing.individualPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passengerCount, individualPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PassengerPricing {\n");
    sb.append("    passengerCount: ").append(toIndentedString(passengerCount)).append("\n");
    sb.append("    individualPrice: ").append(toIndentedString(individualPrice)).append("\n");
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
    openapiFields.add("passenger_count");
    openapiFields.add("individual_price");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("passenger_count");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PassengerPricing
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (PassengerPricing.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in PassengerPricing is not found in the empty JSON string", PassengerPricing.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!PassengerPricing.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PassengerPricing` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PassengerPricing.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      // validate the optional field `passenger_count`
      if (jsonObj.getAsJsonObject("passenger_count") != null) {
        PassengerCount.validateJsonObject(jsonObj.getAsJsonObject("passenger_count"));
      }
      if (jsonObj.get("individual_price") != null && !jsonObj.get("individual_price").isJsonNull() && !jsonObj.get("individual_price").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `individual_price` to be a primitive type in the JSON string but got `%s`", jsonObj.get("individual_price").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PassengerPricing.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PassengerPricing' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PassengerPricing> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PassengerPricing.class));

       return (TypeAdapter<T>) new TypeAdapter<PassengerPricing>() {
           @Override
           public void write(JsonWriter out, PassengerPricing value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PassengerPricing read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PassengerPricing given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PassengerPricing
  * @throws IOException if the JSON string is invalid with respect to PassengerPricing
  */
  public static PassengerPricing fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PassengerPricing.class);
  }

 /**
  * Convert an instance of PassengerPricing to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

