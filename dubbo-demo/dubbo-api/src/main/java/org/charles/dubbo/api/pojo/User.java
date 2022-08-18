package org.charles.dubbo.api.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {
    private long id;
    private String username;
    private String password;
    private int sex;
    private int age;
}
