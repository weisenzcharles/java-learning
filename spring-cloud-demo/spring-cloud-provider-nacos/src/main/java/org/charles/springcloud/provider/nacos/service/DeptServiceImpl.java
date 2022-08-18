package org.charles.springcloud.provider.nacos.service;

import org.charles.springcloud.api.entity.Dept;
import org.charles.springcloud.provider.nacos.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptDao.getById(id);
    }

    @Override
    public List<Dept> getAll() {
        return deptDao.getAll();
    }
}
