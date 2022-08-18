package org.charles.learning.sql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;


@Configuration("classpath:application.xml")
public class SpringJdbcTest {


  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  public void testSpringJdbc() {
    String author = "1";
    String date = "2018.06.10";
    String sql = "SELECT id, title, author_id, content, create_time FROM article WHERE author_id = '" + author + "' AND create_time > '" + date + "'";
    List<Article> articles = jdbcTemplate.query(sql, (rs, rowNum) -> {
      Article article = new Article();
      article.setId(rs.getInt("id"));
      article.setTitle(rs.getString("title"));
//      article.setAuthor(rs.getString("author_id"));
      article.setContent(rs.getString("content"));
      article.setCreateTime(rs.getDate("create_time"));
      return article;
    });

    System.out.println("Query SQL ==> " + sql);
    System.out.println("Spring JDBC Query Result: ");
    articles.forEach(System.out::println);
  }
}
