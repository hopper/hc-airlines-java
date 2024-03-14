package example;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class CommonExample {
    protected static HopperClient client = new HopperClient("", "", "", "", "", "", true);
    // Testing locally
    // protected static HopperClient client = new HopperClient("http://localhost:7071/airline/v1.1", "7lrxWCn9ZJOvhpeK03XzDXOsmrtWodIy", "0gPGKrQeckjgElCRwlMLSvl9Nfzc_K_5ZNnVWpKuNZ8r3U0NiKSgBLC70D1QrzGP", "", "", "", true);
    protected static String flightDate = "2024-03-15";

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
        CfarItinerary itinerary = new CfarItinerary();
        itinerary.setCurrency("CAD");
        itinerary.setTotalPrice("100.00");

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

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));

        //-- Ancillaries
        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("10.00");

        itinerary.setAncillaries(Collections.singletonList(ancillary));

        //-- Passenger Pricings
        PassengerPricing passengerPricing = new PassengerPricing();
        passengerPricing.setIndividualPrice("30.00");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.count(3);
        passengerCount.setType(PassengerType.ADULT);
        passengerPricing.setPassengerCount(passengerCount);
        itinerary.setPassengerPricing(Collections.singletonList(passengerPricing));

        // Second itinerary
        CfarItinerary itinerary1 = new CfarItinerary();
        itinerary1.setCurrency("CAD");
        itinerary1.setTotalPrice("120.00");

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

        itinerary1.setSlices(Collections.singletonList(cfarItinerarySlice1));

        //-- Ancillaries
        Ancillary ancillary1 = new Ancillary();
        ancillary1.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary1.setTotalPrice("30.00");
        itinerary1.setAncillaries(Collections.singletonList(ancillary1));

        //-- Passenger Pricings
        PassengerPricing passengerPricing1 = new PassengerPricing();
        passengerPricing1.setIndividualPrice("30.00");
        PassengerCount passengerCount1 = new PassengerCount();
        passengerCount1.count(3);
        passengerCount1.setType(PassengerType.ADULT);
        passengerPricing1.setPassengerCount(passengerCount1);

        itinerary1.setPassengerPricing(Collections.singletonList(passengerPricing1));

        List<CfarItinerary> itineraries = new ArrayList<>();
        itineraries.add(itinerary);
        itineraries.add(itinerary1);
        createCfarOfferRequest.setItinerary(itineraries);

        return createCfarOfferRequest;
    }

    protected static List<CfarOffer> createCfarOffers(HopperClient client, String sessionId) throws ApiException {
        return client.createOffers(sessionId, prepareCreateCfarOfferRequest());
    }

    protected static List<CfarOffer> initPurchaseElements(HopperClient client) throws ApiException {
        return client.initPurchase(prepareCreateAirlineSessionRequest(FlowType.PURCHASE), prepareCreateCfarOfferRequest());
    }
}
