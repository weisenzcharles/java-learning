package org.charles.learning.sql;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
  private Integer id;
  private String title;
  private String author_id;

  private ArticleTypeEnum type;

  private String content;
  private Author author;
  private Date createTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public ArticleTypeEnum getType() {
    return type;
  }

  public void setType(ArticleTypeEnum type) {
    this.type = type;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  @Override
  public String toString() {
    return "Article: {" +
      " id = " + id +
      ", title = '" + title + '\'' +
//      ", author = " + author +
      ", content = '" + content + '\'' +
      ", createTime = " + createTime +
      " }";
  }
}
