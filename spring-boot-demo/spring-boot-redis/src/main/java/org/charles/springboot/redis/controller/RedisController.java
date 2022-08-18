package org.charles.springboot.redis.controller;

import org.charles.springboot.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    RedisService redisService;

    @GetMapping("/redis/test")
    public String index() {
        redisService.set("test", "hello redis!");
        String test = (String) redisService.get("test");
        System.out.println(test);
        return test;
    }
}
