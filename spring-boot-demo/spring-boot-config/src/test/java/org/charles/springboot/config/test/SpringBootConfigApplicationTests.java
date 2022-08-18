package org.charles.springboot.config.test;

import org.charles.springboot.config.entity.User;
import org.charles.springboot.config.entity.UserGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootConfigApplicationTests {
    @Autowired
    private User user;
    @Autowired
    private UserGroup userGroup;
    @Test
    void contextLoads() {
        System.out.println(user);
    }

    @Test
    void loadGroup(){
        System.out.println(userGroup);
    }
}

