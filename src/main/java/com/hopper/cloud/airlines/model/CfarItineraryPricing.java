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

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CfarItineraryPricing {
    public static final String SERIALIZED_NAME_PASSENGER_PRICING = "passenger_pricing";
    @SerializedName(SERIALIZED_NAME_PASSENGER_PRICING)
    private List<PassengerPricing> passengerPricing = new ArrayList<>();

    public static final String SERIALIZED_NAME_ANCILLARIES = "ancillaries";
    @SerializedName(SERIALIZED_NAME_ANCILLARIES)
    private List<Ancillary> ancillaries = null;

    public static final String SERIALIZED_NAME_PASSENGERS = "passengers";
    @SerializedName(SERIALIZED_NAME_PASSENGERS)
    private List<CfarPassenger> passengers = null;

    public CfarItineraryPricing() {
    }

    /**
     * List of pricing per passenger for a fare
     *
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

    public CfarItineraryPricing passengerPricing(List<PassengerPricing> passengerPricing) {

        this.passengerPricing = passengerPricing;
        return this;
    }

    public CfarItineraryPricing addPassengerPricingItem(PassengerPricing passengerPricingItem) {
        this.passengerPricing.add(passengerPricingItem);
        return this;
    }


    /**
     * Ancillaries attached to a fare and their prices
     *
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

    public CfarItineraryPricing ancillaries(List<Ancillary> ancillaries) {

        this.ancillaries = ancillaries;
        return this;
    }

    public CfarItineraryPricing addAncillariesItem(Ancillary ancillariesItem) {
        if (this.ancillaries == null) {
            this.ancillaries = new ArrayList<>();
        }
        this.ancillaries.add(ancillariesItem);
        return this;
    }

    public CfarItineraryPricing passengers(List<CfarPassenger> passengers) {
        this.passengers = passengers;
        return this;
    }

    public CfarItineraryPricing addPassengersItem(CfarPassenger passengerItem) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CfarItineraryPricing cfarItineraryPricing = (CfarItineraryPricing) o;
        return Objects.equals(this.passengerPricing, cfarItineraryPricing.passengerPricing) &&
                Objects.equals(this.passengers, cfarItineraryPricing.passengers) &&
                Objects.equals(this.ancillaries, cfarItineraryPricing.ancillaries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerPricing, passengers, ancillaries);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CfarItineraryPricing {\n");
        sb.append("    passengerPricing: ").append(toIndentedString(passengerPricing)).append("\n");
        sb.append("    passengers: ").append(toIndentedString(passengers)).append("\n");
        sb.append("    ancillaries: ").append(toIndentedString(ancillaries)).append("\n");
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
            if (!CfarItineraryPricing.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'CfarItineraryPricing' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<CfarItineraryPricing> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(CfarItineraryPricing.class));

            return (TypeAdapter<T>) new TypeAdapter<CfarItineraryPricing>() {
                @Override
                public void write(JsonWriter out, CfarItineraryPricing value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public CfarItineraryPricing read(JsonReader in) throws IOException {
                    JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
                    return thisAdapter.fromJsonTree(jsonObj);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of CfarItineraryPricing given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CfarItineraryPricing
     * @throws IOException if the JSON string is invalid with respect to CfarItineraryPricing
     */
    public static CfarItineraryPricing fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, CfarItineraryPricing.class);
    }

    /**
     * Convert an instance of CfarItineraryPricing to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

