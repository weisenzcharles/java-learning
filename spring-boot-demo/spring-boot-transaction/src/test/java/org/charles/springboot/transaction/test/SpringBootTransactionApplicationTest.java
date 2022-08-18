package org.charles.springboot.transaction.test;

import org.charles.springboot.transaction.config.TransactionConfig;
import org.charles.springboot.transaction.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBootTransactionApplicationTest {

    @Test
    public void test() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(appconfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService bean = context.getBean(UserService.class);
        bean.transfer(1, 2, 100);
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);
        UserService bean = context.getBean(UserService.class);
        bean.transfer(2, 1, 100);
    }
}
