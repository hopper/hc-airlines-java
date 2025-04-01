

# CfarContractExercise

An object containing exercise information for a contract

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier for a CFAR exercise |  |
|**contractId** | **String** | Unique identifier for a contract |  |
|**exerciseInitiatedDateTime** | **OffsetDateTime** | A UTC [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) datetime; the date and time at which a contract exercise was initiated |  |
|**cashRefundAllowance** | **String** | Refundable amount allowed in cash |  |
|**extAttributes** | **Map&lt;String, String&gt;** |  |  |
|**ftcRefundAllowance** | **String** | Refundable amount allowed in future travel credit |  [optional] |
|**currency** | **String** | The currency of the airline&#39;s refund allowance |  [optional] |
|**redirectionToken** | **UUID** | Token used to authenticate the redirection after filling refund information in claims portal |  |
|**redirectionUrl** | **String** | URL on which the customer should be redirected to exercise (if applicable) |  [optional] |



