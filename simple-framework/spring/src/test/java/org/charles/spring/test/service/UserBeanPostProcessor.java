package org.charles.spring.test.service;

import org.charles.spring.config.BeanPostProcessor;
import org.charles.spring.annotation.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class UserBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("执行 -> BeanPostProcessor.postProcessBeforeInitialization()");
        if (beanName.equals("userService")) {
            System.out.println("设置 UserBeanPostProcessor 的值！");
            ((UserServiceImpl) bean).setName("charles");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("执行 -> BeanPostProcessor.postProcessAfterInitialization()");
        if ("goodService".equals(beanName)) {
            Object instance = Proxy.newProxyInstance(UserBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("BeanPostProcessor -> 执行代理 goodService");
                    if (args != null) {
                        for (int i = 0; i < args.length; i++) {
                            if (args[i] instanceof String) {
                                args[i] = "proxy update arg value " + args[i];
                            }
                        }
                    }
                    return method.invoke(bean, args);
                }
            });
            return instance;
        }
        return bean;
    }
}
