package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VideosService {

	List<Student> videos = Arrays.asList(
            new Student("1","http://videos.com/video1","Darin"),
            new Student("2","http://videos.com/video2","Dina"),
            new Student("3","http://videos.com/video3","Majed")
            

    );
	
	  public List<Student> getVideos() {
	        return videos;
	    }

	    

	    public void addVideo(Student vi) {
	        videos.add(vi);
	    }

	    public boolean remove(String id) {
	        for (int i = 0 ; i < videos.size() ; i++) {
	            if (videos.get(i).getId().equals(id)) {
	                videos.remove(i);
	                return true;
	            }
	        }
	        return false;
	    }



		public Student getVideo(String id) {
			// TODO Auto-generated method stub
			return videos.stream().filter(T -> T.getId().equals(id)).findFirst().get();
		}

	    
}
