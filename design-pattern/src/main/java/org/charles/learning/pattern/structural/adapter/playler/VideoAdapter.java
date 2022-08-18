package org.charles.learning.pattern.structural.adapter.playler;


public class VideoAdapter implements MediaAdapter {

    private MediaPlayer mediaPlayer;

    public VideoAdapter(String mediaType) {
//        if (mediaType.equalsIgnoreCase("mp4")) {
            mediaPlayer = new VideoPlayer();
//        } else if (mediaType.equalsIgnoreCase("mp3")) {
//            mediaPlayer = new AudioPlayer();
//        } else {
//            System.out.println("Invalid media. " + mediaType + " format not supported");
//        }
    }

    @Override
    public void play(String mediaType, String fileName) {
        if (mediaType.equalsIgnoreCase("mp4")) {
            mediaPlayer.playVideo(fileName);
        } else if (mediaType.equalsIgnoreCase("mp3")) {
            mediaPlayer.playAudio(fileName);
        } else {
            System.out.println("Invalid media. " + mediaType + " format not supported");
        }
    }
}
