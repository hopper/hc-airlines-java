package example;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;
import java.util.*;

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

//            CfarContract updatedContract = updateCfarFormsOfPaymentWithSuppliedToken(client, contract.getReference(), sessionId);
//            System.out.println("*********************************************************************");
//            System.out.println("************ UPDATE FORMS OF PAYMENT WHEN TOKEN IS SUPPLIED *********");
//            System.out.println("*********************************************************************");
//            System.out.println(updatedContract);

            CfarContract updatedContract = updateCfarFormsOfPaymentWithoutSuppliedToken(client, contract.getReference(), sessionId);
            System.out.println("*********************************************************************");
            System.out.println("************* UPDATE FORMS OF PAYMENT WHEN NO TOKEN IS SUPPLIED *****");
            System.out.println("*********************************************************************");
            System.out.println(updatedContract);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static CfarContract updateCfarFormsOfPaymentWithSuppliedToken(HopperClient client, String contractReference, String sessionId) throws ApiException {
//        Base64RsaKeyPair keyPair = null;
//        try {
//            keyPair = RsaHelper.buildBase64RsaKeys();
//        } catch (Exception e) {
//            throw new ApiException("generateRsaKeyPair ko");
//        }

        UpdateCfarContractFormsOfPaymentRequest updateCfarContractFormsOfPaymentRequest = new UpdateCfarContractFormsOfPaymentRequest();

        FormOfPayment.TokenizedPaymentCard tokenizedPaymentCard = new FormOfPayment.TokenizedPaymentCard("80.00", Currency.getInstance("CAD"), "FDDFDFDFDFDFFcc00028");
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(tokenizedPaymentCard);

        FormOfPayment.Cash paymentCash = new FormOfPayment.Cash("12.00", Currency.getInstance("CAD"));
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(paymentCash);

        return client.updateCfarContractFormsOfPayment(sessionId, contractReference, updateCfarContractFormsOfPaymentRequest);
    }

    private static CfarContract updateCfarFormsOfPaymentWithoutSuppliedToken(HopperClient client, String contractReference, String sessionId) throws ApiException {
        UpdateCfarContractFormsOfPaymentRequest updateCfarContractFormsOfPaymentRequest = new UpdateCfarContractFormsOfPaymentRequest();

        PaymentCardDetails paymentCardDetails = new PaymentCardDetails();
        paymentCardDetails.setFirstName("John");
        paymentCardDetails.setLastName("Smith");
        paymentCardDetails.setExpirationMonth("09");
        paymentCardDetails.setExpirationYear("2029");
        paymentCardDetails.setNumber("4111111111111111");
        FormOfPayment.PaymentCard paymentCard = new FormOfPayment.PaymentCard("50.00", Currency.getInstance("CAD"), paymentCardDetails);
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(paymentCard);

        FormOfPayment.Cash paymentCash = new FormOfPayment.Cash("46.00", Currency.getInstance("CAD"));
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(paymentCash);

        FormOfPayment.NonCash paymentNonCash = new FormOfPayment.NonCash("8.00", Currency.getInstance("CAD"));
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(paymentNonCash);

        FormOfPayment.Points paymentPoints = new FormOfPayment.Points("74.00");
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(paymentPoints);

        FormOfPayment.TokenizedPaymentCard paymentCardToken = new FormOfPayment.TokenizedPaymentCard("15.00", Currency.getInstance("CAD"), "RRREFFDFFDFDFF888");
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(paymentCardToken);

        return client.updateCfarContractFormsOfPayment(sessionId, contractReference, updateCfarContractFormsOfPaymentRequest);
    }
}