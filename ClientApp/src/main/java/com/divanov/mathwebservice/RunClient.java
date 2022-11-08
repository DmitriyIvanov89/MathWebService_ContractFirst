package com.divanov.mathwebservice;

import com.divanov.mathwebservice.client.QuadraticEducationResponse;
import com.divanov.mathwebservice.config.SoapClientConfig;
import com.divanov.mathwebservice.webservice.MathClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RunClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SoapClientConfig.class);
        MathClient client = context.getBean(MathClient.class);
        QuadraticEducationResponse response = client.getSolutionQuadraticEducation(1, 3, -2);
//        System.out.println(response);
    }

}
