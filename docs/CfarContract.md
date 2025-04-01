

# CfarContract

A CFAR contract

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier for a contract |  |
|**reference** | **String** | Unique reference for a contract |  |
|**offers** | [**List&lt;CfarOffer&gt;**](CfarOffer.md) | CFAR Offer(s) used to create the contract |  |
|**itinerary** | [**CfarItinerary**](CfarItinerary.md) |  |  |
|**coveragePercentage** | **String** | Percentage of the amount to be refunded to customer compared to flight tickets price |  |
|**coverage** | **String** | Total amount to be refunded upon CFAR exercise |  |
|**premium** | **String** | Total amount to be paid for CFAR |  |
|**currency** | **String** | Currency of contract |  |
|**taxesTotal** | **String** | Part of the premium which are taxes |  |
|**taxes** | [**List&lt;CfarTax&gt;**](CfarTax.md) | List of applicable taxes |  [optional] |
|**createdDateTime** | **OffsetDateTime** | A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which a CFAR contract was created |  |
|**expiryDateTime** | **OffsetDateTime** | A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) A UTC RFC3339 datetime; the date and time at which the CFAR contract will expire once purchased |  |
|**status** | **CfarStatus** |  |  |
|**pnrReference** | **String** | Reference of the PNR in the airline system |  [optional] |
|**extAttributes** | **Map&lt;String, String&gt;** |  |  |
|**exerciseUrl** | **String** | URL to exercise the contract (if applicable) |  [optional] |



