package org.charles.learning.fanout;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {


    private static final String ORDER_EXCHANGE = "ORDER_EXCHANGE";

    private static final String ORDER_QUEUE = "ORDER_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.0.86");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        // 创建连接
        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();
        // 创建 Exchange
        channel.exchangeDeclare(ORDER_EXCHANGE, "fanout", false, false, null);
        // 创建 Queue
        channel.queueDeclare(ORDER_QUEUE, false, false, false, null);


        // channel.basicConsume()
    }

}
