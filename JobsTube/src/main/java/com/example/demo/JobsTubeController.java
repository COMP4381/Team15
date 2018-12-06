package com.example.demo;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Playlist;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.PlaylistItemSnippet;
import com.google.api.services.youtube.model.PlaylistListResponse;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatus;
import com.google.common.collect.Lists;

@Service
@RestController
@RequestMapping("/JobsTube")
public class JobsTubeController {

	static YouTube youtube = YouTubeQuickstart.getYouTubeService();
	static Gmail gmail;

	/*
	 * This method is used to insert student's uploaded video into service playlist
	 * in youtube using youtube data api used by student controller
	 * 
	 * Using POST method
	 */

//	public PlaylistItem addPlaylistItemUsingPOST(String category,String video) throws IOException {
//		youtube = YouTubeQuickstart.getYouTubeService();
//		PlaylistItem response = null;
//		try {
//			HashMap<String, String> parameters = new HashMap<>();
//			parameters.put("part", "snippet");
//			parameters.put("onBehalfOfContentOwner", "");
//
//			PlaylistItem playlistItem = new PlaylistItem();
//			PlaylistItemSnippet snippet = new PlaylistItemSnippet();
//			ResourceId resourceId = new ResourceId();
//			resourceId.set("kind", video.getKind());// "youtube#video"
//			resourceId.set("videoId", video.getId());// "M7FIvfx5J10"
//
//			snippet.setResourceId(resourceId);
//			playlistItem.setSnippet(snippet);
//
//			YouTube.PlaylistItems.Insert playlistItemsInsertRequest = youtube.playlistItems()
//					.insert(parameters.get("part").toString(), playlistItem);
//
//			if (parameters.containsKey("onBehalfOfContentOwner") && parameters.get("onBehalfOfContentOwner") != "") {
//				playlistItemsInsertRequest
//						.setOnBehalfOfContentOwner(parameters.get("onBehalfOfContentOwner").toString());
//			}
//
//			response = playlistItemsInsertRequest.execute();
//			System.out.println(response);
//		} finally {
//
//		}
//		return response;
//	}
	
	public PlaylistItem addVideoToPlaylist(String category,String videoId) throws IOException {
		PlaylistListResponse response = getAllPlaylists();
		List<Playlist> playlists = response.getItems();
		
		String playlistId=null;
		for(int i =0;i<playlists.size();i++) {
			if(category.equals(playlists.get(i).getSnippet().getTitle())) {
				playlistId=playlists.get(i).getId();
				System.out.println(playlistId);
			}
		}
		PlaylistItem response2 = YouTubeQuickstart.insertPlaylistItem(playlistId, videoId, youtube);
		return response2;
		
	}

