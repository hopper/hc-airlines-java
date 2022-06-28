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
 * Gets or Sets device_type
 */
@JsonAdapter(DeviceType.Adapter.class)
public enum DeviceType {
  
  MOBILE("mobile"),
  
  TABLET("tablet"),
  
  DESKTOP("desktop");

  private String value;

  DeviceType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static DeviceType fromValue(String value) {
    for (DeviceType b : DeviceType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<DeviceType> {
    @Override
    public void write(final JsonWriter jsonWriter, final DeviceType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public DeviceType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return DeviceType.fromValue(value);
    }
  }
}

