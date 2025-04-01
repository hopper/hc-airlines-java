package example;

import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.api.AnalyticsApi;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;
import com.hopper.cloud.airlines.api.SessionsApi;
import com.hopper.cloud.airlines.model.AirlineRefundMethod;
import com.hopper.cloud.airlines.model.AirlineSession;
import com.hopper.cloud.airlines.model.Ancillary;
import com.hopper.cloud.airlines.model.AncillaryType;
import com.hopper.cloud.airlines.model.BookingConfirmed;
import com.hopper.cloud.airlines.model.Browser;
import com.hopper.cloud.airlines.model.CfarContract;
import com.hopper.cloud.airlines.model.CfarContractExercise;
import com.hopper.cloud.airlines.model.CfarCreateExerciseItinerary;
import com.hopper.cloud.airlines.model.CfarCreateExerciseItinerarySlice;
import com.hopper.cloud.airlines.model.CfarCreateExercisePassengerPricing;
import com.hopper.cloud.airlines.model.CfarCreateExerciseSliceSegment;
import com.hopper.cloud.airlines.model.CfarItinerary;
import com.hopper.cloud.airlines.model.CfarItinerarySlice;
import com.hopper.cloud.airlines.model.CfarItinerarySliceSegment;
import com.hopper.cloud.airlines.model.CfarOffer;
import com.hopper.cloud.airlines.model.CfarOfferItinerary;
import com.hopper.cloud.airlines.model.CfarOfferPassenger;
import com.hopper.cloud.airlines.model.CfarPassengerTax;
import com.hopper.cloud.airlines.model.CfarStatus;
import com.hopper.cloud.airlines.model.Chrome;
import com.hopper.cloud.airlines.model.CreateAirlineSessionRequest;
import com.hopper.cloud.airlines.model.CreateCfarContractExerciseRequest;
import com.hopper.cloud.airlines.model.CreateCfarContractRequest;
import com.hopper.cloud.airlines.model.CreateCfarOfferRequest;
import com.hopper.cloud.airlines.model.Desktop;
import com.hopper.cloud.airlines.model.Device;
import com.hopper.cloud.airlines.model.Event;
import com.hopper.cloud.airlines.model.FareClass;
import com.hopper.cloud.airlines.model.FlowType;
import com.hopper.cloud.airlines.model.MacOs;
import com.hopper.cloud.airlines.model.MarkCfarContractExerciseCompleteRequest;
import com.hopper.cloud.airlines.model.OperatingSystem;
import com.hopper.cloud.airlines.model.PassengerCount;
import com.hopper.cloud.airlines.model.PassengerPricing;
import com.hopper.cloud.airlines.model.PassengerType;
import com.hopper.cloud.airlines.model.Platform;
import com.hopper.cloud.airlines.model.RequestType;
import com.hopper.cloud.airlines.model.UpdateCfarContractRequest;
import com.hopper.cloud.airlines.model.UserInfo;
import com.hopper.cloud.airlines.model.Web;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

public class CommonExample {
    protected static String flightDate = LocalDate.now().plusMonths(2).toString();

    static ApiClient configureApiClient() {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        apiClient.setBasePath("https://airlines-api.staging.hopper.com/airline/v1.1");
        String bearerToken = System.getenv("CLOUD_AIRLINES_JAVA_SDK_BEARER_TOKEN");
        if (bearerToken == null || bearerToken.isEmpty()) {
            throw new IllegalArgumentException("BEARER_TOKEN environment variable is not set");
        }
        apiClient.setBearerToken(bearerToken);
        return apiClient;
    }

