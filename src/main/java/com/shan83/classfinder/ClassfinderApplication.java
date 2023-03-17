package com.shan83.classfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ClassfinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassfinderApplication.class, args);
    }

}
