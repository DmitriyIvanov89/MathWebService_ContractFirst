//package com.divanov.mathwebservice.client;
//
//import com.divanov.mathwebservice.gen.*;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class SoapConnector {
//    private final MathServiceService service;
//
//    @Autowired
//    public SoapConnector(MathServiceService service) {
//        this.service = service;
//    }
//
//    public MathServiceService getService() {
//        return service;
//    }
//
//    public SolveQuadraticEducationResponse invokeService(SolveQuadraticEducationRequest request) throws SolveQuadraticEducationException {
//        return getService().getMathServiceSoap11().solveQuadraticEducation(request);
//    }
//
//}
