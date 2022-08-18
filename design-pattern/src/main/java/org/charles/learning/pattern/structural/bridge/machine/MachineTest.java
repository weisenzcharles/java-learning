package org.charles.learning.pattern.structural.bridge.machine;

public class MachineTest {
    public static void main(String[] args) {
        Machine hotSpot = new HotSpot(new MacOS());
        hotSpot.run();

        Machine jRockit = new JRockit(new Windows());
        jRockit.run();

        Machine openJDK = new OpenJDK(new Linux());
        openJDK.run();

        Machine harmony = new Harmony(new Windows());
        harmony.run();
    }


}
