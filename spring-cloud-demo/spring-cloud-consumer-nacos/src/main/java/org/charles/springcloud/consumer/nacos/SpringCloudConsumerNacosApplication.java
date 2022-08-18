package org.charles.springcloud.consumer.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudConsumerNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerNacosApplication.class, args);
    }
}
