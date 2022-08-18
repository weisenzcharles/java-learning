package org.springframwork.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframwork.demo.service.UserService;

@Configuration
public class Config {
    @Bean(name="userService")
    public UserService getUserService () {
        return new UserService();
    }
}