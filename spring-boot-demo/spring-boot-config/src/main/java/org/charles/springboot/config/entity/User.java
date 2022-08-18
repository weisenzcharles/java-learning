package org.charles.springboot.config.entity;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private String name;
    private Date birth;
    private Integer age;
    private Boolean sex;
    private List<String> hobby;
    private Map<String, Object> attr;
    private Auto auto;

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public User() {
    }
    public User(String name, Date birth, Integer age, Boolean sex, List<String> hobby, Map<String, Object> attr, Auto auto) {
        this.name = name;
        this.birth = birth;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
        this.attr = attr;
        this.auto = auto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public Map<String, Object> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, Object> attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return "User : { " +
                "name = '" + name + '\'' +
                ", birth = " + birth +
                ", age = " + age +
                ", sex = " + sex +
                ", hobby = " + hobby +
                ", attr = " + attr +
                ", auto = " + auto +
                " }";
    }
}
