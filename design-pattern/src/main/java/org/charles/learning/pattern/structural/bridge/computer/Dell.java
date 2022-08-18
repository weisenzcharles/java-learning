package org.charles.learning.pattern.structural.bridge.computer;

public class Dell implements Brand {
    @Override
    public String name() {
        return "Dell";
    }

    @Override
    public void info() {
        System.out.print("戴尔");
    }
}
