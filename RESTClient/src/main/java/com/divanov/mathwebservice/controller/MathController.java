package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.client.SoapConnector;
import com.divanov.mathwebservice.gen.CommonFault;
import com.divanov.mathwebservice.gen.ObjectFactory;
import com.divanov.mathwebservice.gen.QuadraticEducationRequestPayLoad;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calc")
public class MathController {
    private final SoapConnector soapConnector;
    private final ObjectFactory objectFactory;

    @Autowired
    public MathController(SoapConnector soapConnector, ObjectFactory objectFactory) {
        this.soapConnector = soapConnector;
        this.objectFactory = objectFactory;
    }

    @GetMapping
    public SolutionQuadraticEducation getResult(@RequestParam double a,
                                                @RequestParam double b,
                                                @RequestParam double c) throws CommonFault {
        QuadraticEducationRequestPayLoad payLoad = objectFactory.createQuadraticEducationRequestPayLoad();
        payLoad.setA(a);
        payLoad.setB(b);
        payLoad.setC(c);
        return soapConnector.getSolveQuadraticEducation(payLoad);

    }


}
