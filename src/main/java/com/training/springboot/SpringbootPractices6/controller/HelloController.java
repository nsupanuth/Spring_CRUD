package com.training.springboot.SpringbootPractices6.controller;

import com.training.springboot.SpringbootPractices6.config.HelloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*
    @Value("${hello.message}")          // Get value from application.properties
    String message;
    */

    @Autowired
    private HelloConfig helloConfig;

    @GetMapping("/hello")
    public String getMessageConfig(){
        return helloConfig.getMessage();
    }

}
