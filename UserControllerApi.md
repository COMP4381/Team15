# UserControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**uploadVideoUsingGET**](UserControllerApi.md#uploadVideoUsingGET) | **GET** /users/user/upload | uploadVideo


<a name="uploadVideoUsingGET"></a>
# **uploadVideoUsingGET**
> String uploadVideoUsingGET()

uploadVideo

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserControllerApi;


UserControllerApi apiInstance = new UserControllerApi();
try {
    String result = apiInstance.uploadVideoUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserControllerApi#uploadVideoUsingGET");
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

