package com.guide.tour;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}