package com.divanov.mathwebservice.config;

import com.divanov.mathwebservice.client.MathClient;
//import com.divanov.mathwebservice.client.MathPortSoap11Impl;
import com.divanov.mathwebservice.gen.MathServiceService;
import com.divanov.mathwebservice.gen.ObjectFactory;
//import com.divanov.mathwebservice.interceptors.MathFaultInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {
    private static final String BASE_URL = "http://localhost:8080";

    @Bean
    public MathServiceService service() {
        return new MathServiceService();
    }

//    @Bean
//    public MathPortSoap11Impl mathPortSoap11() {
//        return new MathPortSoap11Impl(service());
//    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage>
        marshaller.setContextPath("com.divanov.mathwebservice.gen");
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
