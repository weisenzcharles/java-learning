package org.charles.springboot.aop.service;

import org.charles.springboot.aop.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User query(long id) {
        System.out.println("UserServiceImpl.query");
        return new User(1, "charles", "13800008888");
    }

    @Override
    public void testIntroduction() {
        System.out.println("do testIntroduction");
    }
}
