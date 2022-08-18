package org.charles.springboot.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

//    @GetMapping("/test")
//    public String test() {
//        System.out.println("test");
//        return "test";
//    }
}
