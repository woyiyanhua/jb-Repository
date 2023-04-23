package com.jb.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.jb")
@MapperScan(basePackages = "com.jb.mapper")
@SpringBootApplication(scanBasePackages="com.jb.website.controller")
public class WebSiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSiteApplication.class,args);
    }
}
