package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.gen.*;
import org.springframework.beans.factory.annotation.Autowired;

public class SoapConnector implements MathService {
    private final MathServiceService service;

    @Autowired
    public SoapConnector(MathServiceService service) {
        this.service = service;
    }

    public MathServiceService getService() {
        return service;
    }

    @Override
    public SolutionQuadraticEducation getSolveQuadraticEducation(QuadraticEducationRequestPayLoad getSolveQuadraticEducationRequest) throws CommonFault {
        return getService().getMathServiceSoap11().getSolveQuadraticEducation(getSolveQuadraticEducationRequest);
    }
}
