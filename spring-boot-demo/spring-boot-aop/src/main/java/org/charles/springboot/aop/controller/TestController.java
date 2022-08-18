package org.charles.springboot.aop.controller;

import org.charles.springboot.aop.model.Group;
import org.charles.springboot.aop.model.User;
import org.charles.springboot.aop.service.GroupService;
import org.charles.springboot.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    UserService userService;
    @Autowired
    GroupService groupService;



    @GetMapping("/user")
    public User queryUser() {

        User user = userService.query(1);
        // Aop 让 userService 方法拥有 GroupService 的方法
        GroupService groupService = (GroupService) userService;
        Group group = groupService.query(1);
        return userService.query(1);
    }

    @GetMapping("/group")
    public Group queryGroup() {
        Group group = groupService.query(1);
        // Aop 让 userService 方法拥有 GroupService 的方法
        UserService userService = (UserService) groupService;
        User user = userService.query(1);
        return group;
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("test");
        return "test";
    }
}
