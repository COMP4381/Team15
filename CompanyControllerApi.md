# CompanyControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllPlaylistsUsingGET**](CompanyControllerApi.md#getAllPlaylistsUsingGET) | **GET** /company/playlists | getAllPlaylists
[**getSpecificPlaylistUsingGET**](CompanyControllerApi.md#getSpecificPlaylistUsingGET) | **GET** /company/playlists/{category} | getSpecificPlaylist
[**getStudentInfoUsingGET**](CompanyControllerApi.md#getStudentInfoUsingGET) | **GET** /company/student/{id} | getStudentInfo
[**sendMessgeInGmailUsingGET**](CompanyControllerApi.md#sendMessgeInGmailUsingGET) | **GET** /company/sendMessage | sendMessgeInGmail


<a name="getAllPlaylistsUsingGET"></a>
# **getAllPlaylistsUsingGET**
> String getAllPlaylistsUsingGET()

getAllPlaylists

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CompanyControllerApi;


CompanyControllerApi apiInstance = new CompanyControllerApi();
try {
    String result = apiInstance.getAllPlaylistsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CompanyControllerApi#getAllPlaylistsUsingGET");
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

<a name="getSpecificPlaylistUsingGET"></a>
# **getSpecificPlaylistUsingGET**
> String getSpecificPlaylistUsingGET(category)

getSpecificPlaylist

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CompanyControllerApi;


CompanyControllerApi apiInstance = new CompanyControllerApi();
String category = "category_example"; // String | category
try {
    String result = apiInstance.getSpecificPlaylistUsingGET(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CompanyControllerApi#getSpecificPlaylistUsingGET");
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

<a name="getStudentInfoUsingGET"></a>
# **getStudentInfoUsingGET**
> getStudentInfoUsingGET(id)

getStudentInfo

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CompanyControllerApi;


CompanyControllerApi apiInstance = new CompanyControllerApi();
Integer id = 56; // Integer | id
try {
    apiInstance.getStudentInfoUsingGET(id);
} catch (ApiException e) {
    System.err.println("Exception when calling CompanyControllerApi#getStudentInfoUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="sendMessgeInGmailUsingGET"></a>
# **sendMessgeInGmailUsingGET**
> String sendMessgeInGmailUsingGET()

sendMessgeInGmail

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CompanyControllerApi;


CompanyControllerApi apiInstance = new CompanyControllerApi();
try {
    String result = apiInstance.sendMessgeInGmailUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CompanyControllerApi#sendMessgeInGmailUsingGET");
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

