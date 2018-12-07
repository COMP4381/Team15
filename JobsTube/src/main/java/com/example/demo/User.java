package com.example.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="User Model Class", description="This model represents a student or user object that consists of id, name and videoURL")
public class User {

	String id;
	String name;
	String videoURL;

	public User() {

	}

	public User(String id, String videoURL, String name) {
		this.id = id;
		this.name = name;
		this.videoURL = videoURL;
	}
	
	@ApiModelProperty(position=1, required=true,value="133")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@ApiModelProperty(position=2, required=true,value="Majed")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ApiModelProperty(position=3, required=true,value="http://videos.com/video1")
	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

}
