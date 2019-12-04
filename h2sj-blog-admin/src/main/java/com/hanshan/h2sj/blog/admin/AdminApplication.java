package com.hanshan.h2sj.blog.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.hanshan.h2sj.blog.domain.entity")
@EnableJpaRepositories("com.hanshan.h2sj.blog.domain.repository")
@ComponentScan({"com.hanshan.h2sj.blog.domain","com.hanshan.h2sj.blog.admin"})

public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
