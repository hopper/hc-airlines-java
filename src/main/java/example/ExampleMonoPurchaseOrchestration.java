package example;

import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;
import com.hopper.cloud.airlines.model.*;

import java.net.MalformedURLException;

//public class ExampleMonoPurchaseOrchestration extends CommonExample {
//    public static void main(String[] args) {
//        try {
//            ApiClient apiClient = Configuration.getDefaultApiClient();
//            apiClient.setBasePath("https://airlines-api.staging.hopper.com/airline/v1.1");
//            apiClient.setBearerToken("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImtjN2FjWmV4bHBvZk1QY3V6UF9HTyJ9.eyJodHRwczovL2FwaS5ob3BwZXIuY29tL2FwaXMiOiJhaXJsaW5lL3YxLjEiLCJpc3MiOiJodHRwczovL2hvcHBlci1hcGkuYXV0aDAuY29tLyIsInN1YiI6IkhxeW10U0xyNUlNY0tXcUtVcTdGWHpnWFp5MHBHSWdVQGNsaWVudHMiLCJhdWQiOiJodHRwczovL2FpcmxpbmVzLWFwaS5zdGFnaW5nLmhvcHBlci5jb20iLCJpYXQiOjE3NDM0NzgyNzEsImV4cCI6MTc0MzU2NDY3MSwic2NvcGUiOiJhbGw6Z2VuZXJhbCBhbGw6Y2ZhciIsImd0eSI6ImNsaWVudC1jcmVkZW50aWFscyIsImF6cCI6IkhxeW10U0xyNUlNY0tXcUtVcTdGWHpnWFp5MHBHSWdVIn0.P7yuE1SavZn6N7XD8TrJRC5TIZNAMtRzmtagd28OX4h7EcY9fWcOLLkgDbPlsuU_ZiVkfdvDCw5MRxLbVqI51Oi_4mHu-q3TVpGN4ayRP30sYYNjab-6kbg2093bpVTd9J5F-4pGVKQS868sq_62ltrUQGHAYPSjloiHgb9gW9u6SuIHQHeXrdLrqn7ajV978Yty8mBrtFCUaaFilk9yksUJ_aS78ocDphHjyAoOSnGvdzNDayI30ItN9u4t7_5smh3mmypUxkj9TcngpvGd5__0pgm4mlGvsUoVyyXxoCzwAQIHHPlz9qhy00sLH7qeG6PcniHX32YASd9MRHg22A");
//            CancelForAnyReasonCfarApi client = new CancelForAnyReasonCfarApi(apiClient);
//
//            CreateSessionOffersContractsResponse initPurchaseResponse = createSessionOffersAndContracts(client);
//            System.out.println("*********************************************************************");
//            System.out.println("*************************** INIT PURCHASE ELEMENTS ******************");
//            System.out.println("*********************************************************************");
//            System.out.println(initPurchaseResponse);
//
//            CfarContract confirmedCfarContract = updateCfarContract(client, initPurchaseResponse.getContracts().get(0).getReference(), initPurchaseResponse.getAirlineSession().getId());
//            System.out.println("*********************************************************************");
//            System.out.println("*************************** UPDATE CFAR CONTRACT STATUS**************");
//            System.out.println("*********************************************************************");
//            System.out.println(confirmedCfarContract);
//
//            AirlineSession session = getAirlineSession(client, FlowType.EXERCISE);
//            System.out.println("*********************************************************************");
//            System.out.println("*************************** CREATE EXERCISE SESSION *****************");
//            System.out.println("*********************************************************************");
//            System.out.println(session);
//
//            String sessionId = session.getId();
//            CfarContractExercise exercise = createCfarContractExercise(client, confirmedCfarContract.getId(), sessionId);
//            System.out.println("*********************************************************************");
//            System.out.println("*************************** CREATE EXERCISE *************************");
//            System.out.println("*********************************************************************");
//            System.out.println(exercise);
//
//            exercise = completeCfarContractExercise(client, exercise.getId(), sessionId);
//            System.out.println("*********************************************************************");
//            System.out.println("*************************** COMPLETE EXERCISE *************************");
//            System.out.println("*********************************************************************");
//            System.out.println(exercise);
//        } catch (ApiException | MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
//}