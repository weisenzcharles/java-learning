package org.springframwork.demo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframwork.demo.config.Config;
import org.springframwork.demo.service.UserService;

public class SpringDemoApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new  AnnotationConfigApplicationContext(Config.class);
        // applicationContext.register(Config.class);
        // applicationContext.refresh();
        UserService userService = applicationContext.getBean(UserService.class);
        String user = userService.getById();
        System.out.println(user);
    }
}
