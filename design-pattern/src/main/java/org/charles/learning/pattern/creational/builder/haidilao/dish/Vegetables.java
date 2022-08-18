package org.charles.learning.pattern.creational.builder.haidilao.dish;

import org.charles.learning.pattern.creational.builder.haidilao.pot.Pot;

public class Vegetables extends Dish {
    @Override
    public String name() {
        return "蔬菜";
    }

    @Override
    public float price() {
        return 40.0f;
    }
}
