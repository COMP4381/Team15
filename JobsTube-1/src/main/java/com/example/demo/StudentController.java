package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

	ArrayList<Student> students = new ArrayList<Student>();

	@Autowired
	private JobsTubeController service = new JobsTubeController();

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public ResponseEntity<List<Student>> getAllVideos() {
		return new ResponseEntity<List<Student>>(service.getVideos(), HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.POST)
	String addVideo(@RequestBody Student v) {
		students.add(v);
		return "video added successfully";

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public boolean deleteVideo(@PathVariable String id) {
		return service.remove(id);
//		return false;
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/getVideo/{id}")
//	public ResponseEntity<Student> getVideo(@PathVariable String id) {
//		return new ResponseEntity<Student>(service.getVideos(), HttpStatus.OK);
////		return null;
//	}
	
	
	
	/*
	 * This method allows the Student to add his uploaded video in our channel
	 * by calling the the method from Jobstube controller
	 * 
	 */
	public void insertInPlaylist() {
		Video v = new Video();
		service.addPlaylistItemUsingPOST(v);
	}
	
	
	

}
