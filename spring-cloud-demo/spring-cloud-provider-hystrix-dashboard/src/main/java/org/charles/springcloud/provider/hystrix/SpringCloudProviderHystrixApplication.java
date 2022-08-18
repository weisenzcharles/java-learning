package org.charles.springcloud.provider.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker   // 添加对熔断的支持
public class SpringCloudProviderHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderHystrixApplication.class, args);
    }
}
