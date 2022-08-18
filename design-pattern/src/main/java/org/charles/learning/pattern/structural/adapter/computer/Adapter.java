package org.charles.learning.pattern.structural.adapter.computer;

public class Adapter extends NetworkAdapter implements USBAdapter {
    @Override
    public void handleRequest() {
        super.request();
    }
}
