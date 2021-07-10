package com.katle.design;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.katle.design.dao")
public class GraduationDesignManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraduationDesignManagerApplication.class, args);
    }

}
