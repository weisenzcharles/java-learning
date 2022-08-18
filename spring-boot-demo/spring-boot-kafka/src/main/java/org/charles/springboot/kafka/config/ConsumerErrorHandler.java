package org.charles.springboot.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.stereotype.Component;

@Component
public class ConsumerErrorHandler implements ErrorHandler {
    @Override
    public void handle(Exception thrownException, ConsumerRecord<?, ?> data) {
        System.out.println("消费数据发生异常了");
    }
}
