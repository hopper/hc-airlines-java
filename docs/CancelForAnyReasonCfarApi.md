# CancelForAnyReasonCfarApi

All URIs are relative to *https://airlines-api.hopper.com/airline/v1.1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getCfarContractsId**](CancelForAnyReasonCfarApi.md#getCfarContractsId) | **GET** /cfar_contracts/{id} | Get a CFAR Contract |
| [**postCfarContractExercises**](CancelForAnyReasonCfarApi.md#postCfarContractExercises) | **POST** /cfar_contract_exercises | Create CFAR Exercise |
| [**postCfarContracts**](CancelForAnyReasonCfarApi.md#postCfarContracts) | **POST** /cfar_contracts | Create a CFAR Contract |
| [**postCfarContractsIdPayment**](CancelForAnyReasonCfarApi.md#postCfarContractsIdPayment) | **POST** /cfar_contracts/{id}/payment | Process CFAR Payment |
| [**postCfarOffers**](CancelForAnyReasonCfarApi.md#postCfarOffers) | **POST** /cfar_offers | Create CFAR Offers |
| [**putCfarContractExercisesIdMarkCompleted**](CancelForAnyReasonCfarApi.md#putCfarContractExercisesIdMarkCompleted) | **PUT** /cfar_contract_exercises/{id}/mark_completed | Complete CFAR Exercise |
| [**putCfarContractsIdFormsOfPayment**](CancelForAnyReasonCfarApi.md#putCfarContractsIdFormsOfPayment) | **PUT** /cfar_contracts/{id}/forms_of_payment | Update forms of payment of a CFAR Contract |
| [**putCfarContractsIdUpdateStatus**](CancelForAnyReasonCfarApi.md#putCfarContractsIdUpdateStatus) | **PUT** /cfar_contracts/{id}/update_status | Update CFAR Contract Status |


<a id="getCfarContractsId"></a>
# **getCfarContractsId**
> CfarContract getCfarContractsId(id, hcSessionID)

Get a CFAR Contract

Get a CFAR contract

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    CancelForAnyReasonCfarApi apiInstance = new CancelForAnyReasonCfarApi(defaultClient);
    String id = "id_example"; // String | A unique identifier for a contract
    String hcSessionID = "9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f"; // String | The ID of the current airline session, see [Sessions](#tag/Sessions)
    try {
      CfarContract result = apiInstance.getCfarContractsId(id, hcSessionID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CancelForAnyReasonCfarApi#getCfarContractsId");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| A unique identifier for a contract | |
| **hcSessionID** | **String**| The ID of the current airline session, see [Sessions](#tag/Sessions) | [optional] |

### Return type

[**CfarContract**](CfarContract.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The requested CFAR contract |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="postCfarContractExercises"></a>
# **postCfarContractExercises**
> CfarContractExercise postCfarContractExercises(createCfarContractExerciseRequest, hcSessionID)

Create CFAR Exercise

Record that a request to exercise a CFAR contract has occurred.

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    CancelForAnyReasonCfarApi apiInstance = new CancelForAnyReasonCfarApi(defaultClient);
    CreateCfarContractExerciseRequest createCfarContractExerciseRequest = new CreateCfarContractExerciseRequest(); // CreateCfarContractExerciseRequest | 
    String hcSessionID = "9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f"; // String | The ID of the current airline session, see [Sessions](#tag/Sessions)
    try {
      CfarContractExercise result = apiInstance.postCfarContractExercises(createCfarContractExerciseRequest, hcSessionID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CancelForAnyReasonCfarApi#postCfarContractExercises");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createCfarContractExerciseRequest** | [**CreateCfarContractExerciseRequest**](CreateCfarContractExerciseRequest.md)|  | |
| **hcSessionID** | **String**| The ID of the current airline session, see [Sessions](#tag/Sessions) | [optional] |

### Return type

[**CfarContractExercise**](CfarContractExercise.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The created CFAR contract exercise |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="postCfarContracts"></a>
# **postCfarContracts**
> CfarContract postCfarContracts(createCfarContractRequest)

Create a CFAR Contract

Create a CFAR contract from selected CFAR offer(s).

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    CancelForAnyReasonCfarApi apiInstance = new CancelForAnyReasonCfarApi(defaultClient);
    CreateCfarContractRequest createCfarContractRequest = new CreateCfarContractRequest(); // CreateCfarContractRequest | 
    try {
      CfarContract result = apiInstance.postCfarContracts(createCfarContractRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CancelForAnyReasonCfarApi#postCfarContracts");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createCfarContractRequest** | [**CreateCfarContractRequest**](CreateCfarContractRequest.md)|  | |

### Return type

[**CfarContract**](CfarContract.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The created CFAR contract |  * Expires -  <br>  * Cache-Control -  <br>  |
| **204** | The CFAR contract creation request was successfully validated but not performed |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="postCfarContractsIdPayment"></a>
# **postCfarContractsIdPayment**
> CfarPayment postCfarContractsIdPayment(id, processCfarPaymentRequest, hcSessionID)

Process CFAR Payment

When HTS is the Merchant of Record (MoR), the customer&#39;s credit card is charged by HTS for the CFAR fee.  HTS is relying on an external payment gateway to process the payments, it allows the partner airline to tokenize the customer&#39;s credit card details and then pass the generated token in HTS Ancillaries for Airlines API payment endpoints in order to process the payment and confirm the contract related to the purchased product.  **Token URL**: https://core.spreedly.com/v1/payment_methods.json    **Example Token Request**:      &#x60;&#x60;&#x60;   curl --request POST --url https://core.spreedly.com/v1/payment_methods.json --header &#39;content-type: application/json&#39; -u  \&quot;login:password\&quot; --data &#39;{  \&quot;payment_method\&quot;: {   \&quot;email\&quot;: \&quot;aaa@bbb.ccc\&quot;,   \&quot;credit_card\&quot;: {    \&quot;number\&quot;: \&quot;4111111111111111\&quot;,    \&quot;month\&quot;: \&quot;09\&quot;,    \&quot;year\&quot;: \&quot;2029\&quot;,    \&quot;first_name\&quot;: \&quot;John\&quot;,    \&quot;last_name\&quot;: \&quot;Smith\&quot;,    \&quot;address1\&quot;: \&quot;123 12th St\&quot;,    \&quot;address2\&quot;: \&quot;Building B\&quot;,    \&quot;city\&quot;: \&quot;Quebec City\&quot;,    \&quot;state\&quot;: \&quot;QC\&quot;,    \&quot;zip\&quot;: \&quot;G1R 4S9\&quot;,    \&quot;country\&quot;: \&quot;CA\&quot;,    \&quot;verification_value\&quot;: \&quot;123\&quot;   }  } }&#39; &#x60;&#x60;&#x60; **Example Token Response**:   &#x60;&#x60;&#x60;   {  \&quot;transaction\&quot;:  {   \&quot;token\&quot;:  \&quot;KtToV20m9qT1Yi8pbTeLNz0Ypns\&quot;,   \&quot;created_at\&quot;:  \&quot;2023-11-29T13:31:56Z\&quot;,   \&quot;updated_at\&quot;:  \&quot;2023-11-29T13:31:56Z\&quot;,   \&quot;succeeded\&quot;:  true,   \&quot;transaction_type\&quot;:  \&quot;AddPaymentMethod\&quot;,   \&quot;retained\&quot;:  false,   \&quot;state\&quot;:  \&quot;succeeded\&quot;,   \&quot;message_key\&quot;:  \&quot;messages.transaction_succeeded\&quot;,   \&quot;message\&quot;:  \&quot;Succeeded!\&quot;,   \&quot;payment_method\&quot;:  {    \&quot;token\&quot;:  \&quot;MxyYEhDK12CUAA18bJDkAq0ab3y\&quot;,    \&quot;created_at\&quot;:  \&quot;2023-11-29T13:31:56Z\&quot;,    \&quot;updated_at\&quot;:  \&quot;2023-11-29T13:31:56Z\&quot;,    \&quot;email\&quot;:  \&quot;aaa@bbb.ccc\&quot;,    \&quot;data\&quot;:  null,    \&quot;storage_state\&quot;:  \&quot;cached\&quot;,    \&quot;test\&quot;:  true,    \&quot;metadata\&quot;:  null,    \&quot;callback_url\&quot;:  null,    \&quot;last_four_digits\&quot;:  \&quot;1111\&quot;,    \&quot;first_six_digits\&quot;:  \&quot;411111\&quot;,    \&quot;card_type\&quot;:  \&quot;visa\&quot;,    \&quot;first_name\&quot;:  \&quot;John\&quot;,    \&quot;last_name\&quot;:  \&quot;Smith\&quot;,    \&quot;month\&quot;:  9,    \&quot;year\&quot;:  2029,    \&quot;address1\&quot;:  \&quot;123 12th St\&quot;,    \&quot;address2\&quot;:  \&quot;Building B\&quot;,    \&quot;city\&quot;:  \&quot;Quebec City\&quot;,    \&quot;state\&quot;:  \&quot;QC\&quot;,    \&quot;zip\&quot;:  \&quot;G1R 4S9\&quot;,    \&quot;country\&quot;:  \&quot;CA\&quot;,    \&quot;phone_number\&quot;:  null,    \&quot;company\&quot;:  null,    \&quot;full_name\&quot;:  \&quot;John Smith\&quot;,    \&quot;eligible_for_card_updater\&quot;:  true,    \&quot;shipping_address1\&quot;:  null,    \&quot;shipping_address2\&quot;:  null,    \&quot;shipping_city\&quot;:  null,    \&quot;shipping_state\&quot;:  null,    \&quot;shipping_zip\&quot;:  null,    \&quot;shipping_country\&quot;:  null,    \&quot;shipping_phone_number\&quot;:  null,    \&quot;issuer_identification_number\&quot;:  \&quot;41111111\&quot;,    \&quot;click_to_pay\&quot;:  false,    \&quot;managed\&quot;:  true,    \&quot;payment_method_type\&quot;:  \&quot;credit_card\&quot;,    \&quot;errors\&quot;:  [],    \&quot;bin_metadata\&quot;:  {     \&quot;message\&quot;:  \&quot;BIN Metadata is available only to Advanced Vault enrolled customers and payment methods. Reach out to your account representative for more details.\&quot;    },    \&quot;fingerprint\&quot;:  \&quot;7ccffcf38900f224fc946cf2a9c8e260072b\&quot;,    \&quot;verification_value\&quot;:  \&quot;XXX\&quot;,    \&quot;number\&quot;:  \&quot;XXXX-XXXX-XXXX-1111\&quot;   }  } } &#x60;&#x60;&#x60; Here the returned payment method token **MxyYEhDK12CUAA18bJDkAq0ab3y** has to be used in the Process CFAR Payment request below.

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    CancelForAnyReasonCfarApi apiInstance = new CancelForAnyReasonCfarApi(defaultClient);
    String id = "id_example"; // String | A unique identifier for a contract
    ProcessCfarPaymentRequest processCfarPaymentRequest = new ProcessCfarPaymentRequest(); // ProcessCfarPaymentRequest | 
    String hcSessionID = "9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f"; // String | The ID of the current airline session, see [Sessions](#tag/Sessions)
    try {
      CfarPayment result = apiInstance.postCfarContractsIdPayment(id, processCfarPaymentRequest, hcSessionID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CancelForAnyReasonCfarApi#postCfarContractsIdPayment");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| A unique identifier for a contract | |
| **processCfarPaymentRequest** | [**ProcessCfarPaymentRequest**](ProcessCfarPaymentRequest.md)|  | |
| **hcSessionID** | **String**| The ID of the current airline session, see [Sessions](#tag/Sessions) | [optional] |

### Return type

[**CfarPayment**](CfarPayment.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result of the transaction |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="postCfarOffers"></a>
# **postCfarOffers**
> List&lt;CfarOffer&gt; postCfarOffers(createCfarOfferRequest, hcSessionID)

Create CFAR Offers

Create CFAR offers for a user&#39;s trip

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    CancelForAnyReasonCfarApi apiInstance = new CancelForAnyReasonCfarApi(defaultClient);
    CreateCfarOfferRequest createCfarOfferRequest = new CreateCfarOfferRequest(); // CreateCfarOfferRequest | 
    String hcSessionID = "9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f"; // String | The ID of the current airline session, see [Sessions](#tag/Sessions)
    try {
      List<CfarOffer> result = apiInstance.postCfarOffers(createCfarOfferRequest, hcSessionID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CancelForAnyReasonCfarApi#postCfarOffers");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createCfarOfferRequest** | [**CreateCfarOfferRequest**](CreateCfarOfferRequest.md)|  | |
| **hcSessionID** | **String**| The ID of the current airline session, see [Sessions](#tag/Sessions) | [optional] |

### Return type

[**List&lt;CfarOffer&gt;**](CfarOffer.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The created CFAR offers |  * Expires -  <br>  * Cache-Control -  <br>  * HTS-Session-ID - The ID of the current session, see [Sessions](#tag/Sessions) <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="putCfarContractExercisesIdMarkCompleted"></a>
# **putCfarContractExercisesIdMarkCompleted**
> CfarContractExercise putCfarContractExercisesIdMarkCompleted(id, markCfarContractExerciseCompleteRequest, hcSessionID)

Complete CFAR Exercise

Record that a request to exercise a CFAR contract has been completed

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    CancelForAnyReasonCfarApi apiInstance = new CancelForAnyReasonCfarApi(defaultClient);
    String id = "id_example"; // String | A unique identifier for a exercise
    MarkCfarContractExerciseCompleteRequest markCfarContractExerciseCompleteRequest = new MarkCfarContractExerciseCompleteRequest(); // MarkCfarContractExerciseCompleteRequest | 
    String hcSessionID = "9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f"; // String | The ID of the current airline session, see [Sessions](#tag/Sessions)
    try {
      CfarContractExercise result = apiInstance.putCfarContractExercisesIdMarkCompleted(id, markCfarContractExerciseCompleteRequest, hcSessionID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CancelForAnyReasonCfarApi#putCfarContractExercisesIdMarkCompleted");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| A unique identifier for a exercise | |
| **markCfarContractExerciseCompleteRequest** | [**MarkCfarContractExerciseCompleteRequest**](MarkCfarContractExerciseCompleteRequest.md)|  | |
| **hcSessionID** | **String**| The ID of the current airline session, see [Sessions](#tag/Sessions) | [optional] |

### Return type

[**CfarContractExercise**](CfarContractExercise.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The updated CFAR contract exercise |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="putCfarContractsIdFormsOfPayment"></a>
# **putCfarContractsIdFormsOfPayment**
> CfarContract putCfarContractsIdFormsOfPayment(id, updateCfarFormOfPaymentRequest, hcSessionID)

Update forms of payment of a CFAR Contract

Update forms of payment linked with a CFAR contract

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    CancelForAnyReasonCfarApi apiInstance = new CancelForAnyReasonCfarApi(defaultClient);
    String id = "id_example"; // String | A unique identifier for a contract
    UpdateCfarFormOfPaymentRequest updateCfarFormOfPaymentRequest = new UpdateCfarFormOfPaymentRequest(); // UpdateCfarFormOfPaymentRequest | 
    String hcSessionID = "9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f"; // String | The ID of the current airline session, see [Sessions](#tag/Sessions)
    try {
      CfarContract result = apiInstance.putCfarContractsIdFormsOfPayment(id, updateCfarFormOfPaymentRequest, hcSessionID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CancelForAnyReasonCfarApi#putCfarContractsIdFormsOfPayment");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| A unique identifier for a contract | |
| **updateCfarFormOfPaymentRequest** | [**UpdateCfarFormOfPaymentRequest**](UpdateCfarFormOfPaymentRequest.md)|  | |
| **hcSessionID** | **String**| The ID of the current airline session, see [Sessions](#tag/Sessions) | [optional] |

### Return type

[**CfarContract**](CfarContract.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The updated CFAR contract |  * Expires -  <br>  * Cache-Control -  <br>  |
| **204** | Forms of payment update request was successfully validated but not performed |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="putCfarContractsIdUpdateStatus"></a>
# **putCfarContractsIdUpdateStatus**
> CfarContract putCfarContractsIdUpdateStatus(id, updateCfarContractRequest, hcSessionID)

Update CFAR Contract Status

Update the CFAR contract

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.CancelForAnyReasonCfarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    CancelForAnyReasonCfarApi apiInstance = new CancelForAnyReasonCfarApi(defaultClient);
    String id = "id_example"; // String | A unique identifier for a contract
    UpdateCfarContractRequest updateCfarContractRequest = new UpdateCfarContractRequest(); // UpdateCfarContractRequest | 
    String hcSessionID = "9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f"; // String | The ID of the current airline session, see [Sessions](#tag/Sessions)
    try {
      CfarContract result = apiInstance.putCfarContractsIdUpdateStatus(id, updateCfarContractRequest, hcSessionID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CancelForAnyReasonCfarApi#putCfarContractsIdUpdateStatus");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| A unique identifier for a contract | |
| **updateCfarContractRequest** | [**UpdateCfarContractRequest**](UpdateCfarContractRequest.md)|  | |
| **hcSessionID** | **String**| The ID of the current airline session, see [Sessions](#tag/Sessions) | [optional] |

### Return type

[**CfarContract**](CfarContract.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The updated CFAR contract |  * Expires -  <br>  * Cache-Control -  <br>  |
| **204** | The CFAR contract status update request was successfully validated but not performed |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

