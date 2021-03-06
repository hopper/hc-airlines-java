# Java SDK

The Java SDK aims to help implement all API calls coming from the airline backend. It will automatically retrieve and
renew authentication tokens required to consume the Hopper Cloud Airlines API.

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
    + [CfarContract](#cfarcontract)
    + [CfarOffer](#cfaroffer)
    + [CfarExercise](#cfarexercise)
    + [PassengerPricing](#passengerpricing)
    + [PassengerCount](#passengercount)
    + [Slice](#slice)
    + [Segment](#segment)
    + [Ancillary](#ancillary)

## Client initialization

### Download

Gradle:

```gradle
dependencies {
  implementation group: 'com.hopper.cloud', name: 'cloud-airlines-java', version: '0.4.0'
}
```

Maven:

```xml
<!-- https://mvnrepository.com/artifact/com.hopper.cloud/cloud-airlines-java -->
<dependency>
  <groupId>com.hopper.cloud</groupId>
  <artifactId>cloud-airlines-java</artifactId>
  <version>0.4.0</version>
</dependency>

```

### Parameters

* Endpoint URL: Will be provided by Hopper for each environment
* Client ID: Will be provided by Hopper for each environment
* Client Secret: Will be provided by Hopper for each environment
* Pci Proxy Url: Will be provided by Hopper for each environment
* Debugging : True to log input and output

```
HopperClient client = new HopperClient(endpointUrl, clientId, clientSecret, pciProxyUrl, debugging);
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

[UserInfo](#userinfo)

<p>
An object containing information related to the airline's user. Should be included if known, but not if the user is anonymous.
   </td>
  </tr>
  <tr>
   <td>device
   </td>
   <td>


[Device](#device)
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
ProcessCfarPaymentRequest processCfarPaymentRequest = new ProcessCfarPaymentRequest();
processCfarPaymentRequest.setFirstName("John");
processCfarPaymentRequest.setLastName("Smith");
processCfarPaymentRequest.setMonth("09");
processCfarPaymentRequest.setYear("26");
processCfarPaymentRequest.setNumber("4111111111111111");
processCfarPaymentRequest.setVerificationValue("123");
processCfarPaymentRequest.setEmailAddress("test@email.com");
processCfarPaymentRequest.setPnrReference("AB1234");
boolean succeeded =  client.processCfarPayment(sessionId, contractId, processCfarPaymentRequest);
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
   <td>

[CfarContract](#cfarcontract)
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

[Platform](#platform)
<p>
The device???s platform
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

[OperatingSystem](#operatingsystem)

<p>
The platform???s Operating System
   </td>
  </tr>
  <tr>
   <td>browser
   </td>
   <td>

[Browser](#browser)
<p>
The platform???s browser
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

### CfarContract

<table>
  <tr>
   <td>id
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: 1ec9ef29-be31-6ed3-beec-9f5ae0d164ee
<p>
Unique identifier for a contract
   </td>
  </tr>
  <tr>
   <td>offers
<p style="color:red">required</p>
   </td>
   <td>

array ( [CfarOffer](#cfaroffer) )

<p>
CFAR Offer(s) used to create the contract
   </td>
  </tr>
  <tr>
   <td>premium
<p style="color:red">required</p>
   </td>
   <td>string >= 0
<p>
Example:  80.00
<p>
Total amount to be paid for CFAR
   </td>
  </tr>
  <tr>
   <td>coverage
<p style="color:red">required</p>
   </td>
   <td>string >= 0
<p>
Example: 98.64
<p>
Total amount to be refunded upon CFAR exercise
   </td>
  </tr>
  <tr>
   <td>currency
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example:  USD
<p>
Currency of contract
   </td>
  </tr>
  <tr>
   <td>status
<p style="color:red">required</p>
   </td>
   <td>Enum: "created" "confirmed" "canceled" "exercised" "expired"
   </td>
  </tr>
  <tr>
   <td>created_date_time
<p style="color:red">required</p>
   </td>
   <td>string &lt;date-time>
<p>
Example: 2022-01-08T14:36:56.324Z
<p>
A UTC <a href="https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14">RFC3339</a> datetime; the date and time at which the contract was created
   </td>
  </tr>
  <tr>
   <td>confirmed_date_time
   </td>
   <td>string &lt;date-time>
<p>
Example: 2022-01-09T15:37:57.325Z
<p>
A UTC <a href="https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14">RFC3339</a> datetime; the date and time at which the contract was confirmed
   </td>
  </tr>
  <tr>
   <td>canceled_date_time
   </td>
   <td>string &lt;date-time>
<p>
Example: 2022-01-10T16:38:58.326Z
<p>
A UTC <a href="https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14">RFC3339</a> datetime; the date and time at which the contract was canceled
   </td>
  </tr>
  <tr>
   <td>expiry_date_time
<p style="color:red">required</p>
   </td>
   <td>string &lt;date-time>
<p>
Example: 2022-06-01T15:00:00Z
<p>
A UTC <a href="https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14">RFC3339</a> datetime; the date and time at which the CFAR contract will expire once purchased
   </td>
  </tr>
  <tr>
   <td>contract_exercise
   </td>
   <td>

[CfarExercise](#cfarexercise)

<p>
An object containing exercise information for a contract
   </td>
  </tr>
  <tr>
   <td>ext_attributes
<p style="color:red">required</p>
   </td>
   <td>object (map_string)
<p>
An array of arbitrary key-value pairs for storing airline-specific entity metadata
   </td>
  </tr>
  <tr>
   <td>pnr_reference
   </td>
   <td>string
<p>
Example: ABC123
<p>
Reference of the PNR in the airline system
   </td>
  </tr>
</table>

### CfarOffer

<table>
  <tr>
   <td>id
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example: 1ec9eed3-4486-6460-9d6c-2fb8469d35db
<p>
Unique identifier for an offer
   </td>
  </tr>
  <tr>
   <td>request_type
<p>
required
   </td>
   <td>string
<p>
Enum: "fare" "bundle" "ancillary" "post_booking"
<p>
Type of CFAR offer
   </td>
  </tr>
  <tr>
   <td>itinerary
<p style="color:red">required</p>
   </td>
   <td>

array ( [Itinerary](#itinerary) )
<p>
An object detailing the itinerary and fare used to create this CFAR offer
   </td>
  </tr>
  <tr>
   <td>premium
<p style="color:red">required</p>
   </td>
   <td>string >= 0
<p>
Example:  40.00
<p>
Total amount to be paid for CFAR
   </td>
  </tr>
  <tr>
   <td>coverage
<p style="color:red">required</p>
   </td>
   <td>string >= 0
<p>
Example:  400.00
<p>
Total amount to be refunded upon CFAR exercise
   </td>
  </tr>
  <tr>
   <td>currency
<p style="color:red">required</p>
   </td>
   <td>String
<p>
Example:  CAD
<p>
Currency of offer
   </td>
  </tr>
  <tr>
   <td>to_usd_exchange_rate
<p style="color:red">required</p>
   </td>
   <td>string > 0
<p>
Example:  0.7796267926543563596106543797484144
<p>
USD Exchange rate for currency; amount * toUsdExchangeRate == USD
   </td>
  </tr>
  <tr>
   <td>contract_expiry_date_time
<p style="color:red">required</p>
   </td>
   <td>string &lt;date-time>
<p>
Example: 2022-04-01T22:34:30Z
<p>
A UTC <a href="https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14">RFC3339</a> datetime; the date and time at which the CFAR contract will expire once purchased
   </td>
  </tr>
  <tr>
   <td>created_date_time
<p style="color:red">required</p>
   </td>
   <td>string &lt;date-time>
<p>
Example: 2022-01-08T14:36:56.324Z
<p>
A UTC <a href="https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14">RFC3339</a> datetime; the date and time at which a CFAR offer was created
   </td>
  </tr>
  <tr>
   <td>ext_attributes
<p style="color:red">required</p>
   </td>
   <td>object (map_string)
<p>
An array of arbitrary key-value pairs for storing airline-specific entity metadata
   </td>
  </tr>
  <tr>
   <td>offer_description
<p style="color:red">required</p>
   </td>
   <td>array (string)
<p>
Example:  [
<p>
 "Get 80% of your flight cost back in cash",
<p>
 "Cancel in a few taps right in the app ??? no forms or claims required"
<p>
]
<p>
One or more paragraphs describing the offer and its conditions in the user???s preferred language (or in english by default).
   </td>
  </tr>
</table>

### CfarExercise

<table>
  <tr>
   <td>id
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Example: 1ec9ef4b-b3bf-64ae-8a3d-6b084d9f6b3c
<p>
Unique identifier for a CFAR exercise
   </td>
  </tr>
  <tr>
   <td>contract_id
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Example: 1ec9ef29-be31-6ed3-beec-9f5ae0d164ee
<p>
Unique identifier for a contract
   </td>
  </tr>
  <tr>
   <td>exercise_initiated_date_time
<p style="color:red">required</p>
   </td>
   <td>string &lt;date-time>
<p>
Example: 2022-03-08T15:20:30Z
<p>
A UTC <a href="https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14">RFC3339</a> datetime; the date and time at which a contract exercise was initiated
   </td>
  </tr>
  <tr>
   <td>exercise_completed_date_time
   </td>
   <td>string &lt;date-time>
<p>
Example: 2022-03-08T15:22:20Z
<p>
A UTC <a href="https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14">RFC3339</a> datetime; the date and time at which a contract exercise was completed
   </td>
  </tr>
  <tr>
   <td>exchange_rate
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Example: 0.7771197300596905664658848324102446
<p>
Exchange rate
   </td>
  </tr>
  <tr>
   <td>hopper_refund
<p style="color:red">required</p>
   </td>
   <td>string >= 0
<p>
Example: 49.32
<p>
The amount refunded by hopper to the customer to complete the CFAR contract exercise
   </td>
  </tr>
  <tr>
   <td>hopper_refund_method
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Enum: "cash" "ftc"
<p>
The refund method used by hopper
   </td>
  </tr>
  <tr>
   <td>airline_refund_allowance
   </td>
   <td>string >= 0
<p>
Example: 123.20
<p>
Refundable amount allowed by the airline
   </td>
  </tr>
  <tr>
   <td>airline_refund_method
   </td>
   <td>string
<p>
Enum: "cash" "ftc"
<p>
The refund method used by the airline
   </td>
  </tr>
  <tr>
   <td>currency
   </td>
   <td>string
<p>
Example: CAD
<p>
The currency of the airline's refund allowance
   </td>
  </tr>
  <tr>
   <td>ext_attributes
<p style="color:red">required</p>
   </td>
   <td>object (map_string)
<p>
An array of arbitrary key-value pairs for storing airline-specific entity metadata
   </td>
  </tr>
</table>

### Itinerary

<table>
  <tr>
   <td>passenger_pricing
<p style="color:red">required</p>
   </td>
   <td>

array ( [PassengerPricing](#passengerpricing) )
<p>
List of passengers type, count and pricing for the itinerary
   </td>
  </tr>
  <tr>
   <td>total_price
<p>
required
   </td>
   <td>string >=0
<p>
Example: 401.10
<p>
Total price of the itinerary
   </td>
  </tr>
  <tr>
   <td>currency
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Example: CAD
<p>
Currency of pricing fields
   </td>
  </tr>
  <tr>
   <td>slices
<p style="color:red">required</p>
   </td>
   <td>

array ( [Slice](#slice) )
<p>
List of slices of the itinerary; 1 (one way),  2 (round trip) or up to 10 (multi-destination) slices are allowed
   </td>
  </tr>
  <tr>
   <td>ancillaries
   </td>
   <td>

array ( [Ancillary](#ancillary) )

<p>
Ancillaries attached to the itinerary and their prices
   </td>
  </tr>
</table>

### PassengerPricing

<table>
  <tr>
   <td>passenger_count
<p style="color:red">required</p>
   </td>
   <td>

array ([PassengerCount](#passengercount))

Type and number of passengers
   </td>
  </tr>
  <tr>
   <td>individual_price
   </td>
   <td>string >=0
<p>
Example: 200.55
<p>
Price per passenger
   </td>
  </tr>
</table>

### PassengerCount

<table>
  <tr>
   <td>count
<p style="color:red">required</p>
   </td>
   <td>integer
<p>
Example: 3
<p>
Number of passenger type
   </td>
  </tr>
  <tr>
   <td>passenger_type
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Enum: "adult" "child" "seated_infant" "lap_infant"
<p>
The type of passenger:
<p>
* adult - 12+ years of age
<p>
* child - 2-11 years of age
<p>
* seated_infant - &lt; 2 years of age, in their own seat
<p>
* lap_infant - &lt; 2 years of age, not in their own seat
   </td>
  </tr>
</table>

### Slice

<table>
  <tr>
   <td>segments
<p style="color:red">required</p>
   </td>
   <td>

array ( [Segment](#segment) )
<p>
A list of segments which make up the slice
   </td>
  </tr>
</table>

### Segment

<table>
  <tr>
   <td>origin_airport
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Example: BOS
<p>
IATA airport code of origin
   </td>
  </tr>
  <tr>
   <td>destination_airport
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Example: LGA
<p>
IATA airport code of destination
   </td>
  </tr>
  <tr>
   <td>departure_date_time
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Example: 2022-04-02T18:34:30
<p>
The local date and time of departure in ISO Local Date Time format
   </td>
  </tr>
  <tr>
   <td>arrival_date_time
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Example: 2022-04-02T19:12:30
<p>
The local date and time of arrival in ISO Local Date Time format
   </td>
  </tr>
  <tr>
   <td>flight_number
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Example: JB776
<p>
The number of the flight
   </td>
  </tr>
  <tr>
   <td>validating_carrier_code
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Example: B6
<p>
The IATA airline code of the validating carrier for this segment
   </td>
  </tr>
  <tr>
   <td>service_class
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Enum: "basic_economy" "economy" "premium_economy" "business" "first"
<p>
Service class of the segment
   </td>
  </tr>
</table>

### Ancillary

<table>
  <tr>
   <td>total_price
<p style="color:red">required</p>
   </td>
   <td>string >= 0
<p>
Example: 20.55
<p>
Total price of ancillaries of this type
   </td>
  </tr>
  <tr>
   <td>type
<p style="color:red">required</p>
   </td>
   <td>string
<p>
Enum: "travel_insurance" "cabin_bag" "checked_bag" "seat" "lounge" "meal" "fast_track" "pet" "other"
<p>
The type of ancillary
   </td>
  </tr>
</table>

