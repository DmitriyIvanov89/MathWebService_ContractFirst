package com.divanov.mathwebservice.controller;

//import com.divanov.mathwebservice.client.MathClient;
//import com.divanov.mathwebservice.client.MathPortSoap11Impl;
import com.divanov.mathwebservice.client.SoapConnector;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationRequest;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationResponse;
import org.apache.neethi.PolicyRegistryImpl;
//import com.divanov.mathwebservice.client.MathClient;
import com.divanov.mathwebservice.gen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBElement;

@RestController
@RequestMapping("/api/calc")
public class MathWSController {

    //    @Autowired
//    private MathPortSoap11Impl mathPortSoap11;
//
//    @Autowired
//    private ObjectFactory objectFactory;
//
//    @GetMapping
//    public SolveQuadraticEducationResponse getResult(@RequestParam double a,
//                                                     @RequestParam double b,
//                                                     @RequestParam double c) throws SolveQuadraticEducationException {
//        SolveQuadraticEducationRequest request = objectFactory.createSolveQuadraticEducationRequest();
//        request.setA(a);
//        request.setB(b);
//        request.setC(c);
//
//        return mathPortSoap11.solveQuadraticEducation(request);
//    }
//    @Autowired
//    private MathClient client;
//
//    @Autowired
//    private ObjectFactory objectFactory;
//
//    @GetMapping
//    public JAXBElement<SolveQuadraticEducationResponse> getResult(@RequestParam Double a,
//                                                                  @RequestParam Double b,
//                                                                  @RequestParam Double c) {
//        SolveQuadraticEducationRequest request = new SolveQuadraticEducationRequest();
//        request.setA(a);
//        request.setB(b);
//        request.setC(c);
//
//        return client.getSolveQuadraticEducation(request);
//    }

    @Autowired
    private SoapConnector soapConnector;

    @GetMapping
    public SolveQuadraticEducationResponse getResult(@RequestParam Double a,
                                                     @RequestParam Double b,
                                                     @RequestParam Double c) throws SolveQuadraticEducationException {
        SolveQuadraticEducationRequest request = new SolveQuadraticEducationRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);

        return soapConnector.invokeService(request);
    }

}