package org.charles.springcloud.provider.nacos.dao;

import org.apache.ibatis.annotations.Mapper;
import org.charles.springcloud.api.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept getById(Integer id);

    public List<Dept> getAll();
}
