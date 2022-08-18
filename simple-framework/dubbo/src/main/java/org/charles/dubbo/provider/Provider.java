package org.charles.dubbo.provider;

import org.charles.dubbo.api.Service;
import org.charles.dubbo.api.ServiceImpl;
import org.charles.dubbo.protocol.http.HttpServer;
import org.charles.dubbo.register.LocalRegister;
import org.charles.dubbo.register.RemoteRegister;
import org.charles.dubbo.Url;

public class Provider {
    public static void main(String[] args) {

        LocalRegister.register(Service.class.getName(), ServiceImpl.class);

        Url url = new Url("localhost", 8099);

        RemoteRegister.register(Service.class.getName(), url);


        HttpServer httpServer = new HttpServer();
        httpServer.start(url);
    }
}
