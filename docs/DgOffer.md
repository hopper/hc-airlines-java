

# DgOffer

A Dg offer

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier for a DG offer |  |
|**premium** | **String** | Total amount to be paid for DG |  |
|**coverage** | **String** | Total amount to be refunded upon DG exercise |  |
|**coveragePercentage** | **String** | Percentage of the amount to be refunded to customer compared to flight tickets price |  |
|**serviceCap** | **String** | Allowed amount per passenger to book a new flight in case of disruption |  |
|**currency** | **String** | Currency of offer |  |
|**taxesTotal** | **String** | Total of applicable taxes |  |
|**taxes** | [**List&lt;DgTax&gt;**](DgTax.md) | List of applicable taxes |  [optional] |
|**requestType** | **DgRequestType** |  |  |
|**entryPoint** | **String** | Information about product placement on partner&#39;s website |  [optional] |
|**maxHoursBeforeDeparture** | **Integer** | The number of hours before each flight or slice departure from which a purchased contract would start to cover disruptions |  |
|**minMinutesDelay** | **Integer** | The minimum flight or slice departure delay in hours to be covered |  |
|**contractExpiryDateTime** | **OffsetDateTime** | A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which the DG contract will expire once purchased |  |
|**createdDateTime** | **OffsetDateTime** | A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which a DG offer was created |  |
|**itinerary** | [**DgItinerary**](DgItinerary.md) |  |  |
|**extAttributes** | **Map&lt;String, String&gt;** |  |  |
|**experiments** | **Map&lt;String, String&gt;** |  |  |
|**contents** | [**Map&lt;String, DgContents&gt;**](DgContents.md) |  |  |
|**termsConditionsUrl** | **String** | The terms and conditions for this offer |  [optional] |
|**faqUrl** | **String** | The faq url for this offer |  [optional] |
|**merchandisingUrl** | **String** | The url for rendering offer merchandising |  [optional] |



