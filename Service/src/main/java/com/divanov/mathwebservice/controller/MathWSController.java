package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.dto.*;
import com.divanov.mathwebservice.endpoint.MathWSEndpoint;
import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calc")
public class MathWSController {

    @Autowired
    private MathWSEndpoint endpoint;

    @GetMapping
    public QuadraticEducationResponse getResult(@RequestParam double a,
                                                @RequestParam double b,
                                                @RequestParam double c) throws QuadraticEducationNoSolutionException {

        ObjectFactory objectFactory = new ObjectFactory();
        QuadraticEducationRequest request = objectFactory.createQuadraticEducationRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);

        return endpoint.getResult(request);
    }
}