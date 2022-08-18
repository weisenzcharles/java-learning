package org.charles.learning.pattern.structural.adapter.playler;

public class Player  {

    //    MediaPlayer mediaPlayer;
    MediaAdapter mediaAdapter;


    public void play(String mediaType, String fileName) {
//        if (mediaType.equals(".mp4")) {
//            mediaPlayer = new VideoPlayer();
//        }

        //播放 mp3 音乐文件的内置支持
        if (mediaType.equalsIgnoreCase("mp3")) {
            mediaAdapter = new AudioAdapter(mediaType);
            mediaAdapter.play(mediaType, fileName);
        }
        //mediaAdapter 提供了播放其他文件格式的支持
        else if (mediaType.equalsIgnoreCase("vlc") || mediaType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new VideoAdapter(mediaType);
            mediaAdapter.play(mediaType, fileName);
        } else {
            System.out.println("Invalid media. " + mediaType + " format not supported");
        }
    }


}
