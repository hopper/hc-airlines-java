

# CreateCfarOfferRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**itinerary** | [**List&lt;CfarOfferItinerary&gt;**](CfarOfferItinerary.md) | An object detailing the itinerary and fare used to create a CFAR offer |  |
|**requestType** | **RequestType** |  |  |
|**bookingDateTime** | **OffsetDateTime** | A UTC RFC3339 datetime; the date and time at which the booking was made. To be used only with the request type \&quot;post_booking\&quot; |  [optional] |
|**extAttributes** | **Map&lt;String, String&gt;** |  |  |
|**session** | [**CreateAirlineCfarSessionRequest**](CreateAirlineCfarSessionRequest.md) |  |  [optional] |
|**entryPoint** | **String** | Information about product placement on partner&#39;s website |  [optional] |



