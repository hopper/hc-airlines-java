

# CfarCreateExerciseItinerarySlice

An object containing the list of flight segments for a fare slice

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**segments** | [**List&lt;CfarCreateExerciseSliceSegment&gt;**](CfarCreateExerciseSliceSegment.md) | A list of segments which make up the slice |  |
|**passengerPricing** | [**List&lt;PassengerPricing&gt;**](PassengerPricing.md) | List of passengers type, count and pricing for the slice |  [optional] |
|**totalPrice** | **String** | The price of the slice for all the passengers |  [optional] |
|**fareBrand** | **String** | Name of the fare brand applied to the slice |  [optional] |
|**fareBasis** | **String** | Code of the fare basis applied to the slice |  [optional] |
|**fareRules** | [**List&lt;FareRule&gt;**](FareRule.md) | The fare rules associated to the slice |  [optional] |
|**otherFares** | [**List&lt;Fare&gt;**](Fare.md) | Other available fares in the same cabin |  [optional] |



