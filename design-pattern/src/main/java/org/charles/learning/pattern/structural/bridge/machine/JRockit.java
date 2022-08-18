package org.charles.learning.pattern.structural.bridge.machine;

public class JRockit extends Machine{
    public JRockit(Platform platform) {
        super(platform);
    }

    @Override
    public void run() {
        System.out.print("JRockit for ");
        super.run();
    }
}
