package org.charles.learning.pattern.structural.adapter.playler;

public class AudioAdapter implements MediaAdapter {

    private MediaPlayer mediaPlayer;

    public AudioAdapter(String mediaType) {
//        if (mediaType.equalsIgnoreCase("mp4")) {
//            mediaPlayer = new VideoPlayer();
//        } else if (mediaType.equalsIgnoreCase("mp3")) {
            mediaPlayer = new AudioPlayer();
//        } else {
//            System.out.println("Invalid media. " + mediaType + " format not supported");
//        }
    }

    @Override
    public void play(String mediaType, String fileName) {
        //播放 mp3 音乐文件的内置支持
        if (mediaType.equalsIgnoreCase("mp3")) {
            mediaPlayer = new AudioPlayer();
            mediaPlayer.playAudio(fileName);
        }
        //mediaAdapter 提供了播放其他文件格式的支持
        else if (mediaType.equalsIgnoreCase("vlc")
                || mediaType.equalsIgnoreCase("mp4")) {
            mediaPlayer = new AudioPlayer();
            mediaPlayer.playAudio(fileName);
        } else {
            System.out.println("Invalid media. " + mediaType + " format not supported");
        }
    }
}
