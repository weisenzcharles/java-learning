package org.charles.springcloud.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class UserGroup {
    private Integer id;
    private String name;
    private String description;
}
