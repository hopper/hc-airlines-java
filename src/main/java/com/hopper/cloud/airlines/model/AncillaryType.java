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

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Ancillary type of the itinerary
 */
@JsonAdapter(AncillaryType.Adapter.class)
public enum AncillaryType {
  
  TRAVEL_INSURANCE("travel_insurance"),
  
  CABIN_BAG("cabin_bag"),

  CHECKED_BAG("checked_bag"),

  SEAT("seat"),

  LOUNGE("lounge"),

  MEAL("meal"),

  FAST_TRACK("fast_track"),

  PET("pet"),

  OTHER("other"),

  BAG_INSURANCE("bag_insurance"),

  CHANGE("change"),

  BUNDLE("bundle"),

  PAYMENT_FEE("payment_fee");

  private String value;

  AncillaryType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static AncillaryType fromValue(String value) {
    for (AncillaryType b : AncillaryType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<AncillaryType> {
    @Override
    public void write(final JsonWriter jsonWriter, final AncillaryType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public AncillaryType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return AncillaryType.fromValue(value);
    }
  }
}

