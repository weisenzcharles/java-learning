package org.charles.learning.pattern.structural.bridge.machine;

public class OpenJDK extends Machine {
    public OpenJDK(Platform platform) {
        super(platform);
    }

    @Override
    public void run() {
        System.out.print("OpenJDK for ");
        super.run();
    }
}
