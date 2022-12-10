package com.divanov.mathwebservice.config;

import com.divanov.mathwebservice.client.MathClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage>
        marshaller.setContextPath("com.divanov.mathwebservice.dto");
        return marshaller;
    }

    @Bean
    public MathClient clientTest() {
        return new MathClient();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.create("http://localhost:8080");
    }
}
