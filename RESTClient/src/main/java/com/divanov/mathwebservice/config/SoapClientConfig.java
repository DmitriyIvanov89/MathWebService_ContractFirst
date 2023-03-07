package com.divanov.mathwebservice.config;

import com.divanov.mathwebservice.client.MathPortSoap11Impl;
import com.divanov.mathwebservice.gen.MathServiceService;
import com.divanov.mathwebservice.gen.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapClientConfig {
    private static final String BASE_URL = "http://localhost:8080";

    @Bean
    public MathServiceService service() {
        return new MathServiceService();
    }

    @Bean
    public MathPortSoap11Impl mathPortSoap11() {
        return new MathPortSoap11Impl(service());
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }
}
