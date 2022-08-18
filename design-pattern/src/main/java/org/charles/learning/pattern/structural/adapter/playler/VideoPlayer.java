package org.charles.learning.pattern.structural.adapter.playler;



public class VideoPlayer implements MediaPlayer {
    @Override
    public void playVideo(String filename) {
        System.out.println("开始播放视频文件：" + filename);
    }

    @Override
    public void playAudio(String filename) {
        System.out.println("Invalid media. " + filename + " format not supported");
    }
}
