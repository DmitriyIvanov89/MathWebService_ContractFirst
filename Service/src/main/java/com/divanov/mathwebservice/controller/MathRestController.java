package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.endpoint.MathWSEndpoint;
import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;
import com.divanov.mathwebservice.service.QuadraticEducationRequest;
import com.divanov.mathwebservice.service.QuadraticEducationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathRestController {
    private final MathWSEndpoint endpoint;

    @Autowired
    public MathRestController(MathWSEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @GetMapping("/api/calc")
    @ResponseBody
    public QuadraticEducationResponse getSolutionQuadraticEducation(@RequestParam("a") double a,
                                                                    @RequestParam("b") double b,
                                                                    @RequestParam("c") double c) throws QuadraticEducationNoSolutionException {
        QuadraticEducationRequest request = new QuadraticEducationRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);
        return endpoint.createQuadraticEducationResult(request);
    }

}
