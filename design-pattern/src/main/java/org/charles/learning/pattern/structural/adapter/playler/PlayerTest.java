package org.charles.learning.pattern.structural.adapter.playler;

public class PlayerTest {
    public static void main(String[] args) {
        Player player = new Player();

        player.play("mp3", "beyond the horizon.mp3");
        player.play("mp4", "alone.mp4");
        player.play("vlc", "far far away.vlc");
        player.play("avi", "mind me.avi");
    }
}
