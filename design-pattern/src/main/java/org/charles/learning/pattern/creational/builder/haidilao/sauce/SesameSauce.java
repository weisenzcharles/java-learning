package org.charles.learning.pattern.creational.builder.haidilao.sauce;

/**
 * 芝麻酱。
 */
public class SesameSauce extends Sauce {
    @Override
    public String name() {
        return "芝麻酱料";
    }

    @Override
    public float price() {
        return 16.0f;
    }
}
