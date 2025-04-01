

# DgExerciseItinerarySliceSegment

An object detailing a segment of a fare slice

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**originAirport** | **String** | IATA airport code of origin |  |
|**destinationAirport** | **String** | IATA airport code of destination |  |
|**departureDateTime** | **String** | The local date and time of departure in ISO Local Date Time format |  |
|**arrivalDateTime** | **String** | The local date and time of arrival in ISO Local Date Time format |  |
|**estimatedDepartureDateTime** | **String** | The local date and time of estimated time of departure in ISO Local Date Time format |  |
|**estimatedArrivalDateTime** | **String** | The local date and time of estimated time of arrival in ISO Local Date Time format |  |
|**flightNumber** | **String** | The number of the flight |  |
|**validatingCarrierCode** | **String** | The IATA airline code of the validating carrier for this segment |  |
|**cabin** | **Cabin** |  |  |
|**flightStatus** | **FlightStatus** |  |  |
|**checkedIn** | **Boolean** | Is there at least one checked-in passenger on this flight |  [optional] |
|**checkedInBags** | **Boolean** | Is there at least one checked-in bag on this flight |  [optional] |
|**checkedBagAllowance** | **Boolean** | Is there a checked bag allowance on this flight |  [optional] |
|**boarded** | **Boolean** | Is there at least one passenger boarded on this flight |  [optional] |
|**flown** | **Boolean** | Is this segment flown already |  [optional] |



