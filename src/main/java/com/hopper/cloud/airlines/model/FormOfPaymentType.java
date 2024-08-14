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
 * Gets or Sets flow_type
 */
@JsonAdapter(FormOfPaymentType.Adapter.class)
public enum FormOfPaymentType {

    CASH("cash"),
    NON_CASH("non_cash"),
    POINTS("points"),
    PAYMENT_CARD("payment_card");

    private String value;

    FormOfPaymentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static FormOfPaymentType fromValue(String value) {
        for (FormOfPaymentType b : FormOfPaymentType.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<FormOfPaymentType> {
        @Override
        public void write(final JsonWriter jsonWriter, final FormOfPaymentType enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public FormOfPaymentType read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return FormOfPaymentType.fromValue(value);
        }
    }
}

