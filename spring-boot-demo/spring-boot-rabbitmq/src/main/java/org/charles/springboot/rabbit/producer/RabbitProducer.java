package org.charles.springboot.rabbit.producer;

import org.charles.springboot.rabbit.message.RabbitMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Integer id) {
        // 创建 DemoMessage 消息
        RabbitMessage message = new RabbitMessage();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(RabbitMessage.EXCHANGE, RabbitMessage.ROUTING_KEY, message);
    }

    public void send(String message) {
        // 创建 DemoMessage 消息
        RabbitMessage rabbitMessage = new RabbitMessage(0, message);
        // 同步发送消息
        rabbitTemplate.convertAndSend(RabbitMessage.EXCHANGE, RabbitMessage.ROUTING_KEY, rabbitMessage);
    }
}
