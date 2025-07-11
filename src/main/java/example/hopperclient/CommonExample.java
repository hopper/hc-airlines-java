package example.hopperclient;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

public class CommonExample {
    protected static String flightDate = LocalDate.now().plusMonths(2).toString();
    private static CreateAirlineSessionRequest prepareCreateAirlineSessionRequest(FlowType flowType) {
        CreateAirlineSessionRequest sessionRequest = new CreateAirlineSessionRequest();
        sessionRequest.setFlowType(flowType);
        sessionRequest.setLanguage("EN");
        sessionRequest.setPointOfSale("US");

        Web web = new Web();

        Chrome chrome = new Chrome();
        chrome.version("103.0.5060.53");
        Browser browser = new Browser();
        browser.setActualInstance(chrome);
        web.browser(browser);

        MacOs macOs = new MacOs();
        macOs.setVersion("monterey");
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setActualInstance(macOs);
        web.operatingSystem(operatingSystem);

        Desktop desktop = new Desktop();
        desktop.setId("airlines-test-device-1");
        Platform platform = new Platform();
        platform.setActualInstance(web);
        desktop.setPlatform(platform);

        Device device = new Device();
        device.setActualInstance(desktop);

        return sessionRequest;
    }

    protected static AirlineSession getAirlineSession(HopperClient client, FlowType flowType) throws ApiException {
        return client.createSession(prepareCreateAirlineSessionRequest(flowType));
    }

    protected static void createBookingConfirmedEvent(HopperClient client, String sessionId) throws ApiException {
        BookingConfirmed bookingConfirmed = new BookingConfirmed();
        bookingConfirmed.setType("booking_confirmed");
        bookingConfirmed.setOccurredDateTime(LocalDateTime.now().atOffset(ZoneOffset.UTC));
        Event event = new Event();
        event.setActualInstance(bookingConfirmed);
        client.createEvent(sessionId, event);
    }

    private static CreateCfarOfferRequest prepareCreateCfarOfferRequest() {
        CreateCfarOfferRequest createCfarOfferRequest = new CreateCfarOfferRequest();
        createCfarOfferRequest.setRequestType(RequestType.FARE);

        Map<String, String> params = new HashMap<>();
        params.put("property1", "test1");
        params.put("property2", "test2");
        createCfarOfferRequest.setExtAttributes(params);

        // First itinerary
        CfarOfferItinerary itinerary1 = new CfarOfferItinerary();
        itinerary1.setCurrency("USD");
        itinerary1.setTotalPrice("100.00");

        //-- Slices
        CfarItinerarySlice cfarItinerarySlice = new CfarItinerarySlice();
        cfarItinerarySlice.setFareBrand("basic");
        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime(flightDate + "T15:12:30");
        cfarItinerarySliceSegment.setOriginAirport("FLL");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("JB");
        cfarItinerarySlice.setSegments(Collections.singletonList(cfarItinerarySliceSegment));

        itinerary1.setSlices(Collections.singletonList(cfarItinerarySlice));

        //-- Ancillaries
        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("10.00");

        itinerary1.setAncillaries(Collections.singletonList(ancillary));

        //-- Passenger Pricings
        PassengerPricing passengerPricing = new PassengerPricing();
        passengerPricing.setIndividualPrice("30.00");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.count(3);
        passengerCount.setType(PassengerType.ADULT);
        passengerPricing.setPassengerCount(passengerCount);

        CfarPassengerTax cfarPassengerTax = new CfarPassengerTax();
        cfarPassengerTax.amount("15.50");
        cfarPassengerTax.code("CF");
        cfarPassengerTax.currency("USD");

        passengerPricing.setTaxes(Collections.singletonList(cfarPassengerTax));

        itinerary1.setPassengerPricing(Collections.singletonList(passengerPricing));


        List<CfarOfferPassenger> passengersIti1 = new ArrayList<>();
        CfarOfferPassenger passengerIti1 = new CfarOfferPassenger();
        passengerIti1.setPassengerType(PassengerType.ADULT);
        passengerIti1.setPassengerReference("PAX1");
        passengersIti1.add(passengerIti1);
        itinerary1.setPassengers(passengersIti1);

        // Second itinerary
        CfarOfferItinerary itinerary2 = new CfarOfferItinerary();
        itinerary2.setCurrency("USD");
        itinerary2.setTotalPrice("120.00");

        //-- Slices
        CfarItinerarySlice cfarItinerarySlice1 = new CfarItinerarySlice();
        cfarItinerarySlice1.setFareBrand("flex");
        CfarItinerarySliceSegment cfarItinerarySliceSegment1 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment1.setArrivalDateTime(flightDate + "T23:12:30");
        cfarItinerarySliceSegment1.setDepartureDateTime(flightDate + "T21:12:30");
        cfarItinerarySliceSegment1.setOriginAirport("BOS");
        cfarItinerarySliceSegment1.setDestinationAirport("JFK");
        cfarItinerarySliceSegment1.setFlightNumber("777");
        cfarItinerarySliceSegment1.setFareClass(FareClass.BUSINESS);
        cfarItinerarySliceSegment1.setFareBrand("flex");
        cfarItinerarySliceSegment1.setValidatingCarrierCode("JB");
        cfarItinerarySlice1.setSegments(Collections.singletonList(cfarItinerarySliceSegment1));

        itinerary2.setSlices(Collections.singletonList(cfarItinerarySlice1));

        //-- Ancillaries
        Ancillary ancillary1 = new Ancillary();
        ancillary1.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary1.setTotalPrice("30.00");
        itinerary2.setAncillaries(Collections.singletonList(ancillary1));

        //-- Passenger Pricings
        PassengerPricing passengerPricing1 = new PassengerPricing();
        passengerPricing1.setIndividualPrice("30.00");
        PassengerCount passengerCount1 = new PassengerCount();
        passengerCount1.count(3);
        passengerCount1.setType(PassengerType.ADULT);
        passengerPricing1.setPassengerCount(passengerCount1);

        List<CfarOfferPassenger> passengersIti2 = new ArrayList<>();
        CfarOfferPassenger passengerIti2 = new CfarOfferPassenger();
        passengerIti2.setPassengerType(PassengerType.ADULT);
        passengerIti2.setPassengerReference("PAX1");
        passengersIti2.add(passengerIti2);
        itinerary2.setPassengers(passengersIti2);

        itinerary2.setPassengerPricing(Collections.singletonList(passengerPricing1));

        List<CfarOfferItinerary> itineraries = new ArrayList<>();
        itineraries.add(itinerary1);
        itineraries.add(itinerary2);
        createCfarOfferRequest.setItinerary(itineraries);

        return createCfarOfferRequest;
    }

