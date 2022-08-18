package org.charles.learning.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Send {
    private final static String QUEUE_NAME = "hello_queue";

    public static void main(String[] argv) throws Exception {

        // 创建连接工厂
        ConnectionFactory factory = null;
        // 建立到代理服务器到连接
        Connection connection = null;
        // 获得通道
        Channel channel = null;
        try {
            factory = new ConnectionFactory();
            factory.setHost("192.168.0.86");
            factory.setUsername("admin");
            factory.setPassword("admin");
            // 建立到代理服务器到连接
            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent: '" + message + "'");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}

