package org.charles.springcloud.api.service;

import org.charles.springcloud.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "spring-cloud-provider", fallbackFactory = UserClientServiceFallbackFactory.class)
public interface UserClientService {

    @PostMapping("/user/add")
    public boolean add(User user);

    @PostMapping("/user/delete")
    public boolean delete(Integer id);

    @PostMapping("/user/update")
    public boolean update(User user);

    @GetMapping("/user/{id}")
    public User queryById(@PathVariable("id") Integer id);

    @GetMapping("/user/list")
    public List<User> queryList();
}