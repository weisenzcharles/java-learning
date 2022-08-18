package org.charles.learning.jackson;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor

public class User {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String description;
    private String avatar;
    private String role;

    private String status;

    private Date createdTime;

    private Date updatedTime;
}
