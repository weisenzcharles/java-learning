package org.charles.dubbo.consumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.charles.dubbo.api.pojo.User;
import org.charles.dubbo.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(protocol = "dubbo", version = "1.0.0")
    UserService userService;

    @GetMapping("user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }
}
