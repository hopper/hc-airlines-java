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
import com.hopper.cloud.airlines.model.Ancillary;
import com.hopper.cloud.airlines.model.CfarItinerarySlice;
import com.hopper.cloud.airlines.model.PassengerPricing;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import com.hopper.cloud.airlines.JSON;

/**
 * An object detailing the fare used to create a CFAR offer
 */
@ApiModel(description = "An object detailing the fare used to create a CFAR offer")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
public class CfarItinerary {
  public static final String SERIALIZED_NAME_PASSENGER_PRICING = "passenger_pricing";
  @SerializedName(SERIALIZED_NAME_PASSENGER_PRICING)
  private List<PassengerPricing> passengerPricing = new ArrayList<>();

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_SLICES = "slices";
  @SerializedName(SERIALIZED_NAME_SLICES)
  private List<CfarItinerarySlice> slices = new ArrayList<>();

  public static final String SERIALIZED_NAME_ANCILLARIES = "ancillaries";
  @SerializedName(SERIALIZED_NAME_ANCILLARIES)
  private List<Ancillary> ancillaries = null;

  public static final String SERIALIZED_NAME_TOTAL_PRICE = "total_price";
  @SerializedName(SERIALIZED_NAME_TOTAL_PRICE)
  private String totalPrice;

  public CfarItinerary() { 
  }

  public CfarItinerary passengerPricing(List<PassengerPricing> passengerPricing) {
    
    this.passengerPricing = passengerPricing;
    return this;
  }

  public CfarItinerary addPassengerPricingItem(PassengerPricing passengerPricingItem) {
    this.passengerPricing.add(passengerPricingItem);
    return this;
  }

