package org.charles.learning.pattern.creational.builder.haidilao.sauce;

public class SeafoodSauce extends Sauce {
    @Override
    public String name() {
        return "海鲜味碟";
    }

    @Override
    public float price() {
        return 18.0f;
    }
}
