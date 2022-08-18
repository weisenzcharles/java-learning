package org.charles.springboot.bean.config;

import org.charles.springboot.bean.cycle.UserBeanFactoryPostProcessor;
import org.charles.springboot.bean.cycle.UserBeanPostProcessor;
import org.charles.springboot.bean.cycle.UserInstantiationAwareBeanPostProcessorAdapter;
import org.charles.springboot.bean.model.User;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public User user() {
        return new User("charles", "男");
    }

    @Bean
    public BeanPostProcessor userBeanPostProcessor() {
        return new UserBeanPostProcessor();
    }

    @Bean
    public InstantiationAwareBeanPostProcessorAdapter userInstantiationAwareBeanPostProcessor() {
        return new UserInstantiationAwareBeanPostProcessorAdapter();
    }

    @Bean
    public BeanFactoryPostProcessor userBeanFactoryPostProcessor() {
        return new UserBeanFactoryPostProcessor();
    }
}