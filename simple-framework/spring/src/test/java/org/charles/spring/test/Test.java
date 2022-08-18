package org.charles.spring.test;

import org.charles.spring.SpringApplicationContext;
import org.charles.spring.test.service.GoodService;
import org.charles.spring.test.service.OrderServiceImpl;
import org.charles.spring.test.service.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        SpringApplicationContext springApplicationContext = new SpringApplicationContext(AppConfig.class);
        UserServiceImpl userService = (UserServiceImpl) springApplicationContext.getBean("userService");

        System.out.println("userService -> " + userService);

        userService.test();
        userService.getName();

        OrderServiceImpl orderServiceImpl = (OrderServiceImpl) springApplicationContext.getBean("orderService");
        orderServiceImpl.getBeanName();

        GoodService goodService = (GoodService) springApplicationContext.getBean("goodService");
        goodService.test();
        goodService.list("id");
    }
}
