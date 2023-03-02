package com.divanov.mathwebservice.config;

;
import com.divanov.mathwebservice.client.MathPortSoap11Impl;
import com.divanov.mathwebservice.generated.MathService;
import com.divanov.mathwebservice.generated.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapClientConfig {
    private static final String BASE_URL = "http://localhost:8080";

    @Bean
    public MathService service() {
        return new MathService();
    }

    @Bean
    public MathPortSoap11Impl mathPortSoap11() {
        return new MathPortSoap11Impl(service());
    }

//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        // this is the package name specified in the <generatePackage>
//        marshaller.setContextPath("com.divanov.mathwebservice.dto");
//        return marshaller;
//    }

//    @Bean
//    public MathClient mathClient(Jaxb2Marshaller jaxb2Marshaller) {
//        MathClient client = new MathClient();
//        client.setDefaultUri("http://localhost:8080/services/MathServiceEndpoint");
//        client.setMarshaller(jaxb2Marshaller);
//        client.setUnmarshaller(jaxb2Marshaller);
//        return client;
//    }

//    @Bean
//    public MathClient mathClient(Jaxb2Marshaller jaxb2Marshaller) {
//        MathClient client = new MathClient();
//        client.setDefaultUri("http://localhost:8080/services/MathServiceEndpoint");
//        client.setMarshaller(jaxb2Marshaller);
//        client.setUnmarshaller(jaxb2Marshaller);
//        return client;
//    }


    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }
}
