package example.hopperclient;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;

import java.net.MalformedURLException;
import java.util.*;

public class Example extends CommonExample {
    public static void main(String[] args) {
        try {
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

            List<CfarOffer> selectedOffer = new ArrayList<>();
            selectedOffer.add(offers.get(0));
            selectedOffer.add(offers.get(1));
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

            CfarContract isSucceeded = updateCfarContract(client, getContract.getReference(), sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** UPDATE CFAR CONTRACT*********************");
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
        ProcessCfarPaymentRequest processCfarPaymentRequest = new ProcessCfarPaymentRequest();
        processCfarPaymentRequest.setFirstName("John");
        processCfarPaymentRequest.setLastName("Smith");
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
}