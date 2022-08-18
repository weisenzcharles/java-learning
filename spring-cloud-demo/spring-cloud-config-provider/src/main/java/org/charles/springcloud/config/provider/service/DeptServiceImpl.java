package org.charles.springcloud.config.provider.service;

import org.charles.springcloud.api.entity.Dept;
import org.charles.springcloud.config.provider.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    /**
     * 添加一个对象。
     * @param dept
     * @return {@link Boolean}
     */
    @Override
    public boolean add(Dept dept) {
        return deptDao.add(dept);
    }

    /**
     * 删除一个对象。
     * @param id
     * @return {@link Boolean}
     */
    @Override
    public boolean delete(Integer id) {
        return false;
    }

    /**
     * 更新一个对象。
     * @param dept
     * @return {@link Boolean}
     */
    @Override
    public boolean update(Dept dept) {
        return deptDao.update(dept);
    }

    /**
     * 查询一个对象。
     * @param id
     * @return a {@link Dept} object
     */
    @Override
    public Dept queryById(Integer id) {
        return deptDao.queryById(id);
    }

    /**
     * 查询列表。
     * @return a {@link List<Dept>} for {@link Dept} instance
     * @see List<Dept>
     */
    @Override
    public List<Dept> queryList() {
        return deptDao.queryList();
    }
}
