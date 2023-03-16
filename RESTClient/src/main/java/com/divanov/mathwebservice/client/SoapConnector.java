<<<<<<< HEAD
package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.exception.SolveQuadraticEducationException;
import com.divanov.mathwebservice.gen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class SoapConnector {

    public SolveQuadraticEducationResponse invokeService(SolveQuadraticEducationRequest request) throws SolveQuadraticEducationException {
        return new MathServiceService().getMathServiceSoap11().solveQuadraticEducation(request);
    }
}
=======
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
>>>>>>> 0621b9d1d806f63a33dee08943842941346e06f0
