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
import com.hopper.cloud.airlines.model.CfarItinerarySliceSegment;
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
 * An object containing the list of flight segments for a fare slice
 */
@ApiModel(description = "An object containing the list of flight segments for a fare slice")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
@JsonInclude(JsonInclude.Include. NON_NULL)
public class CfarItinerarySlice {
  public static final String SERIALIZED_NAME_SEGMENTS = "segments";
  @SerializedName(SERIALIZED_NAME_SEGMENTS)
  private List<CfarItinerarySliceSegment> segments = new ArrayList<>();

  public static final String SERIALIZED_NAME_PASSENGER_PRICING = "passenger_pricing";
  @SerializedName(SERIALIZED_NAME_PASSENGER_PRICING)
  private List<PassengerPricing> passengerPricing = new ArrayList<>();

  public static final String SERIALIZED_NAME_TOTAL_PRICE = "total_price";
  @SerializedName(SERIALIZED_NAME_TOTAL_PRICE)
  private String totalPrice;

  public static final String SERIALIZED_NAME_FARE_BRAND = "fare_brand";
  @SerializedName(SERIALIZED_NAME_FARE_BRAND)
  private String fareBrand;

  public static final String SERIALIZED_NAME_FARE_BASIS = "fare_basis";
  @SerializedName(SERIALIZED_NAME_FARE_BASIS)
  private String fareBasis;

  public static final String SERIALIZED_NAME_FARE_RULES = "fare_rules";
  @SerializedName(SERIALIZED_NAME_FARE_RULES)
  private List<FareRule> fareRules = null;

  public static final String SERIALIZED_NAME_OTHER_FARES = "other_fares";
  @SerializedName(SERIALIZED_NAME_OTHER_FARES)
  private List<Fare> otherFares = null;

  public CfarItinerarySlice() { 
  }

  public CfarItinerarySlice segments(List<CfarItinerarySliceSegment> segments) {
    
    this.segments = segments;
    return this;
  }

  public CfarItinerarySlice addSegmentsItem(CfarItinerarySliceSegment segmentsItem) {
    this.segments.add(segmentsItem);
    return this;
  }

    /**
   * A list of segments which make up the slice of the fare
   * @return segments
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A list of segments which make up the slice of the fare")

  public List<CfarItinerarySliceSegment> getSegments() {
    return segments;
  }

  public void setSegments(List<CfarItinerarySliceSegment> segments) {
    this.segments = segments;
  }

  public CfarItinerarySlice passengerPricing(List<PassengerPricing> passengerPricing) {
      this.passengerPricing = passengerPricing;
      return this;
  }

  public CfarItinerarySlice addPassengerPricingItem(PassengerPricing passengerPricingItem) {
      this.passengerPricing.add(passengerPricingItem);
      return this;
  }

  /**
   * List of passengers type, count and pricing for the slice
   * @return passengerPricing
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "List of passengers type, count and pricing for the slice")

  public List<PassengerPricing> getPassengerPricing() {
      return passengerPricing;
  }

  public void setPassengerPricing(List<PassengerPricing> passengerPricing) {
      this.passengerPricing = passengerPricing;
  }

  public CfarItinerarySlice totalPrice(String totalPrice) {
      this.totalPrice = totalPrice;
      return this;
  }

  /**
   * The price of the slice for all the passengers
   * @return totalPrice
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "401.10", required = true, value = "The price of the slice for all the passengers")
  public String getTotalPrice() {
        return totalPrice;
    }

  public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

  public CfarItinerarySlice fareBrand(String fareBrand) {
      this.fareBrand = fareBrand;
      return this;
  }

  /**
   * Get fareBrand
   * @return fareBrand
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = false, value = "")

  public String getFareBrand() {
    return fareBrand;
}

  public void setFareBrand(String fareBrand) {
    this.fareBrand = fareBrand;
}

  public CfarItinerarySlice fareBasis(String fareBasis) {
      this.fareBasis = fareBasis;
      return this;
  }

  /**
   * Code of the fare basis applied to the slice
   * @return fareBasis
   **/
  @ApiModelProperty(required = false, value = "Code of the fare basis applied to the slice")
  public String getFareBasis() {
     return fareBasis;
  }

