package org.charles.rpc.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RpcNetTransport {

    String host;
    int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket createSocket() {
        System.out.println("Begin create socket connect!");
        Socket socket = null;

        try {
            socket = new Socket(host, port);
        } catch (Exception e) {
            throw new RuntimeException("build connect failed.");
        }
        return socket;
    }

    public Object send(RpcRequest rpcRequest) {
        Socket socket = null;


        try {
            socket = createSocket();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();

            // 返回结果接收

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object resultObject = objectInputStream.readObject();// 反序列化 对象
            objectInputStream.close();
            objectOutputStream.close();

            return resultObject;
        } catch (Exception e) {
            throw new RuntimeException("send request exception:" + e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}