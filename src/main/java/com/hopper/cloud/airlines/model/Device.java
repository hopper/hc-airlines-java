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
import com.hopper.cloud.airlines.model.DeviceType;
import com.hopper.cloud.airlines.model.Platform;
import io.swagger.annotations.ApiModel;
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
 * The end-user&#39;s device
 */
@ApiModel(description = "The end-user's device")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
public class Device {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_PLATFORM = "platform";
  @SerializedName(SERIALIZED_NAME_PLATFORM)
  private Platform platform;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private DeviceType type;

  public Device() { 
  }

  public Device id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * A unique identifier for the end-user&#39;s device, generated by the partner
   * @return id
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "eb2dddb7-dc69-4521-9fbb-762b96eb921f", required = true, value = "A unique identifier for the end-user's device, generated by the partner")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public Device platform(Platform platform) {
    
    this.platform = platform;
    return this;
  }

   /**
   * Get platform
   * @return platform
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Platform getPlatform() {
    return platform;
  }


  public void setPlatform(Platform platform) {
    this.platform = platform;
  }


  public Device type(DeviceType type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public DeviceType getType() {
    return type;
  }


  public void setType(DeviceType type) {
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
    Device device = (Device) o;
    return Objects.equals(this.id, device.id) &&
        Objects.equals(this.platform, device.platform) &&
        Objects.equals(this.type, device.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, platform, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Device {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    platform: ").append(toIndentedString(platform)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("platform");
    openapiFields.add("type");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("type");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Device
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (Device.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in Device is not found in the empty JSON string", Device.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!Device.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Device` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Device.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("id") != null && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      // validate the optional field `platform`
      if (jsonObj.getAsJsonObject("platform") != null) {
        Platform.validateJsonObject(jsonObj.getAsJsonObject("platform"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Device.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Device' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Device> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Device.class));

       return (TypeAdapter<T>) new TypeAdapter<Device>() {
           @Override
           public void write(JsonWriter out, Device value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Device read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Device given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Device
  * @throws IOException if the JSON string is invalid with respect to Device
  */
  public static Device fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Device.class);
  }

 /**
  * Convert an instance of Device to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

