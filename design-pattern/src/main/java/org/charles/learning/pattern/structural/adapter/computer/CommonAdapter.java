package org.charles.learning.pattern.structural.adapter.computer;

public class CommonAdapter implements USBAdapter {

    private NetworkAdapter adapter;

    public CommonAdapter(NetworkAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void handleRequest() {
        this.adapter.request();
    }
}
