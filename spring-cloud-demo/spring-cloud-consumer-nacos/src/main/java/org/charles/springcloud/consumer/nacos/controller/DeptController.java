package org.charles.springcloud.consumer.nacos.controller;

import org.charles.springcloud.api.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_REST_URL = "http://spring-cloud-provider/";

    @RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
    public Dept dept(@PathVariable("id") Integer id) {
        return restTemplate.getForObject("http://spring-cloud-provider/dept/" + id, Dept.class);
    }

    @RequestMapping("/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(BASE_REST_URL + "dept/add", dept, Boolean.class);
    }

    @RequestMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(BASE_REST_URL + "dept/get/" + id, Dept.class);
    }

    @RequestMapping("/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(BASE_REST_URL + "dept/list", List.class);
    }
}
