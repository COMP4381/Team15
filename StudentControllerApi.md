# StudentControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addVideoUsingPOST**](StudentControllerApi.md#addVideoUsingPOST) | **POST** /students | addVideo
[**deleteVideoUsingDELETE**](StudentControllerApi.md#deleteVideoUsingDELETE) | **DELETE** /students/delete/{id} | deleteVideo
[**getAllVideosUsingGET**](StudentControllerApi.md#getAllVideosUsingGET) | **GET** /students/all | getAllVideos
[**getVideoUsingGET**](StudentControllerApi.md#getVideoUsingGET) | **GET** /students/getVideo/{id} | getVideo


<a name="addVideoUsingPOST"></a>
# **addVideoUsingPOST**
> String addVideoUsingPOST(v)

addVideo

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentControllerApi;


StudentControllerApi apiInstance = new StudentControllerApi();
Student v = new Student(); // Student | v
try {
    String result = apiInstance.addVideoUsingPOST(v);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentControllerApi#addVideoUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **v** | [**Student**](Student.md)| v |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteVideoUsingDELETE"></a>
# **deleteVideoUsingDELETE**
> Boolean deleteVideoUsingDELETE(id)

deleteVideo

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentControllerApi;


StudentControllerApi apiInstance = new StudentControllerApi();
String id = "id_example"; // String | id
try {
    Boolean result = apiInstance.deleteVideoUsingDELETE(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentControllerApi#deleteVideoUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id |

### Return type

**Boolean**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getAllVideosUsingGET"></a>
# **getAllVideosUsingGET**
> List&lt;Student&gt; getAllVideosUsingGET()

getAllVideos

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentControllerApi;


StudentControllerApi apiInstance = new StudentControllerApi();
try {
    List<Student> result = apiInstance.getAllVideosUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentControllerApi#getAllVideosUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Student&gt;**](Student.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getVideoUsingGET"></a>
# **getVideoUsingGET**
> Student getVideoUsingGET(id)

getVideo

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentControllerApi;


StudentControllerApi apiInstance = new StudentControllerApi();
String id = "id_example"; // String | id
try {
    Student result = apiInstance.getVideoUsingGET(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentControllerApi#getVideoUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id |

### Return type

[**Student**](Student.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

