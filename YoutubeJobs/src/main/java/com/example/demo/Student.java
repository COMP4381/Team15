package com.example.demo;

public class Student {

	String id;
	String name;
	String videoURL;
	
	
	public Student() {
		
	}
	
	public Student(String id, String videoURL,String name) {
		super();
		this.id = id;
		this.name = name;
		this.videoURL=videoURL;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	
}
