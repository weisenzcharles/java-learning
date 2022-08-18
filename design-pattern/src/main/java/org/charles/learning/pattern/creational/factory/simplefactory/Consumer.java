package org.charles.learning.pattern.creational.factory.simplefactory;

public class Consumer {
    public static void main(String[] args) {
        Auto auto = AutoFactory.getAuto("BYD");

        System.out.println(auto.name());
    }
}
