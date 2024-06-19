package com.hopper.cloud.airlines.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hopper.cloud.airlines.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An object detailing a CFAR itinerary
 */
@ApiModel(description = "An object detailing a CFAR itinerary for exercise")
@JsonInclude(JsonInclude.Include. NON_NULL)
public class CfarCreateExerciseItinerary {
    public static final String SERIALIZED_NAME_PASSENGER_PRICING = "passenger_pricing";
    @SerializedName(SERIALIZED_NAME_PASSENGER_PRICING)
    private List<PassengerPricing> passengerPricing = null;

    public static final String SERIALIZED_NAME_CURRENCY = "currency";
    @SerializedName(SERIALIZED_NAME_CURRENCY)
    private String currency;

    public static final String SERIALIZED_NAME_SLICES = "slices";
    @SerializedName(SERIALIZED_NAME_SLICES)
    private List<CfarItinerarySlice> slices = new ArrayList<>();

    public static final String SERIALIZED_NAME_ANCILLARIES = "ancillaries";
    @SerializedName(SERIALIZED_NAME_ANCILLARIES)
    private List<Ancillary> ancillaries = null;

    public static final String SERIALIZED_NAME_TOTAL_PRICE = "total_price";
    @SerializedName(SERIALIZED_NAME_TOTAL_PRICE)
    private String totalPrice;

    public static final String SERIALIZED_NAME_PASSENGERS = "passengers";
    @SerializedName(SERIALIZED_NAME_PASSENGERS)
    private List<CfarPassenger> passengers = null;

    public static final String SERIALIZED_NAME_FARE_RULES = "fare_rules";
    @SerializedName(SERIALIZED_NAME_FARE_RULES)
    private List<FareRule> fareRules = null;

    public CfarCreateExerciseItinerary() {
    }

    public CfarCreateExerciseItinerary passengerPricing(List<PassengerPricing> passengerPricing) {
        this.passengerPricing = passengerPricing;
        return this;
    }

    public CfarCreateExerciseItinerary addPassengerPricingItem(PassengerPricing passengerPricingItem) {
        if (this.passengerPricing == null) {
            this.passengerPricing = new ArrayList<>();
        }
        this.passengerPricing.add(passengerPricingItem);
        return this;
    }

    /**
     * List of pricing per passenger for a fare
     * @return passengerPricing
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "List of pricing per passenger for a fare")

    public List<PassengerPricing> getPassengerPricing() {
        return passengerPricing;
    }


    public void setPassengerPricing(List<PassengerPricing> passengerPricing) {
        this.passengerPricing = passengerPricing;
    }


    public CfarCreateExerciseItinerary currency(String currency) {

        this.currency = currency;
        return this;
    }

    /**
     * Currency of pricing fields
     * @return currency
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "CAD", required = true, value = "Currency of pricing fields")

    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public CfarCreateExerciseItinerary slices(List<CfarItinerarySlice> slices) {

        this.slices = slices;
        return this;
    }

    public CfarCreateExerciseItinerary addSlicesItem(CfarItinerarySlice slicesItem) {
        this.slices.add(slicesItem);
        return this;
    }

    /**
     * List of fare slices included in this fare; only 1 (one way) or 2 (round trip) slices are allowed
     * @return slices
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "List of fare slices included in this fare; only 1 (one way) or 2 (round trip) slices are allowed")

    public List<CfarItinerarySlice> getSlices() {
        return slices;
    }


    public void setSlices(List<CfarItinerarySlice> slices) {
        this.slices = slices;
    }


    public CfarCreateExerciseItinerary ancillaries(List<Ancillary> ancillaries) {

        this.ancillaries = ancillaries;
        return this;
    }

    public CfarCreateExerciseItinerary addAncillariesItem(Ancillary ancillariesItem) {
        if (this.ancillaries == null) {
            this.ancillaries = new ArrayList<>();
        }
        this.ancillaries.add(ancillariesItem);
        return this;
    }

    /**
     * Ancillaries attached to a fare and their prices
     * @return ancillaries
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Ancillaries attached to a fare and their prices")

    public List<Ancillary> getAncillaries() {
        return ancillaries;
    }

    public void setAncillaries(List<Ancillary> ancillaries) {
        this.ancillaries = ancillaries;
    }


    public CfarCreateExerciseItinerary totalPrice(String totalPrice) {

        this.totalPrice = totalPrice;
        return this;
    }

    /**
     * Get totalPrice
     * @return totalPrice
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public String getTotalPrice() {
        return totalPrice;
    }


    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CfarCreateExerciseItinerary passengers(List<CfarPassenger> passengers) {
        this.passengers = passengers;
        return this;
    }

    public CfarCreateExerciseItinerary addPassengersItem(CfarPassenger passengerItem) {
        if (this.passengers == null) {
            this.passengers = new ArrayList<>();
        }
        this.passengers.add(passengerItem);
        return this;
    }

    /**
     * Retrieve Passengers
     * @return passengers
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Passengers associated with the itinerary")

    public List<CfarPassenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<CfarPassenger> passengers) {
        this.passengers = passengers;
    }

    public CfarCreateExerciseItinerary fareRules(List<FareRule> fareRules) {
        this.fareRules = fareRules;
        return this;
    }

    public CfarCreateExerciseItinerary addFareRulesItem(FareRule fareRuleItem) {
        if (this.fareRules == null) {
            this.fareRules = new ArrayList<>();
        }
        this.fareRules.add(fareRuleItem);
        return this;
    }

    /**
     * Retrieve fare rules associated to the itinerary
     * @return fareRules
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The fare rules associated to the itinerary. If different fare rules apply to different slices in the itinerary, indicate the most restrictive")

    public List<FareRule> getFareRules() {
        return fareRules;
    }

    public void setFareRules(List<FareRule> fareRules) {
        this.fareRules = fareRules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CfarCreateExerciseItinerary cfarItinerary = (CfarCreateExerciseItinerary) o;
        return Objects.equals(this.passengerPricing, cfarItinerary.passengerPricing) &&
                Objects.equals(this.currency, cfarItinerary.currency) &&
                Objects.equals(this.slices, cfarItinerary.slices) &&
                Objects.equals(this.ancillaries, cfarItinerary.ancillaries) &&
                Objects.equals(this.passengers, cfarItinerary.passengers) &&
                Objects.equals(this.fareRules, cfarItinerary.fareRules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerPricing, currency, slices, ancillaries, totalPrice, passengers, fareRules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CfarCreateExerciseItinerary {\n");
        sb.append("    passengerPricing: ").append(toIndentedString(passengerPricing)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    slices: ").append(toIndentedString(slices)).append("\n");
        sb.append("    ancillaries: ").append(toIndentedString(ancillaries)).append("\n");
        sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
        sb.append("    passengers: ").append(toIndentedString(passengers)).append("\n");
        sb.append("    fareRules: ").append(toIndentedString(fareRules)).append("\n");
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
            if (!CfarCreateExerciseItinerary.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'CfarItinerary' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CfarCreateExerciseItinerary> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(CfarCreateExerciseItinerary.class));

            return (TypeAdapter<T>) new TypeAdapter<CfarCreateExerciseItinerary>() {
                @Override
                public void write(JsonWriter out, CfarCreateExerciseItinerary value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CfarCreateExerciseItinerary read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CfarItinerary given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CfarItinerary
     * @throws IOException if the JSON string is invalid with respect to CfarItinerary
     */
    public static CfarCreateExerciseItinerary fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CfarCreateExerciseItinerary.class);
    }

    /**
     * Convert an instance of CfarItinerary to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

