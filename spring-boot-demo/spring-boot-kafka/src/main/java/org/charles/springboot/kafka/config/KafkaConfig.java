package org.charles.springboot.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

public class KafkaConfig {


//    //这个是我们之前编写的KafkaTemplate代码，加入@Primary注解
//    @Bean
//    @Primary
//    public KafkaTemplate<Integer, String> kafkaTemplate() {
//        KafkaTemplate template = new KafkaTemplate<Integer, String>(producerFactory());
//        return template;
//    }
//
//    @Bean("defaultKafkaTemplate")
//    public KafkaTemplate<Integer, String> defaultKafkaTemplate() {
//        KafkaTemplate template = new KafkaTemplate<Integer, String>(producerFactory());
//        template.setDefaultTopic("topic.quick.default");
//        return template;
//    }
}
