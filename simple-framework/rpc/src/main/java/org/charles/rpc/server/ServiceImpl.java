package org.charles.rpc.server;

public class ServiceImpl implements Service {
    @Override
    public String send(String str) {
        return "Hello:" + str;
    }
}
