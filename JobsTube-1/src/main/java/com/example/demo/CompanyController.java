package com.example.demo;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.gmail.model.Message;
import com.google.api.services.youtube.model.Playlist;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.PlaylistListResponse;

import models.Company;
//import models.Video;

@RestController
@RequestMapping("/Company")
public class CompanyController {
	ArrayList<Company> company = new ArrayList<Company>();
	ArrayList<Playlist> playlists;

	@Autowired
	private JobsTubeController service;

	/*
	 * This method calls sendMessageUsingPOST from jobsTube controller to send
	 * message to the students information
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sendMessage")
	String sendMessgeInGmail() throws GeneralSecurityException, IOException, MessagingException {

		String to = "farahnusseibeh@hotmail.com";
		String from = "xalp266@gmail.com";
		String subject = "Hello";
		String bodyText = "This message sent using gmail api";
		Message m = service.sendMessageUsingPOST(to, from, subject, bodyText);
		return m.toPrettyString();
	}

	/*
	 * This method calls getUserInfoUsingGET from jobstube controller to get student
	 * info.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/student/{id}")
	public void getStudentInfo(@PathVariable int id) { // needs some modifications
		service.getUserInfoUsingGET(id);
	}

	/*
	 * This method calls from jobsTube service search method to search for specific
	 * category
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/playlists/{category}")
	public String searchForSpecificPlaylist(@PathVariable String category) throws IOException {
		getAllPlaylistsfor();
		String playlistId = null;
		for (int i = 0; i < playlists.size(); i++) {
			if (category.equals(playlists.get(i).getSnippet().getTitle())) {
				playlistId = playlists.get(i).getId();
				System.out.println(playlistId);
			}
		}
		PlaylistItemListResponse response = service.getAllVideoInCategoryUsingGET(category, playlistId);
		return response.getItems().toString();

	}

	private void getAllPlaylistsfor() throws IOException {
		PlaylistListResponse response = service.getAllPlaylists();
		playlists = (ArrayList<Playlist>) response.getItems();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/playlists")
	public String getAllPlaylists() throws IOException {
		PlaylistListResponse response = service.getAllPlaylists();
		playlists = (ArrayList<Playlist>) response.getItems();
		return response.toPrettyString();

	}

}
