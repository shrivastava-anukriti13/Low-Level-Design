import java.util.*;

public class YouTubePlaylistIterator implements PlaylistIterator {
    private List<Video> videos;
    private int position;

    public YouTubePlaylistIterator(List<Video> videos){
        this.videos = videos;
        this.position = 0;
    }

    @Override
    public boolean hasNext(){
        return position < videos.size();
    }

    @Override
    public Video next(){
        return hasNext() ? videos.get(position++) : null;
    }
}
