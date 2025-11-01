import java.util.*;

public class YouTubePlaylist {
    List<Video> videos = new ArrayList<>();

    public void addVideo(Video video){
        videos.add(video);
    }

    public List<Video> getVideos(){
        return videos;
    }
}
