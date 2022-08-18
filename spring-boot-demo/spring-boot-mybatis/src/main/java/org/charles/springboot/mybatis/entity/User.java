package org.charles.springboot.mybatis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private long id;
    private String name;
    private int age;
    private boolean sex;
    private String phone;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "User : { " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", age = " + age +
                ", sex = " + sex +
                ", phone = '" + phone + '\'' +
                ", createTime = " + createTime +
                ", updateTime = " + updateTime +
                " }";
    }
}
