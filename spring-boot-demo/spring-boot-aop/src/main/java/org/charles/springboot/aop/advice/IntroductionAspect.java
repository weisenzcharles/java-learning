package org.charles.springboot.aop.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.charles.springboot.aop.service.GroupService;
import org.charles.springboot.aop.service.GroupServiceImpl;
import org.charles.springboot.aop.service.UserService;
import org.charles.springboot.aop.service.UserServiceImpl;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IntroductionAspect {
    @DeclareParents(value = "org.charles.springboot.aop.service.UserServiceImpl", defaultImpl = UserServiceImpl.class)
    public UserService userService;

    @DeclareParents(value = "org.charles.springboot.aop.service.GroupServiceImpl", defaultImpl = GroupServiceImpl.class)
    public GroupService groupService;
}
