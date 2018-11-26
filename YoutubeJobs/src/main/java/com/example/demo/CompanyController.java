package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Company")
public class CompanyController {
 ArrayList<Company> company =new ArrayList<Company>();
 
 @Autowired
 private VideosService service;


@RequestMapping(method = RequestMethod.GET,value = "/all")
public ResponseEntity<List<Student>> getAllVideos() {
 return new ResponseEntity<List<Student>>(service.getVideos(), HttpStatus.OK);
}


@RequestMapping(method = RequestMethod.GET, value = "/getVideo/{category}")
public ResponseEntity<Student> getVideo(@PathVariable String category) {
    return new ResponseEntity<Student>(service.getVideo(category),HttpStatus.OK);
}

}
