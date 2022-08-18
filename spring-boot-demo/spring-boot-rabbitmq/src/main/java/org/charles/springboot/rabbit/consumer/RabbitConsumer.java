package org.charles.springboot.rabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.charles.springboot.rabbit.message.RabbitMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitMessage.QUEUE)
public class RabbitConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(RabbitMessage message) {
        logger.info("[onMessage] - [线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}