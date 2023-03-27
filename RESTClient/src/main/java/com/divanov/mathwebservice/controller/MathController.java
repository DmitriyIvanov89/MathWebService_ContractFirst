package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.*;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calc")
public class MathController {
    private final MathServiceService service;
    private final ObjectFactory objectFactory;

    @Autowired
    public MathController(MathServiceService service) {
        this.service = service;
        this.objectFactory = new ObjectFactory();
    }

    @GetMapping
    public SolutionQuadraticEducation getResult(@RequestParam double a,
                                                @RequestParam double b,
                                                @RequestParam double c) throws QuadraticEducationException {
        QuadraticEducationRequestPayLoad payLoad = objectFactory.createQuadraticEducationRequestPayLoad();
        payLoad.setA(a);
        payLoad.setB(b);
        payLoad.setC(c);

        return service.getMathServiceSoap11().getSolveQuadraticEducation(payLoad);

    }
}
