package com.testspringboot.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//测试demo
@SpringBootApplication
public class SpringboottestApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringboottestApplication.class, args);
        System.out.println("hello springboot");
        System.out.println("解决冲突");
    }

}
