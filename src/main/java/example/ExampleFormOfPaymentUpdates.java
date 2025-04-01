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

        FormOfPayment formOfPayment = new FormOfPayment();
        formOfPayment.setActualInstance(paymentCard);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(formOfPayment);

        Cash paymentCash = new Cash();
        paymentCash.amount("12.00");
        paymentCash.currency("CAD");
        FormOfPayment formOfPayment1 = new FormOfPayment();
        formOfPayment.setActualInstance(paymentCash);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(formOfPayment1);

        return client.putCfarContractsIdFormsOfPayment(contractReference, updateCfarContractFormsOfPaymentRequest, sessionId);
    }

    private static CfarContract updateCfarFormsOfPaymentWithoutSuppliedToken(CancelForAnyReasonCfarApi client, String contractReference, String sessionId) throws ApiException {
        UpdateCfarFormOfPaymentRequest updateCfarContractFormsOfPaymentRequest = new UpdateCfarFormOfPaymentRequest();

        PaymentCardDetails paymentCardDetails = new PaymentCardDetails();
        paymentCardDetails.setFirstName("John");
        paymentCardDetails.setLastName("Smith");
        paymentCardDetails.setExpirationMonth("09");
        paymentCardDetails.setExpirationYear("2029");
        paymentCardDetails.setNumber("4111111111111111");
        FormOfPayment paymentCard = new FormOfPayment(paymentCardDetails);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(paymentCard);

        Cash cash = new Cash();
        cash.amount("46.00");
        cash.currency("CAD");
        FormOfPayment paymentCash = new FormOfPayment(cash);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(paymentCash);

        NonCash nonCash = new NonCash();
        nonCash.amount("8.00");
        nonCash.currency("CAD");
        FormOfPayment paymentNonCash = new FormOfPayment(nonCash);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(paymentNonCash);

        Points points = new Points();
        points.amount("74.00");
        FormOfPayment paymentPoints = new FormOfPayment(points);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(paymentPoints);

        PaymentCard paymentCardToken = new PaymentCard();
        paymentCardToken.amount("15.00");
        paymentCardToken.currency("CAD");
        paymentCardToken.setToken("RRREFFDFFDFDFF888");
        FormOfPayment formOfPaymentToken = new FormOfPayment(paymentCardToken);
        updateCfarContractFormsOfPaymentRequest.addFormsOfPaymentItem(formOfPaymentToken);

        return client.putCfarContractsIdFormsOfPayment(contractReference, updateCfarContractFormsOfPaymentRequest, sessionId);
    }
}