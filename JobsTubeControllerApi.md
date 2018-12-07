# JobsTubeControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addPlaylistUsingPOSTUsingGET**](JobsTubeControllerApi.md#addPlaylistUsingPOSTUsingGET) | **GET** /jobsTube/playlists/create/{name} | addPlaylistUsingPOST
[**deletePlaylistItemUsingDELETEUsingDELETE**](JobsTubeControllerApi.md#deletePlaylistItemUsingDELETEUsingDELETE) | **DELETE** /jobsTube/playlists/delete/{name} | deletePlaylistItemUsingDELETE


<a name="addPlaylistUsingPOSTUsingGET"></a>
# **addPlaylistUsingPOSTUsingGET**
> String addPlaylistUsingPOSTUsingGET(name)

addPlaylistUsingPOST

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JobsTubeControllerApi;


JobsTubeControllerApi apiInstance = new JobsTubeControllerApi();
String name = "name_example"; // String | name
try {
    String result = apiInstance.addPlaylistUsingPOSTUsingGET(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobsTubeControllerApi#addPlaylistUsingPOSTUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| name |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deletePlaylistItemUsingDELETEUsingDELETE"></a>
# **deletePlaylistItemUsingDELETEUsingDELETE**
> deletePlaylistItemUsingDELETEUsingDELETE()

deletePlaylistItemUsingDELETE

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JobsTubeControllerApi;


JobsTubeControllerApi apiInstance = new JobsTubeControllerApi();
try {
    apiInstance.deletePlaylistItemUsingDELETEUsingDELETE();
} catch (ApiException e) {
    System.err.println("Exception when calling JobsTubeControllerApi#deletePlaylistItemUsingDELETEUsingDELETE");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

