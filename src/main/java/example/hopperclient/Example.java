package example.hopperclient;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.api.model.ProcessPaymentRequest;
import com.hopper.cloud.airlines.model.*;

import java.net.MalformedURLException;
import java.util.*;
import java.util.stream.Collectors;

public class Example extends CommonExample {
    public static void main(String[] args) {
        try {
            HopperClient client = new HopperClient("", "", "", "", "", "", true);

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

            List<CfarOffer> offersWith100PercentCoverage = offers.stream().filter(offer -> offer.getCoveragePercentage().contains("100")).collect(Collectors.toList());;
            List<CfarOffer> selectedOffer = new ArrayList<>();
            selectedOffer.add(offersWith100PercentCoverage.get(0));
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

            /**
            CfarContract isSucceeded = updateCfarContract(client, getContract.getReference(), sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** UPDATE CFAR CONTRACT*********************");
            System.out.println("*********************************************************************");
            System.out.println(isSucceeded);
             */

            boolean isSucceeded = processCfarPayment(client, getContract.getId(), sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** PROCESS CFAR PAYMENT*********************");
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
        } catch (ApiException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static boolean processCfarPayment(HopperClient client, String contractId, String sessionId) throws ApiException {
        ProcessPaymentRequest processPaymentRequest = new ProcessPaymentRequest();
        processPaymentRequest.setFullName("John");
        processPaymentRequest.setAddressLine1("123 12th St");
        processPaymentRequest.setAddressLine2("Building B");
        processPaymentRequest.setCity("Quebec City");
        processPaymentRequest.setPostalCode("G1R 4S9");
        processPaymentRequest.setStateOrProvince("QC");
        processPaymentRequest.setCountry("CA");
        processPaymentRequest.setNumber("4111111111111111");
        processPaymentRequest.setMonth("12");
        processPaymentRequest.setYear("2030");
        processPaymentRequest.setVerificationValue("123");
        processPaymentRequest.setEmailAddress("john@doe.com");
        processPaymentRequest.setPnrReference("ABC123");
        return client.processCfarPayment(sessionId, contractId, processPaymentRequest);
    }
}