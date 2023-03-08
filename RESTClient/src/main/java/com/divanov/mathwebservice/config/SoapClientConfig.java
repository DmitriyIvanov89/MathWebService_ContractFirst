package com.divanov.mathwebservice.config;

import com.divanov.mathwebservice.client.MathClient;
import com.divanov.mathwebservice.client.MathPortSoap11Impl;
import com.divanov.mathwebservice.gen.MathServiceService;
import com.divanov.mathwebservice.gen.ObjectFactory;
import com.divanov.mathwebservice.interceptors.MathFaultInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;

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

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.divanov.mathwebservice.gen");
        return marshaller;
    }

    @Bean
    public MathFaultInterceptor interceptor() {
        return new MathFaultInterceptor();
    }

//    @Bean
//    public MathClient mathClient(Jaxb2Marshaller marshaller) {
//        MathClient client = new MathClient();
//        client.setDefaultUri("http://localhost:8080/services/MathServiceEndpoint");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
//        MathFaultInterceptor interceptor = new MathFaultInterceptor();
//        ClientInterceptor[] interceptors = new ClientInterceptor[] {(ClientInterceptor) interceptor()};
//        client.setInterceptors();
//        return client;
//    }
}
