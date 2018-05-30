package com.guide.tour.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {
    /**
     * Configure Spring MVC Route
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setStatusCode(HttpStatus.OK).setViewName("home");
        registry.addViewController("/home").setStatusCode(HttpStatus.OK).setViewName("home");
        registry.addViewController("/signin").setStatusCode(HttpStatus.OK).setViewName("signin");
        registry.addViewController("/signup").setStatusCode(HttpStatus.OK).setViewName("signup");
//        registry.addViewController("/redirect/signin").setStatusCode(HttpStatus.PERMANENT_REDIRECT).setViewName("signin");
//        registry.addViewController("/redirect/signup").setStatusCode(HttpStatus.PERMANENT_REDIRECT).setViewName("signup");
    }
}
