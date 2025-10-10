

# DgContract

A DG contract

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier for a contract |  |
|**reference** | **String** | Unique reference for a contract |  |
|**status** | **DgStatus** |  |  |
|**offers** | [**List&lt;DgOffer&gt;**](DgOffer.md) | DG Offer(s) used to create the contract |  |
|**itinerary** | [**DgItinerary**](DgItinerary.md) |  |  |
|**coveragePercentage** | **String** | Percentage of the ticket’s value to be refunded upon DG exercise |  |
|**coverage** | **String** | Total amount to be refunded upon DG exercise |  |
|**premium** | **String** | Total amount to be paid for DG |  |
|**serviceCap** | **String** | Allowed amount per passenger to book a new flight in case of disruption |  |
|**currency** | **String** | Currency of contract |  |
|**taxesTotal** | **String** | Part of the premium which are taxes |  |
|**taxes** | [**List&lt;DgTax&gt;**](DgTax.md) | List of applicable taxes |  [optional] |
|**maxHoursBeforeDeparture** | **Integer** | The number of hours before each flight or slice departure from which a purchased contract would start to cover disruptions |  |
|**minMinutesDelay** | **Integer** | The minimum flight or slice departure delay in minutes to be covered |  |
|**createdDateTime** | **OffsetDateTime** | A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which a CFAR contract was created |  |
|**expiryDateTime** | **OffsetDateTime** | A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) A UTC RFC3339 datetime; the date and time at which the CFAR contract will expire once purchased |  |
|**language** | **String** | Language of the booking |  [optional] |
|**pnrReference** | **String** | Reference of the PNR in the airline system |  [optional] |
|**extAttributes** | **Map&lt;String, String&gt;** |  |  |



