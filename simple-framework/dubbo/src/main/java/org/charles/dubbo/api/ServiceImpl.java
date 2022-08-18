package org.charles.dubbo.api;

public class ServiceImpl implements Service {
    @Override
    public String send(String str) {
        return "hello " + str;
    }
}
