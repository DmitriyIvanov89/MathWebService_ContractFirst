package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.MathService;
import com.divanov.mathwebservice.gen.MathServiceService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MathComponentTestConfig {

    @Bean
    @Primary
    public MathServiceService mathServiceService() {
        return Mockito.mock(MathServiceService.class);
    }

    @Bean
    public MathService mathService() {
        return mathServiceService().getMathServiceSoap11();
    }

    @Bean
    public MathController mathController(MathServiceService mathServiceService) {
        return new MathController(mathServiceService());
    }
}
