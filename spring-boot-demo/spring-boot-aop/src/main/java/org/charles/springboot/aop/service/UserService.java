package org.charles.springboot.aop.service;

import org.charles.springboot.aop.model.User;

public interface UserService {



    boolean insert(User user);

    boolean delete(long id);

    boolean update(User user);

    User query(long id);

    void testIntroduction();
}