    private static CreateAirlineSessionRequest prepareCreateAirlineSessionRequest(FlowType flowType) {
        CreateAirlineSessionRequest sessionRequest = new CreateAirlineSessionRequest();
        sessionRequest.setFlowType(flowType);
        sessionRequest.setLanguage("EN");
        sessionRequest.setPointOfSale("US");

        UserInfo userInfo = new UserInfo();
        userInfo.setAirlineUserId("airline-test-1");
        userInfo.setCreatedDateTime(LocalDateTime.now().atOffset(ZoneOffset.UTC));
        userInfo.setPreviousBookings(1);

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

    protected static AirlineSession getAirlineSession(SessionsApi client, FlowType flowType) throws ApiException {
        CreateAirlineSessionRequest sessionRequest = prepareCreateAirlineSessionRequest(flowType);
        System.out.println(sessionRequest.toJson());
        return client.postSessions(sessionRequest);
    }

    protected static void createBookingConfirmedEvent(AnalyticsApi client, String sessionId) throws ApiException {
        BookingConfirmed bookingConfirmed = new BookingConfirmed();
        bookingConfirmed.setType("booking_confirmed");
        bookingConfirmed.setOccurredDateTime(LocalDateTime.now().atOffset(ZoneOffset.UTC));
        Event event = new Event();
        event.setActualInstance(bookingConfirmed);
        client.postEvents(sessionId, event);
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
        itinerary1.setFareRules(null);

        // -- Slices
        CfarItinerarySlice cfarItinerarySlice = new CfarItinerarySlice();
        cfarItinerarySlice.setFareBrand("basic");
        cfarItinerarySlice.setPassengerPricing(null);
        cfarItinerarySlice.setFareRules(null);
        cfarItinerarySlice.setOtherFares(null);

        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("JB");
        cfarItinerarySlice.addSegmentsItem(cfarItinerarySliceSegment);

        itinerary1.addSlicesItem(cfarItinerarySlice);

        // -- Ancillaries
        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("10.00");

        itinerary1.addAncillariesItem(ancillary);

        // -- Passenger Pricings
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

        passengerPricing.addTaxesItem(cfarPassengerTax);

        itinerary1.addPassengerPricingItem(passengerPricing);

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
        itinerary2.setFareRules(null);

        // -- Slices
        CfarItinerarySlice cfarItinerarySlice1 = new CfarItinerarySlice();
        cfarItinerarySlice1.setFareBrand("flex");
        cfarItinerarySlice1.setPassengerPricing(null);
        cfarItinerarySlice1.setFareRules(null);
        cfarItinerarySlice1.setOtherFares(null);

        CfarItinerarySliceSegment cfarItinerarySliceSegment1 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment1.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment1.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment1.setOriginAirport("LGA");
        cfarItinerarySliceSegment1.setDestinationAirport("BOS");
        cfarItinerarySliceSegment1.setFlightNumber("777");
        cfarItinerarySliceSegment1.setFareClass(FareClass.BUSINESS);
        cfarItinerarySliceSegment1.setFareBrand("flex");
        cfarItinerarySliceSegment1.setValidatingCarrierCode("JB");
        cfarItinerarySlice1.setSegments(Collections.singletonList(cfarItinerarySliceSegment1));

        itinerary2.setSlices(Collections.singletonList(cfarItinerarySlice1));

        // -- Ancillaries
        Ancillary ancillary1 = new Ancillary();
        ancillary1.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary1.setTotalPrice("30.00");
        itinerary2.setAncillaries(Collections.singletonList(ancillary1));

        // -- Passenger Pricings
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

    protected static List<CfarOffer> createCfarOffers(CancelForAnyReasonCfarApi client, String sessionId)
            throws ApiException {
        CreateCfarOfferRequest cfarOfferReq = prepareCreateCfarOfferRequest();
        System.out.println(
                cfarOfferReq.toJson()
        );
        return client.postCfarOffers(cfarOfferReq, sessionId);
    }

    protected static CfarContract createCfarContract(CancelForAnyReasonCfarApi client, List<CfarOffer> offers,
                                                     String sessionId)
            throws ApiException {
        CreateCfarContractRequest contractRequest = new CreateCfarContractRequest();
        Map<String, String> params = new HashMap<>();
        params.put("property1", "test1");
        params.put("property2", "test2");

        contractRequest.setOfferIds(offers.stream().map(CfarOffer::getId).collect(Collectors.toList()));
        contractRequest.setExtAttributes(params);

        CfarItinerary itinerary = new CfarItinerary();
        itinerary.setCurrency("USD");
        itinerary.setTotalPrice("190.00");
        itinerary.setFareRules(null);


        // -- Slices
        CfarItinerarySlice cfarItinerarySlice = new CfarItinerarySlice();
        cfarItinerarySlice.setFareBrand("flex");
        cfarItinerarySlice.setFareRules(null);
        cfarItinerarySlice.setPassengerPricing(null);
        cfarItinerarySlice.setOtherFares(null);

        CfarItinerarySliceSegment cfarItinerarySliceSegment = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("JB");

        CfarItinerarySliceSegment cfarItinerarySliceSegment2 = new CfarItinerarySliceSegment();
        cfarItinerarySliceSegment2.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment2.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment2.setOriginAirport("LGA");
        cfarItinerarySliceSegment2.setDestinationAirport("BOS");
        cfarItinerarySliceSegment2.setFlightNumber("777");
        cfarItinerarySliceSegment2.setFareClass(FareClass.BUSINESS);
        cfarItinerarySliceSegment2.setFareBrand("flex");
        cfarItinerarySliceSegment2.setValidatingCarrierCode("JB");

        List<CfarItinerarySliceSegment> segments = new ArrayList<>();
        segments.add(cfarItinerarySliceSegment);
        segments.add(cfarItinerarySliceSegment2);
        cfarItinerarySlice.setSegments(segments);

        itinerary.setSlices(Collections.singletonList(cfarItinerarySlice));

        // -- Ancillaries
        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("10.00");

        itinerary.setAncillaries(Collections.singletonList(ancillary));

        // -- Passenger Pricings
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
        System.out.println(contractRequest.toJson());
        return client.postCfarContracts(contractRequest);
    }

    protected static List<CfarOffer> createSessionOffersAndContracts(
            CancelForAnyReasonCfarApi client, String sessionId)
            throws ApiException {
        return client.postCfarOffers(
                prepareCreateCfarOfferRequest(), sessionId);
    }

    protected static CfarContract updateCfarContract(CancelForAnyReasonCfarApi client, String contractReference,
                                                     String sessionId)
            throws ApiException {
        UpdateCfarContractRequest updateCfarContractRequest = new UpdateCfarContractRequest();
        updateCfarContractRequest.setEmailAddress("test@test.com");
        updateCfarContractRequest.setStatus(CfarStatus.CONFIRMED);
        updateCfarContractRequest.setPnrReference("ABC123");
        updateCfarContractRequest.setCurrency("EUR");
        updateCfarContractRequest.setExchangeRate("0.90");
        updateCfarContractRequest.setFormsOfPayment(null);

        System.out.print(updateCfarContractRequest.toJson());
        return client.putCfarContractsIdUpdateStatus(contractReference, updateCfarContractRequest, sessionId);
    }

    protected static CfarContractExercise completeCfarContractExercise(CancelForAnyReasonCfarApi client,
                                                                       String exerciseId,
                                                                       String sessionId) throws ApiException {
        MarkCfarContractExerciseCompleteRequest markCfarContractExerciseCompleteRequest = new MarkCfarContractExerciseCompleteRequest();
        markCfarContractExerciseCompleteRequest.setRefundMethod(AirlineRefundMethod.CASH);
        markCfarContractExerciseCompleteRequest.setRefundAmount("80.00");
        return client.putCfarContractExercisesIdMarkCompleted(exerciseId, markCfarContractExerciseCompleteRequest,
                sessionId);
    }

    protected static CfarContractExercise createCfarContractExercise(CancelForAnyReasonCfarApi client,
                                                                     String contractId,
                                                                     String sessionId) throws ApiException, MalformedURLException {
        CreateCfarContractExerciseRequest createCfarContractExerciseRequest = new CreateCfarContractExerciseRequest();
        createCfarContractExerciseRequest.setContractId(contractId);
        createCfarContractExerciseRequest.setCallbackUrl(
                "https://www.volaris.com/callback?id=1234456790&session=1A530637289A03B07199A44E8D531427");
        createCfarContractExerciseRequest.setRedirectbackUrl(
                "https://www.volaris.com/mmb?pnr=ABC123&session=1A530637289A03B07199A44E8D5");
        createCfarContractExerciseRequest.setCurrency("USD");
        createCfarContractExerciseRequest.setPnrReference("ABC123");
        Map<String, String> params = new HashMap<>();
        params.put("property1", "test1");
        params.put("property2", "test2");
        createCfarContractExerciseRequest.setExtAttributes(params);
        createCfarContractExerciseRequest.setAirlineRefundPenalty("146.64");
        createCfarContractExerciseRequest.setAirlineRefundMethod(AirlineRefundMethod.CASH);

        CfarCreateExerciseItinerary itinerary = new CfarCreateExerciseItinerary();
        itinerary.setCurrency("USD");
        itinerary.setTotalPrice("190.00");
        itinerary.setFareRules(null);

        Ancillary ancillary = new Ancillary();
        ancillary.setType(AncillaryType.TRAVEL_INSURANCE);
        ancillary.setTotalPrice("10.00");

        CfarCreateExerciseItinerarySlice cfarItinerarySlice = new CfarCreateExerciseItinerarySlice();
        cfarItinerarySlice.setFareBrand("flex");
        cfarItinerarySlice.setFareRules(null);
        cfarItinerarySlice.setOtherFares(null);
        cfarItinerarySlice.setPassengerPricing(null);

        CfarCreateExerciseSliceSegment cfarItinerarySliceSegment = new CfarCreateExerciseSliceSegment();
        cfarItinerarySliceSegment.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment.setOriginAirport("LGA");
        cfarItinerarySliceSegment.setDestinationAirport("BOS");
        cfarItinerarySliceSegment.setFlightNumber("776");
        cfarItinerarySliceSegment.setFareClass(FareClass.ECONOMY);
        cfarItinerarySliceSegment.setFareBrand("basic");
        cfarItinerarySliceSegment.setValidatingCarrierCode("JB");

        CfarCreateExerciseSliceSegment cfarItinerarySliceSegment2 = new CfarCreateExerciseSliceSegment();
        cfarItinerarySliceSegment2.setArrivalDateTime(flightDate + "T19:12:30");
        cfarItinerarySliceSegment2.setDepartureDateTime(flightDate + "T18:12:30");
        cfarItinerarySliceSegment2.setOriginAirport("LGA");
        cfarItinerarySliceSegment2.setDestinationAirport("BOS");
        cfarItinerarySliceSegment2.setFlightNumber("777");
        cfarItinerarySliceSegment2.setFareClass(FareClass.BUSINESS);
        cfarItinerarySliceSegment2.setFareBrand("flex");
        cfarItinerarySliceSegment2.setValidatingCarrierCode("JB");

        List<CfarCreateExerciseSliceSegment> segments = new ArrayList<>();
        segments.add(cfarItinerarySliceSegment);
        segments.add(cfarItinerarySliceSegment2);
        cfarItinerarySlice.setSegments(segments);

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
        return client.postCfarContractExercises(createCfarContractExerciseRequest, sessionId);
    }
}
