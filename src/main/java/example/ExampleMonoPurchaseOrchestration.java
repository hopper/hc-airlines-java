package example;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.model.*;

public class ExampleMonoPurchaseOrchestration extends CommonExample {
    public static void main(String[] args) {
        try {
            CreateSessionOffersContractsResponse initPurchaseResponse = createSessionOffersAndContracts(client);
            System.out.println("*********************************************************************");
            System.out.println("*************************** INIT PURCHASE ELEMENTS ******************");
            System.out.println("*********************************************************************");
            System.out.println(initPurchaseResponse);

            CfarContract confirmedCfarContract = updateCfarContract(client, initPurchaseResponse.getContracts().get(0).getReference(), initPurchaseResponse.getAirlineSession().getId());
            System.out.println("*********************************************************************");
            System.out.println("*************************** UPDATE CFAR CONTRACT STATUS**************");
            System.out.println("*********************************************************************");
            System.out.println(confirmedCfarContract);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}