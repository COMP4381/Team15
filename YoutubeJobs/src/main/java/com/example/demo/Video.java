package com.example.demo;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Video Model Class", description = "This model represents a video object")
public class Video {
	String video_id;
	String title;
	String category;
	String description;
	String size;
	Date date_created;

	public Video() {

	}

	public Video(String video_id, String title, String category, String description, String size, Date date_created) {
		this.video_id = video_id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.size = size;
		this.date_created = date_created;
	}

	@ApiModelProperty(position=1,required=true,value="12345678")
	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	@ApiModelProperty(position=2,required=true,value="My work in java")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ApiModelProperty(position=3,required=true,value="programming")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@ApiModelProperty(position=4,required=true,value="helloo world :p")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ApiModelProperty(position=5,required=true,value="200mb")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@ApiModelProperty(position=1,required=true,value="2/12/2018")
	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

}
