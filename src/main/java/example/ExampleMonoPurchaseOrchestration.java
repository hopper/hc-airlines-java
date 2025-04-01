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
//            ApiClient apiClient = configureApiClient();
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