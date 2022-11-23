package example;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        try {
            HopperClient client = new HopperClient("", "", "", "", "", "", true);

            AirlineSession session = getAirlineSession(client, FlowType.PURCHASE);
            System.out.println("*********************************************************************");
            System.out.println("*************************** SESSION *********************************");
            System.out.println("*********************************************************************");
            System.out.println(session);

            String sessionId = session.getId();
            List<CfarOffer> offers = createCfarOffers(client, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** OFFERS *********************************");
            System.out.println("*********************************************************************");
            System.out.println(offers);

            List<CfarOffer> selectedOffer = new ArrayList<>();
            selectedOffer.add(offers.get(0));
            selectedOffer.add(offers.get(1));
            CfarContract contract = createCfarContract(client, selectedOffer, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CONTRACT *********************************");
            System.out.println("*********************************************************************");
            System.out.println(contract);

            String contractId = contract.getId();
            CfarContract getContract = client.getContract(sessionId, contractId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CONTRACT *********************************");
            System.out.println("*********************************************************************");
            System.out.println(getContract);

            boolean isSucceeded = processCfarPayment(client, contractId, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** PAYMENT *********************************");
            System.out.println("*********************************************************************");
            System.out.println(isSucceeded);

            session = getAirlineSession(client, FlowType.EXERCISE);
            System.out.println("*********************************************************************");
            System.out.println("*************************** SESSION *********************************");
            System.out.println("*********************************************************************");
            System.out.println(session);

            sessionId = session.getId();
            CfarContractExercise exercise = createCfarContractExercise(client, contractId, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** EXERCISE *********************************");
            System.out.println("*********************************************************************");
            System.out.println(exercise);
        } catch (ApiException e) {
            e.printStackTrace();
        }
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
        createCfarContractExerciseRequest.setAirlineRefundAllowance("146.64");
        createCfarContractExerciseRequest.setAirlineRefundMethod(AirlineRefundMethod.CASH);

        CfarItinerary itinerary = new CfarItinerary();
        itinerary.setCurrency("CAD");
        itinerary.setTotalPrice("183.30");

        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("30.55");

        CfarItinerarySlice cfarItinerarySlice = new CfarItinerarySlice();
        cfarItinerarySlice.setFareBrand("flex");

        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime("2022-12-15T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime("2022-12-15T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("JB776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("B6");

        CfarItinerarySliceSegment cfarItinerarySliceSegment2 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment2.setArrivalDateTime("2022-12-15T19:12:30");
        cfarItinerarySliceSegment2.setDepartureDateTime("2022-12-15T18:12:30");
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
        passengerPricing.setIndividualPrice("61.10");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.count(3);
        passengerCount.setType(PassengerType.ADULT);
        passengerPricing.setPassengerCount(passengerCount);

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));
        itinerary.setAncillaries(Collections.singletonList(ancillary));
        itinerary.setPassengerPricing(Collections.singletonList(passengerPricing));

        createCfarContractExerciseRequest.setItinerary(itinerary);
        return client.createCfarContractExercise(sessionId, createCfarContractExerciseRequest);
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
        itinerary.setTotalPrice("183.30");

        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("30.55");

        CfarItinerarySlice cfarItinerarySlice = new CfarItinerarySlice();
        cfarItinerarySlice.setFareBrand("flex");
        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime("2022-12-15T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime("2022-12-15T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("JB776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("B6");

        CfarItinerarySliceSegment cfarItinerarySliceSegment2 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment2.setArrivalDateTime("2022-12-15T19:12:30");
        cfarItinerarySliceSegment2.setDepartureDateTime("2022-12-15T18:12:30");
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
        passengerPricing.setIndividualPrice("61.10");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.count(3);
        passengerCount.setType(PassengerType.ADULT);
        passengerPricing.setPassengerCount(passengerCount);

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));
        itinerary.setAncillaries(Collections.singletonList(ancillary));
        itinerary.setPassengerPricing(Collections.singletonList(passengerPricing));

        contractRequest.setItinerary(itinerary);
        return client.createCfarContract(sessionId, contractRequest);
    }

    private static List<CfarOffer> createCfarOffers(HopperClient client, String sessionId) throws ApiException {
        CreateCfarOfferRequest createCfarOfferRequest = new CreateCfarOfferRequest();
        createCfarOfferRequest.setRequestType(RequestType.FARE);

        Map<String, String> params = new HashMap<>();
        params.put("property1", "test1");
        params.put("property2", "test2");
        createCfarOfferRequest.setExtAttributes(params);

        CfarItinerary itinerary = new CfarItinerary();
        itinerary.setCurrency("CAD");
        itinerary.setTotalPrice("91.65");

        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("30.55");

        CfarItinerarySlice cfarItinerarySlice = new CfarItinerarySlice();
        cfarItinerarySlice.setFareBrand("basic");
        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime("2022-12-15T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime("2022-12-15T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("JB776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("B6");
        cfarItinerarySlice.setSegments(Collections.singletonList(cfarItinerarySliceSegment));

        PassengerPricing passengerPricing = new PassengerPricing();
        passengerPricing.setIndividualPrice("30.55");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.count(3);
        passengerCount.setType(PassengerType.ADULT);
        passengerPricing.setPassengerCount(passengerCount);

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));
        itinerary.setAncillaries(Collections.singletonList(ancillary));
        itinerary.setPassengerPricing(Collections.singletonList(passengerPricing));

        CfarItinerary itinerary1 = new CfarItinerary();
        itinerary1.setCurrency("CAD");
        itinerary1.setTotalPrice("91.65");

        Ancillary ancillary1 = new Ancillary();
        ancillary1.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary1.setTotalPrice("30.55");

        CfarItinerarySlice cfarItinerarySlice1 = new CfarItinerarySlice();
        cfarItinerarySlice1.setFareBrand("flex");
        CfarItinerarySliceSegment cfarItinerarySliceSegment1 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment1.setArrivalDateTime("2022-12-15T19:12:30");
        cfarItinerarySliceSegment1.setDepartureDateTime("2022-12-15T18:12:30");
        cfarItinerarySliceSegment1.setOriginAirport("LGA");
        cfarItinerarySliceSegment1.setDestinationAirport("BOS");
        cfarItinerarySliceSegment1.setFlightNumber("JB777");
        cfarItinerarySliceSegment1.setFareClass(FareClass.BUSINESS);
        cfarItinerarySliceSegment1.setFareBrand("flex");
        cfarItinerarySliceSegment1.setValidatingCarrierCode("B6");
        cfarItinerarySlice1.setSegments(Collections.singletonList(cfarItinerarySliceSegment1));

        PassengerPricing passengerPricing1 = new PassengerPricing();
        passengerPricing1.setIndividualPrice("30.55");
        PassengerCount passengerCount1 = new PassengerCount();
        passengerCount1.count(3);
        passengerCount1.setType(PassengerType.ADULT);
        passengerPricing1.setPassengerCount(passengerCount1);

        itinerary1.setSlices(Collections.singletonList(cfarItinerarySlice1));
        itinerary1.setAncillaries(Collections.singletonList(ancillary1));
        itinerary1.setPassengerPricing(Collections.singletonList(passengerPricing1));

        List<CfarItinerary> itineraries = new ArrayList<>();
        itineraries.add(itinerary);
        itineraries.add(itinerary1);
        createCfarOfferRequest.setItinerary(itineraries);

        return client.createOffers(sessionId, createCfarOfferRequest);
    }

    private static CfarContract updateCfarContract(HopperClient client, String contractId, String sessionId) throws ApiException {
        UpdateCfarContractRequest updateCfarContractRequest = new UpdateCfarContractRequest();
        updateCfarContractRequest.setEmailAddress("test@test.com");
        updateCfarContractRequest.setStatus(CfarContractStatus.CONFIRMED);
        updateCfarContractRequest.setPnrReference("ABC123");
        return client.updateCfarContractStatus(sessionId, contractId, updateCfarContractRequest);
    }

    private static AirlineSession getAirlineSession(HopperClient client, FlowType flowType) throws ApiException {
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

        return client.createSession(sessionRequest);
    }
}