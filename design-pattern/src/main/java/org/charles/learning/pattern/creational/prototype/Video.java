package org.charles.learning.pattern.creational.prototype;

import java.util.Date;

// 视频原型
public class Video implements Cloneable {
    private String name;
    private Date createTime;

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Video : { " +
                "name = '" + name + '\'' +
                ", createTime = " + createTime +
                " }";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Video video = (Video) super.clone();
//        video.setCreateTime((Date) this.createTime.clone());
        video.createTime = (Date) this.createTime.clone();
        return video;
    }

}
