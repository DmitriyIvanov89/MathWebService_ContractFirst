package com.divanov.mathwebservice;

import com.divanov.mathwebservice.client.MathClient;
import com.divanov.mathwebservice.config.SoapClientConfig;
import com.divanov.mathwebservice.generated.QuadraticEducationResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RunClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        MathClient client = context.getBean(MathClient.class);
        QuadraticEducationResponse response = client.getSolution(1, -3, 4);
        System.out.printf("Service said: %f", response);
    }
}
