

# DgPassenger

An object detailing the Passenger Information

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**passengerReference** | **String** | Unique reference of the passenger |  |
|**passengerType** | **DgPassengerType** |  |  |
|**firstName** | **String** | Ancillaries attached to the itinerary and their prices |  [optional] |
|**lastName** | **String** | Ancillaries attached to the itinerary and their prices |  [optional] |
|**dateOfBirth** | **LocalDate** | The birth date in ISO Local Date format |  [optional] |
|**gender** | **Gender** |  |  [optional] |
|**passportNumber** | **String** | The passport number of the passenger |  [optional] |
|**passportCountryIssuance** | **String** | The country of issuance of the passenger&#39;s passport. Must be a valid ISO 3166-1 alpha-2 country code (2 uppercase letters, e.g., &#39;US&#39;, &#39;JP&#39;, &#39;TH&#39;) |  [optional] |
|**passportIssuanceDate** | **LocalDate** | The date of issuance of the passenger&#39;s passport |  [optional] |
|**passportExpirationDate** | **LocalDate** | The passport expiration date of the passenger |  [optional] |
|**nationality** | **String** | The nationality of the passenger. Must be a valid ISO 3166-1 alpha-2 country code (e.g., &#39;US&#39;, &#39;JP&#39;, &#39;TH&#39;) |  [optional] |



