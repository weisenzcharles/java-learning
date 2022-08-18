package org.charles.dubbo.consumer.mock;

import org.charles.dubbo.api.pojo.User;
import org.charles.dubbo.api.service.UserService;

public class UserServiceMock implements UserService {

    @Override
    public User getUserById(long id) {
        return new User();
    }

}
