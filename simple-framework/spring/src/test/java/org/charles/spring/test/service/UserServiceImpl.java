package org.charles.spring.test.service;

import org.charles.spring.annotation.Autowired;
import org.charles.spring.annotation.Scope;
import org.charles.spring.factory.InitializingBean;
import org.charles.spring.annotation.Component;

@Component("userService")
@Scope("singleton")
public class UserServiceImpl implements InitializingBean {
    @Autowired
    OrderServiceImpl orderService;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void test() {
        System.out.println("orderService -> " + orderService);
        System.out.println("BeanPostProcessor.postProcessBeforeInitialization() 设置的值 -> " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行 -> InitializingBean.afterPropertiesSet()");
    }
}
