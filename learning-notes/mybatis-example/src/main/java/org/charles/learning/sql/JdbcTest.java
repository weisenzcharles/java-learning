package org.charles.learning.sql;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {
  public static void main(String[] args) {

  }

  @Test
  public void jdbcTest() throws ClassNotFoundException, SQLException {
    String url = "jdbc:mysql://192.168.0.86:3306/mybatis?user=root&password=123456&useUnicode=true&characterEncoding=UTF8&useSSL=false";
//    Connection connection = null;

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection connection = DriverManager.getConnection(url);
    String author = "1";
    String date = "2018.06.10";
    String sql = "SELECT id, title, author_id, content, create_time FROM article WHERE author_id = " + author + " AND create_time > '" + date + "'";
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    List<Article> articles = new ArrayList<>(resultSet.getRow());
    while (resultSet.next()) {
      Article article = new Article();
      article.setId(resultSet.getInt("id"));
      article.setTitle(resultSet.getString("title"));
//      article.setAuthor(resultSet.getString("author_id"));
      article.setContent(resultSet.getString("content"));
      article.setCreateTime(resultSet.getDate("create_time"));
      articles.add(article);
    }
    System.out.println("Query SQL ==> " + sql);
    System.out.println("Query Result: ");
    articles.forEach(System.out::println);
  }

}
