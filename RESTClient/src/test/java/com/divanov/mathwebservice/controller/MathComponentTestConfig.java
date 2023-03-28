package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.MathService;
import com.divanov.mathwebservice.gen.MathServiceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

@Configuration
public class MathComponentTestConfig {

    @Bean
    @Primary
    public MathServiceService mathServiceService() {
        return mock(MathServiceService.class);
    }

    @Bean
    public MathController mathController() {
        return new MathController(mathServiceService());
    }
}
