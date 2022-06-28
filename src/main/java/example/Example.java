package example;

import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.HopperClient;
import com.hopper.cloud.airlines.model.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Example {
    public static void main(String[] args) {
        try {
            HopperClient client = new HopperClient("http://localhost:7071/airline/v1.0", "", "");

            AirlineSession session = getAirlineSession(client);
            System.out.println(session);
            System.out.println(updateCfarContract(client,session.getId()));
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private static CfarContract updateCfarContract(HopperClient client,String sessionId) throws ApiException {
        UpdateCfarContractRequest updateCfarContractRequest = new UpdateCfarContractRequest();
        updateCfarContractRequest.setEmailAddress("test@test.com");
        updateCfarContractRequest.setStatus(CfarContractStatus.CONFIRMED);
        updateCfarContractRequest.setPnrReference("12345");
        return client.updateCfarContractStatus("1ecf41a5-714c-6ace-946e-b34b5d81272e",updateCfarContractRequest,sessionId);
    }

    private static AirlineSession getAirlineSession(HopperClient client) throws ApiException {
        CreateAirlineSessionRequest sessionRequest = new CreateAirlineSessionRequest();
        sessionRequest.setLanguage("EN");
        sessionRequest.setPointOfSale("FR");

        UserInfo userInfo = new UserInfo();
        userInfo.setAirlineUserId("airline-test-1");
        userInfo.setCreatedDateTime(LocalDateTime.now().atOffset(ZoneOffset.UTC));
        userInfo.setPreviousBookings(1);

        Device device = new Device();
        device.setId("airlines-test-device-1");
        device.setType(DeviceType.DESKTOP);

        Platform platform = new Platform();
        platform.setType(PlatformType.WEB);

        Browser browser = new Browser();
        browser.setType(BrowserType.CHROME);
        browser.setVersion("103.0.5060.53");

        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setType(OperatingSystemType.MAC_OS);
        operatingSystem.setVersion("monterey");

        platform.setBrowser(browser);
        platform.setOperatingSystem(operatingSystem);
        device.setPlatform(platform);
        sessionRequest.setDevice(device);
        sessionRequest.setUserInfo(userInfo);

        return client.createSession(sessionRequest);
    }
}
/*
{
  "user_info": {
    "airline_user_id": "airlines-test-1",
    "created_date_time": "2022-05-25T18:34:30Z",
    "previous_bookings": 3
  },
  "device": {
    "id": "airlines-test-device-1",
    "platform": {
      "operating_system": {
        "version": "monterey",
        "type": "mac_os"
      },
      "browser": {
        "version": "3.0",
          "type": "chrome"
      },
      "type": "web"
    },
    "type": "desktop"
  },
  "point_of_sale": "FR",
  "language": "EN"
}
 */