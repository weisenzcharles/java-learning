package org.charles.springcloud.consumer.controller;

import org.charles.springcloud.api.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_REST_URL = "http://SPRING-CLOUD-PROVIDER";

    @Autowired
    DiscoveryClient discoveryClient;

    int count = 0;

    @GetMapping("/list")
    public List<Dept> hello(String name) {
        List<ServiceInstance> list = discoveryClient.getInstances("SPRING-CLOUD-PROVIDER");
        ServiceInstance instance = list.get(count % list.size());
        count++;
        String host = instance.getHost();
        int port = instance.getPort();
        List<Dept> deptList = restTemplate.getForObject("http://" + host + ":" + port + "/dept/list", List.class);
        return deptList;
    }


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(BASE_REST_URL + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(BASE_REST_URL + "/dept/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(BASE_REST_URL + "/dept/list", List.class);
    }
}
