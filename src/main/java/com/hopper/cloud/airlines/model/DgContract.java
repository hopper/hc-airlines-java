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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hopper.cloud.airlines.model.DgOffer;
import com.hopper.cloud.airlines.model.DgStatus;
import com.hopper.cloud.airlines.model.DgTax;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hopper.cloud.airlines.JSON;

/**
 * A DG contract
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-02T18:35:20.974206513Z[Etc/UTC]", comments = "Generator version: 7.10.0")
public class DgContract {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  @javax.annotation.Nonnull
  private String id;

  public static final String SERIALIZED_NAME_REFERENCE = "reference";
  @SerializedName(SERIALIZED_NAME_REFERENCE)
  @javax.annotation.Nonnull
  private String reference;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  @javax.annotation.Nonnull
  private DgStatus status;

  public static final String SERIALIZED_NAME_OFFERS = "offers";
  @SerializedName(SERIALIZED_NAME_OFFERS)
  @javax.annotation.Nonnull
  private List<DgOffer> offers;

  public static final String SERIALIZED_NAME_COVERAGE_PERCENTAGE = "coverage_percentage";
  @SerializedName(SERIALIZED_NAME_COVERAGE_PERCENTAGE)
  @javax.annotation.Nonnull
  private String coveragePercentage;

  public static final String SERIALIZED_NAME_COVERAGE = "coverage";
  @SerializedName(SERIALIZED_NAME_COVERAGE)
  @javax.annotation.Nonnull
  private String coverage;

  public static final String SERIALIZED_NAME_PREMIUM = "premium";
  @SerializedName(SERIALIZED_NAME_PREMIUM)
  @javax.annotation.Nonnull
  private String premium;

  public static final String SERIALIZED_NAME_SERVICE_CAP = "service_cap";
  @SerializedName(SERIALIZED_NAME_SERVICE_CAP)
  @javax.annotation.Nonnull
  private String serviceCap;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  @javax.annotation.Nonnull
  private String currency;

  public static final String SERIALIZED_NAME_TAXES_TOTAL = "taxes_total";
  @SerializedName(SERIALIZED_NAME_TAXES_TOTAL)
  @javax.annotation.Nonnull
  private String taxesTotal;

  public static final String SERIALIZED_NAME_TAXES = "taxes";
  @SerializedName(SERIALIZED_NAME_TAXES)
  @javax.annotation.Nullable
  private List<DgTax> taxes;

  public static final String SERIALIZED_NAME_MAX_HOURS_BEFORE_DEPARTURE = "max_hours_before_departure";
  @SerializedName(SERIALIZED_NAME_MAX_HOURS_BEFORE_DEPARTURE)
  @javax.annotation.Nonnull
  private Integer maxHoursBeforeDeparture;

  public static final String SERIALIZED_NAME_MIN_MINUTES_DELAY = "min_minutes_delay";
  @SerializedName(SERIALIZED_NAME_MIN_MINUTES_DELAY)
  @javax.annotation.Nonnull
  private Integer minMinutesDelay;

  public static final String SERIALIZED_NAME_CREATED_DATE_TIME = "created_date_time";
  @SerializedName(SERIALIZED_NAME_CREATED_DATE_TIME)
  @javax.annotation.Nonnull
  private OffsetDateTime createdDateTime;

  public static final String SERIALIZED_NAME_EXPIRY_DATE_TIME = "expiry_date_time";
  @SerializedName(SERIALIZED_NAME_EXPIRY_DATE_TIME)
  @javax.annotation.Nonnull
  private OffsetDateTime expiryDateTime;

  public static final String SERIALIZED_NAME_LANGUAGE = "language";
  @SerializedName(SERIALIZED_NAME_LANGUAGE)
  @javax.annotation.Nullable
  private String language;

  public static final String SERIALIZED_NAME_PNR_REFERENCE = "pnr_reference";
  @SerializedName(SERIALIZED_NAME_PNR_REFERENCE)
  @javax.annotation.Nullable
  private String pnrReference;

  public static final String SERIALIZED_NAME_EXT_ATTRIBUTES = "ext_attributes";
  @SerializedName(SERIALIZED_NAME_EXT_ATTRIBUTES)
  @javax.annotation.Nonnull
  private Map<String, String> extAttributes;

  public DgContract() {
  }

  public DgContract id(@javax.annotation.Nonnull String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for a contract
   * @return id
   */
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(@javax.annotation.Nonnull String id) {
    this.id = id;
  }


  public DgContract reference(@javax.annotation.Nonnull String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Unique reference for a contract
   * @return reference
   */
  @javax.annotation.Nonnull
  public String getReference() {
    return reference;
  }

  public void setReference(@javax.annotation.Nonnull String reference) {
    this.reference = reference;
  }


  public DgContract status(@javax.annotation.Nonnull DgStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @javax.annotation.Nonnull
  public DgStatus getStatus() {
    return status;
  }

  public void setStatus(@javax.annotation.Nonnull DgStatus status) {
    this.status = status;
  }


  public DgContract offers(@javax.annotation.Nonnull List<DgOffer> offers) {
    this.offers = offers;
    return this;
  }

  public DgContract addOffersItem(DgOffer offersItem) {
    if (this.offers == null) {
      this.offers = new ArrayList<>();
    }
    this.offers.add(offersItem);
    return this;
  }

  /**
   * DG Offer(s) used to create the contract
   * @return offers
   */
  @javax.annotation.Nonnull
  public List<DgOffer> getOffers() {
    return offers;
  }

  public void setOffers(@javax.annotation.Nonnull List<DgOffer> offers) {
    this.offers = offers;
  }


  public DgContract coveragePercentage(@javax.annotation.Nonnull String coveragePercentage) {
    this.coveragePercentage = coveragePercentage;
    return this;
  }

  /**
   * Percentage of the ticket’s value to be refunded upon DG exercise
   * @return coveragePercentage
   */
  @javax.annotation.Nonnull
  public String getCoveragePercentage() {
    return coveragePercentage;
  }

  public void setCoveragePercentage(@javax.annotation.Nonnull String coveragePercentage) {
    this.coveragePercentage = coveragePercentage;
  }


  public DgContract coverage(@javax.annotation.Nonnull String coverage) {
    this.coverage = coverage;
    return this;
  }

  /**
   * Total amount to be refunded upon DG exercise
   * @return coverage
   */
  @javax.annotation.Nonnull
  public String getCoverage() {
    return coverage;
  }

  public void setCoverage(@javax.annotation.Nonnull String coverage) {
    this.coverage = coverage;
  }


  public DgContract premium(@javax.annotation.Nonnull String premium) {
    this.premium = premium;
    return this;
  }

  /**
   * Total amount to be paid for DG
   * @return premium
   */
  @javax.annotation.Nonnull
  public String getPremium() {
    return premium;
  }

  public void setPremium(@javax.annotation.Nonnull String premium) {
    this.premium = premium;
  }


  public DgContract serviceCap(@javax.annotation.Nonnull String serviceCap) {
    this.serviceCap = serviceCap;
    return this;
  }

  /**
   * Allowed amount per passenger to book a new flight in case of disruption
   * @return serviceCap
   */
  @javax.annotation.Nonnull
  public String getServiceCap() {
    return serviceCap;
  }

  public void setServiceCap(@javax.annotation.Nonnull String serviceCap) {
    this.serviceCap = serviceCap;
  }


  public DgContract currency(@javax.annotation.Nonnull String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Currency of contract
   * @return currency
   */
  @javax.annotation.Nonnull
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(@javax.annotation.Nonnull String currency) {
    this.currency = currency;
  }


  public DgContract taxesTotal(@javax.annotation.Nonnull String taxesTotal) {
    this.taxesTotal = taxesTotal;
    return this;
  }

  /**
   * Part of the premium which are taxes
   * @return taxesTotal
   */
  @javax.annotation.Nonnull
  public String getTaxesTotal() {
    return taxesTotal;
  }

  public void setTaxesTotal(@javax.annotation.Nonnull String taxesTotal) {
    this.taxesTotal = taxesTotal;
  }


  public DgContract taxes(@javax.annotation.Nullable List<DgTax> taxes) {
    this.taxes = taxes;
    return this;
  }

  public DgContract addTaxesItem(DgTax taxesItem) {
    if (this.taxes == null) {
      this.taxes = new ArrayList<>();
    }
    this.taxes.add(taxesItem);
    return this;
  }

  /**
   * List of applicable taxes
   * @return taxes
   */
  @javax.annotation.Nullable
  public List<DgTax> getTaxes() {
    return taxes;
  }

  public void setTaxes(@javax.annotation.Nullable List<DgTax> taxes) {
    this.taxes = taxes;
  }


  public DgContract maxHoursBeforeDeparture(@javax.annotation.Nonnull Integer maxHoursBeforeDeparture) {
    this.maxHoursBeforeDeparture = maxHoursBeforeDeparture;
    return this;
  }

  /**
   * The number of hours before each flight or slice departure from which a purchased contract would start to cover disruptions
   * minimum: 0
   * @return maxHoursBeforeDeparture
   */
  @javax.annotation.Nonnull
  public Integer getMaxHoursBeforeDeparture() {
    return maxHoursBeforeDeparture;
  }

  public void setMaxHoursBeforeDeparture(@javax.annotation.Nonnull Integer maxHoursBeforeDeparture) {
    this.maxHoursBeforeDeparture = maxHoursBeforeDeparture;
  }


  public DgContract minMinutesDelay(@javax.annotation.Nonnull Integer minMinutesDelay) {
    this.minMinutesDelay = minMinutesDelay;
    return this;
  }

  /**
   * The minimum flight or slice departure delay in minutes to be covered
   * minimum: 0
   * @return minMinutesDelay
   */
  @javax.annotation.Nonnull
  public Integer getMinMinutesDelay() {
    return minMinutesDelay;
  }

  public void setMinMinutesDelay(@javax.annotation.Nonnull Integer minMinutesDelay) {
    this.minMinutesDelay = minMinutesDelay;
  }


  public DgContract createdDateTime(@javax.annotation.Nonnull OffsetDateTime createdDateTime) {
    this.createdDateTime = createdDateTime;
    return this;
  }

  /**
   * A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which a CFAR contract was created
   * @return createdDateTime
   */
  @javax.annotation.Nonnull
  public OffsetDateTime getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(@javax.annotation.Nonnull OffsetDateTime createdDateTime) {
    this.createdDateTime = createdDateTime;
  }


  public DgContract expiryDateTime(@javax.annotation.Nonnull OffsetDateTime expiryDateTime) {
    this.expiryDateTime = expiryDateTime;
    return this;
  }

  /**
   * A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) A UTC RFC3339 datetime; the date and time at which the CFAR contract will expire once purchased
   * @return expiryDateTime
   */
  @javax.annotation.Nonnull
  public OffsetDateTime getExpiryDateTime() {
    return expiryDateTime;
  }

  public void setExpiryDateTime(@javax.annotation.Nonnull OffsetDateTime expiryDateTime) {
    this.expiryDateTime = expiryDateTime;
  }


  public DgContract language(@javax.annotation.Nullable String language) {
    this.language = language;
    return this;
  }

  /**
   * Language of the booking
   * @return language
   */
  @javax.annotation.Nullable
  public String getLanguage() {
    return language;
  }

  public void setLanguage(@javax.annotation.Nullable String language) {
    this.language = language;
  }


  public DgContract pnrReference(@javax.annotation.Nullable String pnrReference) {
    this.pnrReference = pnrReference;
    return this;
  }

  /**
   * Reference of the PNR in the airline system
   * @return pnrReference
   */
  @javax.annotation.Nullable
  public String getPnrReference() {
    return pnrReference;
  }

  public void setPnrReference(@javax.annotation.Nullable String pnrReference) {
    this.pnrReference = pnrReference;
  }


  public DgContract extAttributes(@javax.annotation.Nonnull Map<String, String> extAttributes) {
    this.extAttributes = extAttributes;
    return this;
  }

  public DgContract putExtAttributesItem(String key, String extAttributesItem) {
    if (this.extAttributes == null) {
      this.extAttributes = new HashMap<>();
    }
    this.extAttributes.put(key, extAttributesItem);
    return this;
  }

  /**
   * Get extAttributes
   * @return extAttributes
   */
  @javax.annotation.Nonnull
  public Map<String, String> getExtAttributes() {
    return extAttributes;
  }

  public void setExtAttributes(@javax.annotation.Nonnull Map<String, String> extAttributes) {
    this.extAttributes = extAttributes;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DgContract dgContract = (DgContract) o;
    return Objects.equals(this.id, dgContract.id) &&
        Objects.equals(this.reference, dgContract.reference) &&
        Objects.equals(this.status, dgContract.status) &&
        Objects.equals(this.offers, dgContract.offers) &&
        Objects.equals(this.coveragePercentage, dgContract.coveragePercentage) &&
        Objects.equals(this.coverage, dgContract.coverage) &&
        Objects.equals(this.premium, dgContract.premium) &&
        Objects.equals(this.serviceCap, dgContract.serviceCap) &&
        Objects.equals(this.currency, dgContract.currency) &&
        Objects.equals(this.taxesTotal, dgContract.taxesTotal) &&
        Objects.equals(this.taxes, dgContract.taxes) &&
        Objects.equals(this.maxHoursBeforeDeparture, dgContract.maxHoursBeforeDeparture) &&
        Objects.equals(this.minMinutesDelay, dgContract.minMinutesDelay) &&
        Objects.equals(this.createdDateTime, dgContract.createdDateTime) &&
        Objects.equals(this.expiryDateTime, dgContract.expiryDateTime) &&
        Objects.equals(this.language, dgContract.language) &&
        Objects.equals(this.pnrReference, dgContract.pnrReference) &&
        Objects.equals(this.extAttributes, dgContract.extAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reference, status, offers, coveragePercentage, coverage, premium, serviceCap, currency, taxesTotal, taxes, maxHoursBeforeDeparture, minMinutesDelay, createdDateTime, expiryDateTime, language, pnrReference, extAttributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DgContract {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    offers: ").append(toIndentedString(offers)).append("\n");
    sb.append("    coveragePercentage: ").append(toIndentedString(coveragePercentage)).append("\n");
    sb.append("    coverage: ").append(toIndentedString(coverage)).append("\n");
    sb.append("    premium: ").append(toIndentedString(premium)).append("\n");
    sb.append("    serviceCap: ").append(toIndentedString(serviceCap)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    taxesTotal: ").append(toIndentedString(taxesTotal)).append("\n");
    sb.append("    taxes: ").append(toIndentedString(taxes)).append("\n");
    sb.append("    maxHoursBeforeDeparture: ").append(toIndentedString(maxHoursBeforeDeparture)).append("\n");
    sb.append("    minMinutesDelay: ").append(toIndentedString(minMinutesDelay)).append("\n");
    sb.append("    createdDateTime: ").append(toIndentedString(createdDateTime)).append("\n");
    sb.append("    expiryDateTime: ").append(toIndentedString(expiryDateTime)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    pnrReference: ").append(toIndentedString(pnrReference)).append("\n");
    sb.append("    extAttributes: ").append(toIndentedString(extAttributes)).append("\n");
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
    openapiFields.add("reference");
    openapiFields.add("status");
    openapiFields.add("offers");
    openapiFields.add("coverage_percentage");
    openapiFields.add("coverage");
    openapiFields.add("premium");
    openapiFields.add("service_cap");
    openapiFields.add("currency");
    openapiFields.add("taxes_total");
    openapiFields.add("taxes");
    openapiFields.add("max_hours_before_departure");
    openapiFields.add("min_minutes_delay");
    openapiFields.add("created_date_time");
    openapiFields.add("expiry_date_time");
    openapiFields.add("language");
    openapiFields.add("pnr_reference");
    openapiFields.add("ext_attributes");
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DgContract.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DgContract' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DgContract> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DgContract.class));

       return (TypeAdapter<T>) new TypeAdapter<DgContract>() {
           @Override
           public void write(JsonWriter out, DgContract value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DgContract read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of DgContract given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of DgContract
   * @throws IOException if the JSON string is invalid with respect to DgContract
   */
  public static DgContract fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DgContract.class);
  }

  /**
   * Convert an instance of DgContract to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

