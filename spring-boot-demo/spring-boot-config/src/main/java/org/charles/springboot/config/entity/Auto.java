package org.charles.springboot.config.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "auto")
public class Auto {
    private String model;
    private String name;

    public Auto() {
    }

    public Auto(String model, String name) {
        this.model = model;
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Auto : { " +
                "model = '" + model + '\'' +
                ", name = '" + name + '\'' +
                " }";
    }
}
