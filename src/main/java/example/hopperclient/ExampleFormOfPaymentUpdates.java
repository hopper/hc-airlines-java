package example.hopperclient;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;

import java.util.*;

public class ExampleFormOfPaymentUpdates extends CommonExample {
    public static void main(String[] args) {
        try {
            HopperClient client = new HopperClient("", "", "", "", "", "", "", "", 3000, true);

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

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.amount("80.00");
        paymentCard.currency("CAD");
        paymentCard.setToken("FDDFDFDFDFDFFcc00028");
        paymentCard.type("payment_card");

        FormOfPayment formOfPayment = new FormOfPayment(paymentCard);
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(formOfPayment);

        Cash paymentCash = new Cash();
        paymentCash.amount("12.00");
        paymentCash.currency("CAD");
        paymentCash.type("cash");
        FormOfPayment formOfPayment1 = new FormOfPayment(paymentCash);
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(formOfPayment1);

        return client.updateCfarContractFormsOfPayment(sessionId, contractReference, updateCfarContractFormsOfPaymentRequest, null);
    }

    private static CfarContract updateCfarFormsOfPaymentWithoutSuppliedToken(HopperClient client, String contractReference, String sessionId) throws ApiException {
        UpdateCfarContractFormsOfPaymentRequest updateCfarContractFormsOfPaymentRequest = new UpdateCfarContractFormsOfPaymentRequest();

        PaymentCardDetails paymentCardDetails = new PaymentCardDetails();
        paymentCardDetails.setFirstName("John");
        paymentCardDetails.setLastName("Smith");
        paymentCardDetails.setExpirationMonth("09");
        paymentCardDetails.setExpirationYear("2029");
        paymentCardDetails.setNumber("4111111111111111");

        Cash cash = new Cash();
        cash.amount("46.00");
        cash.currency("CAD");
        cash.type("cash");
        FormOfPayment paymentCash = new FormOfPayment(cash);
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(paymentCash);

        NonCash nonCash = new NonCash();
        nonCash.amount("8.00");
        nonCash.currency("CAD");
        nonCash.type("non_cash");
        FormOfPayment paymentNonCash = new FormOfPayment(nonCash);
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(paymentNonCash);

        Points points = new Points();
        points.amount("74.00");
        points.type("points");
        FormOfPayment paymentPoints = new FormOfPayment(points);
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(paymentPoints);

        PaymentCard paymentCardToken = new PaymentCard();
        paymentCardToken.type("payment_card");
        paymentCardToken.amount("15.00");
        paymentCardToken.currency("CAD");
        FormOfPayment formOfPaymentToken = new FormOfPayment(paymentCardToken);
        updateCfarContractFormsOfPaymentRequest.addFormOfPaymentItem(formOfPaymentToken);

        return client.updateCfarContractFormsOfPayment(sessionId, contractReference, updateCfarContractFormsOfPaymentRequest, paymentCardDetails);
    }
}