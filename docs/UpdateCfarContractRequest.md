

# UpdateCfarContractRequest

Update CFAR contract request

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | **CfarStatus** |  |  |
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
|**taxes** | [**List&lt;CfarTax&gt;**](CfarTax.md) | List of taxes that is associated with a contract |  [optional] |
|**currency** | **String** | Updated currency in case it has changed at payment time |  [optional] |
|**exchangeRate** | **String** | Exchange rate applied provided by partner if currency has changed at payment time, for instance, if a contract is created in EUR and the customer chose to pay in CAD on the partner&#39;s website, the partner will send us their exchange rate value from EUR to CAD. |  [optional] |
|**totalPrice** | **String** | Updated total price to be covered by CFAR in case it can change at payment time |  [optional] |
|**formsOfPayment** | [**List&lt;FormOfPayment&gt;**](FormOfPayment.md) | List of the forms of payment used to purchase the booking |  [optional] |



