package org.charles.rpc.client;

public class RpcClientMain {
    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
        Service service = rpcClientProxy.clientProxy(Service.class, "localhost", 8090);
        System.out.println(service.send("charles"));
    }
}