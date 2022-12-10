package com.divanov.mathwebservice;

import com.divanov.mathwebservice.client.MathClient;
import com.divanov.mathwebservice.config.SoapClientConfig;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RunClient {
    /**
     * The first way to call the service
     * Just execute run the app
     * Parameters are passed to the getSolution method
     */

    public static void main(String[] args) {
        SpringApplication.run(RunClient.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        MathClient mathClient = context.getBean(MathClient.class);

        QuadraticEducationResponse response = mathClient.createResult(5, 1, -1);

        System.out.printf("Service response:\nFormula: %s\nDiscriminant : %f\nx1 : %f\nx2 : %f\n",
                response.getFormula(), response.getDiscriminant(), response.getX1(), response.getX2());
    }

    /**
     * The second way to call the service
     * First you need to do 'mvn clean install' in command line
     * Then 'java -jar target/ClientApp.jar a b c
     * where a,b,c - service call parameters
     * More information in file commands.txt in resources dir
     */

//    public static void main(String[] args) {
//        SpringApplication.run(RunClient.class, args);
//    }
//
//    @Bean
//    CommandLineRunner lookup(MathClient client) {
//        return args -> {
//            double a = 1;
//            double b = 1;
//            double c = 1;
//            if (args.length > 0) {
//                a = Double.parseDouble(args[0]);
//                b = Double.parseDouble(args[1]);
//                c = Double.parseDouble(args[2]);
//            }
//
//            QuadraticEducationRequest request = new QuadraticEducationRequest();
//            request.setA(a);
//            request.setB(b);
//            request.setC(c);
//            QuadraticEducationResponse response = (QuadraticEducationResponse) client.callWebService("http://localhost:8080/services/MathServiceHttpEndpoint", request);
//            System.out.printf("Response from service:\nx1 = %f\nx2 = %f\ndiscriminant = %f\nformula = %s",
//                    response.getX1(),
//                    response.getX2(),
//                    response.getD(),
//                    response.getFormula());
//        };
//    }
}
