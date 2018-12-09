package com.example.demo;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.youtube.model.Playlist;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.PlaylistListResponse;

@RestController
@RequestMapping("/company")
public class CompanyController {
	ArrayList<Company> company = new ArrayList<Company>();
	ArrayList<Playlist> playlists;

	@Autowired
	private JobsTubeController service;
	

	@RequestMapping(method = RequestMethod.GET, value = "/playlists/{category}")
	public ResponseEntity<List<PlaylistItem>> searchForSpecificPlaylist(@PathVariable String category) throws IOException {
		getAllPlaylistsfor();
		String playlistId = null;
		for (int i = 0; i < playlists.size(); i++) {
			if (category.equals(playlists.get(i).getSnippet().getTitle())) {
				playlistId = playlists.get(i).getId();
				System.out.println(playlistId);
			}
		}
	//	PlaylistItemListResponse response = service.getAllVideoInCategoryUsingGET( playlistId);
		return new ResponseEntity<List<PlaylistItem>>(service.getAllVideoInCategoryUsingGET( playlistId).getItems(),HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/userInformation")
	public ResponseEntity<User> getUserInfo() {
        return new ResponseEntity<User>(service.getUserInfo(),HttpStatus.OK);

	} 

	@RequestMapping(method = RequestMethod.POST, value = "/sendMessage")
	public HttpEntity<String> sendMessage(@RequestBody String bodyText) throws GeneralSecurityException, IOException, MessagingException {
		String to = "dinaayoubnatsheh@gmail.com";
		String from = "xalp266@gmail.com";
		String subject = "Hello";
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, GmailQuickstart.JSON_FACTORY,
				GmailQuickstart.getCredentials(HTTP_TRANSPORT)).setApplicationName(GmailQuickstart.APPLICATION_NAME)
						.build();

		String userId = "me";
		MimeMessage m = GmailQuickstart.createEmail(to, from, subject, bodyText);
		Message content = GmailQuickstart.createMessageWithEmail(m);
		HttpResponse mess = service.users().messages().send(userId, content).executeUnparsed();
		return new ResponseEntity<String>(content.toPrettyString(), HttpStatus.OK);
	}

	private void getAllPlaylistsfor() throws IOException {
		PlaylistListResponse response = service.getAllPlaylists();
		playlists = (ArrayList<Playlist>) response.getItems();

	}


}
