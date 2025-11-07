# AnalyticsApi

All URIs are relative to *https://airlines-api.hopper.com/airline/v1.1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**postEvents**](AnalyticsApi.md#postEvents) | **POST** /events | Send a Backend Event |


<a id="postEvents"></a>
# **postEvents**
> postEvents(hcSessionID, event)

Send a Backend Event

Events can be send directly from partner backend using the same authentication as the other endpoints

### Example
```java
// Import classes:
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.auth.*;
import com.hopper.cloud.airlines.models.*;
import com.hopper.cloud.airlines.api.AnalyticsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://airlines-api.hopper.com/airline/v1.1");
    
    // Configure HTTP bearer authorization: PartnerAuth
    HttpBearerAuth PartnerAuth = (HttpBearerAuth) defaultClient.getAuthentication("PartnerAuth");
    PartnerAuth.setBearerToken("BEARER TOKEN");

    AnalyticsApi apiInstance = new AnalyticsApi(defaultClient);
    String hcSessionID = "9fd3f2f9-e5aa-4128-ace9-3c4ee37b685f"; // String | The ID of the current airline session, see [Sessions](#tag/Sessions)
    Event event = new Event(); // Event | 
    try {
      apiInstance.postEvents(hcSessionID, event);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalyticsApi#postEvents");
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
| **hcSessionID** | **String**| The ID of the current airline session, see [Sessions](#tag/Sessions) | |
| **event** | [**Event**](Event.md)|  | |

### Return type

null (empty response body)

### Authorization

[PartnerAuth](../README.md#PartnerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The event has been successfully created |  * Expires -  <br>  * Cache-Control -  <br>  |
| **400** | Syntactic errors were encountered while handling the request |  -  |
| **401** | The client could not be authenticated |  -  |
| **403** | The authenticated client does not have permission to call this endpoint |  -  |
| **404** | The requested resource could not be found |  -  |
| **422** | Semantic errors were encountered while handling the request |  -  |
| **500** | The server encountered an internal error |  -  |

