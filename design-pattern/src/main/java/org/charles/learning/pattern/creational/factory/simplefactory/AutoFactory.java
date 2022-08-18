package org.charles.learning.pattern.creational.factory.simplefactory;

public class AutoFactory {
    public static Auto getAuto(String name) {
        if (name.equals("BYD")) {
            return new BYD();
        } else if (name.equals("Tesla")) {
            return new Tesla();
        } else if (name.equals("Nio")) {
            return new Tesla();
        } else {
            return null;
        }
    }
}
