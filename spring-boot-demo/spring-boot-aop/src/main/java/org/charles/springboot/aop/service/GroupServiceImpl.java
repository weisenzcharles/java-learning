package org.charles.springboot.aop.service;

import org.charles.springboot.aop.model.Group;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Override
    public boolean insert(Group group) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(Group group) {
        return false;
    }

    @Override
    public Group query(long id) {
        System.out.println("GroupServiceImpl.query");
        return new Group(1, "管理员");
    }
}
