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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hopper.cloud.airlines.model.Device;
import com.hopper.cloud.airlines.model.UserInfo;
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
 * CreateAirlineSessionRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
@JsonInclude(JsonInclude.Include. NON_NULL)
public class CreateAirlineSessionRequest {
  public static final String SERIALIZED_NAME_USER_INFO = "user_info";
  @SerializedName(SERIALIZED_NAME_USER_INFO)
  private UserInfo userInfo;

  public static final String SERIALIZED_NAME_DEVICE = "device";
  @SerializedName(SERIALIZED_NAME_DEVICE)
  private Device device;

  public static final String SERIALIZED_NAME_POINT_OF_SALE = "point_of_sale";
  @SerializedName(SERIALIZED_NAME_POINT_OF_SALE)
  private String pointOfSale;

  public static final String SERIALIZED_NAME_LANGUAGE = "language";
  @SerializedName(SERIALIZED_NAME_LANGUAGE)
  private String language;

  public CreateAirlineSessionRequest() { 
  }

  public CreateAirlineSessionRequest userInfo(UserInfo userInfo) {
    
    this.userInfo = userInfo;
    return this;
  }

   /**
   * Get userInfo
   * @return userInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public UserInfo getUserInfo() {
    return userInfo;
  }


  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }


  public CreateAirlineSessionRequest device(Device device) {
    
    this.device = device;
    return this;
  }

   /**
   * Get device
   * @return device
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Device getDevice() {
    return device;
  }


  public void setDevice(Device device) {
    this.device = device;
  }


  public CreateAirlineSessionRequest pointOfSale(String pointOfSale) {
    
    this.pointOfSale = pointOfSale;
    return this;
  }

   /**
   * The point of sale related to the user. Must be an ISO 3166-1-alpha-2 country code
   * @return pointOfSale
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The point of sale related to the user. Must be an ISO 3166-1-alpha-2 country code")

  public String getPointOfSale() {
    return pointOfSale;
  }


  public void setPointOfSale(String pointOfSale) {
    this.pointOfSale = pointOfSale;
  }


  public CreateAirlineSessionRequest language(String language) {
    
    this.language = language;
    return this;
  }

   /**
   * The language associated with the user. Must be an ISO_639-1 country code
   * @return language
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The language associated with the user. Must be an ISO_639-1 country code")

  public String getLanguage() {
    return language;
  }


  public void setLanguage(String language) {
    this.language = language;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateAirlineSessionRequest createAirlineSessionRequest = (CreateAirlineSessionRequest) o;
    return Objects.equals(this.userInfo, createAirlineSessionRequest.userInfo) &&
        Objects.equals(this.device, createAirlineSessionRequest.device) &&
        Objects.equals(this.pointOfSale, createAirlineSessionRequest.pointOfSale) &&
        Objects.equals(this.language, createAirlineSessionRequest.language);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userInfo, device, pointOfSale, language);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAirlineSessionRequest {\n");
    sb.append("    userInfo: ").append(toIndentedString(userInfo)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    pointOfSale: ").append(toIndentedString(pointOfSale)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
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
    openapiFields.add("user_info");
    openapiFields.add("device");
    openapiFields.add("point_of_sale");
    openapiFields.add("language");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("point_of_sale");
    openapiRequiredFields.add("language");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CreateAirlineSessionRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (CreateAirlineSessionRequest.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in CreateAirlineSessionRequest is not found in the empty JSON string", CreateAirlineSessionRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!CreateAirlineSessionRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CreateAirlineSessionRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CreateAirlineSessionRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      // validate the optional field `user_info`
      if (jsonObj.getAsJsonObject("user_info") != null) {
        UserInfo.validateJsonObject(jsonObj.getAsJsonObject("user_info"));
      }
      // validate the optional field `device`
      if (jsonObj.getAsJsonObject("device") != null) {
        Device.validateJsonObject(jsonObj.getAsJsonObject("device"));
      }
      if (jsonObj.get("point_of_sale") != null && !jsonObj.get("point_of_sale").isJsonPrimitive() && !jsonObj.get("point_of_sale").isJsonNull()) {
        throw new IllegalArgumentException(String.format("Expected the field `point_of_sale` to be a primitive type in the JSON string but got `%s`", jsonObj.get("point_of_sale").toString()));
      }
      if (jsonObj.get("language") != null && !jsonObj.get("language").isJsonPrimitive() && !jsonObj.get("language").isJsonNull()) {
        throw new IllegalArgumentException(String.format("Expected the field `language` to be a primitive type in the JSON string but got `%s`", jsonObj.get("language").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateAirlineSessionRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateAirlineSessionRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateAirlineSessionRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateAirlineSessionRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateAirlineSessionRequest>() {
           @Override
           public void write(JsonWriter out, CreateAirlineSessionRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CreateAirlineSessionRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CreateAirlineSessionRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CreateAirlineSessionRequest
  * @throws IOException if the JSON string is invalid with respect to CreateAirlineSessionRequest
  */
  public static CreateAirlineSessionRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateAirlineSessionRequest.class);
  }

 /**
  * Convert an instance of CreateAirlineSessionRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

