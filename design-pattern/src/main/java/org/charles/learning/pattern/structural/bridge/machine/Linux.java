package org.charles.learning.pattern.structural.bridge.machine;

public class Linux implements Platform {
    @Override
    public void info() {
        System.out.println("Linux");
    }
}
