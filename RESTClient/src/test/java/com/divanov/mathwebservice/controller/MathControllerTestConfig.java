package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.MathServiceService;
import com.divanov.mathwebservice.gen.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.divanov.mathwebservice.gen")
@ComponentScan("target/generated-sources/cxf/com/divanov/mathwebservice/gen")
public class MathControllerTestConfig {

//    @Bean
//    public MathServiceService mathServiceService() {
//        return new MathServiceService();
//    }

//    @Bean
//    public MathController mathController() {
//        return new MathController(mathServiceService());
//    }

    @Bean
    public MathController mathController(MathServiceService mathServiceService) {
        return new MathController(mathServiceService);
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }
}
