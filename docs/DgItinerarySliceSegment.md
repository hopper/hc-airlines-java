

# DgItinerarySliceSegment

An object detailing a segment of a fare slice

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**segmentId** | **String** | A unique identifier for the segment |  [optional] |
|**originAirport** | **String** | IATA airport code of origin |  |
|**destinationAirport** | **String** | IATA airport code of destination |  |
|**departureDateTime** | **String** | The local date and time of departure in ISO Local Date Time format |  |
|**arrivalDateTime** | **String** | The local date and time of arrival in ISO Local Date Time format |  |
|**flightNumber** | **String** | The number of the flight |  |
|**validatingCarrierCode** | **String** | The IATA airline code of the validating carrier for this segment |  |
|**cabin** | **Cabin** |  |  |
|**fareBrand** | **String** | Name of the fare brand applied to the segment (if applicable) |  [optional] |



