package org.charles.springboot.bean.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class UserBeanPostProcessor implements BeanPostProcessor {

    public UserBeanPostProcessor() {
        super();
        System.out.println("这是【BeanPostProcessor】实现类构造器！！");
    }

    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
        System.out.println("【BeanPostProcessor】接口方法 postProcessAfterInitialization 对属性进行更改！");
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
        System.out.println("【BeanPostProcessor】接口方法 postProcessBeforeInitialization 对属性进行更改！");
        return arg0;
    }
}
