package org.charles.springboot.kafka.producer;

import org.charles.springboot.kafka.config.KafkaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class KafkaProducer implements CommandLineRunner {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void run(String... args) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            kafkaTemplate.send(KafkaConstant.TOPIC, String.valueOf(System.currentTimeMillis())).addCallback(new SuccessCallback<SendResult<String, String>>() {
                @Override
                public void onSuccess(SendResult<String, String> result) {
                    if (null != result.getRecordMetadata()) {
                        System.out.println("消费发送成功 offset：" + result.getRecordMetadata().offset());
                        return;
                    }
                    System.out.println("消息发送成功！");
                }
            }, new FailureCallback() {
                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println("消费发送失败：" + throwable.getMessage());
                }
            });
        }, 0, 1, TimeUnit.SECONDS);
    }
}
