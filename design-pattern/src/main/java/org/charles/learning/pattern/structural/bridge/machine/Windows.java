package org.charles.learning.pattern.structural.bridge.machine;

public class Windows implements Platform {
    @Override
    public void info() {
        System.out.println("Windows");
    }
}
