package example.hopperclient;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleItinerarySlicesUpdate extends CommonExample {
    public static void main(String[] args) {
        try {
            HopperClient client = new HopperClient("", "", "", "", "", "", "", "", 3000, true);

            AirlineSession session = getAirlineSession(client, FlowType.PURCHASE);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE PURCHASE SESSION *****************");
            System.out.println("*********************************************************************");
            System.out.println(session);

            String sessionId = session.getId();
            List<CfarOffer> offers = createCfarOffers(client, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE OFFERS ***************************");
            System.out.println("*********************************************************************");
            System.out.println(offers);

            List<CfarOffer> selectedOffer = new ArrayList<>();
            selectedOffer.add(offers.get(0));
            selectedOffer.add(offers.get(1));
            CfarContract contract = createCfarContract(client, selectedOffer, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE CONTRACT *************************");
            System.out.println("*********************************************************************");
            System.out.println(contract);

            CfarContract updatedContract = updateCfarContractItinerarySlices(client, contract.getId(), sessionId);
            System.out.println("*********************************************************************");
            System.out.println("************* UPDATE ITINERARY SLICES *******************************");
            System.out.println("*********************************************************************");
            System.out.println(updatedContract);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static CfarContract updateCfarContractItinerarySlices(HopperClient client, String contractId, String sessionId) throws ApiException {
        // Create updated itinerary slices
        List<UpdateCfarContractItinerarySliceRequest> slices = new ArrayList<>();

        UpdateCfarContractItinerarySliceRequest slice = new UpdateCfarContractItinerarySliceRequest();

        // First segment - updated flight
        CfarItinerarySliceSegment segment1 = new CfarItinerarySliceSegment();
        String updatedFlightDate = LocalDate.now().plusMonths(2).toString();
        segment1.setArrivalDateTime(updatedFlightDate + "T20:30:00");
        segment1.setDepartureDateTime(updatedFlightDate + "T16:30:00");
        segment1.setOriginAirport("FLL");
        segment1.setDestinationAirport("BOS");
        segment1.setFlightNumber("888");
        segment1.setFareClass(FareClass.ECONOMY);
        segment1.setFareBrand("premium");
        segment1.setValidatingCarrierCode("JB");

        // Second segment - updated flight
        CfarItinerarySliceSegment segment2 = new CfarItinerarySliceSegment();
        segment2.setArrivalDateTime(updatedFlightDate + "T23:45:00");
        segment2.setDepartureDateTime(updatedFlightDate + "T21:45:00");
        segment2.setOriginAirport("BOS");
        segment2.setDestinationAirport("JFK");
        segment2.setFlightNumber("999");
        segment2.setFareClass(FareClass.BUSINESS);
        segment2.setFareBrand("premium");
        segment2.setValidatingCarrierCode("JB");

        List<CfarItinerarySliceSegment> segments = new ArrayList<>();
        segments.add(segment1);
        segments.add(segment2);
        slice.setSegments(segments);

        slices.add(slice);

        UpdateCfarContractItinerarySlicesRequest request = new UpdateCfarContractItinerarySlicesRequest();
        request.setSlices(slices);

        return client.updateCfarContractItinerarySlices(sessionId, contractId, request);
    }
}
