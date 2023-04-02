package com.divanov.mathwebservice.config;


import com.divanov.mathwebservice.gen.MathServiceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapConfig {
    @Bean
    public MathServiceService mathServiceService() {
        return new MathServiceService();
    }
}
