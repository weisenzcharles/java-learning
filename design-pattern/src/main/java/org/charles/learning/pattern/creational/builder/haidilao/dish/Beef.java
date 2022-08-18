package org.charles.learning.pattern.creational.builder.haidilao.dish;

import org.charles.learning.pattern.creational.builder.haidilao.pot.Pot;

public class Beef extends Dish {
    @Override
    public String name() {
        return "牛肉";
    }

    @Override
    public float price() {
        return 100.0f;
    }
}
