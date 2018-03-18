package com.training.springboot.SpringbootPractices6.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hello")
@Data
public class HelloConfig {

    private String message;

}
