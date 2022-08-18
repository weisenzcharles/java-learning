package org.charles.springboot.bean;

import org.charles.springboot.bean.model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootBeanApplication {

    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringBootBeanApplication.class);
        System.out.println("容器初始化成功");
        User bean = context.getBean(User.class);
        System.out.println(bean.toString());
        System.out.println("现在开始关闭容器！");
        ((AnnotationConfigApplicationContext) context).close();
    }
}
