package org.charles.springcloud.api.service;

import org.charles.springcloud.api.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(value = "spring-cloud-provider", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept);

//    @PostMapping("/dept/delete")
//    public boolean delete(Integer id);
//
//    @PostMapping("/dept/update")
//    public boolean update(Dept dept);

    @GetMapping("/dept/{id}")
    public Dept queryById(@PathVariable("id") Integer id);

    @GetMapping("/dept/list")
    public List<Dept> queryList();
}
