package example;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

public class CommonExample {
    protected static HopperClient client = new HopperClient("", "", "", "", "", "", true);
    protected static String flightDate = "2024-09-30";

    private static CreateAirlineSessionRequest prepareCreateAirlineSessionRequest(FlowType flowType) {
        CreateAirlineSessionRequest sessionRequest = new CreateAirlineSessionRequest();
        sessionRequest.setFlowType(flowType);
        sessionRequest.setLanguage("EN");
        sessionRequest.setPointOfSale("US");

        UserInfo userInfo = new UserInfo();
        userInfo.setAirlineUserId("airline-test-1");
        userInfo.setCreatedDateTime(LocalDateTime.now().atOffset(ZoneOffset.UTC));
        userInfo.setPreviousBookings(1);

        Device device = new Device();
        device.setId("airlines-test-device-1");
        device.setType(DeviceType.DESKTOP);

        Platform platform = new Platform();
        platform.setType(PlatformType.WEB);

        Browser browser = new Browser();
        browser.setType(BrowserType.CHROME);
        browser.setVersion("103.0.5060.53");

        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setType(OperatingSystemType.MAC_OS);
        operatingSystem.setVersion("monterey");

        platform.setBrowser(browser);
        platform.setOperatingSystem(operatingSystem);
        device.setPlatform(platform);
        //sessionRequest.setDevice(device);
        //sessionRequest.setUserInfo(userInfo);

        return sessionRequest;
    }

    protected static AirlineSession getAirlineSession(HopperClient client, FlowType flowType) throws ApiException {
        return client.createSession(prepareCreateAirlineSessionRequest(flowType));
    }

    protected static void createBookingConfirmedEvent(HopperClient client, String sessionId) throws ApiException {
        Event event = new Event();
        event.setType("booking_confirmed");
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
        cfarItinerarySliceSegment.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("JB776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("B6");
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
        cfarItinerarySliceSegment1.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment1.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment1.setOriginAirport("LGA");
        cfarItinerarySliceSegment1.setDestinationAirport("BOS");
        cfarItinerarySliceSegment1.setFlightNumber("JB777");
        cfarItinerarySliceSegment1.setFareClass(FareClass.BUSINESS);
        cfarItinerarySliceSegment1.setFareBrand("flex");
        cfarItinerarySliceSegment1.setValidatingCarrierCode("B6");
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

        itinerary2.setPassengerPricing(Collections.singletonList(passengerPricing1));

        List<CfarOfferItinerary> itineraries = new ArrayList<>();
        itineraries.add(itinerary1);
        itineraries.add(itinerary2);
        createCfarOfferRequest.setItinerary(itineraries);

        return createCfarOfferRequest;
    }

    protected static List<CfarOffer> createCfarOffers(HopperClient client, String sessionId) throws ApiException {
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
        updateCfarContractRequest.setStatus(CfarContractStatus.CONFIRMED);
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
        createCfarContractExerciseRequest.setCallbackUrl(new URL("https://www.volaris.com/callback?id=1234456790&session=1A530637289A03B07199A44E8D531427"));
        createCfarContractExerciseRequest.setRedirectbackUrl(new URL("https://www.volaris.com/mmb?pnr=ABC123&session=1A530637289A03B07199A44E8D5"));
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
        cfarPassengerTax.currency("USD");

        passengerPricing.setTaxes(Collections.singletonList(cfarPassengerTax));

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));
        itinerary.setAncillaries(Collections.singletonList(ancillary));
        itinerary.setPassengerPricing(Collections.singletonList(passengerPricing));

        createCfarContractExerciseRequest.setItinerary(itinerary);
        return client.createCfarContractExercise(sessionId, createCfarContractExerciseRequest);
    }
}
