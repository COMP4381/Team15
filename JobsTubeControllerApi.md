# JobsTubeControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addPlaylistUsingPOST**](JobsTubeControllerApi.md#addPlaylistUsingPOST) | **POST** /JobsTube/playlists/createPlaylist | addPlaylist
[**allPlaylistsUsingGET**](JobsTubeControllerApi.md#allPlaylistsUsingGET) | **GET** /JobsTube/playlists | AllPlaylists
[**deletePlaylistUsingDELETE**](JobsTubeControllerApi.md#deletePlaylistUsingDELETE) | **DELETE** /JobsTube/playlists/delete/{category} | deletePlaylist


<a name="addPlaylistUsingPOST"></a>
# **addPlaylistUsingPOST**
> String addPlaylistUsingPOST(playlistName)

addPlaylist

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JobsTubeControllerApi;


JobsTubeControllerApi apiInstance = new JobsTubeControllerApi();
String playlistName = "playlistName_example"; // String | PlaylistName
try {
    String result = apiInstance.addPlaylistUsingPOST(playlistName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobsTubeControllerApi#addPlaylistUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **playlistName** | **String**| PlaylistName |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="allPlaylistsUsingGET"></a>
# **allPlaylistsUsingGET**
> String allPlaylistsUsingGET()

AllPlaylists

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JobsTubeControllerApi;


JobsTubeControllerApi apiInstance = new JobsTubeControllerApi();
try {
    String result = apiInstance.allPlaylistsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobsTubeControllerApi#allPlaylistsUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deletePlaylistUsingDELETE"></a>
# **deletePlaylistUsingDELETE**
> String deletePlaylistUsingDELETE(category)

deletePlaylist

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.JobsTubeControllerApi;


JobsTubeControllerApi apiInstance = new JobsTubeControllerApi();
String category = "category_example"; // String | category
try {
    String result = apiInstance.deletePlaylistUsingDELETE(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JobsTubeControllerApi#deletePlaylistUsingDELETE");
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

