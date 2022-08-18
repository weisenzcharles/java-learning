package org.charles.learning.pattern.creational.prototype;

import java.util.Date;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        Video video = new Video("video", date);

        Video clone = (Video) video.clone();
        System.out.println("video -> " + video + ", hashcode : " + video.hashCode());
        System.out.println("clone -> " + clone + ", hashcode : " + clone.hashCode());

        System.out.println("====================================================================================================");
        date.setTime(1394356555341l);

        clone.setName("clone");
        System.out.println("video -> " + video + ", hashcode : " + video.hashCode());
        System.out.println("clone -> " + clone + ", hashcode : " + clone.hashCode());

    }
}
