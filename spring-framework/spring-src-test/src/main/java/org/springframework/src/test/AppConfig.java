package org.springframework.src.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.springframework.src")
public class AppConfig {
//扫描 org.springframework.src 包下面的所有 bean
}