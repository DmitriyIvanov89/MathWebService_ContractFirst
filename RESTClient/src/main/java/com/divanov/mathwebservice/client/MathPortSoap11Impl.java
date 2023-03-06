package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.generated.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * This class was generated by Apache CXF 3.5.3
 * 2023-02-09T23:06:39.264+03:00
 * Generated source version: 3.5.3
 */

@WebService(
        serviceName = "MathService",
        portName = "MathPortSoap11",
        targetNamespace = "http://math.ws.divanov",
        wsdlLocation = "http://localhost:8080/services/MathService.wsdl",
        endpointInterface = "com.divanov.mathwebservice.dto.MathPort")

public class MathPortSoap11Impl implements MathServicePort {
    private final MathService service;

    @Autowired
    public MathPortSoap11Impl(MathService service) {
        this.service = service;
    }

    public MathService getService() {
        return service;
    }

    @Override
    public SolveQuadraticEducationResponse solveQuadraticEducation(SolveQuadraticEducationRequest solveQuadraticEducationRequest) {
        SolveQuadraticEducationResponse response = new SolveQuadraticEducationResponse();

        try {
            response = getService().getMathServicePortSoap11().solveQuadraticEducation(solveQuadraticEducationRequest);
        } catch (CommonFault ex) {
            System.err.println(ex.getFaultInfo().getFormula());
        }
        return response;
    }
}
