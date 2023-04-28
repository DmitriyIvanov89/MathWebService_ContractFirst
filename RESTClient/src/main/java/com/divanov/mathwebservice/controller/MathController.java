package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.*;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/api")
public class MathController {
    private final Logger log = LogManager.getLogger(MathController.class);

    private final MathServiceService service;
    private final ObjectFactory objectFactory;

    @Autowired
    public MathController(@Value("${soap.wsdlLocation}") String wsdlLocation, MathServiceService service) throws MalformedURLException {
        this.service = new MathServiceService(new URL(wsdlLocation));
        this.objectFactory = new ObjectFactory();
    }

    @GetMapping("/calc")
    public SolutionQuadraticEducation getResult(@RequestParam double a,
                                                @RequestParam double b,
                                                @RequestParam double c) throws QuadraticEducationException {
        QuadraticEducationRequestPayLoad payLoad = objectFactory.createQuadraticEducationRequestPayLoad();
        payLoad.setA(a);
        payLoad.setB(b);
        payLoad.setC(c);

        log.info("Start processing request with params: a = {}, b = {}, c = {}", payLoad.getA(), payLoad.getB(), payLoad.getC());

        return service.getMathServiceSoap11().getSolveQuadraticEducation(payLoad);

    }
}