    protected static List<CfarOffer> createCfarOffers(HopperClient client, String sessionId) throws ApiException {
        System.out.println(prepareCreateCfarOfferRequest().toJson());
        return client.createOffers(sessionId, prepareCreateCfarOfferRequest());
    }

    protected static CfarContract createCfarContract(HopperClient client, List<CfarOffer> offers, String sessionId) throws ApiException {
        CreateCfarContractRequest contractRequest = new CreateCfarContractRequest();
        Map<String, String> params = new HashMap<>();
        params.put("property1", "test1");
        params.put("property2", "test2");

        contractRequest.setOfferIds(offers.stream().map(CfarOffer::getId).collect(Collectors.toList()));
        contractRequest.setExtAttributes(params);

        CfarItinerary itinerary = new CfarItinerary();
        itinerary.setCurrency("USD");
        itinerary.setTotalPrice("220.00");

        //-- Slices
        CfarItinerarySlice cfarItinerarySlice = new CfarItinerarySlice();
        cfarItinerarySlice.setFareBrand("flex");
        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime(flightDate + "T15:12:30");
        cfarItinerarySliceSegment.setOriginAirport("FLL");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("JB");

        CfarItinerarySliceSegment cfarItinerarySliceSegment2 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment2.setArrivalDateTime(flightDate + "T23:12:30");
        cfarItinerarySliceSegment2.setDepartureDateTime(flightDate + "T21:12:30");
        cfarItinerarySliceSegment2.setOriginAirport("BOS");
        cfarItinerarySliceSegment2.setDestinationAirport("JFK");
        cfarItinerarySliceSegment2.setFlightNumber("777");
        cfarItinerarySliceSegment2.setFareClass(FareClass.BUSINESS);
        cfarItinerarySliceSegment2.setFareBrand("flex");
        cfarItinerarySliceSegment2.setValidatingCarrierCode("JB");

        List<CfarItinerarySliceSegment> segments = new ArrayList<>();
        segments.add(cfarItinerarySliceSegment);
        segments.add(cfarItinerarySliceSegment2);
        cfarItinerarySlice.setSegments(segments);

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));

        //-- Ancillaries
        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("40.00");

        itinerary.setAncillaries(Collections.singletonList(ancillary));

        //-- Passenger Pricings
        PassengerPricing passengerPricing = new PassengerPricing();
        passengerPricing.setIndividualPrice("60.00");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.count(3);
        passengerCount.setType(PassengerType.ADULT);

        passengerPricing.setPassengerCount(passengerCount);

        CfarPassengerTax cfarPassengerTax = new CfarPassengerTax();
        cfarPassengerTax.amount("15.50");
        cfarPassengerTax.code("CF");
        cfarPassengerTax.currency("USD");

        passengerPricing.setTaxes(Collections.singletonList(cfarPassengerTax));

        itinerary.setPassengerPricing(Collections.singletonList(passengerPricing));

        contractRequest.setItinerary(itinerary);
        return client.createCfarContract(sessionId, contractRequest);
    }

    protected static CreateSessionOffersContractsResponse createSessionOffersAndContracts(HopperClient client) throws ApiException {
        return client.createSessionOffersAndContracts(prepareCreateAirlineSessionRequest(FlowType.PURCHASE), prepareCreateCfarOfferRequest());
    }

    protected static CfarContract updateCfarContract(HopperClient client, String contractReference, String sessionId) throws ApiException {
        UpdateCfarContractRequest updateCfarContractRequest = new UpdateCfarContractRequest();
        updateCfarContractRequest.setEmailAddress("test@test.com");
        updateCfarContractRequest.setStatus(CfarStatus.CONFIRMED);
        updateCfarContractRequest.setPnrReference("ABC123");
        updateCfarContractRequest.setCurrency("EUR");
        updateCfarContractRequest.setExchangeRate("0.90");
        return client.updateCfarContractStatus(sessionId, contractReference, updateCfarContractRequest);
    }


    protected static CfarContractExercise completeCfarContractExercise(HopperClient client, String exerciseId, String sessionId) throws ApiException {
        MarkCfarContractExerciseCompleteRequest markCfarContractExerciseCompleteRequest = new MarkCfarContractExerciseCompleteRequest();
        markCfarContractExerciseCompleteRequest.setRefundMethod(AirlineRefundMethod.CASH);
        markCfarContractExerciseCompleteRequest.setRefundAmount("80.00");
        return client.completeCfarContractExercise(sessionId, markCfarContractExerciseCompleteRequest, exerciseId);
    }

    protected static CfarContractExercise createCfarContractExercise(HopperClient client, String contractId, String sessionId) throws ApiException, MalformedURLException {
        CreateCfarContractExerciseRequest createCfarContractExerciseRequest = new CreateCfarContractExerciseRequest();
        createCfarContractExerciseRequest.setContractId(contractId);
        createCfarContractExerciseRequest.setCallbackUrl("https://www.volaris.com/callback?id=1234456790&session=1A530637289A03B07199A44E8D531427");
        createCfarContractExerciseRequest.setRedirectbackUrl("https://www.volaris.com/mmb?pnr=ABC123&session=1A530637289A03B07199A44E8D5");
        createCfarContractExerciseRequest.setCurrency("USD");
        createCfarContractExerciseRequest.setPnrReference("ABC123");
        Map<String, String> params = new HashMap<>();
        params.put("property1", "test1");
        params.put("property2", "test2");
        createCfarContractExerciseRequest.setExtAttributes(params);
        createCfarContractExerciseRequest.setAirlineRefundPenalty("146.64");
        createCfarContractExerciseRequest.setAirlineRefundMethod(AirlineRefundMethod.CASH);

        CfarCreateExerciseItinerary itinerary = new CfarCreateExerciseItinerary ();
        itinerary.setCurrency("USD");
        itinerary.setTotalPrice("190.00");

        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("10.00");

        CfarCreateExerciseItinerarySlice cfarItinerarySlice = new CfarCreateExerciseItinerarySlice();
        cfarItinerarySlice.setFareBrand("flex");

        CfarCreateExerciseSliceSegment cfarItinerarySliceSegment = new CfarCreateExerciseSliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime(flightDate + "T15:12:30");
        cfarItinerarySliceSegment.setOriginAirport("FLL");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("JB");

        CfarCreateExerciseSliceSegment cfarItinerarySliceSegment2 = new CfarCreateExerciseSliceSegment();
        cfarItinerarySliceSegment2.setArrivalDateTime(flightDate + "T23:12:30");
        cfarItinerarySliceSegment2.setDepartureDateTime(flightDate + "T21:12:30");
        cfarItinerarySliceSegment2.setOriginAirport("BOS");
        cfarItinerarySliceSegment2.setDestinationAirport("JFK");
        cfarItinerarySliceSegment2.setFlightNumber("777");
        cfarItinerarySliceSegment2.setFareClass(FareClass.BUSINESS);
        cfarItinerarySliceSegment2.setFareBrand("flex");
        cfarItinerarySliceSegment2.setValidatingCarrierCode("JB");

        cfarItinerarySlice.addSegmentsItem(cfarItinerarySliceSegment);
        cfarItinerarySlice.addSegmentsItem(cfarItinerarySliceSegment2);

        CfarCreateExercisePassengerPricing passengerPricing = new CfarCreateExercisePassengerPricing();
        passengerPricing.setIndividualPrice("60.00");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.count(3);
        passengerCount.setType(PassengerType.ADULT);
        passengerPricing.setPassengerCount(passengerCount);

        CfarPassengerTax cfarPassengerTax = new CfarPassengerTax();
        cfarPassengerTax.amount("15.50");
        cfarPassengerTax.code("CF");
        cfarPassengerTax.currency("USD");

        passengerPricing.setTaxes(Collections.singletonList(cfarPassengerTax));

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));
        itinerary.setAncillaries(Collections.singletonList(ancillary));
        itinerary.setPassengerPricing(Collections.singletonList(passengerPricing));

        createCfarContractExerciseRequest.setItinerary(itinerary);
        return client.createCfarContractExercise(sessionId, createCfarContractExerciseRequest);
    }
}
