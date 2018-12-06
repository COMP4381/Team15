package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.youtube.model.Playlist;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.Video;

import models.User;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/Users")
public class UserController {

	ArrayList<Video> Videos = new ArrayList<Video>();

	@Autowired
	private JobsTubeController service = new JobsTubeController();

	@RequestMapping(method = RequestMethod.GET, value = "/playlists/{category}/{videoId}")
	public String addVideoToPlaylist(@PathVariable String category, @PathVariable String videoId) throws IOException {

		PlaylistItem response = service.addVideoToPlaylist(category, videoId);
		return response.toPrettyString();
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String Upload() throws IOException {
		Video v = service.uploadVideoUsingPOST();
		return v.toPrettyString();

	}

}
