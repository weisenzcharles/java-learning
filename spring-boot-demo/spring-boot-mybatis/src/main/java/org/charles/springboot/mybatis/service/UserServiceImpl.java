package org.charles.springboot.mybatis.service;

import org.charles.springboot.mybatis.entity.User;
import org.charles.springboot.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public boolean delete(long id) {
        return userMapper.delete(id);
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User queryById(long id) {
        return userMapper.queryById(id);
    }

    @Override
    public List<User> queryList() {
        return userMapper.queryList();
    }
}
