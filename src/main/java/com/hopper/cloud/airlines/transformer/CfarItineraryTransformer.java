package com.hopper.cloud.airlines.transformer;
import com.hopper.cloud.airlines.model.CfarItinerary;
import com.hopper.cloud.airlines.model.CfarOfferItinerary;
import com.hopper.cloud.airlines.model.CfarOfferPassenger;
import com.hopper.cloud.airlines.model.CfarPassenger;

import java.util.List;
import java.util.stream.Collectors;

public class CfarItineraryTransformer {
    /**
     * Transform a CfarOfferItinerary to a CfarItinerary
     * @param cfarOfferItinerary
     * @return
     */
    public static CfarItinerary toCfarItinerary(CfarOfferItinerary cfarOfferItinerary) {
        CfarItinerary cfarItinerary = new CfarItinerary();
        cfarItinerary.setPassengerPricing(cfarOfferItinerary.getPassengerPricing());
        cfarItinerary.setCurrency(cfarOfferItinerary.getCurrency());
        cfarItinerary.setSlices(cfarOfferItinerary.getSlices());
        cfarItinerary.setAncillaries(cfarOfferItinerary.getAncillaries());
        cfarItinerary.setTotalPrice(cfarOfferItinerary.getTotalPrice());

        List<CfarPassenger> passengers = cfarOfferItinerary.getPassengers().stream().map(cfarOfferPassenger -> toCfarPassenger(cfarOfferPassenger)).collect(Collectors.toList());
        cfarItinerary.setPassengers(passengers);
        cfarItinerary.setFareRules(cfarOfferItinerary.getFareRules());

        return cfarItinerary;
    }

    /**
     * Transform a CfarOfferPassenger to a CfarPassenger
     * @param cfarOfferPassenger
     * @return
     */
    public static CfarPassenger toCfarPassenger(CfarOfferPassenger cfarOfferPassenger) {
        CfarPassenger cfarPassenger = new CfarPassenger();
        cfarPassenger.setPassengerType(cfarOfferPassenger.getPassengerType());
        cfarPassenger.setPassengerReference(cfarOfferPassenger.getPassengerReference());
        return cfarPassenger;
    }
}
