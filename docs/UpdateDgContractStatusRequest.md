

# UpdateDgContractStatusRequest

A update DG contract status request

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | **DgStatus** |  |  |
|**pnrReference** | **String** | Reference of the PNR in the airline system.&lt;br/&gt;Mandatory only if new status is \&quot;confirmed\&quot; |  [optional] |
|**emailAddress** | **String** | Email address of the user |  [optional] |
|**phoneNumber** | **String** | Phone number of the customer |  [optional] |
|**firstName** | **String** | First name of the cardholder |  [optional] |
|**lastName** | **String** | Last name of the cardholder |  [optional] |
|**addressLine1** | **String** | Address of the cardholder (first line) |  [optional] |
|**addressLine2** | **String** | Address of the cardholder (second line) |  [optional] |
|**city** | **String** | City of the cardholder |  [optional] |
|**stateOrProvince** | **String** | State or province of the cardholder |  [optional] |
|**postalCode** | **String** | Postal code  of the cardholder |  [optional] |
|**country** | **String** | Country of the cardholder |  [optional] |
|**taxesTotal** | **String** | Total of taxes |  [optional] |
|**taxes** | [**List&lt;DgTax&gt;**](DgTax.md) | List of taxes that is associated with a contract |  [optional] |
|**formsOfPayment** | [**List&lt;FormOfPayment&gt;**](FormOfPayment.md) | List of the forms of payment used to purchase the booking |  [optional] |



