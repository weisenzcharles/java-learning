package org.charles.springboot.bean.cycle;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class UserInstantiationAwareBeanPostProcessorAdapter extends
        InstantiationAwareBeanPostProcessorAdapter {

    public UserInstantiationAwareBeanPostProcessorAdapter() {
        super();
        System.out.println("这是 InstantiationAwareBeanPostProcessorAdapter 实现类构造器！！");
    }

    // 接口方法、实例化 Bean 之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {

        System.out.println("InstantiationAwareBeanPostProcessor 调用 postProcessBeforeInstantiation 方法");
        return null;
    }

    // 接口方法、实例化 Bean 之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor 调用 postProcessAfterInitialization 方法");
        return bean;
    }

    // 接口方法、设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor 调用 postProcessPropertyValues 方法");
        return pvs;
    }
}