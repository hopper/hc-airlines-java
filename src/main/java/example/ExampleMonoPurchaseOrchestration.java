package example;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class ExampleMonoPurchaseOrchestration extends CommonExample {
    public static void main(String[] args) {
        try {
            List<CfarOffer> offers = initPurchaseElements(client);
            System.out.println("*********************************************************************");
            System.out.println("*************************** INIT PURCHASE ELEMENTS ******************");
            System.out.println("*********************************************************************");
            System.out.println(offers);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}