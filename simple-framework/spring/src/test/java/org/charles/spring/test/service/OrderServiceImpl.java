package org.charles.spring.test.service;

import org.charles.spring.factory.BeanNameAware;
import org.charles.spring.annotation.Component;

@Component("orderService")
public class OrderServiceImpl implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println("执行 -> BeanNameAware.setName()");
    }

    public void getBeanName() {
        System.out.println("orderService.beanName -> " + beanName);
    }
}
