package org.charles.springboot.bean.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class UserBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public UserBeanFactoryPostProcessor() {
        super();
        System.out.println("这是 BeanFactoryPostProcessor 实现类构造器！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory arg)
            throws BeansException {
        System.out.println("BeanFactoryPostProcessor 调用 postProcessBeanFactory 方法");
        BeanDefinition beanDefinition = arg.getBeanDefinition("user");
        beanDefinition.getPropertyValues().addPropertyValue("phone", "13555551122");
    }
}