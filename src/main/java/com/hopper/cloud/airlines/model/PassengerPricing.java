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
import com.hopper.cloud.airlines.model.CfarPassengerTax;
import com.hopper.cloud.airlines.model.PassengerCount;
import java.io.IOException;
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
 * PassengerPricing
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-02T18:35:20.974206513Z[Etc/UTC]", comments = "Generator version: 7.10.0")
public class PassengerPricing {
  public static final String SERIALIZED_NAME_PASSENGER_COUNT = "passenger_count";
  @SerializedName(SERIALIZED_NAME_PASSENGER_COUNT)
  @javax.annotation.Nonnull
  private PassengerCount passengerCount;

  public static final String SERIALIZED_NAME_INDIVIDUAL_PRICE = "individual_price";
  @SerializedName(SERIALIZED_NAME_INDIVIDUAL_PRICE)
  @javax.annotation.Nonnull
  private String individualPrice;

  public static final String SERIALIZED_NAME_TAXES = "taxes";
  @SerializedName(SERIALIZED_NAME_TAXES)
  @javax.annotation.Nullable
  private List<CfarPassengerTax> taxes;

  public PassengerPricing() {
  }

  public PassengerPricing passengerCount(@javax.annotation.Nonnull PassengerCount passengerCount) {
    this.passengerCount = passengerCount;
    return this;
  }

  /**
   * Get passengerCount
   * @return passengerCount
   */
  @javax.annotation.Nonnull
  public PassengerCount getPassengerCount() {
    return passengerCount;
  }

  public void setPassengerCount(@javax.annotation.Nonnull PassengerCount passengerCount) {
    this.passengerCount = passengerCount;
  }


  public PassengerPricing individualPrice(@javax.annotation.Nonnull String individualPrice) {
    this.individualPrice = individualPrice;
    return this;
  }

  /**
   * Price per passenger (excluding ancillaries)
   * @return individualPrice
   */
  @javax.annotation.Nonnull
  public String getIndividualPrice() {
    return individualPrice;
  }

  public void setIndividualPrice(@javax.annotation.Nonnull String individualPrice) {
    this.individualPrice = individualPrice;
  }


  public PassengerPricing taxes(@javax.annotation.Nullable List<CfarPassengerTax> taxes) {
    this.taxes = taxes;
    return this;
  }

  public PassengerPricing addTaxesItem(CfarPassengerTax taxesItem) {
    if (this.taxes == null) {
      this.taxes = new ArrayList<>();
    }
    this.taxes.add(taxesItem);
    return this;
  }

  /**
   * Taxes applicable per passenger
   * @return taxes
   */
  @javax.annotation.Nullable
  public List<CfarPassengerTax> getTaxes() {
    return taxes;
  }

  public void setTaxes(@javax.annotation.Nullable List<CfarPassengerTax> taxes) {
    this.taxes = taxes;
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
        Objects.equals(this.individualPrice, passengerPricing.individualPrice) &&
        Objects.equals(this.taxes, passengerPricing.taxes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passengerCount, individualPrice, taxes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PassengerPricing {\n");
    sb.append("    passengerCount: ").append(toIndentedString(passengerCount)).append("\n");
    sb.append("    individualPrice: ").append(toIndentedString(individualPrice)).append("\n");
    sb.append("    taxes: ").append(toIndentedString(taxes)).append("\n");
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
    openapiFields.add("taxes");
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
             JsonElement jsonElement = elementAdapter.read(in);
             return thisAdapter.fromJsonTree(jsonElement);
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

