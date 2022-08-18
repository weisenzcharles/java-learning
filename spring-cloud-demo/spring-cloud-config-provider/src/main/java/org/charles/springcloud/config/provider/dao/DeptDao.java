package org.charles.springcloud.config.provider.dao;

import org.apache.ibatis.annotations.Mapper;
import org.charles.springcloud.api.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

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
     * @return a {@link List<Dept>} for {@link Dept} instance
     * @see List<Dept>
     */
    public List<Dept> queryList();

}
