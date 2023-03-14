package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.exception.*;
import com.divanov.mathwebservice.gen.*;
import com.divanov.mathwebservice.service.IMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;

@Endpoint
public class MathWSEndpoint {
    public static final String NAME_SPACE = "http://math.ws.divanov";

    private final IMathService service;
    private final ObjectFactory objectFactory;

    @Autowired
    public MathWSEndpoint(IMathService service) {
        this.service = service;
        this.objectFactory = new ObjectFactory();
    }

    public IMathService getService() {
        return service;
    }

    public ObjectFactory getObjectFactory() {
        return objectFactory;
    }

    @PayloadRoot(namespace = NAME_SPACE, localPart = "solveQuadraticEducationRequest")
    @ResponsePayload
    public JAXBElement<SolveQuadraticEducationResponse> getQuadraticEducationSolution(@RequestPayload SolveQuadraticEducationRequest request) throws SolveQuadraticEducationException {
        SolveQuadraticEducationResponse response = service.solveQuadraticEducation(request);
        return objectFactory.createSolveQuadraticEducationResponse(response);
    }
}

