package org.charles.learning.pattern.creational.builder.haidilao.drinks;

import org.charles.learning.pattern.creational.builder.mcdonalds.ColdDrink;

public class Coke extends Drinks {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "可乐";
    }
}