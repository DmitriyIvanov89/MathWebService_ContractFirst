package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.MathServiceService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MathComponentTestConfig {

    @Bean
    public MathServiceService mathServiceService() {
        return Mockito.mock(MathServiceService.class);
    }
}
