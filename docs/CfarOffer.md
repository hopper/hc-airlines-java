

# CfarOffer

A successful CFAR offer response

## Properties

| Name                       | Type                                                   | Description                                                                                                                                                             | Notes      |
|----------------------------|--------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------|
| **id**                     | **String**                                             | Unique identifier for an offer                                                                                                                                          |            |
| **premium**                | **String**                                             | Total amount to be paid for CFAR                                                                                                                                        |            |
| **coverage**               | **String**                                             | Total amount to be refunded upon CFAR exercise                                                                                                                          |            |
| **coveragePercentage**     | **String**                                             | Percentage of the amount to be refunded to customer compared to flight tickets price                                                                                    |            |
| **coverageExtension**      | **String**                                             | Maximum amount added on top of the coverage to cover ancillaries                                                                                                        | [optional] |
| **currency**               | **String**                                             | Currency of offer                                                                                                                                                       |            |
| **taxesTotal**             | **String**                                             | Part of the premium which are taxes                                                                                                                                     |            |
| **taxes**                  | [**List&lt;CfarTax&gt;**](CfarTax.md)                  | List of applicable taxes                                                                                                                                                | [optional] |
| **requestType**            | **RequestType**                                        |                                                                                                                                                                         |            |
| **contractExpiryDateTime** | **OffsetDateTime**                                     | A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which the CFAR contract will expire once purchased |            |
| **createdDateTime**        | **OffsetDateTime**                                     | A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which a CFAR offer was created                     |            |
| **itinerary**              | [**CfarItinerary**](CfarItinerary.md)                  |                                                                                                                                                                         |            |
| **contents**               | [**Map&lt;String, CfarContents&gt;**](CfarContents.md) | One or more contents describing the offer and its conditions in the available languages                                                                                 |            |
| **extAttributes**          | **Map&lt;String, String&gt;**                          |                                                                                                                                                                         |            |
| **termsConditionsUrl**     | **String**                                             | The terms and conditions for this offer                                                                                                                                 | [optional] |
| **faqUrl**                 | **String**                                             | The faq url for this offer                                                                                                                                              | [optional] |
| **merchandisingUrl**       | **String**                                             | The url for rendering offer merchandising                                                                                                                               | [optional] |