   /**
   * List of pricing per passenger for a fare
   * @return passengerPricing
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "List of pricing per passenger for a fare")

  public List<PassengerPricing> getPassengerPricing() {
    return passengerPricing;
  }


  public void setPassengerPricing(List<PassengerPricing> passengerPricing) {
    this.passengerPricing = passengerPricing;
  }


  public CfarItinerary currency(String currency) {
    
    this.currency = currency;
    return this;
  }

   /**
   * Currency of pricing fields
   * @return currency
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "CAD", required = true, value = "Currency of pricing fields")

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    this.currency = currency;
  }


  public CfarItinerary slices(List<CfarItinerarySlice> slices) {
    
    this.slices = slices;
    return this;
  }

  public CfarItinerary addSlicesItem(CfarItinerarySlice slicesItem) {
    this.slices.add(slicesItem);
    return this;
  }

   /**
   * List of fare slices included in this fare; only 1 (one way) or 2 (round trip) slices are allowed
   * @return slices
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "List of fare slices included in this fare; only 1 (one way) or 2 (round trip) slices are allowed")

  public List<CfarItinerarySlice> getSlices() {
    return slices;
  }


  public void setSlices(List<CfarItinerarySlice> slices) {
    this.slices = slices;
  }


  public CfarItinerary ancillaries(List<Ancillary> ancillaries) {
    
    this.ancillaries = ancillaries;
    return this;
  }

  public CfarItinerary addAncillariesItem(Ancillary ancillariesItem) {
    if (this.ancillaries == null) {
      this.ancillaries = new ArrayList<>();
    }
    this.ancillaries.add(ancillariesItem);
    return this;
  }

   /**
   * Ancillaries attached to a fare and their prices
   * @return ancillaries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Ancillaries attached to a fare and their prices")

  public List<Ancillary> getAncillaries() {
    return ancillaries;
  }


  public void setAncillaries(List<Ancillary> ancillaries) {
    this.ancillaries = ancillaries;
  }


  public CfarItinerary totalPrice(String totalPrice) {
    
    this.totalPrice = totalPrice;
    return this;
  }

   /**
   * Get totalPrice
   * @return totalPrice
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getTotalPrice() {
    return totalPrice;
  }


  public void setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CfarItinerary cfarItinerary = (CfarItinerary) o;
    return Objects.equals(this.passengerPricing, cfarItinerary.passengerPricing) &&
        Objects.equals(this.currency, cfarItinerary.currency) &&
        Objects.equals(this.slices, cfarItinerary.slices) &&
        Objects.equals(this.ancillaries, cfarItinerary.ancillaries) &&
        Objects.equals(this.totalPrice, cfarItinerary.totalPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passengerPricing, currency, slices, ancillaries, totalPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CfarItinerary {\n");
    sb.append("    passengerPricing: ").append(toIndentedString(passengerPricing)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    slices: ").append(toIndentedString(slices)).append("\n");
    sb.append("    ancillaries: ").append(toIndentedString(ancillaries)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
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
    openapiFields.add("passenger_pricing");
    openapiFields.add("currency");
    openapiFields.add("slices");
    openapiFields.add("ancillaries");
    openapiFields.add("total_price");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("passenger_pricing");
    openapiRequiredFields.add("currency");
    openapiRequiredFields.add("slices");
    openapiRequiredFields.add("total_price");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CfarItinerary
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (CfarItinerary.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in CfarItinerary is not found in the empty JSON string", CfarItinerary.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!CfarItinerary.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CfarItinerary` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CfarItinerary.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      JsonArray jsonArraypassengerPricing = jsonObj.getAsJsonArray("passenger_pricing");
      if (jsonArraypassengerPricing != null) {
        // ensure the json data is an array
        if (!jsonObj.get("passenger_pricing").isJsonArray()) {
          throw new IllegalArgumentException(String.format("Expected the field `passenger_pricing` to be an array in the JSON string but got `%s`", jsonObj.get("passenger_pricing").toString()));
        }

        // validate the optional field `passenger_pricing` (array)
        for (int i = 0; i < jsonArraypassengerPricing.size(); i++) {
          PassengerPricing.validateJsonObject(jsonArraypassengerPricing.get(i).getAsJsonObject());
        };
      }
      if (jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
      }
      JsonArray jsonArrayslices = jsonObj.getAsJsonArray("slices");
      if (jsonArrayslices != null) {
        // ensure the json data is an array
        if (!jsonObj.get("slices").isJsonArray()) {
          throw new IllegalArgumentException(String.format("Expected the field `slices` to be an array in the JSON string but got `%s`", jsonObj.get("slices").toString()));
        }

        // validate the optional field `slices` (array)
        for (int i = 0; i < jsonArrayslices.size(); i++) {
          CfarItinerarySlice.validateJsonObject(jsonArrayslices.get(i).getAsJsonObject());
        };
      }
      JsonArray jsonArrayancillaries = jsonObj.getAsJsonArray("ancillaries");
      if (jsonArrayancillaries != null) {
        // ensure the json data is an array
        if (!jsonObj.get("ancillaries").isJsonArray()) {
          throw new IllegalArgumentException(String.format("Expected the field `ancillaries` to be an array in the JSON string but got `%s`", jsonObj.get("ancillaries").toString()));
        }

        // validate the optional field `ancillaries` (array)
        for (int i = 0; i < jsonArrayancillaries.size(); i++) {
          Ancillary.validateJsonObject(jsonArrayancillaries.get(i).getAsJsonObject());
        };
      }
      if (jsonObj.get("total_price") != null && !jsonObj.get("total_price").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `total_price` to be a primitive type in the JSON string but got `%s`", jsonObj.get("total_price").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CfarItinerary.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CfarItinerary' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CfarItinerary> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CfarItinerary.class));

       return (TypeAdapter<T>) new TypeAdapter<CfarItinerary>() {
           @Override
           public void write(JsonWriter out, CfarItinerary value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CfarItinerary read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CfarItinerary given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CfarItinerary
  * @throws IOException if the JSON string is invalid with respect to CfarItinerary
  */
  public static CfarItinerary fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CfarItinerary.class);
  }

 /**
  * Convert an instance of CfarItinerary to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

