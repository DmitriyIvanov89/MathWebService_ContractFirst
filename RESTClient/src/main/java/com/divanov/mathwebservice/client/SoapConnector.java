package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.gen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class SoapConnector {

    public SolveQuadraticEducationResponse invokeService(SolveQuadraticEducationRequest request) throws SolveQuadraticEducationException {
        return new MathServiceService().getMathServiceSoap11().solveQuadraticEducation(request);
    }

}
