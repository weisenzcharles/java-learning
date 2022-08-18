package org.charles.learning.pattern.structural.bridge.computer;

public class Apple implements Brand{
    @Override
    public String name() {
        return "Apple";
    }

    @Override
    public void info() {
        System.out.print("苹果");
    }
}
