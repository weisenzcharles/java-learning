package org.charles.springboot.rabbit.config;


import org.charles.springboot.rabbit.message.RabbitMessage;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    // 声明交换机和队列
    public static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    public static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    public static final String EXCHANGE_TOPICS_INFORM = "exchange_topics_inform";
    public static final String ROUTINGKEY_EMAIL = "inform.#.email.#";
    public static final String ROUTINGKEY_SMS = "inform.#.sms.#";

    // 声明 TOPICS 工作模式的交换机
    @Bean(EXCHANGE_TOPICS_INFORM)
    public Exchange EXCHANGE_TOPICS_INFORM() {
        // durable(true) 表面重启之后交换机还在
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS_INFORM).durable(true).build();
    }

    // 声明 QUEUE_INFORM_EMAIL 队列
    @Bean(QUEUE_INFORM_EMAIL)
    public Queue QUEUE_INFORM_EMAIL() {
        return new Queue(QUEUE_INFORM_EMAIL);
    }

    // 声明 QUEUE_INFORM_SMS 队列
    @Bean(QUEUE_INFORM_SMS)
    public Queue QUEUE_INFORM_SMS() {
        return new Queue(QUEUE_INFORM_SMS);
    }

    // 交换机与 QUEUE_INFORM_EMAIL 队列绑定
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL(@Qualifier(QUEUE_INFORM_EMAIL) Queue queue,
                                              @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_EMAIL).noargs();
    }

    // 交换机与 QUEUE_INFORM_SMS 队列绑定
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(QUEUE_INFORM_SMS) Queue queue,
                                            @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_SMS).noargs();
    }

    // 创建 Queue
    @Bean
    public Queue RabbitQueue() {
        return new Queue(RabbitMessage.QUEUE, // Queue 名字
                true, // durable: 是否持久化，true 表示将队列持久化到磁盘，false 表示将队列不持久化到磁盘
                false, // exclusive: 是否排它
                false); // autoDelete: 是否自动删除
    }

    // 创建 Direct Exchange
    @Bean
    public DirectExchange RabbitExchange() {
        return new DirectExchange(RabbitMessage.EXCHANGE,
                true,  // durable: 是否持久化，true 表示将交换机持久化到磁盘，false 表示将交换机不持久化到磁盘
                false);  // exclusive: 是否排它
    }
//@Bean
//public Message rabbitMessage(){
//
//    return new Message();
//}


    // 创建 Binding
    // Exchange：RabbitMessage.EXCHANGE
    // Routing key：RabbitMessage.ROUTING_KEY
    // Queue：RabbitMessage.QUEUE
    @Bean
    public Binding RabbitBinding() {
        return BindingBuilder.bind(RabbitQueue()).to(RabbitExchange()).with(RabbitMessage.ROUTING_KEY);
    }
}
