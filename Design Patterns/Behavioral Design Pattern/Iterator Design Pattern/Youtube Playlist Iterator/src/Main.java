public class Main {
    public static void main(String[] args) {
        YouTubePlaylist playlist = new YouTubePlaylist();
        playlist.addVideo(new Video("video 1"));
        playlist.addVideo(new Video("video 2"));

        YouTubePlaylistIterator iterator = new YouTubePlaylistIterator(playlist.getVideos());

        while(iterator.hasNext()){
            System.out.println(iterator.next().getTitle());
        }
    }
}