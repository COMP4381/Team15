package com.example.demo;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.gmail.model.Message;

@RestController
@RequestMapping("/Company")
public class CompanyController {
	ArrayList<Company> company = new ArrayList<Company>();

	@Autowired
	private JobsTubeController service;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public ResponseEntity<List<Student>> getAllVideos() {
		return new ResponseEntity<List<Student>>(service.getVideos(), HttpStatus.OK);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/getVideo/{category}")
//	public ResponseEntity<Student> getVideo(@PathVariable String category) {
//		return new ResponseEntity<Student>(service.getVideo(category), HttpStatus.OK);
//	}

	/*
	 * This method calls sendMessageUsingPOST from jobsTube controller to send
	 * message to the students information
	 */
	public void sendMessgeInGmail() throws GeneralSecurityException, IOException, MessagingException {

		String to = "";
		String from = "";
		String subject = "";
		String bodyText = "";
		Message m = service.sendMessageUsingPOST(to, from, subject, bodyText);
		System.out.println("Message id: " + m.getId());
		System.out.println(m.toPrettyString());
	}

	/*
	 * This method calls getUserInfoUsingGET from jobstube controller to get 
	 * student info.
	 */
	public void getStudentInfo() { //needs some modifications
		String id="";
		service.getUserInfoUsingGET(id);
	}

}
