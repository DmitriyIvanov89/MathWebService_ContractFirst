package com.divanov.mathwebservice.config;

import com.divanov.mathwebservice.client.SoapConnector;
import com.divanov.mathwebservice.gen.MathServiceService;
import com.divanov.mathwebservice.gen.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapConfig {
    @Bean
    public MathServiceService mathServiceService() {
        return new MathServiceService();
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }

    @Bean
    public SoapConnector soapConnector() {
        return new SoapConnector(mathServiceService());
    }

}
