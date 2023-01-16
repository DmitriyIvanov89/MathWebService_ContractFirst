package com.divanov.mathwebservice.service;

import com.divanov.mathwebservice.dto.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MathServiceTestConfig {

    @Bean
    public MathService mathService() {
        return new MathService();
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }
}
