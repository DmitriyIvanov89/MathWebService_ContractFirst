package com.divanov.mathwebservice.config;


import com.divanov.mathwebservice.gen.MathServiceService;
import com.divanov.mathwebservice.gen.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class SoapConfig {

    @Bean
    public MathServiceService mathServiceService(@Value("${soap.wsdlLocation}") String wsdlLocation) throws MalformedURLException {
        if (wsdlLocation == null || wsdlLocation.isEmpty()) {
            throw new IllegalArgumentException("wsdlLocation cannot be null or empty");
        }
        return new MathServiceService(new URL(wsdlLocation));
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }
}
