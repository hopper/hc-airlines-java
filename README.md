# Java SDK
    
The Java SDK aims to help implement all API calls coming from the airline backend. It will automatically retrieve and renew
authentication tokens required to consume the Hopper Cloud Airlines API.

  * [Client initialization](#client-initialization)
    + [Download](#download)
    + [Parameters](#parameters)
  * [Client methods](#client-methods)
    + [createSession](#createsession)
    + [getCfarContract](#getcfarcontract)
      - [Example](#--example--)
    + [processCfarPayment](#processcfarpayment)
      - [Example](#--example---1)
    + [updateCfarContractStatus](#updatecfarcontractstatus)
  * [Data structures](#data-structures)
    + [Device](#device)
    + [Platform](#platform)
    + [OperatingSystem](#operatingsystem)
    + [Browser](#browser)
    + [UserInfo](#userinfo)
v
## Client initialization
### Download

Gradle:
```gradle
dependencies {
  implementation group: 'com.hopper.cloud', name: 'cloud-airlines-java', version: '0.1.2'
}
```

Maven:
```xml
<!-- https://mvnrepository.com/artifact/com.hopper.cloud/cloud-airlines-java -->
<dependency>
  <groupId>com.hopper.cloud</groupId>
  <artifactId>cloud-airlines-java</artifactId>
  <version>0.1.2</version>
</dependency>

```
### Parameters

* Endpoint URL: Will be provided by Hopper for each environment
* Client ID: Will be provided by Hopper for each environment
* Client Secret: Will be provided by Hopper for each environment
* Debugging : True to log input and output

```
HopperClient client = new HopperClient(endpointUrl, clientId, clientSecret, debugging);
```

## Client methods

### createSession

It has to be called each time an end-customer begins shopping on the airline website.

The returned sessionId will then be required in all subsequent calls to the API from the backend, but also from the
frontend using the SDK, so it has to be returned to the airline frontend.

**Parameters**


<table>
  <tr>
   <td>userInfo
   </td>
   <td>

[UserInfo](#UserInfo)

<p>
An object containing information related to the airline's user. Should be included if known, but not if the user is anonymous.
   </td>
  </tr>
  <tr>
   <td>device
   </td>
   <td>


[Device](#devise)
<p>
The end-user's device
   </td>
  </tr>
  <tr>
   <td>pointOfSale
<p style="color:red">required</p>
   </td>
   <td>String

Example: US
<p>
An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1-alpha-2</a> country code; the point of sale of the user
   </td>
  </tr>
  <tr>
   <td>language
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Example: es
<p>
An <a href="https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14">ISO_639-1</a> country code; the language associated with the user
   </td>
  </tr>
</table>


**Return value**


<table>
  <tr>
   <td>id
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: 9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f
<p>
A unique identifier for a session
   </td>
  </tr>
</table>


**Example :**

```
CreateAirlineSessionRequest sessionRequest = new CreateAirlineSessionRequest();
sessionRequest.setLanguage("EN");
sessionRequest.setPointOfSale("US");

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

AirlineSession session = client.createSession(sessionRequest);
```

#### getCfarContract

Called to retrieve details of a contract in order to update the shopping cart with the right amount

**Parameters**


<table>
  <tr>
   <td>sessionId
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: 9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f
<p>
A unique identifier for a session
   </td>
  </tr>
  <tr>
   <td>id
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: af585dfd-dddf-4726-9ef7-f1bb8909a79a
<p>
A unique identifier for a contract
   </td>
  </tr>
</table>


**Return value**


<table>
  <tr>
   <td>contract
<p style="color:red">required</p>
   </td>
   <td>CfarContract
<p>
The CFAR Contract
   </td>
  </tr>
</table>

##### **Example**

```
CfarContract getContract = client.getContract(sessionId,contractId);
```

#### processCfarPayment

**Parameters**


<table>
  <tr>
   <td>sessionId
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: 9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f
<p>
A unique identifier for a session
   </td>
  </tr>
  <tr>
   <td>contractId
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: af585dfd-dddf-4726-9ef7-f1bb8909a79a
<p>
A unique identifier for a contract
   </td>
  </tr>
  <tr>
   <td>firstName
<p style="color:red">required</p>
   </td>
   <td>String
<p>
The first name of the cardholder
   </td>
  </tr>
  <tr>
   <td>lastName
<p style="color:red">required</p>
   </td>
   <td>String
<p>
The last name of the cardholder
   </td>
  </tr>
  <tr>
   <td>number
<p style="color:red">required</p>
   </td>
   <td>String
<p>
The full card number
   </td>
  </tr>
  <tr>
   <td>verificationValue
<p style="color:red">required</p>
   </td>
   <td>String
<p>
The verification value (CVV/CVC) of the card
   </td>
  </tr>
  <tr>
   <td>month
<p style="color:red">required</p>
   </td>
   <td>String
<p>
The expiration month of the card
   </td>
  </tr>
  <tr>
   <td>year
<p>
<p style="color:red">required</p>
   </td>
   <td>String
<p>
The expiration year of the card
   </td>
  </tr>
</table>


**Return value**


<table>
  <tr>
   <td>succeeded
<p style="color:red">required</p>
   </td>
   <td>boolean
<p>
True if the payment succeeded, false if not
   </td>
  </tr>
</table>

##### **Example**

```
boolean succeeded = client.processCfarPayment(sessionId,contractId,"Joe","Smith","4111111111111111","123","12","2029");
```

#### updateCfarContractStatus

It has to be called after the payment details have been transferred, to confirm the contract.

**Parameters**


<table>
  <tr>
   <td>sessionId
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: 9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f
<p>
A unique identifier for a session
   </td>
  </tr>
  <tr>
   <td>contractId
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: af585dfd-dddf-4726-9ef7-f1bb8909a79a
<p>
A unique identifier for a contract
   </td>
  </tr>
  <tr>
   <td>status
<p style="color:red">required</p>
   </td>
   <td>Enum
<p>
Possible values: CONFIRMED, CANCELED
<p>
The new status of the contract
   </td>
  </tr>
  <tr>
   <td>pnrReference
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: ABC123
<p>
Reference of the PNR in the airline system
   </td>
  </tr>
  <tr>
   <td>emailAddress
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: john@doe.com
<p>
Contact email of the end customer
   </td>
  </tr>
</table>


**Return value**


<table>
  <tr>
   <td>contract
<p style="color:red">required</p>
   </td>
   <td>CfarContract
<p>
The updated CFAR Contract
   </td>
  </tr>
</table>


**Example :**

```

UpdateCfarContractRequest updateCfarContractRequest = new UpdateCfarContractRequest();
updateCfarContractRequest.setEmailAddress("test@test.com"); 
updateCfarContractRequest.setStatus(CfarContractStatus.CONFIRMED);
updateCfarContractRequest.setPnrReference("ABC123"); 
CfarContract contract = client.updateCfarContractStatus(sessionId,contractId, updateCfarContractRequest);

```

## Data structures

### Device

<table>
  <tr>
   <td>id
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: 2bcd6619-ac3e-403b-9982-3e12f2698a54
<p>
A unique identifier for the end-user's device, generated by the airline
   </td>
  </tr>
  <tr>
   <td>platform
   </td>
   <td>

[Platform](#Platform)
<p>
The device’s platform
   </td>
  </tr>
  <tr>
   <td>type
<p style="color:red">required</p>
   </td>
   <td>Enum
<p>
Possible values: DESKTOP, MOBILE, TABLET
<p>
Type of device
   </td>
  </tr>
</table>

### Platform

<table>
  <tr>
   <td>operatingSystem
   </td>
   <td>

[OperatingSystem](#OperatingSystem)

<p>
The platform’s Operating System
   </td>
  </tr>
  <tr>
   <td>browser
   </td>
   <td>

[Browser](#Browser)
<p>
The platform’s browser
   </td>
  </tr>
  <tr>
   <td>type
<p style="color:red">required</p>
   </td>
   <td>Enum
<p>
Possible values: APP, WEB
<p>
Type of platform
   </td>
  </tr>
</table>

### OperatingSystem

<table>
  <tr>
   <td>version
   </td>
   <td>String
<p>
Example: monterey
<p>
Version of the operating system
   </td>
  </tr>
  <tr>
   <td>type
<p style="color:red">required</p>
   </td>
   <td>Enum
<p>
Possible values: MAC_OS, WINDOWS, ANDROID, I_OS, CHROME_OS, LINUX, OTHER_OS
<p>
Type of operating system
   </td>
  </tr>
</table>

### Browser

<table>
  <tr>
   <td>type
<p style="color:red">required</p>
   </td>
   <td>Enum
<p>
Possible values: CHROME, SAFARI, INTERNET_EXPLORER, EDGE, FIREFOX, OPERA, OTHER_BROWSER
<p>
Type of browser
   </td>
  </tr>
</table>

### UserInfo

<table>
  <tr>
   <td>airlineUserId
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: 2bcd6619-ac3e-403b-9982-3e12f2698a54
<p>
The airline's unique identifier for a user.
   </td>
  </tr>
  <tr>
   <td>createdDateTime
   </td>
   <td>String &lt;date-time>
<p>
Example: 2022-01-01T18:34:30Z
<p>
A UTC RFC3339 datetime; the date and time at which a user's account was created
   </td>
  </tr>
  <tr>
   <td>previousBookings
   </td>
   <td>Integer >= 0
<p>
Example: 3
<p>
Number of prior bookings a user has made
   </td>
  </tr>
</table>

