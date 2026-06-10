

# DgPassenger

An object detailing the Passenger Information

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**passengerReference** | **String** | Unique reference of the passenger |  |
|**passengerType** | **DgPassengerType** |  |  |
|**firstName** | **String** | Ancillaries attached to the itinerary and their prices |  [optional] |
|**lastName** | **String** | Ancillaries attached to the itinerary and their prices |  [optional] |
|**dateOfBirth** | **String** | The birth date in ISO Local Date format (yyyy-MM-dd). For encrypted partners, this contains the encrypted Base64 string. |  [optional] |
|**gender** | **Gender** |  |  [optional] |
|**passportNumber** | **String** | The passport number of the passenger. For encrypted partners, this contains the encrypted Base64 string. |  [optional] |
|**passportCountryIssuance** | **String** | The country of issuance of the passenger&#39;s passport. Must be a valid ISO 3166-1 alpha-2 country code (2 uppercase letters, e.g., &#39;US&#39;, &#39;JP&#39;, &#39;TH&#39;). For encrypted partners, this contains the encrypted Base64 string. |  [optional] |
|**passportIssuanceDate** | **String** | The date of issuance of the passenger&#39;s passport in ISO Local Date format (yyyy-MM-dd). For encrypted partners, this contains the encrypted Base64 string. |  [optional] |
|**passportExpirationDate** | **String** | The passport expiration date of the passenger in ISO Local Date format (yyyy-MM-dd). For encrypted partners, this contains the encrypted Base64 string. |  [optional] |
|**nationality** | **String** | The nationality of the passenger. Must be a valid ISO 3166-1 alpha-2 country code (e.g., &#39;US&#39;, &#39;JP&#39;, &#39;TH&#39;). For encrypted partners, this contains the encrypted Base64 string. |  [optional] |



