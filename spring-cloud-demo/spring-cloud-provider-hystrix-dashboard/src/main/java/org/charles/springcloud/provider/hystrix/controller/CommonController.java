package org.charles.springcloud.provider.hystrix.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommonController {
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private Environment environment;
    @Value("${server.port}")
    private Integer port;
    @Value("${spring.application.name}")
    private static String name;
    @Value("${spring.application.name}")
    private static String serviceId;


    @GetMapping("/service/list")
    public Object discovery() {
        String string = environment.getProperty("spring");
        List<String> services = client.getServices();
        System.out.println("services:" + services);

        List<ServiceInstance> instances = client.getInstances("spring-cloud-provider");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                            instance.getPort() + "\t" +
                            instance.getUri() + "\t" +
                            instance.getServiceId()
            );
        }
        return client;
    }
}
