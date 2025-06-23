# SessionsApi

All URIs are relative to *https://airlines-api.hopper.com/airline/v1.1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**postSessions**](SessionsApi.md#postSessions) | **POST** /sessions | Create a Session |


<a id="postSessions"></a>
# **postSessions**
> AirlineSession postSessions(createAirlineSessionRequest)

Create a Session

Create a new session for which events will be collected.

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.SessionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    SessionsApi apiInstance = new SessionsApi(defaultClient);
    CreateAirlineSessionRequest createAirlineSessionRequest = new CreateAirlineSessionRequest(); // CreateAirlineSessionRequest | 
    try {
      AirlineSession result = apiInstance.postSessions(createAirlineSessionRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SessionsApi#postSessions");
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
| **createAirlineSessionRequest** | [**CreateAirlineSessionRequest**](CreateAirlineSessionRequest.md)|  | |

### Return type

[**AirlineSession**](AirlineSession.md)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The created airline session |  * Expires -  <br>  * Cache-Control -  <br>  |
| **204** | The airline session creation request was not performed |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

