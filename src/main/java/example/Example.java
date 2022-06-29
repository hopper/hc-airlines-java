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
            HopperClient client = new HopperClient("http://localhost:7071/airline/v1.0", "7lrxWCn9ZJOvhpeK03XzDXOsmrtWodIy", "IOLPDXhl6F9nmTb4l9nnmdzIy0_ZRBK0YP4R3WeFpq-uNIWPB3ahLaySMInYlwVc",false);

            AirlineSession session = getAirlineSession(client);
            String sessionId = session.getId();

            List<CfarOffer> offers = createCfarOffers(client, sessionId);
            CfarContract contract = createCfarContract(client, offers, sessionId);
            String contractId = contract.getId();

            CfarContract updatedContract =  updateCfarContract(client, contractId,sessionId);
            CfarContractExercise exercise = creatCfarContractExercise(client, contractId, sessionId);
            CfarContractExercise completeCfarContractExercise = completeCfarContractExercise(client, exercise.getId(), sessionId);
            CfarContract getContract = client.getContract(contractId,sessionId);

            System.out.println("*********************************************************************");
            System.out.println("*************************** SESSION *********************************");
            System.out.println("*********************************************************************");
            System.out.println(session);
            System.out.println("*********************************************************************");
            System.out.println("*************************** OFFERS *********************************");
            System.out.println("*********************************************************************");
            System.out.println(offers);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CONTRACT *********************************");
            System.out.println("*********************************************************************");
            System.out.println(contract);
            System.out.println("*********************************************************************");
            System.out.println("*************************** EXERCISE *********************************");
            System.out.println("*********************************************************************");
            System.out.println(exercise);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CONTRACT *********************************");
            System.out.println("*********************************************************************");
            System.out.println(updatedContract);
            System.out.println("*********************************************************************");
            System.out.println("*************************** COMPLETED EXERCISE *********************************");
            System.out.println("*********************************************************************");
            System.out.println(completeCfarContractExercise);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CONTRACT *********************************");
            System.out.println("*********************************************************************");
            System.out.println(getContract);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static CfarContractExercise completeCfarContractExercise(HopperClient client, String contractId, String sessionId) throws ApiException {
        MarkCfarContractExerciseCompleteRequest markCfarContractExerciseCompleteRequest = new MarkCfarContractExerciseCompleteRequest();
        markCfarContractExerciseCompleteRequest.setExerciseCompletedDateTime(LocalDateTime.now().atOffset(ZoneOffset.UTC));
        markCfarContractExerciseCompleteRequest.setAirlineRefundAllowance("146.64");
        markCfarContractExerciseCompleteRequest.setAirlineRefundMethod(AirlineRefundMethod.CASH);
        markCfarContractExerciseCompleteRequest.setHopperRefund("146.64");
        markCfarContractExerciseCompleteRequest.setHopperRefundMethod(AirlineRefundMethod.CASH);
        return client.completeCfarContractExercise(markCfarContractExerciseCompleteRequest,contractId,sessionId);
    }

    private static CfarContractExercise creatCfarContractExercise(HopperClient client, String contractId, String sessionId) throws ApiException {
        CreateCfarContractExerciseRequest createCfarContractExerciseRequest = new CreateCfarContractExerciseRequest();
        createCfarContractExerciseRequest.setContractId(contractId);
        createCfarContractExerciseRequest.setCurrency("CAD");
        createCfarContractExerciseRequest.setPnrReference("ABC123");
        Map<String, String> params = new HashMap<>();
        params.put("property1", "test1");
        params.put("property2", "test2");
        createCfarContractExerciseRequest.setExtAttributes(params);
        createCfarContractExerciseRequest.setExerciseInitiatedDateTime(LocalDateTime.now().atOffset(ZoneOffset.UTC));
        createCfarContractExerciseRequest.setAirlineRefundAllowance("146.64");
        createCfarContractExerciseRequest.setAirlineRefundMethod(AirlineRefundMethod.CASH);

        CfarItinerary itinerary = new CfarItinerary();
        itinerary.setCurrency("CAD");
        itinerary.setTotalPrice("183.30");

        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("30.55");

        CfarItinerarySlice cfarItinerarySlice = new CfarItinerarySlice();
        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime("2022-06-30T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime("2022-06-30T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("JB776");
        cfarItinerarySliceSegment.setFareClass(FareClass.BASIC_ECONOMY);
        cfarItinerarySliceSegment.setValidatingCarrierCode("B6");

        CfarItinerarySliceSegment cfarItinerarySliceSegment2 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment2.setArrivalDateTime("2022-06-30T19:12:30");
        cfarItinerarySliceSegment2.setDepartureDateTime("2022-06-30T18:12:30");
        cfarItinerarySliceSegment2.setOriginAirport("LGA");
        cfarItinerarySliceSegment2.setDestinationAirport("BOS");
        cfarItinerarySliceSegment2.setFlightNumber("JB777");
        cfarItinerarySliceSegment2.setFareClass(FareClass.BASIC_ECONOMY);
        cfarItinerarySliceSegment2.setValidatingCarrierCode("B6");

        List<CfarItinerarySliceSegment> segments = new ArrayList<>();
        segments.add(cfarItinerarySliceSegment);
        segments.add(cfarItinerarySliceSegment2);
        cfarItinerarySlice.setSegments(segments);

        PassengerPricing passengerPricing =new PassengerPricing();
        passengerPricing.setIndividualPrice("61.10");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.count(3);
        passengerCount.setType(PassengerType.ADULT);
        passengerPricing.setPassengerCount(passengerCount);

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));
        itinerary.setAncillaries(Collections.singletonList(ancillary));
        itinerary.setPassengerPricing(Collections.singletonList(passengerPricing));

        createCfarContractExerciseRequest.setItinerary(itinerary);
        return client.creatCfarContractExercise(createCfarContractExerciseRequest,sessionId);
    }

    private static CfarContract createCfarContract(HopperClient client, List<CfarOffer> offers, String sessionId) throws ApiException {

        CreateCfarContractRequest contractRequest = new CreateCfarContractRequest();
        Map<String, String> params = new HashMap<>();
        params.put("property1", "test1");
        params.put("property2", "test2");

        contractRequest.setOfferIds(offers.stream().map(CfarOffer::getId).collect(Collectors.toList()));
        contractRequest.setExtAttributes(params);
        contractRequest.setPnrReference("ABC123");

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setType(PaymentMethodType.OFFLINE_RECONCILIATION);

        CfarItinerary itinerary = new CfarItinerary();
        itinerary.setCurrency("CAD");
        itinerary.setTotalPrice("183.30");

        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("30.55");

        CfarItinerarySlice cfarItinerarySlice = new CfarItinerarySlice();
        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime("2022-06-30T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime("2022-06-30T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("JB776");
        cfarItinerarySliceSegment.setFareClass(FareClass.BASIC_ECONOMY);
        cfarItinerarySliceSegment.setValidatingCarrierCode("B6");

        CfarItinerarySliceSegment cfarItinerarySliceSegment2 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment2.setArrivalDateTime("2022-06-30T19:12:30");
        cfarItinerarySliceSegment2.setDepartureDateTime("2022-06-30T18:12:30");
        cfarItinerarySliceSegment2.setOriginAirport("LGA");
        cfarItinerarySliceSegment2.setDestinationAirport("BOS");
        cfarItinerarySliceSegment2.setFlightNumber("JB777");
        cfarItinerarySliceSegment2.setFareClass(FareClass.BASIC_ECONOMY);
        cfarItinerarySliceSegment2.setValidatingCarrierCode("B6");

        List<CfarItinerarySliceSegment> segments = new ArrayList<>();
        segments.add(cfarItinerarySliceSegment);
        segments.add(cfarItinerarySliceSegment2);
        cfarItinerarySlice.setSegments(segments);

        PassengerPricing passengerPricing =new PassengerPricing();
        passengerPricing.setIndividualPrice("61.10");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.count(3);
        passengerCount.setType(PassengerType.ADULT);
        passengerPricing.setPassengerCount(passengerCount);

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));
        itinerary.setAncillaries(Collections.singletonList(ancillary));
        itinerary.setPassengerPricing(Collections.singletonList(passengerPricing));

        contractRequest.setItinerary(itinerary);
        return client.createCfarContract(contractRequest, sessionId);
    }

    private static List<CfarOffer> createCfarOffers(HopperClient client, String sessionId) throws ApiException {
        CreateCfarOfferRequest createCfarOfferRequest = new CreateCfarOfferRequest();
        createCfarOfferRequest.setPartnerId("23459807-1a9a-4227-a7aa-226e3c5552d1");
        createCfarOfferRequest.setRequestType(RequestType.FARE);
        createCfarOfferRequest.setBookingDateTime(LocalDateTime.now().atOffset(ZoneOffset.UTC));

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
        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime("2022-06-30T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime("2022-06-30T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("JB776");
        cfarItinerarySliceSegment.setFareClass(FareClass.BASIC_ECONOMY);
        cfarItinerarySliceSegment.setValidatingCarrierCode("B6");
        cfarItinerarySlice.setSegments(Collections.singletonList(cfarItinerarySliceSegment));

        PassengerPricing passengerPricing =new PassengerPricing();
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
        CfarItinerarySliceSegment cfarItinerarySliceSegment1 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment1.setArrivalDateTime("2022-06-30T19:12:30");
        cfarItinerarySliceSegment1.setDepartureDateTime("2022-06-30T18:12:30");
        cfarItinerarySliceSegment1.setOriginAirport("LGA");
        cfarItinerarySliceSegment1.setDestinationAirport("BOS");
        cfarItinerarySliceSegment1.setFlightNumber("JB777");
        cfarItinerarySliceSegment1.setFareClass(FareClass.BASIC_ECONOMY);
        cfarItinerarySliceSegment1.setValidatingCarrierCode("B6");
        cfarItinerarySlice1.setSegments(Collections.singletonList(cfarItinerarySliceSegment1));

        PassengerPricing passengerPricing1 =new PassengerPricing();
        PassengerCount passengerCount1 = new PassengerCount();
        passengerCount1.count(3);
        passengerCount1.setType(PassengerType.ADULT);
        passengerPricing1.setPassengerCount(passengerCount1);

        itinerary1.setSlices(Collections.singletonList(cfarItinerarySlice1));
        itinerary1.setAncillaries(Collections.singletonList(ancillary1));
        itinerary1.setPassengerPricing(Collections.singletonList(passengerPricing1));

        List<CfarItinerary> itineraries  = new ArrayList<>();
        itineraries.add(itinerary);
        itineraries.add(itinerary1);
        createCfarOfferRequest.setItinerary(itineraries);

        return client.createOffers(createCfarOfferRequest, sessionId);
    }

    private static CfarContract updateCfarContract(HopperClient client, String contractId, String sessionId) throws ApiException {
        UpdateCfarContractRequest updateCfarContractRequest = new UpdateCfarContractRequest();
        updateCfarContractRequest.setEmailAddress("test@test.com");
        updateCfarContractRequest.setStatus(CfarContractStatus.CONFIRMED);
        updateCfarContractRequest.setPnrReference("ABC123");
        return client.updateCfarContractStatus(contractId, updateCfarContractRequest, sessionId);
    }

    private static AirlineSession getAirlineSession(HopperClient client) throws ApiException {
        CreateAirlineSessionRequest sessionRequest = new CreateAirlineSessionRequest();
        sessionRequest.setLanguage("EN");
        sessionRequest.setPointOfSale("FR");

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
        sessionRequest.setDevice(device);
        sessionRequest.setUserInfo(userInfo);

        return client.createSession(sessionRequest);
    }
}