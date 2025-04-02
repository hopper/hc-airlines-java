package example.apiclient;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;
import com.hopper.cloud.airlines.api.SessionsApi;
import com.hopper.cloud.airlines.model.*;
import java.util.*;

public class ExampleFormOfPaymentUpdates extends CommonExample {
    public static void main(String[] args) {
        try {
            ApiClient apiClient = configureApiClient();

            SessionsApi sessionsApi = new SessionsApi(apiClient);
            CancelForAnyReasonCfarApi cfarApi = new CancelForAnyReasonCfarApi(apiClient);

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

            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE CONTRACT *************************");
            System.out.println("*********************************************************************");
            List<CfarOffer> selectedOffer = new ArrayList<>();
            selectedOffer.add(offers.get(0));
            selectedOffer.add(offers.get(1));
            CfarContract contract = createCfarContract(cfarApi, selectedOffer, sessionId);
            System.out.println(contract);

//            CfarContract updatedContract = updateCfarFormsOfPaymentWithSuppliedToken(client, contract.getReference(), sessionId);
//            System.out.println("*********************************************************************");
//            System.out.println("************ UPDATE FORMS OF PAYMENT WHEN TOKEN IS SUPPLIED *********");
//            System.out.println("*********************************************************************");
//            System.out.println(updatedContract);
            System.out.println("*********************************************************************");
            System.out.println("************* UPDATE FORMS OF PAYMENT WHEN NO TOKEN IS SUPPLIED *****");
            System.out.println("*********************************************************************");
            CfarContract updatedContract = updateCfarFormsOfPaymentWithoutSuppliedToken(cfarApi, contract.getReference(), sessionId);
            System.out.println(updatedContract);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static CfarContract updateCfarFormsOfPaymentWithSuppliedToken(CancelForAnyReasonCfarApi client, String contractReference, String sessionId) throws ApiException {
//        Base64RsaKeyPair keyPair = null;
//        try {
//            keyPair = RsaHelper.buildBase64RsaKeys();
//        } catch (Exception e) {
//            throw new ApiException("generateRsaKeyPair ko");
//        }

        UpdateCfarFormOfPaymentRequest updateCfarContractFormsOfPaymentRequest = new UpdateCfarFormOfPaymentRequest();

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.amount("80.00");
        paymentCard.currency("CAD");
        paymentCard.setToken("FDDFDFDFDFDFFcc00028");

        FormOfPayment formOfPayment = new FormOfPayment(paymentCard);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(formOfPayment);

        Cash paymentCash = new Cash();
        paymentCash.amount("12.00");
        paymentCash.currency("CAD");
        FormOfPayment formOfPayment1 = new FormOfPayment(paymentCash);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(formOfPayment1);

        return client.putCfarContractsIdFormsOfPayment(contractReference, updateCfarContractFormsOfPaymentRequest, sessionId);
    }

    private static CfarContract updateCfarFormsOfPaymentWithoutSuppliedToken(CancelForAnyReasonCfarApi client, String contractReference, String sessionId) throws ApiException {
        UpdateCfarFormOfPaymentRequest updateCfarContractFormsOfPaymentRequest = new UpdateCfarFormOfPaymentRequest();

        Cash cash = new Cash();
        cash.amount("46.00");
        cash.currency("CAD");
        cash.setType("cash");
        FormOfPayment paymentCash = new FormOfPayment(cash);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(paymentCash);

        NonCash nonCash = new NonCash();
        nonCash.amount("8.00");
        nonCash.currency("CAD");
        nonCash.setType("non_cash");
        FormOfPayment paymentNonCash = new FormOfPayment(nonCash);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(paymentNonCash);

        Points points = new Points();
        points.amount("74.00");
        points.setType("points");
        FormOfPayment paymentPoints = new FormOfPayment(points);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(paymentPoints);

        PaymentCard paymentCardToken = new PaymentCard();
        paymentCardToken.amount("15.00");
        paymentCardToken.currency("CAD");
        paymentCardToken.setToken("RRREFFDFFDFDFF888");
        paymentCardToken.setType("payment_card");
        FormOfPayment formOfPaymentToken = new FormOfPayment(paymentCardToken);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(formOfPaymentToken);

        System.out.println(updateCfarContractFormsOfPaymentRequest.toJson());
        return client.putCfarContractsIdFormsOfPayment(contractReference, updateCfarContractFormsOfPaymentRequest, sessionId);
    }
}