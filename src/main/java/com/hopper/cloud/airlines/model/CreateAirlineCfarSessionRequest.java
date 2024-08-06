package com.hopper.cloud.airlines.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hopper.cloud.airlines.JSON;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.util.Objects;

/**
 * CreateAirlineSessionRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-28T12:18:49.517876+02:00[Europe/Paris]")
@JsonInclude(JsonInclude.Include. NON_NULL)
public class CreateAirlineCfarSessionRequest {


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

  public CreateAirlineCfarSessionRequest() {
  }


  public CreateAirlineCfarSessionRequest userInfo(UserInfo userInfo) {
    
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


  public CreateAirlineCfarSessionRequest device(Device device) {
    
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


  public CreateAirlineCfarSessionRequest pointOfSale(String pointOfSale) {
    
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


  public CreateAirlineCfarSessionRequest language(String language) {
    
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
    CreateAirlineCfarSessionRequest createAirlineSessionRequest = (CreateAirlineCfarSessionRequest) o;
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
    sb.append("class CreateAirlineCfarSessionRequest {\n");
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

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateAirlineCfarSessionRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateAirlineSessionRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateAirlineCfarSessionRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateAirlineCfarSessionRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateAirlineCfarSessionRequest>() {
           @Override
           public void write(JsonWriter out, CreateAirlineCfarSessionRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CreateAirlineCfarSessionRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
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
  public static CreateAirlineCfarSessionRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateAirlineCfarSessionRequest.class);
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

