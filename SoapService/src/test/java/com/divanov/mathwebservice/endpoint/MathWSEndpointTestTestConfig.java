package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.dto.ObjectFactory;
import com.divanov.mathwebservice.service.MathService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.divanov.mathwebservice")
public class MathWSEndpointTestTestConfig {

    @Bean
    public MathWSEndpoint mathWSEndpoint(MathService mathService) {
        return new MathWSEndpoint(mathService);
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }
}
