//package com.divanov.mathwebservice.client;
//
//import com.divanov.mathwebservice.gen.*;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.jws.WebService;
//
///**
// * This class was generated by Apache CXF 3.5.3
// * 2023-02-09T23:06:39.264+03:00
// * Generated source version: 3.5.3
// */
//
//@WebService(
//        serviceName = "MathServiceService",
//        portName = "MathServiceSoap11",
//        targetNamespace = "http://math.ws.divanov",
//        wsdlLocation = "http://localhost:8080/services/math.wsdl",
//        endpointInterface = "com.divanov.mathwebservice.gen.MathService")
//
//public class MathPortSoap11Impl implements MathService {
//    private final MathServiceService service;
//
//    @Autowired
//    public MathPortSoap11Impl(MathServiceService service) {
//        this.service = service;
//    }
//
//    public MathServiceService getService() {
//        return service;
//    }
//
//    @Override
//    public SolveQuadraticEducationResponse solveQuadraticEducation(SolveQuadraticEducationRequest solveQuadraticEducationRequest) {
//        SolveQuadraticEducationResponse response = new SolveQuadraticEducationResponse();
//
//        try {
//            response = getService().getMathServiceSoap11().solveQuadraticEducation(solveQuadraticEducationRequest);
//        } catch (SolveQuadraticEducationException e) {
//            System.err.println(e.getMessage());
//        }
//        return response;
//    }
//}
