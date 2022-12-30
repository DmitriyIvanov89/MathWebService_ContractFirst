package com.divanov.mathwebservice.config;

import com.divanov.mathwebservice.client.MathClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {
    private static final String BASE_URL = "http://localhost:8080";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage>
        marshaller.setContextPath("com.divanov.mathwebservice.dto");
        return marshaller;
    }

    @Bean
    public MathClient mathClient(Jaxb2Marshaller marshaller) {
        MathClient mathClient = new MathClient();
        mathClient.setDefaultUri("http://localhost:8080/services/MathServiceEndpoint");
        mathClient.setMarshaller(marshaller);
        mathClient.setUnmarshaller(marshaller);
        return mathClient;
    }
}
