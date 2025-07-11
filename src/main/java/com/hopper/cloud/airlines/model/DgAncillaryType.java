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
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * The type of ancillary
 */
@JsonAdapter(DgAncillaryType.Adapter.class)
public enum DgAncillaryType {
  
  TRAVEL_INSURANCE("travel_insurance"),
  
  BAG_INSURANCE("bag_insurance"),
  
  CABIN_BAG("cabin_bag"),
  
  CHECKED_BAG("checked_bag"),
  
  SEAT("seat"),
  
  LOUNGE("lounge"),
  
  MEAL("meal"),
  
  FAST_TRACK("fast_track"),
  
  PET("pet"),
  
  CHANGE("change"),
  
  BUNDLE("bundle"),
  
  PAYMENT_FEE("payment_fee"),
  
  OTHER("other");

  private String value;

  DgAncillaryType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static DgAncillaryType fromValue(String value) {
    for (DgAncillaryType b : DgAncillaryType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<DgAncillaryType> {
    @Override
    public void write(final JsonWriter jsonWriter, final DgAncillaryType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public DgAncillaryType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return DgAncillaryType.fromValue(value);
    }
  }
}

