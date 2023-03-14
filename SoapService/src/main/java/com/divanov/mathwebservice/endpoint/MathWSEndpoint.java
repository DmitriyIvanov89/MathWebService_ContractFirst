package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.exception.NoValidDiscriminantValueException;
import com.divanov.mathwebservice.gen.*;
import com.divanov.mathwebservice.service.IMathService;
//import com.divanov.mathwebservice.service.MathServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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
    public SolveQuadraticEducationResponse getQuadraticEducationSolution(@RequestPayload SolveQuadraticEducationRequest request) throws NoValidDiscriminantValueException {
        return getService().solveQuadraticEducation(request);
    }
}

