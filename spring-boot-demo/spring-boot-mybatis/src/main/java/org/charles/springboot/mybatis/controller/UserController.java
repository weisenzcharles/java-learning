package org.charles.springboot.mybatis.controller;

import org.charles.springboot.mybatis.entity.User;
import org.charles.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public boolean insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @PostMapping("/user/remove")
    public boolean delete(long id) {
        return userService.delete(id);
    }

    @PostMapping("/user/modify")
    public boolean update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/user/{id}")
    public User query(@PathVariable("id") long id) {
        return userService.queryById(id);
    }

    @GetMapping("/user/list")
    public List<User> list() {
        return userService.queryList();
    }

}
