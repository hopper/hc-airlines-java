/*
 * Airline API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.hopper.cloud.airlines.api;

import com.hopper.cloud.airlines.ApiCallback;
import com.hopper.cloud.airlines.ApiClient;
import com.hopper.cloud.airlines.ApiException;
import com.hopper.cloud.airlines.ApiResponse;
import com.hopper.cloud.airlines.Configuration;
import com.hopper.cloud.airlines.Pair;
import com.hopper.cloud.airlines.ProgressRequestBody;
import com.hopper.cloud.airlines.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;


import com.hopper.cloud.airlines.model.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class AnalyticsApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public AnalyticsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AnalyticsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for postEvents
     * @param event  (required)
     * @param hcSessionID The ID of the current airline session, see [Sessions](#tag/Sessions) (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
    <table summary="Response Details" border="1">
    <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
    <tr><td> 201 </td><td> The event was correctly fired </td><td>  -  </td></tr>
    <tr><td> 204 </td><td> The request was successfully validated but not performed </td><td>  -  </td></tr>
    <tr><td> 400 </td><td> Syntactic errors were encountered while handling the request </td><td>  -  </td></tr>
    <tr><td> 401 </td><td> The client could not be authenticated </td><td>  -  </td></tr>
    <tr><td> 403 </td><td> The authenticated client does not have permission to call this endpoint </td><td>  -  </td></tr>
    <tr><td> 404 </td><td> The requested resource could not be found </td><td>  -  </td></tr>
    <tr><td> 422 </td><td> Semantic errors were encountered while handling the request </td><td>  -  </td></tr>
    <tr><td> 500 </td><td> The server encountered an internal error </td><td>  -  </td></tr>
    </table>
     */
    public okhttp3.Call postEventsCall(Event event, String hcSessionID, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = event;

        // create path and map variables
        String localVarPath = "/events";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (hcSessionID != null) {
            localVarHeaderParams.put("HC-Session-ID", localVarApiClient.parameterToString(hcSessionID));
        }

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "PartnerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call postEventsValidateBeforeCall(Event event, String hcSessionID, final ApiCallback _callback) throws ApiException {

        // verify the required parameter 'event' is set
        if (event == null) {
            throw new ApiException("Missing the required parameter 'event' when calling postEvents(Async)");
        }


        okhttp3.Call localVarCall = postEventsCall(event, hcSessionID, _callback);
        return localVarCall;
    }

    /**
     * Send a Backend Event
     * Events can be send directly from partner backend using the same authentication as the other endpoints
     * @param event  (required)
     * @param hcSessionID The ID of the current airline session, see [Sessions](#tag/Sessions) (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
    <table summary="Response Details" border="1">
    <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
    <tr><td> 201 </td><td> The event was correctly fired </td><td>  -  </td></tr>
    <tr><td> 204 </td><td> The request was successfully validated but not performed </td><td>  -  </td></tr>
    <tr><td> 400 </td><td> Syntactic errors were encountered while handling the request </td><td>  -  </td></tr>
    <tr><td> 401 </td><td> The client could not be authenticated </td><td>  -  </td></tr>
    <tr><td> 403 </td><td> The authenticated client does not have permission to call this endpoint </td><td>  -  </td></tr>
    <tr><td> 404 </td><td> The requested resource could not be found </td><td>  -  </td></tr>
    <tr><td> 422 </td><td> Semantic errors were encountered while handling the request </td><td>  -  </td></tr>
    <tr><td> 500 </td><td> The server encountered an internal error </td><td>  -  </td></tr>
    </table>
     */
    public void postEvents(Event event, String hcSessionID) throws ApiException {
        postEventsWithHttpInfo(event, hcSessionID);
    }

    /**
     * Send a Backend Event
     * Events can be send directly from partner backend using the same authentication as the other endpoints
     * @param event  (required)
     * @param hcSessionID The ID of the current airline session, see [Sessions](#tag/Sessions) (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
    <table summary="Response Details" border="1">
    <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
    <tr><td> 201 </td><td> The event was correctly fired </td><td>  -  </td></tr>
    <tr><td> 204 </td><td> The request was successfully validated but not performed </td><td>  -  </td></tr>
    <tr><td> 400 </td><td> Syntactic errors were encountered while handling the request </td><td>  -  </td></tr>
    <tr><td> 401 </td><td> The client could not be authenticated </td><td>  -  </td></tr>
    <tr><td> 403 </td><td> The authenticated client does not have permission to call this endpoint </td><td>  -  </td></tr>
    <tr><td> 404 </td><td> The requested resource could not be found </td><td>  -  </td></tr>
    <tr><td> 422 </td><td> Semantic errors were encountered while handling the request </td><td>  -  </td></tr>
    <tr><td> 500 </td><td> The server encountered an internal error </td><td>  -  </td></tr>
    </table>
     */
    public ApiResponse<Void> postEventsWithHttpInfo(Event event, String hcSessionID) throws ApiException {
        okhttp3.Call localVarCall = postEventsValidateBeforeCall(event, hcSessionID, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Send a Backend Event (asynchronously)
     * Events can be send directly from partner backend using the same authentication as the other endpoints
     * @param event  (required)
     * @param hcSessionID The ID of the current airline session, see [Sessions](#tag/Sessions) (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
    <table summary="Response Details" border="1">
    <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
    <tr><td> 201 </td><td> The event was correctly fired </td><td>  -  </td></tr>
    <tr><td> 204 </td><td> The request was successfully validated but not performed </td><td>  -  </td></tr>
    <tr><td> 400 </td><td> Syntactic errors were encountered while handling the request </td><td>  -  </td></tr>
    <tr><td> 401 </td><td> The client could not be authenticated </td><td>  -  </td></tr>
    <tr><td> 403 </td><td> The authenticated client does not have permission to call this endpoint </td><td>  -  </td></tr>
    <tr><td> 404 </td><td> The requested resource could not be found </td><td>  -  </td></tr>
    <tr><td> 422 </td><td> Semantic errors were encountered while handling the request </td><td>  -  </td></tr>
    <tr><td> 500 </td><td> The server encountered an internal error </td><td>  -  </td></tr>
    </table>
     */
    public okhttp3.Call postEventsAsync(Event event, String hcSessionID, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = postEventsValidateBeforeCall(event, hcSessionID, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
}