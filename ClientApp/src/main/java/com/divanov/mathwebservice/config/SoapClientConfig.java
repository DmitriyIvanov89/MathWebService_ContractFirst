package com.divanov.mathwebservice.config;

import com.divanov.mathwebservice.webservice.MathClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.divanov.mathwebservice.client");
        return marshaller;
    }

    @Bean
    public MathClient mathClient(Jaxb2Marshaller marshaller) {
        MathClient client = new MathClient();
        client.setDefaultUri("http://localhost:8080/services/MathWebService.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