  public void setFareBasis(String fareBasis) {
     this.fareBasis = fareBasis;
  }

  public CfarItinerarySlice fareRules(List<FareRule> fareRules) {
      this.fareRules = fareRules;
      return this;
  }

  public CfarItinerarySlice addFareRulesItem(FareRule fareRuleItem) {
      if (this.fareRules == null) {
          this.fareRules = new ArrayList<>();
      }
      this.fareRules.add(fareRuleItem);
      return this;
  }

  /**
   * The fare rules associated to the slice
   * @return fareRules
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The fare rules associated to the slice")

  public List<FareRule> getFareRules() {
        return fareRules;
    }

  public void setFareRules(List<FareRule> fareRules) {
        this.fareRules = fareRules;
    }

  public CfarItinerarySlice otherFares(List<Fare> otherFares) {
      this.otherFares = otherFares;
      return this;
  }

  public CfarItinerarySlice addOtherFaresItem(Fare otherFareItem) {
      if (this.otherFares == null) {
          this.otherFares = new ArrayList<>();
      }
      this.otherFares.add(otherFareItem);
      return this;
  }

  /**
   * Other available fares in the same cabin
   * @return fareRules
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Other available fares in the same cabin")
  public List<Fare> getOtherFares() {
        return otherFares;
    }

  public void setOtherFares(List<Fare> otherFares) {
        this.otherFares = otherFares;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CfarItinerarySlice cfarItinerarySlice = (CfarItinerarySlice) o;
      return Objects.equals(this.segments, cfarItinerarySlice.segments) &&
              Objects.equals(this.passengerPricing, cfarItinerarySlice.passengerPricing) &&
              Objects.equals(this.totalPrice, cfarItinerarySlice.totalPrice) &&
              Objects.equals(this.fareBrand, cfarItinerarySlice.fareBrand) &&
              Objects.equals(this.fareBasis, cfarItinerarySlice.fareBasis) &&
              Objects.equals(this.fareRules, cfarItinerarySlice.fareRules) &&
              Objects.equals(this.otherFares, cfarItinerarySlice.otherFares);
  }

  @Override
  public int hashCode() {
      return Objects.hash(segments, passengerPricing, totalPrice, fareBrand, fareBasis, fareRules, otherFares);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CfarItinerarySlice {\n");

    sb.append("    segments: ").append(toIndentedString(segments)).append("\n");
    sb.append("    passengerPricing: ").append(toIndentedString(passengerPricing)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
    sb.append("    fareBrand: ").append(toIndentedString(fareBrand)).append("\n");
    sb.append("    fareBasis: ").append(toIndentedString(fareBasis)).append("\n");
    sb.append("    fareRules: ").append(toIndentedString(fareRules)).append("\n");
    sb.append("    otherFares: ").append(toIndentedString(otherFares)).append("\n");
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
    openapiFields.add("segments");
    openapiFields.add("passenger_pricing");
    openapiFields.add("total_price");
    openapiFields.add("fare_brand");
    openapiFields.add("fare_basis");
    openapiFields.add("fare_rules");
    openapiFields.add("other_fares");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("segments");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CfarItinerarySlice
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (CfarItinerarySlice.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in CfarItinerarySlice is not found in the empty JSON string", CfarItinerarySlice.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!CfarItinerarySlice.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CfarItinerarySlice` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CfarItinerarySlice.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("total_price") != null && !jsonObj.get("total_price").isJsonPrimitive() && !jsonObj.get("total_price").isJsonNull()) {
          throw new IllegalArgumentException(String.format("Expected the field `total_price` to be a primitive type in the JSON string but got `%s`", jsonObj.get("total_price").toString()));
      }
      if (jsonObj.get("fare_brand") != null && !jsonObj.get("fare_brand").isJsonPrimitive() && !jsonObj.get("fare_brand").isJsonNull()) {
          throw new IllegalArgumentException(String.format("Expected the field `fare_brand` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fare_brand").toString()));
      }
      if (jsonObj.get("fare_basis") != null && !jsonObj.get("fare_basis").isJsonPrimitive() && !jsonObj.get("fare_basis").isJsonNull()) {
          throw new IllegalArgumentException(String.format("Expected the field `fare_basis` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fare_basis").toString()));
      }

      JsonArray jsonArraySegments = jsonObj.getAsJsonArray("segments");
      if (jsonArraySegments != null) {
        // ensure the json data is an array
        if (!jsonObj.get("segments").isJsonArray()) {
          throw new IllegalArgumentException(String.format("Expected the field `segments` to be an array in the JSON string but got `%s`", jsonObj.get("segments").toString()));
        }

        // validate the optional field `segments` (array)
        for (int i = 0; i < jsonArraySegments.size(); i++) {
          CfarItinerarySliceSegment.validateJsonObject(jsonArraySegments.get(i).getAsJsonObject());
        };
      }

      // validate the optional `passenger_pricing`
      JsonArray jsonArrayPassengerPricing = jsonObj.getAsJsonArray("passenger_pricing");
      if (jsonArrayPassengerPricing != null) {
          // ensure the json data is an array
          if (!jsonObj.get("passenger_pricing").isJsonArray()) {
              throw new IllegalArgumentException(String.format("Expected the field `passenger_pricing` to be an array in the JSON string but got `%s`", jsonObj.get("passenger_pricing").toString()));
          }

          // validate the optional field `passenger_pricing` (array)
          for (int i = 0; i < jsonArrayPassengerPricing.size(); i++) {
              PassengerPricing.validateJsonObject(jsonArrayPassengerPricing.get(i).getAsJsonObject());
          };
      }

      // validate the optional NonEmptyList `fare_rules`
      JsonArray jsonArrayfareRules = jsonObj.getAsJsonArray("fare_rules");
      if (jsonArrayfareRules != null) {
          // ensure the json data is an array
          if (!jsonObj.get("fare_rules").isJsonArray()) {
              throw new IllegalArgumentException(String.format("Expected the field `fare_rules` to be an array in the JSON string but got `%s`", jsonObj.get("fare_rules").toString()));
          }

          // ensure the json data is a non empty array
          if (jsonArrayfareRules.isEmpty()) {
              throw new IllegalArgumentException(String.format("Expected the field `fare_rules` to be a non empty array in the JSON string"));
          }

          // validate the optional field `fareRules` (array)
          for (int i = 0; i < jsonArrayfareRules.size(); i++) {
              FareRule.validateJsonObject(jsonArrayfareRules.get(i).getAsJsonObject());
          };
      }

      // validate the optional NonEmptyList `other_fares`
      JsonArray jsonArrayOtherFares = jsonObj.getAsJsonArray("other_fares");
      if (jsonArrayOtherFares != null) {
          // ensure the json data is an array
          if (!jsonObj.get("other_fares").isJsonArray()) {
              throw new IllegalArgumentException(String.format("Expected the field `other_fares` to be an array in the JSON string but got `%s`", jsonObj.get("other_fares").toString()));
          }

          // ensure the json data is a non empty array
          if (jsonArrayOtherFares.isEmpty()) {
              throw new IllegalArgumentException(String.format("Expected the field `other_fares` to be a non empty array in the JSON string"));
          }

          // validate the optional field `other_fares` (array)
          for (int i = 0; i < jsonArrayOtherFares.size(); i++) {
              Fare.validateJsonObject(jsonArrayOtherFares.get(i).getAsJsonObject());
          };
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CfarItinerarySlice.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CfarItinerarySlice' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CfarItinerarySlice> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CfarItinerarySlice.class));

       return (TypeAdapter<T>) new TypeAdapter<CfarItinerarySlice>() {
           @Override
           public void write(JsonWriter out, CfarItinerarySlice value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CfarItinerarySlice read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CfarItinerarySlice given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CfarItinerarySlice
  * @throws IOException if the JSON string is invalid with respect to CfarItinerarySlice
  */
  public static CfarItinerarySlice fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CfarItinerarySlice.class);
  }

 /**
  * Convert an instance of CfarItinerarySlice to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

