package org.charles.dubbo.consumer.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.service.GenericService;
// import org.apache.dubbo.config.annotation.Reference;
import org.charles.dubbo.api.pojo.User;
import org.charles.dubbo.api.service.UserService;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RestController
@RequestMapping("/user")
public class UserController {

    // @Reference(protocol = "dubbo", version = "1.0.0")
    // Dubbo 提供的注解
    @DubboReference(loadbalance = "roundrobin", timeout = 9000, cluster = "failfast", mock = "org.charles.dubbo.consumer.mock.UserServiceMock", check = false)
    UserService userService;

    @GetMapping("user/{id}")
//    @Produces({ MediaType.APPLICATION_JSON })
//    @Consumes(MediaType.MEDIA_TYPE_WILDCARD)
    public User getUser(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

    // Dubbo 泛化调用
    @DubboReference(interfaceName = "org.charles.dubbo.api.service.UserService", generic = true, check = false)
    GenericService genericService;

    @GetMapping("/generic/{id}")
    public String generic(@FormParam("id") long id) {
        return genericService.$invoke("getUser", new String[0], new Object[] { id }).toString();
    }
}
