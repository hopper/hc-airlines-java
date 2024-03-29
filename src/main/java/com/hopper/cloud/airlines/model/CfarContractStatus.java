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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets cfar_status
 */
@JsonAdapter(CfarContractStatus.Adapter.class)
public enum CfarContractStatus {

  CREATED("created"),

  CONFIRMED("confirmed"),

  CANCELED("canceled"),

  FAILED("failed"),

  VOIDED("voided"),

  CHARGED_BACK("charged_back");

  private String value;

  CfarContractStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static CfarContractStatus fromValue(String value) {
    for (CfarContractStatus b : CfarContractStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<CfarContractStatus> {
    @Override
    public void write(final JsonWriter jsonWriter, final CfarContractStatus enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public CfarContractStatus read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return CfarContractStatus.fromValue(value);
    }
  }
}

