package org.charles.springboot.jpa.controller;

import java.util.List;

import org.charles.springboot.jpa.domain.User;
import org.charles.springboot.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/index")
    public String index() {
        return "user/index";
    }

    @GetMapping("/user/list")
    public List<User> list() {
        return userService.query(1, 10);
    }
}
