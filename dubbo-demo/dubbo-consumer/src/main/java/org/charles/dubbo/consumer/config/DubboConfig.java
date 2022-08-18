package org.charles.dubbo.consumer.config;

import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

    /*
     * 服务端相关调优参数。
     */
    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig config = new ProviderConfig();
        // 默认 200 服务线程池大小(固定大小)
        config.setThreads(200);
        // 默认 CPU + 1
        // IO 线程池，接收网络读写中断，以及序列化和反序列化，
        //  不处理业务，业务线程池参见 threads 配置，此线程池和 CPU 相关，不建议配置。
        config.setIothreads(Runtime.getRuntime().availableProcessors() + 1);
        // 线程池类型，可选：fixed/cached/limit(2.5.3 以上)/eager(2.6.x 以上)
        config.setThreadpool("fixed");
        // 对每个提供者的最大连接数，rmi、http、hessian
        // 等短连接协议表示限制连接数，dubbo 等长连接协表示建立的长连接个数
        config.setConnections(0);
        // 线程池队列大小，当线程池满时，排队等待执行的队列大小，
        // 建议不要设置，当线程池满时应立即失败，重试其它服务提供机器，
        // 而不是排队，除非有特殊需求。
        config.setQueues(0);
        // 每服务消费者每服务每方法最大并发调用数
        config.setAccepts(0);
        // 服务提供者每服务每方法最大可并行执行请求数
        config.setExecutes(0);
        return config;

    }

    /*
     * 客户端相关调优参数。
     */
    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig config = new ConsumerConfig();
        config.setFilter("-sentinel.dubbo.consumer.filter");
        // 每个服务对每个提供者的最大连接数，
        // rmi、http、hessian 等短连接协议支持此配置，dubbo 协议长连接不支持此配置
        config.setConnections(100);
        // 每服务消费者每服务每方法最大并发调用数
        config.setActives(0);
        return config;
    }
}