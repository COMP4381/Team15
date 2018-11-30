# CompanyControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllVideosUsingGET**](CompanyControllerApi.md#getAllVideosUsingGET) | **GET** /company/getAllVideos/all | getAllVideos
[**getCompanyUsingGET**](CompanyControllerApi.md#getCompanyUsingGET) | **GET** /company/getName/{employment} | getCompany


<a name="getAllVideosUsingGET"></a>
# **getAllVideosUsingGET**
> List&lt;VideoModelClass&gt; getAllVideosUsingGET()

getAllVideos

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CompanyControllerApi;


CompanyControllerApi apiInstance = new CompanyControllerApi();
try {
    List<VideoModelClass> result = apiInstance.getAllVideosUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CompanyControllerApi#getAllVideosUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;VideoModelClass&gt;**](VideoModelClass.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getCompanyUsingGET"></a>
# **getCompanyUsingGET**
> Company getCompanyUsingGET(employment)

getCompany

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CompanyControllerApi;


CompanyControllerApi apiInstance = new CompanyControllerApi();
String employment = "employment_example"; // String | employment
try {
    Company result = apiInstance.getCompanyUsingGET(employment);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CompanyControllerApi#getCompanyUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **employment** | **String**| employment |

### Return type

[**Company**](Company.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

