package org.charles.learning.pattern.structural.adapter.computer;

public class Computer {

    public void Internet(USBAdapter usbAdapter) {
        usbAdapter.handleRequest();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        NetworkAdapter networkAdapter = new NetworkAdapter();
        // 不使用公共适配器类
//        Adapter adapter = new Adapter();
//       computer.Internet(adapter);

        CommonAdapter commonAdapter = new CommonAdapter(networkAdapter);
        computer.Internet(commonAdapter);
    }
}
