package example;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.helper.Base64RsaKeyPair;
import com.hopper.cloud.airlines.helper.RsaHelper;
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

            CfarContract updatedContract = updateCfarFormsOfPaymentWithPreDefinedToken(client, contract.getReference(), sessionId);
            System.out.println("*********************************************************************");
            System.out.println("**************** UPDATE FORMS OF PAYMENT WITH TOKEN *****************");
            System.out.println("*********************************************************************");
            System.out.println(updatedContract);

            /*updatedContract = updateCfarFormsOfPaymentWithoutPreDefinedToken(client, contract.getReference(), sessionId);
            System.out.println("*********************************************************************");
            System.out.println("**************** UPDATE FORMS OF PAYMENT WITHOUT TOKEN **************");
            System.out.println("*********************************************************************");
            System.out.println(updatedContract);*/
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static CfarContract updateCfarFormsOfPaymentWithPreDefinedToken(HopperClient client, String contractReference, String sessionId) throws ApiException {
//        Base64RsaKeyPair keyPair = null;
//        try {
//            keyPair = RsaHelper.buildBase64RsaKeys();
//        } catch (Exception e) {
//            throw new ApiException("generateRsaKeyPair ko");
//        }

        UpdateCfarFormOfPaymentRequest updateCfarFormOfPaymentRequest = new UpdateCfarFormOfPaymentRequest();

        FormOfPayment.PaymentCard paymentCard = new FormOfPayment.PaymentCard("80.00", Currency.getInstance("CAD"), "FDDFDFDFDFDFFcc00028");
        updateCfarFormOfPaymentRequest.addFormOfPaymentItem(paymentCard);

        FormOfPayment.Cash paymentCash = new FormOfPayment.Cash("12.00", Currency.getInstance("CAD"));
        updateCfarFormOfPaymentRequest.addFormOfPaymentItem(paymentCash);

        return client.updateCfarContractFormsOfPayment(sessionId, contractReference, updateCfarFormOfPaymentRequest);
    }

    private static CfarContract updateCfarFormsOfPaymentWithoutPreDefinedToken(HopperClient client, String contractReference, String sessionId) throws ApiException {
        UpdateCfarFormOfPaymentRequest updateCfarFormOfPaymentRequest = new UpdateCfarFormOfPaymentRequest();

        CreditCardDetail creditCardDetail = new CreditCardDetail();
        creditCardDetail.setFirstName("John");
        creditCardDetail.setLastName("Smith");
        creditCardDetail.setExpirationMonth("09");
        creditCardDetail.setExpirationYear("2029");
        creditCardDetail.setNumber("4111111111111111");
        FormOfPayment.PaymentCard paymentCard = new FormOfPayment.PaymentCard("50.00", Currency.getInstance("CAD"), creditCardDetail);
        updateCfarFormOfPaymentRequest.addFormOfPaymentItem(paymentCard);

        FormOfPayment.Cash paymentCash = new FormOfPayment.Cash("46.00", Currency.getInstance("CAD"));
        updateCfarFormOfPaymentRequest.addFormOfPaymentItem(paymentCash);

        return client.updateCfarContractFormsOfPayment(sessionId, contractReference, updateCfarFormOfPaymentRequest);
    }
}