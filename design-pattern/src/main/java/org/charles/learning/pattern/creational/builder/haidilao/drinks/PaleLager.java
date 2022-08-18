package org.charles.learning.pattern.creational.builder.haidilao.drinks;

/**
 * 拉格啤酒。
 */
public class PaleLager extends Drinks {
    @Override
    public String name() {
        return "拉格啤酒";
    }

    @Override
    public float price() {
        return 40.0f;
    }
}
