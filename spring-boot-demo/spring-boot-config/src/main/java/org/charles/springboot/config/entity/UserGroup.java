package org.charles.springboot.config.entity;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:usergroup.yml")
public class UserGroup {
    //    @Value("id")
//    private Integer id;
    @Value(value = "name")
    private String name;
    @Value(value = "description")
    private String description;

    public UserGroup() {
    }

    public UserGroup(Integer id, String name, String description) {
//        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserGroup : { " +
//                "id = " + id +
                ", name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                " }";
    }
}
