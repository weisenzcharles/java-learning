package org.charles.springboot.mybatis.service;

import org.charles.springboot.mybatis.entity.User;

import java.util.List;

public interface UserService {

    boolean insert(User user);

    boolean delete(long id);

    boolean update(User user);

    User queryById(long id);

    List<User> queryList();
}
