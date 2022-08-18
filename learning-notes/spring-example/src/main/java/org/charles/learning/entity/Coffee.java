package org.charles.learning.entity;

import lombok.Data;

@Data
public class Coffee {
    private String name;    // 名称

    @Override
    public String toString() {
        return "Coffee {" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sugar='" + sugar + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    private String type;   // 类型
    private String sugar;   // 糖分
    private String size;    // 容量
}

