package org.charles.learning.pattern.creational.builder.haidilao.sauce;

/**
 * 特色蘸料。
 */
public class SpecialSauce extends Sauce {
    @Override
    public String name() {
        return "特色蘸料";
    }

    @Override
    public float price() {
        return 15.0f;
    }
}
