

# DgExerciseItinerarySlice

An object containing the list of flight segments for a fare slice

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**segments** | [**List&lt;DgExerciseItinerarySliceSegment&gt;**](DgExerciseItinerarySliceSegment.md) | A list of segments which make up the slice |  |
|**irop** | **Boolean** | Is the slice impacted by an unplanned short-term Irregularity. It includes delays and cancellations that occur on the day of departure of the first impacted flight. Also known as: Flight Irregularity, IROP or IREG. |  [optional] |
|**invol** | **Boolean** | Is the slice resulting from a rebooking following an unplanned short-term Irregularity. It includes delays and cancellations that occur on the day of departure of the first impacted flight. Also known as: Flight Irregularity, IROP or IREG. |  [optional] |
|**previousSlice** | [**DgExerciseItinerarySlice**](DgExerciseItinerarySlice.md) |  |  [optional] |



