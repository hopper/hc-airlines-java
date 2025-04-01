package example;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.api.AnalyticsApi;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;
import com.hopper.cloud.airlines.api.SessionsApi;
import com.hopper.cloud.airlines.model.*;
import java.util.*;

public class ExampleFormOfPaymentUpdates extends CommonExample {
    public static void main(String[] args) {
        try {
            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("https://airlines-api.staging.hopper.com/airline/v1.1");
            apiClient.setBearerToken("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImtjN2FjWmV4bHBvZk1QY3V6UF9HTyJ9.eyJodHRwczovL2FwaS5ob3BwZXIuY29tL2FwaXMiOiJhaXJsaW5lL3YxLjEiLCJpc3MiOiJodHRwczovL2hvcHBlci1hcGkuYXV0aDAuY29tLyIsInN1YiI6IkhxeW10U0xyNUlNY0tXcUtVcTdGWHpnWFp5MHBHSWdVQGNsaWVudHMiLCJhdWQiOiJodHRwczovL2FpcmxpbmVzLWFwaS5zdGFnaW5nLmhvcHBlci5jb20iLCJpYXQiOjE3NDM0NzgyNzEsImV4cCI6MTc0MzU2NDY3MSwic2NvcGUiOiJhbGw6Z2VuZXJhbCBhbGw6Y2ZhciIsImd0eSI6ImNsaWVudC1jcmVkZW50aWFscyIsImF6cCI6IkhxeW10U0xyNUlNY0tXcUtVcTdGWHpnWFp5MHBHSWdVIn0.P7yuE1SavZn6N7XD8TrJRC5TIZNAMtRzmtagd28OX4h7EcY9fWcOLLkgDbPlsuU_ZiVkfdvDCw5MRxLbVqI51Oi_4mHu-q3TVpGN4ayRP30sYYNjab-6kbg2093bpVTd9J5F-4pGVKQS868sq_62ltrUQGHAYPSjloiHgb9gW9u6SuIHQHeXrdLrqn7ajV978Yty8mBrtFCUaaFilk9yksUJ_aS78ocDphHjyAoOSnGvdzNDayI30ItN9u4t7_5smh3mmypUxkj9TcngpvGd5__0pgm4mlGvsUoVyyXxoCzwAQIHHPlz9qhy00sLH7qeG6PcniHX32YASd9MRHg22A");

            SessionsApi sessionsApi = new SessionsApi(apiClient);
            CancelForAnyReasonCfarApi cfarApi = new CancelForAnyReasonCfarApi(apiClient);
            AnalyticsApi analyticsApi = new AnalyticsApi(apiClient);

            AirlineSession session = getAirlineSession(sessionsApi, FlowType.PURCHASE);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE PURCHASE SESSION *****************");
            System.out.println("*********************************************************************");
            System.out.println(session);

            String sessionId = session.getId();
            List<CfarOffer> offers = createCfarOffers(cfarApi, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE OFFERS ***************************");
            System.out.println("*********************************************************************");
            System.out.println(offers);

            List<CfarOffer> selectedOffer = new ArrayList<>();
            selectedOffer.add(offers.get(0));
            selectedOffer.add(offers.get(1));
            CfarContract contract = createCfarContract(cfarApi, selectedOffer, sessionId);
            System.out.println("*********************************************************************");
            System.out.println("*************************** CREATE CONTRACT *************************");
            System.out.println("*********************************************************************");
            System.out.println(contract);

//            CfarContract updatedContract = updateCfarFormsOfPaymentWithSuppliedToken(client, contract.getReference(), sessionId);
//            System.out.println("*********************************************************************");
//            System.out.println("************ UPDATE FORMS OF PAYMENT WHEN TOKEN IS SUPPLIED *********");
//            System.out.println("*********************************************************************");
//            System.out.println(updatedContract);

            CfarContract updatedContract = updateCfarFormsOfPaymentWithoutSuppliedToken(cfarApi, contract.getReference(), sessionId);
            System.out.println("*********************************************************************");
            System.out.println("************* UPDATE FORMS OF PAYMENT WHEN NO TOKEN IS SUPPLIED *****");
            System.out.println("*********************************************************************");
            System.out.println(updatedContract);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static CfarContract updateCfarFormsOfPaymentWithSuppliedToken(ApiClient client, String contractReference, String sessionId) throws ApiException {
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

    private static CfarContract updateCfarFormsOfPaymentWithoutSuppliedToken(ApiClient client, String contractReference, String sessionId) throws ApiException {
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