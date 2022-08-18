package org.charles.springboot.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.charles.springboot.kafka.config.KafkaConstant;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = KafkaConstant.TOPIC, groupId = KafkaConstant.TOPIC_GROUP)
    public void consumer(ConsumerRecord<String, String> record, Acknowledgment ack) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " 接收到消息，{ partition: " + record.partition() + ", offset: " + record.offset() + ", value: " + record.value() + " }");
        TimeUnit.SECONDS.sleep(1);
        ack.acknowledge();
    }
}
