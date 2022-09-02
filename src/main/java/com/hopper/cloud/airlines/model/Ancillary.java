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

import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hopper.cloud.airlines.model.AncillaryType;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import com.hopper.cloud.airlines.JSON;

/**
 * Ancillary
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
public class Ancillary {
  public static final String SERIALIZED_NAME_TOTAL_PRICE = "total_price";
  @SerializedName(SERIALIZED_NAME_TOTAL_PRICE)
  private String totalPrice;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private AncillaryType type;

  public Ancillary() { 
  }

  public Ancillary totalPrice(String totalPrice) {
    
    this.totalPrice = totalPrice;
    return this;
  }

   /**
   * Total price of ancillaries of this type attached to fare
   * @return totalPrice
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "20.55", required = true, value = "Total price of ancillaries of this type attached to fare")

  public String getTotalPrice() {
    return totalPrice;
  }


  public void setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
  }


  public Ancillary type(AncillaryType type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public AncillaryType getType() {
    return type;
  }


  public void setType(AncillaryType type) {
    this.type = type;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ancillary ancillary = (Ancillary) o;
    return Objects.equals(this.totalPrice, ancillary.totalPrice) &&
        Objects.equals(this.type, ancillary.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalPrice, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ancillary {\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("total_price");
    openapiFields.add("type");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("total_price");
    openapiRequiredFields.add("type");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Ancillary
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (Ancillary.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in Ancillary is not found in the empty JSON string", Ancillary.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!Ancillary.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Ancillary` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Ancillary.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("total_price") != null && !jsonObj.get("total_price").isJsonPrimitive() && !jsonObj.get("total_price").isJsonNull()) {
        throw new IllegalArgumentException(String.format("Expected the field `total_price` to be a primitive type in the JSON string but got `%s`", jsonObj.get("total_price").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Ancillary.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Ancillary' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Ancillary> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Ancillary.class));

       return (TypeAdapter<T>) new TypeAdapter<Ancillary>() {
           @Override
           public void write(JsonWriter out, Ancillary value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Ancillary read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Ancillary given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Ancillary
  * @throws IOException if the JSON string is invalid with respect to Ancillary
  */
  public static Ancillary fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Ancillary.class);
  }

 /**
  * Convert an instance of Ancillary to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

