package org.charles.springboot.aop.service;

import org.charles.springboot.aop.model.Group;
import org.charles.springboot.aop.model.User;

public interface GroupService {
    boolean insert(Group group);

    boolean delete(long id);

    boolean update(Group group);

    Group query(long id);
}
