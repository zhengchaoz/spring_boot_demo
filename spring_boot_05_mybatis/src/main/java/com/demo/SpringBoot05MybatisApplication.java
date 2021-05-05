package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.demo.mapper")
@SpringBootApplication
public class SpringBoot05MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot05MybatisApplication.class, args);
    }

}
