package com.divanov.mathwebservice;

import com.divanov.mathwebservice.client.MathClient;
import com.divanov.mathwebservice.config.SoapClientConfig;
import com.divanov.mathwebservice.dto.ObjectFactory;
import com.divanov.mathwebservice.dto.QuadraticEducationRequest;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class RunClient {
    /**
     * The first way to call the service
     * Just execute run the app
     * Parameters are passed to the getSolution method
     */

//    public static void main(String[] args) {
//        SpringApplication.run(RunClient.class);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
//        MathClient mathClient = context.getBean(MathClient.class);
//
//        QuadraticEducationResponse response = mathClient.getQuadraticEducationResult(5, 1, -1);
//    }

    /**
     * The second way to call the service
     * First you need to do 'mvn clean install' in command line
     * Then 'java -jar target/ClientApp.jar a b c
     * where a,b,c - service call parameters
     * More information in file commands.txt in resources dir
     */

    public static void main(String[] args) {
        SpringApplication.run(RunClient.class, args);
    }

    @Bean
    CommandLineRunner lookup(MathClient client) {
        return args -> {
            double a = 0;
            double b = 0;
            double c = 0;
            if (args.length > 0) {
                a = Double.parseDouble(args[0]);
                b = Double.parseDouble(args[1]);
                c = Double.parseDouble(args[2]);
            }

            ObjectFactory objectFactory = new ObjectFactory();
            QuadraticEducationRequest request = objectFactory.createQuadraticEducationRequest();
            request.setA(a);
            request.setB(b);
            request.setC(c);
            QuadraticEducationResponse response = client.getQuadraticEducationResult(5, 1, -1);
            System.out.printf("Response:\nFormula: %s\nDiscriminant - %f\nx1 - %f\nx2 - %f\n",
                    response.getFormula(),
                    response.getDiscriminant(),
                    response.getX1(),
                    response.getX2());
        };
    }
}
