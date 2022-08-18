package org.charles.learning.sql;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {

  List<Article> queryArticles(@Param("author_id") String author, @Param("createTime") String createTime);
  Article findOne(@Param("id") int id);
}
