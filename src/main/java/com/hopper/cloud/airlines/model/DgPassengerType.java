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
 * Gets or Sets dg_passenger_type
 */
@JsonAdapter(DgPassengerType.Adapter.class)
public enum DgPassengerType {
  
  ADULT("adult"),
  
  CHILD("child"),
  
  SEATED_INFANT("seated_infant"),
  
  LAP_INFANT("lap_infant");

  private String value;

  DgPassengerType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static DgPassengerType fromValue(String value) {
    for (DgPassengerType b : DgPassengerType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<DgPassengerType> {
    @Override
    public void write(final JsonWriter jsonWriter, final DgPassengerType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public DgPassengerType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return DgPassengerType.fromValue(value);
    }
  }
}

