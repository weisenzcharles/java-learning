package org.charles.learning.sql;

import org.apache.ibatis.annotations.Param;


public interface AuthorMapper {

  Author findOne(@Param("id") int id);
}


