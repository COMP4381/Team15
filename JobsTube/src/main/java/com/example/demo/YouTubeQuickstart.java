package com.example.demo;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import com.google.api.services.youtube.YouTubeScopes;
import com.google.api.services.youtube.model.*;
import com.google.api.services.youtube.YouTube;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class YouTubeQuickstart {

	/** Application name. */
	private static final String APPLICATION_NAME = "API Sample";

	/** Directory to store user credentials for this application. */
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"),
			".credentials/youtube-java-quickstart");

	/** Global instance of the {@link FileDataStoreFactory}. */
	private static FileDataStoreFactory DATA_STORE_FACTORY;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	/**
	 * Global instance of the scopes required by this quickstart.
	 *
	 * If modifying these scopes, delete your previously saved credentials at
	 * ~/.credentials/drive-java-quickstart
	 */
	private static final List<String> SCOPES = Arrays.asList(YouTubeScopes.YOUTUBE);

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Create an authorized Credential object.
	 * 
	 * @return an authorized Credential object.
	 * @throws IOException
	 */
	public static Credential authorize() throws IOException {
		// Load client secrets.
		InputStream in = YouTubeQuickstart.class.getResourceAsStream("/credentials.json");
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES).setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();
		Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
		return credential;
	}

	/**
	 * Build and return an authorized API client service, such as a YouTube Data API
	 * client service.
	 * 
	 * @return an authorized API client service
	 * @throws IOException
	 */
	public static YouTube getYouTubeService() {
		Credential credential = null;
		try {
			credential = authorize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME)
				.build();
	}
	 public static Playlist insertPlaylist(String category,YouTube youtube) throws IOException {

        // This code constructs the playlist resource that is being inserted.
        // It defines the playlist's title, description, and privacy status.
        PlaylistSnippet playlistSnippet = new PlaylistSnippet();
        playlistSnippet.setTitle(category);
        playlistSnippet.setDescription("A public playlist created with the YouTube API v3");
        PlaylistStatus playlistStatus = new PlaylistStatus();
        playlistStatus.setPrivacyStatus("public");

        Playlist youTubePlaylist = new Playlist();
        youTubePlaylist.setSnippet(playlistSnippet);
        youTubePlaylist.setStatus(playlistStatus);

        // Call the API to insert the new playlist. In the API call, the first
        // argument identifies the resource parts that the API response should
        // contain, and the second argument is the playlist being inserted.
        YouTube.Playlists.Insert playlistInsertCommand =
                youtube.playlists().insert("snippet,status", youTubePlaylist);
        Playlist playlistInserted = playlistInsertCommand.execute();

        // Print data from the API response and return the new playlist's
        // unique playlist ID.
        System.out.println("New Playlist name: " + playlistInserted.getSnippet().getTitle());
        System.out.println(" - Privacy: " + playlistInserted.getStatus().getPrivacyStatus());
        System.out.println(" - Description: " + playlistInserted.getSnippet().getDescription());
        System.out.println(" - Posted: " + playlistInserted.getSnippet().getPublishedAt());
        System.out.println(" - Channel: " + playlistInserted.getSnippet().getChannelId() + "\n");
        return playlistInserted;

    }
	 
	 
	 public static PlaylistItem insertPlaylistItem(String playlistId, String videoId,YouTube youtube) throws IOException {

	        // Define a resourceId that identifies the video being added to the
	        // playlist.
	        ResourceId resourceId = new ResourceId();
	        resourceId.setKind("youtube#video");
	        resourceId.setVideoId(videoId);

	        // Set fields included in the playlistItem resource's "snippet" part.
	        PlaylistItemSnippet playlistItemSnippet = new PlaylistItemSnippet();
	        playlistItemSnippet.setTitle("Anything");
	        playlistItemSnippet.setPlaylistId(playlistId);
	        playlistItemSnippet.setResourceId(resourceId);

	        // Create the playlistItem resource and set its snippet to the
	        // object created above.
	        PlaylistItem playlistItem = new PlaylistItem();
	        playlistItem.setSnippet(playlistItemSnippet);

	        // Call the API to add the playlist item to the specified playlist.
	        // In the API call, the first argument identifies the resource parts
	        // that the API response should contain, and the second argument is
	        // the playlist item being inserted.
	        YouTube.PlaylistItems.Insert playlistItemsInsertCommand =
	                youtube.playlistItems().insert("snippet,contentDetails", playlistItem);
	        PlaylistItem returnedPlaylistItem = playlistItemsInsertCommand.execute();

	        // Print data from the API response and return the new playlist
	        // item's unique playlistItem ID.

	        System.out.println("New PlaylistItem name: " + returnedPlaylistItem.getSnippet().getTitle());
	        System.out.println(" - Video id: " + returnedPlaylistItem.getSnippet().getResourceId().getVideoId());
	        System.out.println(" - Posted: " + returnedPlaylistItem.getSnippet().getPublishedAt());
	        System.out.println(" - Channel: " + returnedPlaylistItem.getSnippet().getChannelId());
	        return returnedPlaylistItem;

	    }
	 
	 

//	public static void main(String[] args) throws IOException {
//		YouTube youtube = getYouTubeService();
//		
////		youtube.videos().insert(part, content);
//		
//		try {
//			YouTube.Channels.List channelsListByUsernameRequest = youtube.channels()
//					.list("snippet,contentDetails,statistics");
//			channelsListByUsernameRequest.setForUsername("GoogleDevelopers");
//
//			ChannelListResponse response = channelsListByUsernameRequest.execute();
//			Channel channel = response.getItems().get(0);
//			System.out.printf("This channel's ID is %s. Its title is '%s', and it has %s views.\n", channel.getId(),
//					channel.getSnippet().getTitle(), channel.getStatistics().getViewCount());
//		} catch (GoogleJsonResponseException e) {
//			e.printStackTrace();
//			System.err.println(
//					"There was a service error: " + e.getDetails().getCode() + " : " + e.getDetails().getMessage());
//		} catch (Throwable t) {
//			t.printStackTrace();
//		}
//	}
}