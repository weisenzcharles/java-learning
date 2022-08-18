package org.charles.springboot.bean.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class User implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String name;
    private String sex;
    private String phone;

    public User(String name, String sex) {
        System.out.println("【构造器】调用 User 的构造器实例化");
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性 name");
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        System.out.println("【注入属性】注入属性 sex");
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware 接口】调用 BeanFactoryAware.setBeanFactory()");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("【BeanNameAware 接口】调用 BeanNameAware.setBeanName()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean 接口】调用 DisposableBean.destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean 接口】调用 InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【ApplicationContextAware 接口】调用 ApplicationContextAware.setApplicationContext()");
    }

    public void initMethod() {
        System.out.println("【init-method】调用<bean>的 init-method 属性指定的初始化方法");
    }

    public void destroyMethod() {
        System.out.println("【destroy-method】调用<bean>的 destroy-method 属性指定的初始化方法");
    }

    @Override
    public String toString() {
        return "User : {" +
                " name = '" + name + '\'' +
                ", sex = '" + sex + '\'' +
                ", phone = '" + phone + '\'' +
                " }";
    }
}
