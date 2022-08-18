package org.charles.dubbo.provider.service;

import org.apache.dubbo.config.annotation.Service;
import org.charles.dubbo.api.pojo.User;
import org.charles.dubbo.api.service.UserService;
import org.springframework.stereotype.Component;

@Component
@Service(protocol = "dubbo", version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(long id) {
        User user = new User();
        user.setId(1).setUsername("charles").setPassword("123456").setAge(33).setSex(1);
        return user;
    }
}
