package org.charles.rpc.server;

public class RpcServerMain {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.send(service, 8090);
        System.out.println(service.send("charles"));
    }
}