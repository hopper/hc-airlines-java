package example.hopperclient;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.Pair;
import com.hopper.cloud.airlines.Tuple2;
import com.hopper.cloud.airlines.model.*;
import org.apache.http.nio.reactor.SessionRequest;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class DgExample extends CommonExample {
    public static void main(String[] args) {
        String flightDate = LocalDate.now().plusMonths(2).toString();
        try {
            HopperClient client = new HopperClient("", "", "", "", "", "", "", "", 3000, true);


            CreateDgOffersRequest offersRequest = new CreateDgOffersRequest();
            offersRequest.setRequestType(DgRequestType.ANCILLARY);
            offersRequest.setEntryPoint("booking_page");

            // Itinerary
            DgItinerary itinerary = new DgItinerary();
            offersRequest.setItinerary(Collections.singletonList(itinerary));
            itinerary.setCurrency("USD");


            // Passengers Pricing
            DgPassengerPricing passengerPricingAdult = new DgPassengerPricing();
            passengerPricingAdult.setIndividualPrice("64.23");
            PassengerCount passengerCountAdult = new PassengerCount();
            passengerCountAdult.count(1);
            passengerCountAdult.setType(PassengerType.ADULT);
            passengerPricingAdult.setPassengerCount(passengerCountAdult);

            DgPassengerPricing passengerPricingChild = new DgPassengerPricing();
            passengerPricingChild.setIndividualPrice("64.23");
            PassengerCount passengerCountChild = new PassengerCount();
            passengerCountChild.count(1);
            passengerCountChild.setType(PassengerType.CHILD);
            passengerPricingChild.setPassengerCount(passengerCountChild);

            itinerary.setPassengerPricing(Arrays.asList(passengerPricingAdult, passengerPricingChild));

            // Slices
            DgItinerarySlice dgItinerarySlice = new DgItinerarySlice();

            DgItinerarySliceSegment dgItinerarySliceSegment = new DgItinerarySliceSegment();
            dgItinerarySliceSegment.setOriginAirport("SIN");
            dgItinerarySliceSegment.setDestinationAirport("HKG");
            dgItinerarySliceSegment.setDepartureDateTime(flightDate + "T12:25:00");
            dgItinerarySliceSegment.setArrivalDateTime(flightDate + "T16:55:00");
            dgItinerarySliceSegment.setFlightNumber("UO733");
            dgItinerarySliceSegment.setValidatingCarrierCode("UO");
            dgItinerarySliceSegment.setCabin(Cabin.ECONOMY);
            dgItinerarySliceSegment.setFareBrand("lite");

            dgItinerarySlice.setSegments(Collections.singletonList(dgItinerarySliceSegment));
            dgItinerarySlice.setFareBrand("lite");

            itinerary.setSlices(Collections.singletonList(dgItinerarySlice));

            // Passengers
            DgPassenger adult = new DgPassenger();
            adult.setPassengerReference("fac870");
            adult.setPassengerType(DgPassengerType.ADULT);

            DgPassenger child = new DgPassenger();
            child.setPassengerReference("5ef684");
            child.setPassengerType(DgPassengerType.CHILD);

            itinerary.setPassengers(Arrays.asList(adult, child));

            // Ancillaries
            DgAncillary ancillary = new DgAncillary();
            ancillary.setType(DgAncillaryType.CHECKED_BAG);
            ancillary.setTotalPrice("29.14");
            ancillary.setPassengerReference("fac870");

            itinerary.setAncillaries(Collections.singletonList(ancillary));

            // Session
            CreateAirlineDgSessionRequest session = new CreateAirlineDgSessionRequest();
            session.setLanguage("EN");
            session.setPointOfSale("MY");

            UserInfo userInfo = new UserInfo();
            userInfo.setAirlineUserId("airline-user-123456");
            session.setUserInfo(userInfo);

            offersRequest.setSession(session);

            Tuple2<String, List<CreateDgOfferItemResponse>> sessionIdAndOffers = client.createDgOffers(offersRequest);

            List<CreateDgOfferItemResponse> offers = sessionIdAndOffers.getVal2();
            String sessionId = sessionIdAndOffers.getVal1();
            System.out.println("*********************************************************************");
            System.out.println("*************************** SESSION ***************************");
            System.out.println("*********************************************************************");
            System.out.println(sessionId);

            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE OFFERS ***************************");
            System.out.println("*********************************************************************");
            System.out.println(offers);


            CreateDgContractRequest contractRequest = new CreateDgContractRequest();
            contractRequest.setOfferIds(Collections.singletonList(offers.get(0).getId()));

            // Itinerary
            DgItinerary itinerary1 = new DgItinerary();
            contractRequest.setItinerary(itinerary1);
            itinerary1.setCurrency("USD");


            // Passengers Pricing
            DgPassengerPricing passengerPricingAdult1 = new DgPassengerPricing();
            passengerPricingAdult1.setIndividualPrice("64.23");
            PassengerCount passengerCountAdult1 = new PassengerCount();
            passengerCountAdult1.count(1);
            passengerCountAdult1.setType(PassengerType.ADULT);
            passengerPricingAdult1.setPassengerCount(passengerCountAdult1);

            DgPassengerPricing passengerPricingChild1 = new DgPassengerPricing();
            passengerPricingChild1.setIndividualPrice("64.23");
            PassengerCount passengerCountChild1 = new PassengerCount();
            passengerCountChild1.count(1);
            passengerCountChild1.setType(PassengerType.CHILD);
            passengerPricingChild1.setPassengerCount(passengerCountChild1);

            itinerary1.setPassengerPricing(Arrays.asList(passengerPricingAdult1, passengerPricingChild1));

            // Slices
            DgItinerarySlice dgItinerarySlice1 = new DgItinerarySlice();

            DgItinerarySliceSegment dgItinerarySliceSegment1 = new DgItinerarySliceSegment();
            dgItinerarySliceSegment1.setOriginAirport("SIN");
            dgItinerarySliceSegment1.setDestinationAirport("HKG");
            dgItinerarySliceSegment1.setDepartureDateTime(flightDate + "T12:25:00");
            dgItinerarySliceSegment1.setArrivalDateTime(flightDate + "T16:55:00");
            dgItinerarySliceSegment1.setFlightNumber("UO733");
            dgItinerarySliceSegment1.setValidatingCarrierCode("UO");
            dgItinerarySliceSegment1.setCabin(Cabin.ECONOMY);
            dgItinerarySliceSegment1.setFareBrand("lite");

            dgItinerarySlice1.setSegments(Collections.singletonList(dgItinerarySliceSegment1));
            dgItinerarySlice1.setFareBrand("lite");

            itinerary1.setSlices(Collections.singletonList(dgItinerarySlice1));

            // Passengers
            DgPassenger adult1 = new DgPassenger();
            adult1.setPassengerReference("fac870");
            adult1.setPassengerType(DgPassengerType.ADULT);
            adult1.setFirstName("John");
            adult1.setLastName("Doe");

            DgPassenger child1 = new DgPassenger();
            child1.setPassengerReference("5ef684");
            child1.setPassengerType(DgPassengerType.CHILD);
            child1.setFirstName("Junior");
            child1.setLastName("Doe");
            child1.setDateOfBirth(LocalDate.of(2015, 6, 6));

            itinerary1.setPassengers(Arrays.asList(adult1, child1));

            // Ancillaries
            DgAncillary ancillary1 = new DgAncillary();
            ancillary1.setType(DgAncillaryType.CHECKED_BAG);
            ancillary1.setTotalPrice("29.14");
            ancillary1.setPassengerReference("fac870");

            itinerary1.setAncillaries(Collections.singletonList(ancillary1));

            DgContract contract = client.createDgContract(contractRequest);
            String contractId = contract.getId();
            String contractReference = contract.getReference();
            String premium = contract.getPremium();
            String currency = contract.getCurrency();

            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE CONTRACT ***************************");
            System.out.println("*********************************************************************");
            System.out.println(contract);


            UpdateDgContractStatusRequest updateContractRequest = new UpdateDgContractStatusRequest();
            updateContractRequest.setStatus(DgStatus.CONFIRMED);
            updateContractRequest.setPnrReference("ABC001");
            updateContractRequest.setEmailAddress("john@doe.com");
            updateContractRequest.setPhoneNumber("+1234567890");

            PaymentCardDetails paymentCardDetails = new PaymentCardDetails();
            paymentCardDetails.setFirstName("John");
            paymentCardDetails.setLastName("Smith");
            paymentCardDetails.setExpirationMonth("09");
            paymentCardDetails.setExpirationYear("2029");
            paymentCardDetails.setNumber("4111111111111111");

            PaymentCard paymentCardFop = new PaymentCard();
            paymentCardFop.setAmount("157.60");
            paymentCardFop.setCurrency("CAD");
            paymentCardFop.setType("payment_card");
            FormOfPayment formOfPayment1 = new FormOfPayment(paymentCardFop);

            Cash cashFop = new Cash();
            cashFop.setAmount("60.60");
            cashFop.setCurrency("CAD");
            cashFop.setType("cash");
            FormOfPayment formOfPayment2 = new FormOfPayment(cashFop);

            updateContractRequest.addFormsOfPaymentItem(formOfPayment1);
            updateContractRequest.addFormsOfPaymentItem(formOfPayment2);

            DgContract contractUpdated = client.updateDgContractStatus(contractId, updateContractRequest, paymentCardDetails);

            System.out.println("*********************************************************************");
            System.out.println("*************************** UPDATED CONTRACT ***************************");
            System.out.println("*********************************************************************");
            System.out.println(contractUpdated);

            BookingConfirmed bookingConfirmed = new BookingConfirmed();
            bookingConfirmed.setType("booking_confirmed");
            bookingConfirmed.setOccurredDateTime(LocalDateTime.now().atOffset(ZoneOffset.UTC));
            Event event = new Event();
            event.setActualInstance(bookingConfirmed);
            client.createEvent(sessionId, event);

        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }
}