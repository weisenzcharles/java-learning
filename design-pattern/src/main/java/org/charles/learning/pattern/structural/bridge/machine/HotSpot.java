package org.charles.learning.pattern.structural.bridge.machine;

public class HotSpot extends Machine {
    public HotSpot(Platform platform) {
        super(platform);
    }

    @Override
    public void run() {
        System.out.print("HotSpot for ");
        super.run();
    }
}
