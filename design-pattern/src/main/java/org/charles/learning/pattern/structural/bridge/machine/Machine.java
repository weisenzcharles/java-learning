package org.charles.learning.pattern.structural.bridge.machine;

public abstract class Machine {

    private Platform platform;

    public Machine(Platform platform) {
        this.platform = platform;
    }

    public void run() {
        this.platform.info();
    }

}
