

# CreateDgContractExerciseRequest

A create DG contract exercise request

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**contractId** | **String** | A unique identifier for a DG contract |  |
|**itinerary** | [**DgExerciseItinerary**](DgExerciseItinerary.md) |  |  |
|**pnrReference** | **String** | Reference of the PNR in the airline system. In case of a PNR created subsequently to a split, fill requesting PNR / parent PNR (e.g. DEF456/ABC123)  |  |
|**emailAddress** | **String** | Email address of the user |  [optional] |
|**callbackUrl** | **String** | URL on which the customer should be redirected after the exercise (if applicable) |  [optional] |
|**redirectbackUrl** | **String** | URL on which the customer should be redirected if the exercise is aborted (if applicable) |  [optional] |
|**session** | [**CreateAirlineDgSessionRequest**](CreateAirlineDgSessionRequest.md) |  |  [optional] |



