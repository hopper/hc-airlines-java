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
 * Gets or Sets ui_variant
 */
@JsonAdapter(UiVariant.Adapter.class)
public enum UiVariant {
  
  A("variant_a"),
  
  B("variant_b"),
  
  C("variant_c");

  private String value;

  UiVariant(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static UiVariant fromValue(String value) {
    for (UiVariant b : UiVariant.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<UiVariant> {
    @Override
    public void write(final JsonWriter jsonWriter, final UiVariant enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public UiVariant read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return UiVariant.fromValue(value);
    }
  }
}

