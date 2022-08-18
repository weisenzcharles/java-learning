package org.charles.learning.pattern.structural.adapter.playler;



public class AudioPlayer implements MediaPlayer {
    @Override
    public void playVideo(String filename) {
        System.out.println("Invalid media. " + filename + " format not supported");
    }

    @Override
    public void playAudio(String filename) {
        System.out.println("开始播放音频文件：" + filename);

    }
}
