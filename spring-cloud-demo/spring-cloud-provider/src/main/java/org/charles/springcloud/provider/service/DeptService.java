package org.charles.springcloud.provider.service;

import org.charles.springcloud.api.entity.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 添加一个对象。
     * @param dept
     * @return {@link Boolean}
     */
    public boolean add(Dept dept);

    /**
     * 删除一个对象。
     * @param id
     * @return {@link Boolean}
     */
    public boolean delete(Integer id);

    /**
     * 更新一个对象。
     * @param dept
     * @return {@link Boolean}
     */
    public boolean update(Dept dept);

    /**
     * 查询一个对象。
     * @param id
     * @return a {@link Dept} object
     */
    public Dept queryById(Integer id);

    /**
     * 查询列表。
     * @return a {@link java.util.List<Dept>} for {@link Dept} instance
     * @see java.util.List<Dept>
     */
    public List<Dept> queryList();
}
