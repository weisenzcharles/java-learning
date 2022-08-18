package org.charles.springboot.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAdvice {

    @Pointcut("execution (* org.charles.springboot.aop.controller.AopController.*(..))")
    public void aop() {

    }

    // 前置通知，在目标方法调用之前调用通知
    @Before("aop()")
    public void beforeAdvice() {
        System.out.println("beforeAdvice...");
    }
    // 后置通知，在目标方法完成之后调用通知
    @After("aop()")
    public void afterAdvice() {
        System.out.println("afterAdvice...");
    }

    @Around("aop()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("before");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("after");
    }

}
