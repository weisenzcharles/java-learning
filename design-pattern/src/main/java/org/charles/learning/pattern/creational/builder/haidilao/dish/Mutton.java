package org.charles.learning.pattern.creational.builder.haidilao.dish;

import org.charles.learning.pattern.creational.builder.haidilao.pot.Pot;

public class Mutton extends Dish {
    @Override
    public String name() {
        return "羊肉";
    }

    @Override
    public float price() {
        return 90.0f;
    }
}
