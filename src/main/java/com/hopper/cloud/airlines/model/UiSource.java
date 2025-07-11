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
 * Gets or Sets ui_source
 */
@JsonAdapter(UiSource.Adapter.class)
public enum UiSource {
  
  BANNER_VARIANT_A("banner_variant_a"),
  
  BANNER_VARIANT_B("banner_variant_b"),
  
  BANNER_VARIANT_C("banner_variant_c"),
  
  TAKEOVER("takeover");

  private String value;

  UiSource(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static UiSource fromValue(String value) {
    for (UiSource b : UiSource.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<UiSource> {
    @Override
    public void write(final JsonWriter jsonWriter, final UiSource enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public UiSource read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return UiSource.fromValue(value);
    }
  }
}

