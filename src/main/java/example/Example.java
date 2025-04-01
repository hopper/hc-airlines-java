package example;

import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.api.AnalyticsApi;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;
import com.hopper.cloud.airlines.api.SessionsApi;
import com.hopper.cloud.airlines.model.*;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.util.*;

public class Example extends CommonExample {
    public static void main(String[] args) {
        try {
            ApiClient apiClient = configureApiClient();

            SessionsApi sessionsApi = new SessionsApi(apiClient);
            CancelForAnyReasonCfarApi cfarApi = new CancelForAnyReasonCfarApi(apiClient);
            AnalyticsApi analyticsApi = new AnalyticsApi(apiClient);

            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE PURCHASE SESSION *****************");
            System.out.println("*********************************************************************");
            AirlineSession session = getAirlineSession(sessionsApi, FlowType.PURCHASE);
            System.out.println(session);

            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE OFFERS ***************************");
            System.out.println("*********************************************************************");
            String sessionId = session.getId();
            List<CfarOffer> offers = createCfarOffers(cfarApi, sessionId);
            System.out.println(offers);

            List<CfarOffer> selectedOffer = new ArrayList<>();
            List<CfarItinerary> selectedItinerary = new ArrayList<>();

            selectedOffer.add(offers.get(0));
            selectedOffer.add(offers.get(1));
            selectedItinerary.add(offers.get(0).getItinerary());
            selectedItinerary.add(offers.get(1).getItinerary());

            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE CONTRACT *************************");
            System.out.println("*********************************************************************");
            CfarContract contract = createCfarContract(cfarApi, selectedOffer, sessionId);
            System.out.println(contract);

            System.out.println("*********************************************************************");
            System.out.println("*************************** GET CONTRACT ****************************");
            System.out.println("*********************************************************************");
            String contractId = contract.getId();
            CfarContract getContract = cfarApi.getCfarContractsId(contractId, sessionId);
            System.out.println(getContract);

            System.out.println("*********************************************************************");
            System.out.println("*************************** UPDATE CFAR CONTRACT*********************");
            System.out.println("*********************************************************************");
            CfarContract isSucceeded = updateCfarContract(cfarApi, getContract.getReference(), sessionId);
            System.out.println(isSucceeded);

            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE EVENT ****************************");
            System.out.println("*********************************************************************");
            createBookingConfirmedEvent(analyticsApi, sessionId);

            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE EXERCISE SESSION *****************");
            System.out.println("*********************************************************************");
            session = getAirlineSession(sessionsApi, FlowType.EXERCISE);
            System.out.println(session);

            sessionId = session.getId();
            CfarContractExercise exercise = createCfarContractExercise(cfarApi, contractId, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE EXERCISE *************************");
            System.out.println("*********************************************************************");
            System.out.println(exercise);
        } catch (ApiException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

//    private static boolean processCfarPayment(HopperClient client, String contractId, String sessionId) throws ApiException {
//        ProcessCfarPaymentRequest processCfarPaymentRequest = new ProcessCfarPaymentRequest();
//        processCfarPaymentRequest.setFirstName("John");
//        processCfarPaymentRequest.setLastName("Smith");
//        processCfarPaymentRequest.setMonth("09");
//        processCfarPaymentRequest.setYear("2029");
//        processCfarPaymentRequest.setNumber("4111111111111111");
//        processCfarPaymentRequest.setVerificationValue("123");
//        processCfarPaymentRequest.setAddressLine1("123 12th St");
//        processCfarPaymentRequest.setAddressLine2("Building B");
//        processCfarPaymentRequest.setCity("Quebec City");
//        processCfarPaymentRequest.setPostalCode("G1R 4S9");
//        processCfarPaymentRequest.setStateOrProvince("QC");
//        processCfarPaymentRequest.setCountry("CA");
//        processCfarPaymentRequest.setEmailAddress("john@doe.com");
//        processCfarPaymentRequest.setPnrReference("ABC123");
//        return client.processCfarPayment(sessionId, contractId, processCfarPaymentRequest);
//    }
}