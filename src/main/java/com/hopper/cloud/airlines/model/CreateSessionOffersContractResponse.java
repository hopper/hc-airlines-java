package com.hopper.cloud.airlines.model;

import java.util.ArrayList;
import java.util.List;

public class CreateSessionOffersContractResponse {

    private AirlineSession airlineSession;

    private List<CfarOffer> offers = new ArrayList<>();

    private List<CfarContract> contracts = new ArrayList<>();

    public AirlineSession getAirlineSession() {
        return airlineSession;
    }

    public void setAirlineSession(AirlineSession airlineSession) {
        this.airlineSession = airlineSession;
    }

    public List<CfarOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<CfarOffer> offers) {
        this.offers = offers;
    }

    public List<CfarContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<CfarContract> contracts) {
        this.contracts = contracts;
    }

}
