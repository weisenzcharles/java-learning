package org.charles.learning.entity;

public class CoffeeMaker {
    private Coffee coffee = null;

    public String makeCoffee() {
        return "您点了一杯：" + coffee.toString();
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

}
