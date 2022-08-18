package org.charles.rpc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void send(Object service, int port) {
        ServerSocket serverSocket = null;
        try {
            // 启动 socket 服务
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(service, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}