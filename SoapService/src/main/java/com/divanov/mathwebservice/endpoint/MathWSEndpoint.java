package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.gen.SolveQuadraticEducationRequest;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationResponse;
import com.divanov.mathwebservice.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.addressing.server.annotation.Action;


@Endpoint
public class MathWSEndpoint {
    private final MathService service;

    @Autowired
    public MathWSEndpoint(MathService service) {
        this.service = service;
    }

    public MathService getService() {
        return service;
    }

    @PayloadRoot(namespace = MathService.NAME_SPACE, localPart = "solveQuadraticEducationRequest")
    @ResponsePayload
    public SolveQuadraticEducationResponse getSolutionQuadraticEducation(@RequestPayload SolveQuadraticEducationRequest request) {
        return getService().solveQuadraticEducation(request.getA(), request.getB(), request.getC());
    }
}

