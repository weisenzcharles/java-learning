package org.charles.dubbo.consumer;

import org.charles.dubbo.api.Service;
import org.charles.dubbo.protocol.ProxyFactory;

public class Consumer {

    public static void main(String[] args) {

        Service service = ProxyFactory.getProxy(Service.class);
        String result = service.send("charles");


        System.out.println(result);
    }
}
