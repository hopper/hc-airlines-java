package example;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

public class Example extends CommonExample {
    public static void main(String[] args) {
        try {
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

            String contractId = contract.getId();
            CfarContract getContract = client.getContract(sessionId, contractId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** GET CONTRACT ****************************");
            System.out.println("*********************************************************************");
            System.out.println(getContract);

            boolean isSucceeded = processCfarPayment(client, contractId, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** PROCESS PAYMENT *************************");
            System.out.println("*********************************************************************");
            System.out.println(isSucceeded);

            createBookingConfirmedEvent(client, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE EVENT ****************************");
            System.out.println("*********************************************************************");

            session = getAirlineSession(client, FlowType.EXERCISE);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE EXERCISE SESSION *****************");
            System.out.println("*********************************************************************");
            System.out.println(session);

            sessionId = session.getId();
            CfarContractExercise exercise = createCfarContractExercise(client, contractId, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE EXERCISE *************************");
            System.out.println("*********************************************************************");
            System.out.println(exercise);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static CfarContract createCfarContract(HopperClient client, List<CfarOffer> offers, String sessionId) throws ApiException {

        CreateCfarContractRequest contractRequest = new CreateCfarContractRequest();
        Map<String, String> params = new HashMap<>();
        params.put("property1", "test1");
        params.put("property2", "test2");

        contractRequest.setOfferIds(offers.stream().map(CfarOffer::getId).collect(Collectors.toList()));
        contractRequest.setExtAttributes(params);

        CfarItinerary itinerary = new CfarItinerary();
        itinerary.setCurrency("CAD");
        itinerary.setTotalPrice("190.00");

        //-- Slices
        CfarItinerarySlice cfarItinerarySlice = new CfarItinerarySlice();
        cfarItinerarySlice.setFareBrand("flex");
        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("JB776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("B6");

        CfarItinerarySliceSegment cfarItinerarySliceSegment2 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment2.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment2.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment2.setOriginAirport("LGA");
        cfarItinerarySliceSegment2.setDestinationAirport("BOS");
        cfarItinerarySliceSegment2.setFlightNumber("JB777");
        cfarItinerarySliceSegment2.setFareClass(FareClass.BUSINESS);
        cfarItinerarySliceSegment2.setFareBrand("flex");
        cfarItinerarySliceSegment2.setValidatingCarrierCode("B6");

        List<CfarItinerarySliceSegment> segments = new ArrayList<>();
        segments.add(cfarItinerarySliceSegment);
        segments.add(cfarItinerarySliceSegment2);
        cfarItinerarySlice.setSegments(segments);

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));

        //-- Ancillaries
        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("10.00");

        itinerary.setAncillaries(Collections.singletonList(ancillary));

        //-- Passenger Pricings
        PassengerPricing passengerPricing = new PassengerPricing();
        passengerPricing.setIndividualPrice("60.00");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.count(3);
        passengerCount.setType(PassengerType.ADULT);

        passengerPricing.setPassengerCount(passengerCount);itinerary.setPassengerPricing(Collections.singletonList(passengerPricing));

        contractRequest.setItinerary(itinerary);
        return client.createCfarContract(sessionId, contractRequest);
    }

    private static boolean processCfarPayment(HopperClient client, String contractId, String sessionId) throws ApiException {
        ProcessCfarPaymentRequest processCfarPaymentRequest = new ProcessCfarPaymentRequest();
        processCfarPaymentRequest.setFirstName("John");
        processCfarPaymentRequest.setLastName("Smith");
        processCfarPaymentRequest.setMonth("09");
        processCfarPaymentRequest.setYear("2029");
        processCfarPaymentRequest.setNumber("4111111111111111");
        processCfarPaymentRequest.setVerificationValue("123");
        processCfarPaymentRequest.setAddressLine1("123 12th St");
        processCfarPaymentRequest.setAddressLine2("Building B");
        processCfarPaymentRequest.setCity("Quebec City");
        processCfarPaymentRequest.setPostalCode("G1R 4S9");
        processCfarPaymentRequest.setStateOrProvince("QC");
        processCfarPaymentRequest.setCountry("CA");
        processCfarPaymentRequest.setEmailAddress("john@doe.com");
        processCfarPaymentRequest.setPnrReference("ABC123");
        return client.processCfarPayment(sessionId, contractId, processCfarPaymentRequest);
    }

    private static CfarContractExercise completeCfarContractExercise(HopperClient client, String exerciseId, String sessionId) throws ApiException {
        return client.completeCfarContractExercise(sessionId, new MarkCfarContractExerciseCompleteRequest(), exerciseId);
    }

    private static CfarContractExercise createCfarContractExercise(HopperClient client, String contractId, String sessionId) throws ApiException {
        CreateCfarContractExerciseRequest createCfarContractExerciseRequest = new CreateCfarContractExerciseRequest();
        createCfarContractExerciseRequest.setContractId(contractId);
        createCfarContractExerciseRequest.setCurrency("CAD");
        createCfarContractExerciseRequest.setPnrReference("ABC123");
        Map<String, String> params = new HashMap<>();
        params.put("property1", "test1");
        params.put("property2", "test2");
        createCfarContractExerciseRequest.setExtAttributes(params);
        createCfarContractExerciseRequest.setAirlineRefundPenalty("146.64");
        createCfarContractExerciseRequest.setAirlineRefundMethod(AirlineRefundMethod.CASH);

        CfarItinerary itinerary = new CfarItinerary();
        itinerary.setCurrency("CAD");
        itinerary.setTotalPrice("190.00");

        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("10.00");

        CfarItinerarySlice cfarItinerarySlice = new CfarItinerarySlice();
        cfarItinerarySlice.setFareBrand("flex");

        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("JB776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("B6");

        CfarItinerarySliceSegment cfarItinerarySliceSegment2 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment2.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment2.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment2.setOriginAirport("LGA");
        cfarItinerarySliceSegment2.setDestinationAirport("BOS");
        cfarItinerarySliceSegment2.setFlightNumber("JB777");
        cfarItinerarySliceSegment2.setFareClass(FareClass.BUSINESS);
        cfarItinerarySliceSegment2.setFareBrand("flex");
        cfarItinerarySliceSegment2.setValidatingCarrierCode("B6");

        List<CfarItinerarySliceSegment> segments = new ArrayList<>();
        segments.add(cfarItinerarySliceSegment);
        segments.add(cfarItinerarySliceSegment2);
        cfarItinerarySlice.setSegments(segments);

        PassengerPricing passengerPricing = new PassengerPricing();
        passengerPricing.setIndividualPrice("60.00");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.count(3);
        passengerCount.setType(PassengerType.ADULT);
        passengerPricing.setPassengerCount(passengerCount);

        CfarPassengerTax cfarPassengerTax = new CfarPassengerTax();
        cfarPassengerTax.amount("15.50");
        cfarPassengerTax.code("CF");
        cfarPassengerTax.currency("CAD");

        passengerPricing.setTaxes(Collections.singletonList(cfarPassengerTax));

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));
        itinerary.setAncillaries(Collections.singletonList(ancillary));
        itinerary.setPassengerPricing(Collections.singletonList(passengerPricing));

        createCfarContractExerciseRequest.setItinerary(itinerary);
        return client.createCfarContractExercise(sessionId, createCfarContractExerciseRequest);
    }
}