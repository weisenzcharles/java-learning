package org.charles.learning.sql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MyBatisTest {
  private SqlSessionFactory sqlSessionFactory;

  @Before
  public void prepare() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    inputStream.close();
  }

  @Test
  public void testMyBatis() throws IOException {
    SqlSession session = sqlSessionFactory.openSession();
    try {
      ArticleMapper articleMapper = session.getMapper(ArticleMapper.class);
      List<Article> articles = articleMapper.queryArticles("1", "2018-06-10");
//      System.out.println("Query SQL ==> " + articleMapper);
      System.out.println("Query Result: ");
      articles.forEach(System.out::println);
    } finally {
      session.commit();
      session.close();
    }
  }

  @Test
  public void testOne2One() {
    SqlSession session = sqlSessionFactory.openSession();
    try {
      ArticleMapper articleDao = session.getMapper(ArticleMapper.class);
      Article article = articleDao.findOne(1);

      Author author = article.getAuthor();
      article.setAuthor(author);

      System.out.println();
      System.out.println("articles info:");
      System.out.println(article);

      System.out.println();
      System.out.println("author info:");
      System.out.println(author);

    } finally {
      session.close();
    }
  }

  @Test
  public void testOne2Many() {
    SqlSession session = sqlSessionFactory.openSession();
    try {
      AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
      Author author = authorMapper.findOne(1);

      List<Article> arts = author.getArticles();
      List<Article> articles = Arrays.asList(arts.toArray(new Article[arts.size()]));
      author.setArticles(articles);
      arts.clear();

      System.out.println();
      System.out.println("author info:");
      System.out.println(author);
      System.out.println();
      System.out.println("articles info:");
      articles.forEach(System.out::println);
    } finally {
      session.close();
    }
  }
}
