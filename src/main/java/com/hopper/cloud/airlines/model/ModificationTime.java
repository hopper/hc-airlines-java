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
 * Gets or Sets modification_time
 */
@JsonAdapter(ModificationTime.Adapter.class)
public enum ModificationTime {
  
  AFTER_DEPARTURE("after_departure"),
  
  ANYTIME("anytime"),

  BEFORE_DEPARTURE("before_departure");

  private String value;

  ModificationTime(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ModificationTime fromValue(String value) {
    for (ModificationTime b : ModificationTime.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<ModificationTime> {
    @Override
    public void write(final JsonWriter jsonWriter, final ModificationTime enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ModificationTime read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ModificationTime.fromValue(value);
    }
  }
}
