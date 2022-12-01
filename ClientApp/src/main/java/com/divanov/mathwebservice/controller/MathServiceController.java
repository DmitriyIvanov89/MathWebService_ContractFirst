package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.client.MathClient;
import com.divanov.mathwebservice.generated.ObjectFactory;
import com.divanov.mathwebservice.generated.QuadraticEducationRequest;
import com.divanov.mathwebservice.generated.QuadraticEducationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathServiceController {

    @Autowired
    private MathClient mathClient;

    @RequestMapping("/api/calc")
    public QuadraticEducationResponse getSolutionQuadraticEducation(@RequestParam double a,
                                                                    @RequestParam double b,
                                                                    @RequestParam double c) {
        ObjectFactory objectFactory = new ObjectFactory();
        QuadraticEducationRequest request = objectFactory.createQuadraticEducationRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);

        return mathClient.createResult("http://localhost:8080/api/calc", request);

    }

}
