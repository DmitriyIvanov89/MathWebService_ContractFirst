package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.service.gen.ObjectFactory;
import com.divanov.mathwebservice.service.MathServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.divanov.mathwebservice")
public class MathWSEndpointTestTestConfig {

    @Bean
    public MathWSEndpoint mathWSEndpoint(MathServiceImpl mathServiceImpl) {
        return new MathWSEndpoint(mathServiceImpl);
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }
}
