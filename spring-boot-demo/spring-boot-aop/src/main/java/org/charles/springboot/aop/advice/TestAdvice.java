package org.charles.springboot.aop.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAdvice {

    @Pointcut("execution (* org.charles.springboot.aop.controller.TestController.test())")
    public String test() {
        return "aop test";
    }

    @Before("test()")
    public String before() {
        return "aop before";
    }

    @After("test()")
    public String after() {
        return "aop after";
    }
}
