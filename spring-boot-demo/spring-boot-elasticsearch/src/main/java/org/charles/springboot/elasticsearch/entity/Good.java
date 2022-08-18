package org.charles.springboot.elasticsearch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Good {
    private long id;
    private String name;
    private String title;
    private double price;
}
