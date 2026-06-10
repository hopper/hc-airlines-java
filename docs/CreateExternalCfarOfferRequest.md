

# CreateExternalCfarOfferRequest

Create a CFAR offer with externally provided pricing and coverage

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**externalId** | **String** | External identifier for this offer |  |
|**countryCode** | **String** | Two-character country code in ISO 3166-1 format |  |
|**currency** | **String** | Currency of the offer |  |
|**toUsdExchangeRate** | **String** | Exchange rate from offer currency to USD |  |
|**premiumTotalAmount** | **String** | Total premium amount (including taxes) |  |
|**premiumPercentage** | **String** | Premium as a percentage of ticket price |  |
|**payoutTotalAmount** | **String** | Total payout amount upon exercise |  |
|**payoutPercentage** | **String** | Payout as a percentage of ticket price |  |
|**taxesTotal** | **String** | Total taxes on the premium |  |
|**contractExpiryDateTime** | **OffsetDateTime** | A UTC RFC3339 datetime; expiry date and time of the contract once purchased |  |
|**bookingDateTime** | **OffsetDateTime** | A UTC RFC3339 datetime; the date and time at which the booking was made |  [optional] |
|**itinerary** | [**CfarOfferItinerary**](CfarOfferItinerary.md) |  |  |
|**minMinutesDelay** | **Integer** | Minimum delay in minutes required for CFAR exercise eligibility |  |
|**session** | [**CreateAirlineCfarSessionRequest**](CreateAirlineCfarSessionRequest.md) |  |  [optional] |



