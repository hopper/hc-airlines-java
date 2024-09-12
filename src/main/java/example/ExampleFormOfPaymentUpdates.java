package example;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;

import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

public class ExampleFormOfPaymentUpdates extends CommonExample {
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

            CfarContract isSucceeded = updateCfarFormsOfPayment(client, contract.getReference(), sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** UPDATE FORMS OF PAYMENT *****************");
            System.out.println("*********************************************************************");
            System.out.println(isSucceeded);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static CfarContract updateCfarFormsOfPayment(HopperClient client, String contractReference, String sessionId) throws ApiException {
        UpdateCfarFormOfPaymentRequest updateCfarFormOfPaymentRequest = new UpdateCfarFormOfPaymentRequest();

        CreditCardDetail creditCardDetail = new CreditCardDetail();
        creditCardDetail.setFirstName("John");
        creditCardDetail.setLastName("Smith");
        creditCardDetail.setExpirationMonth("09");
        creditCardDetail.setExpirationYear("2029");
        creditCardDetail.setNumber("4111111111111111");
        FormOfPayment.PaymentCard paymentCard = new FormOfPayment.PaymentCard("120.32", Currency.getInstance("CAD"), creditCardDetail);
        updateCfarFormOfPaymentRequest.addFormOfPaymentItem(paymentCard);

        FormOfPayment.Cash paymentCash = new FormOfPayment.Cash("120.32", Currency.getInstance("CAD"));
        updateCfarFormOfPaymentRequest.addFormOfPaymentItem(paymentCash);

        return client.updateCfarContractFormsOfPaymentWithoutTokenization(sessionId, contractReference, updateCfarFormOfPaymentRequest);
    }
}