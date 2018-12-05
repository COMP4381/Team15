package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

@Service
@RestController
@RequestMapping("/JobsTube")
public class JobsTubeController {

	List<Student> videos = Arrays.asList(new Student("1", "http://videos.com/video1", "Darin"),
			new Student("2", "http://videos.com/video2", "Dina"), new Student("3", "http://videos.com/video3", "Majed")

	);

	public List<Student> getVideos() {
		return videos;
	}

	public void addVideo(Student vi) {
		videos.add(vi);
	}

	public boolean remove(String id) {
		for (int i = 0; i < videos.size(); i++) {
			if (videos.get(i).getId().equals(id)) {
				videos.remove(i);
				return true;
			}
		}
		return false;
	}
//
//	public Student getVideo(String id) {
//		// TODO Auto-generated method stub
//		return videos.stream().filter(T -> T.getId().equals(id)).findFirst().get();
//	}

	/*
	 * This method is used to insert student's uploaded video into service playlist
	 * in youtube using youtube data api used by student controller
	 * 
	 * Using POST method
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/playlists/addVideo/{}") // value needs to be fixed
	public void addPlaylistItemUsingPOST(Video v) {

	}

	/*
	 * This method is used to delete Student's Video from the playlist in youtube
	 * used by student controller
	 *
	 * Using DELETE method
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/playlists/addVideo/{}") // value needs to be fixed
	public void deletePlaylistItemUsingDELETE() {

	}

	/*
	 * This method allows admin to insert a new playlist to JobsTube Channel in
	 * youtube as a new Category for employment
	 * 
	 * Using POST method
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/playlist/{}")
	public void addPlaylistUsingPOST(String name) {

	}

	/*
	 * This method search for specific category (category=playlist) in youtube
	 * channel and returns all recent videos in that specific category
	 * 
	 * Using GET method
	 * 
	 * for company to search, used by company controller
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/playlist/search") // value needs to be fixed
	public void getAllVideoInCategoryUsingGET(String Category) throws IOException {
		
		YouTube youtube = YouTubeQuickstart.getYouTubeService();
	    try {
	        HashMap<String, String> parameters = new HashMap<>();
	        parameters.put("part", "snippet,contentDetails");
	        parameters.put("maxResults", "25");
	        parameters.put("playlistId", "PLBCF2DAC6FFB574DE");

	        YouTube.PlaylistItems.List playlistItemsListByPlaylistIdRequest = youtube.playlistItems().list(parameters.get("part").toString());
	        if (parameters.containsKey("maxResults")) {
	            playlistItemsListByPlaylistIdRequest.setMaxResults(Long.parseLong(parameters.get("maxResults").toString()));
	        }

	        if (parameters.containsKey("playlistId") && parameters.get("playlistId") != "") {
	            playlistItemsListByPlaylistIdRequest.setPlaylistId(parameters.get("playlistId").toString());
	        }

	        PlaylistItemListResponse response = playlistItemsListByPlaylistIdRequest.execute();
	        System.out.println(response);
	    }catch(Exception e) {
	    	
	    }
	}

	/*
	 * This method grabs Student's information from google or youtube account used
	 * by company controller
	 * 
	 * Using GET method
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/playlist/{}") // value need to be fixed
	public void getUserInfoUsingGET(String id) {

	}

	/*
	 * This method sends a message to the student after getting his information by
	 * gmail.
	 * 
	 * Using POST method
	 */
	public Message sendMessageUsingPOST(String to, String from, String subject, String bodyText)
			throws GeneralSecurityException, IOException, MessagingException {
		// Build a new authorized API client service.
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, GmailQuickstart.JSON_FACTORY,
				GmailQuickstart.getCredentials(HTTP_TRANSPORT)).setApplicationName(GmailQuickstart.APPLICATION_NAME)
						.build();

		String userId = "me";
		MimeMessage m = GmailQuickstart.createEmail(to, from, subject, bodyText);
		Message content = GmailQuickstart.createMessageWithEmail(m);
//    
		Message mess = service.users().messages().send(userId, content).execute();
		return mess;
	}

}
