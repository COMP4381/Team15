# UserControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addVideoToPlaylistUsingPOST**](UserControllerApi.md#addVideoToPlaylistUsingPOST) | **POST** /Users/playlists/{category}/{videoId} | addVideoToPlaylist
[**uploadUsingPOST**](UserControllerApi.md#uploadUsingPOST) | **POST** /Users/upload | Upload


<a name="addVideoToPlaylistUsingPOST"></a>
# **addVideoToPlaylistUsingPOST**
> String addVideoToPlaylistUsingPOST(category, videoId)

addVideoToPlaylist

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserControllerApi;


UserControllerApi apiInstance = new UserControllerApi();
String category = "category_example"; // String | category
String videoId = "videoId_example"; // String | videoId
try {
    String result = apiInstance.addVideoToPlaylistUsingPOST(category, videoId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserControllerApi#addVideoToPlaylistUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | **String**| category |
 **videoId** | **String**| videoId |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="uploadUsingPOST"></a>
# **uploadUsingPOST**
> Map&lt;String, Object&gt; uploadUsingPOST()

Upload

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserControllerApi;


UserControllerApi apiInstance = new UserControllerApi();
try {
    Map<String, Object> result = apiInstance.uploadUsingPOST();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserControllerApi#uploadUsingPOST");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Map&lt;String, Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

