package org.charles.learning.pattern.structural.bridge.machine;


public class MacOS implements Platform {
    @Override
    public void info() {
        System.out.println("MacOS");
    }
}
