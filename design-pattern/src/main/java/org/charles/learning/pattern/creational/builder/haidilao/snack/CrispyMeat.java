package org.charles.learning.pattern.creational.builder.haidilao.snack;

public class CrispyMeat extends Snack{
    @Override
    public String name() {
        return "小酥肉";
    }

    @Override
    public float price() {
        return 80.0f;
    }
}
