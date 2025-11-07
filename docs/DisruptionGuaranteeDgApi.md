# DisruptionGuaranteeDgApi

All URIs are relative to *https://airlines-api.hopper.com/airline/v1.1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getDgContractsId**](DisruptionGuaranteeDgApi.md#getDgContractsId) | **GET** /dg_contracts/{id} | Get a DG contract |
| [**postDgContractExercises**](DisruptionGuaranteeDgApi.md#postDgContractExercises) | **POST** /dg_contract_exercises | Create DG Exercise |
| [**postDgContracts**](DisruptionGuaranteeDgApi.md#postDgContracts) | **POST** /dg_contracts | Create a DG Contract |
| [**postDgContractsIdPayment**](DisruptionGuaranteeDgApi.md#postDgContractsIdPayment) | **POST** /dg_contracts/{id}/payment | Process DG payment |
| [**postDgOffers**](DisruptionGuaranteeDgApi.md#postDgOffers) | **POST** /dg_offers | Create DG Offers |
| [**putDgContractsIdItinerarySlices**](DisruptionGuaranteeDgApi.md#putDgContractsIdItinerarySlices) | **PUT** /dg_contracts/{id}/itinerary_slices | Update DG Contract Itinerary Slices |
| [**putDgContractsIdUpdateStatus**](DisruptionGuaranteeDgApi.md#putDgContractsIdUpdateStatus) | **PUT** /dg_contracts/{id}/update_status | Update DG Contract Status |


<a id="getDgContractsId"></a>
# **getDgContractsId**
> DgContract getDgContractsId(id)

Get a DG contract

Get a DG contract

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.DisruptionGuaranteeDgApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    DisruptionGuaranteeDgApi apiInstance = new DisruptionGuaranteeDgApi(defaultClient);
    String id = "id_example"; // String | A unique identifier for a contract
    try {
      DgContract result = apiInstance.getDgContractsId(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DisruptionGuaranteeDgApi#getDgContractsId");
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

### Return type

[**DgContract**](DgContract.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The requested DG contract |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="postDgContractExercises"></a>
# **postDgContractExercises**
> CreateDgContractExerciseResponse postDgContractExercises(createDgContractExerciseRequest, hcSessionID)

Create DG Exercise

Record that a request to exercise a DG contract has occurred.

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.DisruptionGuaranteeDgApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    DisruptionGuaranteeDgApi apiInstance = new DisruptionGuaranteeDgApi(defaultClient);
    CreateDgContractExerciseRequest createDgContractExerciseRequest = new CreateDgContractExerciseRequest(); // CreateDgContractExerciseRequest | 
    String hcSessionID = "9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f"; // String | The ID of the current airline session, see [Sessions](#tag/Sessions)
    try {
      CreateDgContractExerciseResponse result = apiInstance.postDgContractExercises(createDgContractExerciseRequest, hcSessionID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DisruptionGuaranteeDgApi#postDgContractExercises");
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
| **createDgContractExerciseRequest** | [**CreateDgContractExerciseRequest**](CreateDgContractExerciseRequest.md)|  | |
| **hcSessionID** | **String**| The ID of the current airline session, see [Sessions](#tag/Sessions) | [optional] |

### Return type

[**CreateDgContractExerciseResponse**](CreateDgContractExerciseResponse.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The created DG contract exercise |  * Expires -  <br>  * Cache-Control -  <br>  * HTS-Session-ID - The ID of the current session, see [Sessions](#tag/Sessions) <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="postDgContracts"></a>
# **postDgContracts**
> DgContract postDgContracts(createDgContractRequest)

Create a DG Contract

Create a DG contract from selected DG offer(s).

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.DisruptionGuaranteeDgApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    DisruptionGuaranteeDgApi apiInstance = new DisruptionGuaranteeDgApi(defaultClient);
    CreateDgContractRequest createDgContractRequest = new CreateDgContractRequest(); // CreateDgContractRequest | 
    try {
      DgContract result = apiInstance.postDgContracts(createDgContractRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DisruptionGuaranteeDgApi#postDgContracts");
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
| **createDgContractRequest** | [**CreateDgContractRequest**](CreateDgContractRequest.md)|  | |

### Return type

[**DgContract**](DgContract.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The created DG contract |  * Expires -  <br>  * Cache-Control -  <br>  |
| **204** | The DG contract creation request was successfully validated but not performed |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="postDgContractsIdPayment"></a>
# **postDgContractsIdPayment**
> DgPayment postDgContractsIdPayment(id, processDgPaymentRequest)

Process DG payment

When HTS is the Merchant of Record (MoR), the customer&#39;s credit card is charged by HTS for the DG fee.  HTS is relying on an external payment gateway to process the payments, it allows the partner airline to tokenize the customer&#39;s credit card details and then pass the generated token in HTS Ancillaries for Airlines API payment endpoints in order to process the payment and confirm the contract related to the purchased product.  **Token URL**: https://core.spreedly.com/v1/payment_methods.json    **Example Token Request**:      &#x60;&#x60;&#x60;   curl --request POST --url https://core.spreedly.com/v1/payment_methods.json --header &#39;content-type: application/json&#39; -u  \&quot;login:password\&quot; --data &#39;{  \&quot;payment_method\&quot;: {   \&quot;email\&quot;: \&quot;aaa@bbb.ccc\&quot;,   \&quot;credit_card\&quot;: {    \&quot;number\&quot;: \&quot;4111111111111111\&quot;,    \&quot;month\&quot;: \&quot;09\&quot;,    \&quot;year\&quot;: \&quot;2029\&quot;,    \&quot;first_name\&quot;: \&quot;John\&quot;,    \&quot;last_name\&quot;: \&quot;Smith\&quot;,    \&quot;address1\&quot;: \&quot;123 12th St\&quot;,    \&quot;address2\&quot;: \&quot;Building B\&quot;,    \&quot;city\&quot;: \&quot;Quebec City\&quot;,    \&quot;state\&quot;: \&quot;QC\&quot;,    \&quot;zip\&quot;: \&quot;G1R 4S9\&quot;,    \&quot;country\&quot;: \&quot;CA\&quot;,    \&quot;verification_value\&quot;: \&quot;123\&quot;   }  } }&#39; &#x60;&#x60;&#x60; **Example Token Response**:   &#x60;&#x60;&#x60;   {  \&quot;transaction\&quot;:  {   \&quot;token\&quot;:  \&quot;KtToV20m9qT1Yi8pbTeLNz0Ypns\&quot;,   \&quot;created_at\&quot;:  \&quot;2023-11-29T13:31:56Z\&quot;,   \&quot;updated_at\&quot;:  \&quot;2023-11-29T13:31:56Z\&quot;,   \&quot;succeeded\&quot;:  true,   \&quot;transaction_type\&quot;:  \&quot;AddPaymentMethod\&quot;,   \&quot;retained\&quot;:  false,   \&quot;state\&quot;:  \&quot;succeeded\&quot;,   \&quot;message_key\&quot;:  \&quot;messages.transaction_succeeded\&quot;,   \&quot;message\&quot;:  \&quot;Succeeded!\&quot;,   \&quot;payment_method\&quot;:  {    \&quot;token\&quot;:  \&quot;MxyYEhDK12CUAA18bJDkAq0ab3y\&quot;,    \&quot;created_at\&quot;:  \&quot;2023-11-29T13:31:56Z\&quot;,    \&quot;updated_at\&quot;:  \&quot;2023-11-29T13:31:56Z\&quot;,    \&quot;email\&quot;:  \&quot;aaa@bbb.ccc\&quot;,    \&quot;data\&quot;:  null,    \&quot;storage_state\&quot;:  \&quot;cached\&quot;,    \&quot;test\&quot;:  true,    \&quot;metadata\&quot;:  null,    \&quot;callback_url\&quot;:  null,    \&quot;last_four_digits\&quot;:  \&quot;1111\&quot;,    \&quot;first_six_digits\&quot;:  \&quot;411111\&quot;,    \&quot;card_type\&quot;:  \&quot;visa\&quot;,    \&quot;first_name\&quot;:  \&quot;John\&quot;,    \&quot;last_name\&quot;:  \&quot;Smith\&quot;,    \&quot;month\&quot;:  9,    \&quot;year\&quot;:  2029,    \&quot;address1\&quot;:  \&quot;123 12th St\&quot;,    \&quot;address2\&quot;:  \&quot;Building B\&quot;,    \&quot;city\&quot;:  \&quot;Quebec City\&quot;,    \&quot;state\&quot;:  \&quot;QC\&quot;,    \&quot;zip\&quot;:  \&quot;G1R 4S9\&quot;,    \&quot;country\&quot;:  \&quot;CA\&quot;,    \&quot;phone_number\&quot;:  null,    \&quot;company\&quot;:  null,    \&quot;full_name\&quot;:  \&quot;John Smith\&quot;,    \&quot;eligible_for_card_updater\&quot;:  true,    \&quot;shipping_address1\&quot;:  null,    \&quot;shipping_address2\&quot;:  null,    \&quot;shipping_city\&quot;:  null,    \&quot;shipping_state\&quot;:  null,    \&quot;shipping_zip\&quot;:  null,    \&quot;shipping_country\&quot;:  null,    \&quot;shipping_phone_number\&quot;:  null,    \&quot;issuer_identification_number\&quot;:  \&quot;41111111\&quot;,    \&quot;click_to_pay\&quot;:  false,    \&quot;managed\&quot;:  true,    \&quot;payment_method_type\&quot;:  \&quot;credit_card\&quot;,    \&quot;errors\&quot;:  [],    \&quot;bin_metadata\&quot;:  {     \&quot;message\&quot;:  \&quot;BIN Metadata is available only to Advanced Vault enrolled customers and payment methods. Reach out to your account representative for more details.\&quot;    },    \&quot;fingerprint\&quot;:  \&quot;7ccffcf38900f224fc946cf2a9c8e260072b\&quot;,    \&quot;verification_value\&quot;:  \&quot;XXX\&quot;,    \&quot;number\&quot;:  \&quot;XXXX-XXXX-XXXX-1111\&quot;   }  } } &#x60;&#x60;&#x60; Here the returned payment method token **MxyYEhDK12CUAA18bJDkAq0ab3y** has to be used in the Process DG Payment request below.

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.DisruptionGuaranteeDgApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    DisruptionGuaranteeDgApi apiInstance = new DisruptionGuaranteeDgApi(defaultClient);
    String id = "id_example"; // String | A unique identifier for a contract
    ProcessDgPaymentRequest processDgPaymentRequest = new ProcessDgPaymentRequest(); // ProcessDgPaymentRequest | 
    try {
      DgPayment result = apiInstance.postDgContractsIdPayment(id, processDgPaymentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DisruptionGuaranteeDgApi#postDgContractsIdPayment");
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
| **processDgPaymentRequest** | [**ProcessDgPaymentRequest**](ProcessDgPaymentRequest.md)|  | |

### Return type

[**DgPayment**](DgPayment.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The contract has been paid |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="postDgOffers"></a>
# **postDgOffers**
> List&lt;CreateDgOfferItemResponse&gt; postDgOffers(createDgOffersRequest, hcSessionID)

Create DG Offers

Create DG offers for a user&#39;s trip

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.DisruptionGuaranteeDgApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    DisruptionGuaranteeDgApi apiInstance = new DisruptionGuaranteeDgApi(defaultClient);
    CreateDgOffersRequest createDgOffersRequest = new CreateDgOffersRequest(); // CreateDgOffersRequest | 
    String hcSessionID = "9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f"; // String | The ID of the current airline session, see [Sessions](#tag/Sessions)
    try {
      List<CreateDgOfferItemResponse> result = apiInstance.postDgOffers(createDgOffersRequest, hcSessionID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DisruptionGuaranteeDgApi#postDgOffers");
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
| **createDgOffersRequest** | [**CreateDgOffersRequest**](CreateDgOffersRequest.md)|  | |
| **hcSessionID** | **String**| The ID of the current airline session, see [Sessions](#tag/Sessions) | [optional] |

### Return type

[**List&lt;CreateDgOfferItemResponse&gt;**](CreateDgOfferItemResponse.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The created DG offers |  * Expires -  <br>  * Cache-Control -  <br>  * HTS-Session-ID - The ID of the current session, see [Sessions](#tag/Sessions) <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="putDgContractsIdItinerarySlices"></a>
# **putDgContractsIdItinerarySlices**
> DgContract putDgContractsIdItinerarySlices(id, dgItinerarySlice)

Update DG Contract Itinerary Slices

Update itinerary slices of a DG contract.

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.DisruptionGuaranteeDgApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    DisruptionGuaranteeDgApi apiInstance = new DisruptionGuaranteeDgApi(defaultClient);
    String id = "id_example"; // String | A unique identifier for a contract
    List<DgItinerarySlice> dgItinerarySlice = Arrays.asList(); // List<DgItinerarySlice> | 
    try {
      DgContract result = apiInstance.putDgContractsIdItinerarySlices(id, dgItinerarySlice);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DisruptionGuaranteeDgApi#putDgContractsIdItinerarySlices");
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
| **dgItinerarySlice** | [**List&lt;DgItinerarySlice&gt;**](DgItinerarySlice.md)|  | |

### Return type

[**DgContract**](DgContract.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The Updated DG contract |  * Expires -  <br>  * Cache-Control -  <br>  |
| **204** | The DG Contract Itinerary Slices update request was successfully validated but not performed |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

<a id="putDgContractsIdUpdateStatus"></a>
# **putDgContractsIdUpdateStatus**
> DgContract putDgContractsIdUpdateStatus(id, updateDgContractStatusRequest)

Update DG Contract Status

Update DG Contract Status

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.DisruptionGuaranteeDgApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    DisruptionGuaranteeDgApi apiInstance = new DisruptionGuaranteeDgApi(defaultClient);
    String id = "id_example"; // String | A unique identifier for a contract
    UpdateDgContractStatusRequest updateDgContractStatusRequest = new UpdateDgContractStatusRequest(); // UpdateDgContractStatusRequest | 
    try {
      DgContract result = apiInstance.putDgContractsIdUpdateStatus(id, updateDgContractStatusRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DisruptionGuaranteeDgApi#putDgContractsIdUpdateStatus");
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
| **updateDgContractStatusRequest** | [**UpdateDgContractStatusRequest**](UpdateDgContractStatusRequest.md)|  | |

### Return type

[**DgContract**](DgContract.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The Updated DG contract |  * Expires -  <br>  * Cache-Control -  <br>  |
| **204** | The DG contract status update request was successfully validated but not performed |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

