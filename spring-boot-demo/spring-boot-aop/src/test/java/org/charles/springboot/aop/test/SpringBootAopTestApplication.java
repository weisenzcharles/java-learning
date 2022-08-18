package org.charles.springboot.aop.test;

import org.aspectj.lang.annotation.DeclareParents;
import org.charles.springboot.aop.model.Group;
import org.charles.springboot.aop.model.User;
import org.charles.springboot.aop.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBootAopTestApplication {

    @DeclareParents(value = "org.charles.springboot.aop.service.*", defaultImpl = UserServiceImpl.class)
    public UserService userService;


    @Test
    public void testUserService() {
        User user = userService.query(1);
        // Aop 让 userService 方法拥有 GroupService 的方法
        GroupService groupService = (GroupService) userService;
        Group group = groupService.query(1);
        System.out.println(group);
    }

    @Test
    public void testIntroduction() {
//        ApplicationContext factory = new ClassPathXmlApplicationContext("config.xml");
        userService.testIntroduction();
        //Aop 让UserService方法拥有 DoSthService的方法

    }

}
