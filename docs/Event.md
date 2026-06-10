

# Event


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**occurredDateTime** | **OffsetDateTime** | A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime;  the date and time at which an event occurred on a client device |  |
|**cfarContractId** | **String** | The purchased CFAR contract, if one is present |  [optional] |
|**dgContractId** | **String** | The purchased DG contract, if one is present |  [optional] |
|**cfarOfferIds** | **List&lt;String&gt;** | CFAR offer IDs shown to the customer during the session. Used to recover the session (and enrich the event) when no HC-Session-ID header is sent. |  [optional] |
|**dgOfferIds** | **List&lt;String&gt;** | DG offer IDs shown to the customer during the session. Used to recover the session (and enrich the event) when no HC-Session-ID header is sent. |  [optional] |
|**bookingReferences** | **Map&lt;String, String&gt;** |  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) |  |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BOOKING_CONFIRMED | &quot;booking_confirmed&quot; |
| OFFERS_DISPLAYED | &quot;offers_displayed&quot; |



