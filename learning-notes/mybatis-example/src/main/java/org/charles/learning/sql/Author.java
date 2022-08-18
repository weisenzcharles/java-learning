package org.charles.learning.sql;

import java.io.Serializable;
import java.util.List;

public class Author implements Serializable {

  private Integer id;

  private String name;

  private Integer age;

  private AuthorSexEnum sex;

  private String email;

  private List<Article> articles;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public AuthorSexEnum getSex() {
    return sex;
  }

  public void setSex(AuthorSexEnum sex) {
    this.sex = sex;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Article> getArticles() {
    return articles;
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }

  @Override
  public String toString() {
    return "Author: {" +
      " id = " + id +
      ", name = '" + name + '\'' +
      ", age = " + age +
      ", sex = " + sex +
      ", email = '" + email + '\'' +
      ", articles = " + articles +
      " }";
  }
}
