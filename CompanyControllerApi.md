# CompanyControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUserInfoUsingGET**](CompanyControllerApi.md#getUserInfoUsingGET) | **GET** /company/userInformation | getUserInfo
[**searchForSpecificPlaylistUsingGET**](CompanyControllerApi.md#searchForSpecificPlaylistUsingGET) | **GET** /company/playlists/{category} | searchForSpecificPlaylist
[**sendMessageUsingPOST**](CompanyControllerApi.md#sendMessageUsingPOST) | **POST** /company/sendMessage | sendMessage


<a name="getUserInfoUsingGET"></a>
# **getUserInfoUsingGET**
> UserModelClass getUserInfoUsingGET()

getUserInfo

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CompanyControllerApi;


CompanyControllerApi apiInstance = new CompanyControllerApi();
try {
    UserModelClass result = apiInstance.getUserInfoUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CompanyControllerApi#getUserInfoUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UserModelClass**](UserModelClass.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="searchForSpecificPlaylistUsingGET"></a>
# **searchForSpecificPlaylistUsingGET**
> List&lt;PlaylistItem&gt; searchForSpecificPlaylistUsingGET(category)

searchForSpecificPlaylist

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CompanyControllerApi;


CompanyControllerApi apiInstance = new CompanyControllerApi();
String category = "category_example"; // String | category
try {
    List<PlaylistItem> result = apiInstance.searchForSpecificPlaylistUsingGET(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CompanyControllerApi#searchForSpecificPlaylistUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | **String**| category |

### Return type

[**List&lt;PlaylistItem&gt;**](PlaylistItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="sendMessageUsingPOST"></a>
# **sendMessageUsingPOST**
> String sendMessageUsingPOST(bodyText)

sendMessage

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CompanyControllerApi;


CompanyControllerApi apiInstance = new CompanyControllerApi();
String bodyText = "bodyText_example"; // String | bodyText
try {
    String result = apiInstance.sendMessageUsingPOST(bodyText);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CompanyControllerApi#sendMessageUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bodyText** | **String**| bodyText |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

