package org.charles.learning.pattern.creational.builder.haidilao.pot;

public class SpicyHotpot extends Pot {
    @Override
    public String name() {
        return "麻辣锅底";
    }

    @Override
    public float price() {
        return 50.0f;
    }
}
