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

	ArrayList<Student> students =new ArrayList<Student>();
	
	 @Autowired
	    private VideosService service;
	
	
	@RequestMapping(method = RequestMethod.GET,value = "/all")
    public ResponseEntity<List<Student>> getAllVideos() {
        return new ResponseEntity<List<Student>>(service.getVideos(), HttpStatus.OK);
    }

//	@RequestMapping(method=RequestMethod.GET,value="/{id}")
//	Student getVideo(String id) {
//		for(Student i:students) {
//			if(i.getId()==id)
//				return i;
//		}
//		return null;
//	}
	
	@RequestMapping(method=RequestMethod.POST)
	String addVideo(@RequestBody Student v) {
		students.add(v);
		return "video added successfully";
	
}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public boolean deleteVideo(@PathVariable String id) {
        return service.remove(id);
    }
	
//	@RequestMapping(method=RequestMethod.GET)
//	ArrayList<Student> getVideosURLs(){
//		return videos;
//	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getVideo/{id}")
    public ResponseEntity<Student> getVideo(@PathVariable String id) {
        return new ResponseEntity<Student>(service.getVideo(id),HttpStatus.OK);
    }

}
