package org.charles.learning.pattern.creational.builder.haidilao.snack;

public class Fritters extends Snack {
    @Override
    public String name() {
        return "油条";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
