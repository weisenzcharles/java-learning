package org.charles.dubbo.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
// import org.apache.dubbo.config.annotation.Service;
import org.charles.dubbo.api.pojo.User;
import org.charles.dubbo.api.service.UserService;
import org.springframework.stereotype.Component;

@Component
// @Service(protocol = "dubbo", version = "1.0.0")
@DubboService(loadbalance = "random", // 负载均衡
        timeout = 50000, // 超时
        cluster = "failsafe", // 服务容错
        protocol = { "dubbo", "rest" }, // 多协议支持
        registry = { "hangzhou", "shanghai" } // 多注册中心
)
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(long id) {
        User user = new User();
        user.setId(1).setUsername("charles").setPassword("123456").setAge(33).setSex(1);
        return user;
    }
}
