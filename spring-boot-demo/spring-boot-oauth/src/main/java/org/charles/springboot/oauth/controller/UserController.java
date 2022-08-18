package org.charles.springboot.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/admin/test")
    public String admin() {
        return "hello admin";
    }

    @GetMapping("/user/test")
    public String user() {
        return "hello user";
    }

    @GetMapping("/test")
    public String hello() {
        return "test";
    }
}
