

# CreateDgOffersRequest

A create DG offers request

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**itinerary** | [**List&lt;DgItinerary&gt;**](DgItinerary.md) | An object detailing the itinerary and fare used to create a DG offer |  |
|**requestType** | **DgRequestType** |  |  |
|**bookingDateTime** | **OffsetDateTime** | A UTC RFC3339 datetime; the date and time at which the booking was made. To be used only with the request type \&quot;post_booking\&quot; |  [optional] |
|**session** | [**CreateAirlineDgSessionRequest**](CreateAirlineDgSessionRequest.md) |  |  [optional] |
|**extAttributes** | **Map&lt;String, String&gt;** |  |  |



