 # JobsTube 


# Motivation

 Our problem domain is  educational , and the based solution for our SOA diagram is YouTube.
JobsTube Serves users either( undergraduate or graduated ) to find a special career or specified internship  according to their skills in their specialized domain. And Serves companies to find employees according to specified skills by watching their works in our service to see the real work for them which will help companies to select the desired ones for this opportunity  without read all coming CVs and make interviews for all of them and then just select one or two.

However using JobsTube will help them to reduce this time of reading , calling , interviews by just watching their short videos which is published via YouTube and then send the desired ones an email via Gmail to interview. 

We use YouTube and Gmail as third parties because they are easy to use, there are a good documentation for them and they will help to achieve our service in good manner.

so that JobsTube added some values like:

1-Find jobs for students/graduated in easy way.

2-Companies reach Applicants rapidly. 

3.companies know the real skills for the student and know exactly in which domain he will help them.

 
 # Service Design
 
## SOA Diagram
![soa](https://user-images.githubusercontent.com/44081110/49665057-584a4e00-fa5c-11e8-9942-cece18a6b337.jpeg)

The client is any PC or any mobile phone and the service is JobsTube service.

The composite service is JobsTube and the third-parties are: youtube and gmail.

## How to use JobsTube service in steps: 
1- Open JobsTube service.

2- Sign in to JobsTube sevice by gmail to get the authentication.

3- After request to log in JobsTube service the response return with JSON data representation.

4- JobsTube service let the user upload Video from youtube with JSON data representation. 

5- Share the video to the specific playlist in JobsTube service the data representation is JSON.

6- Companies open JobsTube service and search for specifies a category to watch videos.

7- JobsTube returns JSON data which is the required video.

8- Company contact with the user in JobsTube by getting its information from the service ( return JSON request from the JobsTube service).

9- Then the company sends to him an email from Gmail through JobsTube service.

10- JobsTube service send the mail to the user.







## BPMN
![jobstube](https://user-images.githubusercontent.com/32819463/49326530-2ae13a00-f55c-11e8-843f-435d2670b14a.png)

first of all we have 5 lanes in JobsTube BPMN, the first lane is the User lane because he will start the whole business process by sing in to JobsTube service (separate lane) using Gmail API (atomic service in separate lane) to get the authentication to log in into JobsTube service, then in JobsTube (separate lane) he will get the access to youtube atomic service  to upload his video  then he will get the garntee from Youtube to this video and then share it in a specific playlist in JobsTube service, then the turn comes to company (separete lane) to open JobsTube service and search for specific playlist, and start watching videos if the video, not the required one for the company then the company research in specified category and watch another video, but if the video is the reqired and acomplish all the reqirment which they looking for then  the company  will get the user information content which is in his channel and from the authentication on the JobsTube service, it will contact them by sending emails to them using Gmail API, and through JobsTube service the mail will send to the user and when the user receives the mail the business process will end.  

# Implementation Details
We impelemented our services using the RESTful service development paradigm. Which is based on the HTTP protocol which is an RPC-based synchronous communication protocol.

# Composite Service Algorithm According to BPMN 2.0

<img width="637" alt="jobtubecode" src="https://user-images.githubusercontent.com/32819463/50530516-1bc3bc80-0b07-11e9-9a32-89d9ac9981d8.PNG">


# Applied Technologies
 development environment STS
 
 programming languages JAVA.
 
 frameworks and libraries ( swagger 2.0, spring boot ).
 
 deployment platforms (PaaS):  Google App Engine (GAE), which is a Google Cloud Platform(GCP) service provided by Google.
 
 application server Apache tomcat server


# Documentation for API Endpoints
All URIs are relative to *https://localhost:8080*

# CompositeServiceControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addPlaylistUsingPOST**](JobsTubeControllerApi.md#addPlaylistUsingPOST) | **POST** /JobsTube/playlists/createPlaylist | addPlaylist
[**allPlaylistsUsingGET**](JobsTubeControllerApi.md#allPlaylistsUsingGET) | **GET** /JobsTube/playlists | AllPlaylists
[**deletePlaylistUsingDELETE**](JobsTubeControllerApi.md#deletePlaylistUsingDELETE) | **DELETE** /JobsTube/playlists/delete/{category} | deletePlaylist

# Atomic Controllers
# UserControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addVideoToPlaylistUsingPOST**](UserControllerApi.md#addVideoToPlaylistUsingPOST) | **POST** /Users/playlists/{category}/{videoId} | addVideoToPlaylist
[**uploadUsingPOST**](UserControllerApi.md#uploadUsingPOST) | **POST** /Users/upload | Upload

# CompanyControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUserInfoUsingGET**](CompanyControllerApi.md#getUserInfoUsingGET) | **GET** /company/userInformation | getUserInfo
[**searchForSpecificPlaylistUsingGET**](CompanyControllerApi.md#searchForSpecificPlaylistUsingGET) | **GET** /company/playlists/{category} | searchForSpecificPlaylist
[**sendMessageUsingPOST**](CompanyControllerApi.md#sendMessageUsingPOST) | **POST** /company/sendMessage | sendMessage

## Documentation for Models
 1- [UserModel](https://github.com/COMP4381/Team15/blob/master/User.md)
 
 2- [CompanyModel](https://github.com/COMP4381/Team15/blob/master/Company.md)
 
# Documentation for Authorization
Gmail and YouTube Require Authorization

# Author
 Majed Nuseibeh: 1152595@student.birzeit.edu
 
 Darin Jojas : 1152901@student.birzeit.edu
 
 Dina Natsheh : dinaayoubnatsheh@gmail.com
     
