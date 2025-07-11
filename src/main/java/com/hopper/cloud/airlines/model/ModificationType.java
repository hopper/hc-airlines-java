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
 * The type of modifications in question in this fare rule
 */
@JsonAdapter(ModificationType.Adapter.class)
public enum ModificationType {
  
  CANCELLATION("cancellation"),
  
  CHANGE("change");

  private String value;

  ModificationType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ModificationType fromValue(String value) {
    for (ModificationType b : ModificationType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<ModificationType> {
    @Override
    public void write(final JsonWriter jsonWriter, final ModificationType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ModificationType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ModificationType.fromValue(value);
    }
  }
}

