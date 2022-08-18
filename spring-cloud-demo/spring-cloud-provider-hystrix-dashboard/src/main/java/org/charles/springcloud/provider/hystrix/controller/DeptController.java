package org.charles.springcloud.provider.hystrix.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.charles.springcloud.api.entity.Dept;
import org.charles.springcloud.provider.hystrix.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping("/dept/{id}")
    @HystrixCommand(fallbackMethod = "fallbackQuery")
    public Dept queryById(@PathVariable("id") Integer id) {
        return deptService.queryById(id);
    }

    public Dept fallbackQuery(@PathVariable("id") Integer id) {
        return new Dept().setId(id).setName("没有对应的信息：id => " + id);
    }

    @GetMapping("/dept/list")
    @HystrixCommand(fallbackMethod = "fallbackList")
    public List<Dept> queryList() {
        return deptService.queryList();
    }

    public List<Dept> fallbackList() {
        return new ArrayList<>();
    }
}
