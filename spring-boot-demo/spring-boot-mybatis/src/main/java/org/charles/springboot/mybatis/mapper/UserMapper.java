package org.charles.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.charles.springboot.mybatis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper {

    boolean insert(User user);

    boolean delete(long id);

    boolean update(User user);

    User queryById(long id);

    List<User> queryList();
}