	/*
	 * This method is used to delete Student's Video from the playlist in youtube
	 * used by student controller
	 *
	 * Using DELETE method
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/playlists/delete/{name}") // value needs to be fixed
	public void deletePlaylistItemUsingDELETE() {
		
	}

	/*
	 * This method allows admin to insert a new playlist to JobsTube Channel in
	 * youtube as a new Category for employment
	 * 
	 * Using POST method
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/playlists/create/{name}")
	public String addPlaylistUsingPOST(@PathVariable String name) throws IOException {
		Playlist response = YouTubeQuickstart.insertPlaylist(name, youtube);
		return response.toPrettyString();
	}

	/*
	 * This method search for specific category (category=playlist) in youtube
	 * channel and returns all recent videos in that specific category
	 * 
	 * Using GET method
	 * 
	 * for company to search, used by company controller
	 */
	public PlaylistItemListResponse getAllVideoInCategoryUsingGET(String Category, String playlistId)
			throws IOException {

		PlaylistItemListResponse response = null;
		try {
			HashMap<String, String> parameters = new HashMap<>();
			parameters.put("part", "snippet,contentDetails");
			parameters.put("maxResults", "25");
			parameters.put("playlistId", playlistId);

			YouTube.PlaylistItems.List playlistItemsListByPlaylistIdRequest = youtube.playlistItems()
					.list(parameters.get("part").toString());
			if (parameters.containsKey("maxResults")) {
				playlistItemsListByPlaylistIdRequest
						.setMaxResults(Long.parseLong(parameters.get("maxResults").toString()));
			}

			if (parameters.containsKey("playlistId") && parameters.get("playlistId") != "") {
				playlistItemsListByPlaylistIdRequest.setPlaylistId(parameters.get("playlistId").toString());
			}

			response = playlistItemsListByPlaylistIdRequest.execute();
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/*
	 * This method grabs Student's information from google or youtube account used
	 * by company controller
	 * 
	 * Using GET method
	 */
	public void getUserInfoUsingGET(int id) {

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

	public Video uploadVideoUsingPOST() {

		List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.upload");
		Video returnedVideo = null;
		try {
			// Authorize the request.
			Credential credential = Auth.authorize(scopes, "uploadvideo");
//            Credential credential = Auth.authorize(scopes, "/credentials.json");

			// This object is used to make YouTube Data API requests.
			youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
					.setApplicationName("majed").build();

			System.out.println("Uploading: " + UploadVideo.SAMPLE_VIDEO_FILENAME);

			// Add extra information to the video before uploading.
			Video videoObjectDefiningMetadata = new Video();

			// Set the video to be publicly visible. This is the default
			// setting. Other supporting settings are "unlisted" and "private."
			VideoStatus status = new VideoStatus();
			status.setPrivacyStatus("public");
			videoObjectDefiningMetadata.setStatus(status);

			// Most of the video's metadata is set on the VideoSnippet object.
			VideoSnippet snippet = new VideoSnippet();

			// This code uses a Calendar instance to create a unique name and
			// description for test purposes so that you can easily upload
			// multiple files. You should remove this code from your project
			// and use your own standard names instead.
			Calendar cal = Calendar.getInstance();
			snippet.setTitle("Test Upload via Java on " + cal.getTime());
			snippet.setDescription(
					"Video uploaded via YouTube Data API V3 using the Java library " + "on " + cal.getTime());

			// Set the keyword tags that you want to associate with the video.
			List<String> tags = new ArrayList<String>();
			tags.add("test");
			tags.add("example");
			tags.add("java");
			tags.add("YouTube Data API V3");
			tags.add("erase me");
			snippet.setTags(tags);

			// Add the completed snippet object to the video resource.
			videoObjectDefiningMetadata.setSnippet(snippet);

			InputStreamContent mediaContent = new InputStreamContent(UploadVideo.VIDEO_FILE_FORMAT,
					UploadVideo.class.getResourceAsStream("/sample2.mp4"));

			// Insert the video. The command sends three arguments. The first
			// specifies which information the API request is setting and which
			// information the API response should return. The second argument
			// is the video resource that contains metadata about the new video.
			// The third argument is the actual video content.
			YouTube.Videos.Insert videoInsert = youtube.videos().insert("snippet,statistics,status",
					videoObjectDefiningMetadata, mediaContent);

			// Set the upload type and add an event listener.
			MediaHttpUploader uploader = videoInsert.getMediaHttpUploader();

			// Indicate whether direct media upload is enabled. A value of
			// "True" indicates that direct media upload is enabled and that
			// the entire media content will be uploaded in a single request.
			// A value of "False," which is the default, indicates that the
			// request will use the resumable media upload protocol, which
			// supports the ability to resume an upload operation after a
			// network interruption or other transmission failure, saving
			// time and bandwidth in the event of network failures.
			uploader.setDirectUploadEnabled(false);

			MediaHttpUploaderProgressListener progressListener = new MediaHttpUploaderProgressListener() {
				public void progressChanged(MediaHttpUploader uploader) throws IOException {
					switch (uploader.getUploadState()) {
					case INITIATION_STARTED:
						System.out.println("Initiation Started");
						break;
					case INITIATION_COMPLETE:
						System.out.println("Initiation Completed");
						break;
					case MEDIA_IN_PROGRESS:
						System.out.println("Upload in progress");
						System.out.println("Upload percentage: " + uploader.getProgress());
						break;
					case MEDIA_COMPLETE:
						System.out.println("Upload Completed!");
						break;
					case NOT_STARTED:
						System.out.println("Upload Not Started!");
						break;
					}
				}
			};
			uploader.setProgressListener(progressListener);

			// Call the API and upload the video.
			returnedVideo = videoInsert.execute();

			// Print data about the newly inserted video from the API response.
			System.out.println("\n================== Returned Video ==================\n");
			System.out.println("  - Id: " + returnedVideo.getId());
			System.out.println("  - Title: " + returnedVideo.getSnippet().getTitle());
			System.out.println("  - Tags: " + returnedVideo.getSnippet().getTags());
			System.out.println("  - Privacy Status: " + returnedVideo.getStatus().getPrivacyStatus());
			System.out.println("  - Video Count: " + returnedVideo.getStatistics().getViewCount());

		} catch (GoogleJsonResponseException e) {
			System.err.println("GoogleJsonResponseException code: " + e.getDetails().getCode() + " : "
					+ e.getDetails().getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
			e.printStackTrace();
		} catch (Throwable t) {
			System.err.println("Throwable: " + t.getMessage());
			t.printStackTrace();
		}
		return returnedVideo;
	}

	public PlaylistListResponse getAllPlaylists() throws IOException {
		PlaylistListResponse response = null;
		try {
			HashMap<String, String> parameters = new HashMap<>();
			parameters.put("part", "snippet,contentDetails");
			parameters.put("channelId", "UCXGTCb9uzTVEqJD44mXEDxQ");// channel id = UCXGTCb9uzTVEqJD44mXEDxQ
			parameters.put("maxResults", "25");

			YouTube.Playlists.List playlistsListByChannelIdRequest = youtube.playlists()
					.list(parameters.get("part").toString());
			if (parameters.containsKey("channelId") && parameters.get("channelId") != "") {
				playlistsListByChannelIdRequest.setChannelId(parameters.get("channelId").toString());
			}

			if (parameters.containsKey("maxResults")) {
				playlistsListByChannelIdRequest.setMaxResults(Long.parseLong(parameters.get("maxResults").toString()));
			}

			response = playlistsListByChannelIdRequest.execute();
			System.out.println(response);
		} finally {

		}
		return response;
	}
}
