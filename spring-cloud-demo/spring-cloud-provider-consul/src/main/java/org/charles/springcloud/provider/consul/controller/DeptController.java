package org.charles.springcloud.provider.consul.controller;

import org.charles.springcloud.api.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.charles.springcloud.provider.consul.service.DeptService;
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
    public Dept queryById(@PathVariable("id") Integer id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryList() {
        return deptService.queryList();
    }
}
