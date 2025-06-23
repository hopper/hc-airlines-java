

# CreateCfarContractExerciseRequest

A create CFAR contract exercise request

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**contractId** | **String** | A unique identifier for a CFAR contract |  [optional] |
|**itinerary** | [**CfarCreateExerciseItinerary**](CfarCreateExerciseItinerary.md) |  |  |
|**emailAddress** | **String** | Email address of the user |  [optional] |
|**pnrReference** | **String** |  |  |
|**airlineRefundPenalty** | **String** | The penalty fee applied by the airline when issuing a refund for the booking |  [optional] |
|**airlineRefundMethod** | **AirlineRefundMethod** |  |  [optional] |
|**currency** | **String** | The currency of the airline&#39;s refund allowance |  [optional] |
|**extAttributes** | **Map&lt;String, String&gt;** |  |  |
|**session** | [**CreateAirlineCfarSessionRequest**](CreateAirlineCfarSessionRequest.md) |  |  [optional] |
|**callbackUrl** | **String** | URL on which the customer should be redirected after the exercise (if applicable) |  [optional] |
|**redirectbackUrl** | **String** | URL on which the customer should be redirected if the exercise is aborted (if applicable) |  [optional] |
|**firstName** | **String** | First name of the cardholder |  [optional] |
|**lastName** | **String** | Last name of the cardholder |  [optional] |



