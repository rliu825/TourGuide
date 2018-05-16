package com.guide.tour;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class GuideHome {
    @RequestMapping("/hello/{test}")
    public String hello(@PathVariable String test){
        return "hello world "+test;
    }
}
