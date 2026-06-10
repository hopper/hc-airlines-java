

# DgExerciseItinerary

Itinerary of the user when the contract exercise was initiated (only active segments should be provided). Optional for partners using DisruptionDetectionService-source disruption detection — when omitted, the exercise's existing itinerary is used.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**passengerCount** | [**List&lt;DgPassengerCount&gt;**](DgPassengerCount.md) | List of passengers type and count for the itinerary |  |
|**slices** | [**List&lt;DgExerciseItinerarySlice&gt;**](DgExerciseItinerarySlice.md) | List of slices of the itinerary; 1 (one way),  2 (round trip) or up to 10 (multi-destination) slices are allowed |  |
|**passengers** | [**List&lt;DgPassenger&gt;**](DgPassenger.md) | Details of the passengers |  [optional] |



