package org.charles.springcloud.provider.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudProviderNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderNacosApplication.class, args);
    }
}
