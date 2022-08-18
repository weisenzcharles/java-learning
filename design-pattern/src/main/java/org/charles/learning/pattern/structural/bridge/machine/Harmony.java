package org.charles.learning.pattern.structural.bridge.machine;

public class Harmony extends Machine{
    public Harmony(Platform platform) {
        super(platform);
    }

    @Override
    public void run() {
        System.out.print("Harmony for ");
        super.run();
    }
}
