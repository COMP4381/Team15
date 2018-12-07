# JobsTubeControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addPlaylistUsingGET**](JobsTubeControllerApi.md#addPlaylistUsingGET) | **GET** /JobsTube/playlists/create/{category} | addPlaylist
[**addVideoToPlaylistUsingGET**](JobsTubeControllerApi.md#addVideoToPlaylistUsingGET) | **GET** /JobsTube/playlists/{category}/{videoId} | addVideoToPlaylist
[**deletePlaylistUsingGET**](JobsTubeControllerApi.md#deletePlaylistUsingGET) | **GET** /JobsTube/playlists/delete/{category} | deletePlaylist


<a name="addPlaylistUsingGET"></a>
# **addPlaylistUsingGET**
> String addPlaylistUsingGET(category)

addPlaylist

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JobsTubeControllerApi;


JobsTubeControllerApi apiInstance = new JobsTubeControllerApi();
String category = "category_example"; // String | category
try {
    String result = apiInstance.addPlaylistUsingGET(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobsTubeControllerApi#addPlaylistUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | **String**| category |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="addVideoToPlaylistUsingGET"></a>
# **addVideoToPlaylistUsingGET**
> Map&lt;String, Object&gt; addVideoToPlaylistUsingGET(category, videoId)

addVideoToPlaylist

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JobsTubeControllerApi;


JobsTubeControllerApi apiInstance = new JobsTubeControllerApi();
String category = "category_example"; // String | category
String videoId = "videoId_example"; // String | videoId
try {
    Map<String, Object> result = apiInstance.addVideoToPlaylistUsingGET(category, videoId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobsTubeControllerApi#addVideoToPlaylistUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | **String**| category |
 **videoId** | **String**| videoId |

### Return type

**Map&lt;String, Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deletePlaylistUsingGET"></a>
# **deletePlaylistUsingGET**
> String deletePlaylistUsingGET(category)

deletePlaylist

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JobsTubeControllerApi;


JobsTubeControllerApi apiInstance = new JobsTubeControllerApi();
String category = "category_example"; // String | category
try {
    String result = apiInstance.deletePlaylistUsingGET(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobsTubeControllerApi#deletePlaylistUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | **String**| category |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

