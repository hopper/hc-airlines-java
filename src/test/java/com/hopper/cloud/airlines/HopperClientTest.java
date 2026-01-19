package com.hopper.cloud.airlines;

import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;
import com.hopper.cloud.airlines.api.SessionsApi;
import com.hopper.cloud.airlines.model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Tests for createSessionOffersAndContracts with multiple offers for a single itinerary.
 */
public class HopperClientTest {

    private HopperClient hopperClient;

    @Mock
    private CancelForAnyReasonCfarApi cfarApi;

    @Mock
    private SessionsApi sessionsApi;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        hopperClient = new HopperClient("https://test.hopper.com", "test-client", "test-secret", false);

        // Inject mocks into HopperClient using reflection
        Field cfarApiField = HopperClient.class.getDeclaredField("cfarApi");
        cfarApiField.setAccessible(true);
        cfarApiField.set(hopperClient, cfarApi);

        Field sessionsApiField = HopperClient.class.getDeclaredField("sessionsApi");
        sessionsApiField.setAccessible(true);
        sessionsApiField.set(hopperClient, sessionsApi);
    }

    /**
     * Test createSessionOffersAndContracts with a single itinerary that returns multiple offers.
     * Verifies the method handles multiple offers (80% and 100% coverage) correctly.
     */
    @Test
    public void testCreateSessionOffersAndContracts_MultipleOffersForSingleItinerary() throws ApiException {
        // Setup mocks
        AirlineSession mockSession = createMockSession();
        when(sessionsApi.postSessions(any())).thenReturn(mockSession);

        List<CfarOffer> mockOffers = createMockOffers();
        when(cfarApi.postCfarOffers(any(), anyString())).thenReturn(mockOffers);

        CfarContract mockContract = createMockContract();
        when(cfarApi.postCfarContracts(any())).thenReturn(mockContract);

        // Execute
        CreateSessionOffersContractsResponse response = hopperClient.createSessionOffersAndContracts(
            createSessionRequest(),
            createSingleItineraryOfferRequest()
        );

        // Verify
        assertNotNull(response);
        assertNotNull(response.getAirlineSession());
        assertEquals("test-session-id", response.getAirlineSession().getId());
        assertNotNull(response.getOffers());
        assertEquals(2, response.getOffers().size());
        assertNotNull(response.getContracts());
        assertEquals(2, response.getContracts().size());
    }

    /**
     * Test createSessionOffersAndContracts with a round-trip itinerary that returns multiple offers.
     */
    @Test
    public void testCreateSessionOffersAndContracts_MultipleOffersForRoundTrip() throws ApiException {
        // Setup mocks
        AirlineSession mockSession = createMockSession();
        when(sessionsApi.postSessions(any())).thenReturn(mockSession);

        List<CfarOffer> mockOffers = createMockOffers();
        when(cfarApi.postCfarOffers(any(), anyString())).thenReturn(mockOffers);

        CfarContract mockContract = createMockContract();
        when(cfarApi.postCfarContracts(any())).thenReturn(mockContract);

        // Execute
        CreateSessionOffersContractsResponse response = hopperClient.createSessionOffersAndContracts(
            createSessionRequest(),
            createRoundTripOfferRequest()
        );

        // Verify
        assertNotNull(response);
        assertNotNull(response.getAirlineSession());
        assertEquals("test-session-id", response.getAirlineSession().getId());
        assertNotNull(response.getOffers());
        assertEquals(2, response.getOffers().size());
        assertNotNull(response.getContracts());
        assertEquals(2, response.getContracts().size());
    }

    private CreateAirlineSessionRequest createSessionRequest() {
        CreateAirlineSessionRequest request = new CreateAirlineSessionRequest();
        request.setFlowType(FlowType.PURCHASE);
        request.setLanguage("EN");
        request.setPointOfSale("SG");
        return request;
    }

    private CreateCfarOfferRequest createSingleItineraryOfferRequest() {
        CreateCfarOfferRequest request = new CreateCfarOfferRequest();
        request.setRequestType(RequestType.ANCILLARY);

        CfarOfferItinerary itinerary = new CfarOfferItinerary();
        itinerary.setCurrency("SGD");
        itinerary.setTotalPrice("145.4");

        CfarItinerarySlice slice = new CfarItinerarySlice();
        CfarItinerarySliceSegment segment = new CfarItinerarySliceSegment();
        segment.setOriginAirport("SIN");
        segment.setDestinationAirport("KUL");
        segment.setDepartureDateTime("2026-02-05T14:10:00");
        segment.setArrivalDateTime("2026-02-05T15:20:00");
        segment.setFlightNumber("AK710");
        segment.setValidatingCarrierCode("AK");
        segment.setFareClass(FareClass.ECONOMY);

        slice.setSegments(Collections.singletonList(segment));
        itinerary.setSlices(Collections.singletonList(slice));

        PassengerPricing pricing = new PassengerPricing();
        pricing.setIndividualPrice("72.7");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.setCount(2);
        passengerCount.setType(PassengerType.ADULT);
        pricing.setPassengerCount(passengerCount);
        itinerary.setPassengerPricing(Collections.singletonList(pricing));

        itinerary.setPassengers(Arrays.asList(
            createPassenger("pax_adt_0", PassengerType.ADULT),
            createPassenger("pax_adt_1", PassengerType.ADULT)
        ));

        request.setItinerary(Collections.singletonList(itinerary));
        return request;
    }

    private CreateCfarOfferRequest createRoundTripOfferRequest() {
        CreateCfarOfferRequest request = new CreateCfarOfferRequest();
        request.setRequestType(RequestType.ANCILLARY);

        CfarOfferItinerary itinerary = new CfarOfferItinerary();
        itinerary.setCurrency("THB");
        itinerary.setTotalPrice("3173.4");

        CfarItinerarySlice outboundSlice = new CfarItinerarySlice();
        CfarItinerarySliceSegment outboundSegment = new CfarItinerarySliceSegment();
        outboundSegment.setOriginAirport("UTH");
        outboundSegment.setDestinationAirport("DMK");
        outboundSegment.setDepartureDateTime("2026-01-27T12:15:00");
        outboundSegment.setArrivalDateTime("2026-01-27T13:20:00");
        outboundSegment.setFlightNumber("FD3355");
        outboundSegment.setValidatingCarrierCode("FD");
        outboundSegment.setFareClass(FareClass.ECONOMY);
        outboundSlice.setSegments(Collections.singletonList(outboundSegment));

        CfarItinerarySlice returnSlice = new CfarItinerarySlice();
        CfarItinerarySliceSegment returnSegment = new CfarItinerarySliceSegment();
        returnSegment.setOriginAirport("DMK");
        returnSegment.setDestinationAirport("UTH");
        returnSegment.setDepartureDateTime("2026-02-01T18:00:00");
        returnSegment.setArrivalDateTime("2026-02-01T19:10:00");
        returnSegment.setFlightNumber("FD3350");
        returnSegment.setValidatingCarrierCode("FD");
        returnSegment.setFareClass(FareClass.ECONOMY);
        returnSlice.setSegments(Collections.singletonList(returnSegment));

        itinerary.setSlices(Arrays.asList(outboundSlice, returnSlice));

        PassengerPricing pricing = new PassengerPricing();
        pricing.setIndividualPrice("2403");
        PassengerCount passengerCount = new PassengerCount();
        passengerCount.setCount(1);
        passengerCount.setType(PassengerType.ADULT);
        pricing.setPassengerCount(passengerCount);
        itinerary.setPassengerPricing(Collections.singletonList(pricing));

        itinerary.setPassengers(Collections.singletonList(
            createPassenger("pax_adt_0", PassengerType.ADULT)
        ));

        request.setItinerary(Collections.singletonList(itinerary));
        return request;
    }

    private CfarOfferPassenger createPassenger(String reference, PassengerType type) {
        CfarOfferPassenger passenger = new CfarOfferPassenger();
        passenger.setPassengerReference(reference);
        passenger.setPassengerType(type);
        return passenger;
    }

    private AirlineSession createMockSession() {
        AirlineSession session = new AirlineSession();
        session.setId("test-session-id");
        return session;
    }

    private List<CfarOffer> createMockOffers() {
        List<CfarOffer> offers = new ArrayList<>();

        CfarOffer offer80 = new CfarOffer();
        offer80.setId("offer-80-percent");
        offer80.setCoverage("0.80");
        offer80.setPremium("5.00");

        CfarOffer offer100 = new CfarOffer();
        offer100.setId("offer-100-percent");
        offer100.setCoverage("1.00");
        offer100.setPremium("8.00");

        offers.add(offer80);
        offers.add(offer100);
        return offers;
    }

    private CfarContract createMockContract() {
        CfarContract contract = new CfarContract();
        contract.setId("test-contract-id");
        return contract;
    }
}
