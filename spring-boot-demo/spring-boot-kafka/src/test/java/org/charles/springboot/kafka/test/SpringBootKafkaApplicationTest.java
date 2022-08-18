package org.charles.springboot.kafka.test;


import org.apache.kafka.clients.producer.ProducerRecord;
import org.charles.springboot.kafka.config.KafkaConstant;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class SpringBootKafkaApplicationTest {
    @Resource
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testDefaultKafkaTemplate() {
        kafkaTemplate.sendDefault("I`m send msg to default topic");
    }

    @Test
    public void testTemplateSend() {
        //发送带有时间戳的消息
        kafkaTemplate.send(KafkaConstant.TOPIC, 0, System.currentTimeMillis(), 0, "send message with timestamp");

        //使用ProducerRecord发送消息
        ProducerRecord record = new ProducerRecord(KafkaConstant.TOPIC, "use ProducerRecord to send message");
        kafkaTemplate.send(record);

        //使用Message发送消息
        Map map = new HashMap();
        map.put(KafkaHeaders.TOPIC, KafkaConstant.TOPIC);
        map.put(KafkaHeaders.PARTITION_ID, 0);
        map.put(KafkaHeaders.MESSAGE_KEY, 0);
        GenericMessage message = new GenericMessage("use Message to send message", new MessageHeaders(map));
        kafkaTemplate.send(message);
    }
}
