package org.charles.springcloud.provider.nacos.service;

import org.charles.springcloud.api.entity.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept getById(Integer id);

    public List<Dept> getAll();
}
