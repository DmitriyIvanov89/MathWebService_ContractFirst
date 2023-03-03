package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.gen.QuadraticEducationRequest;
import com.divanov.mathwebservice.gen.QuadraticEducationResponse;
import com.divanov.mathwebservice.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MathWSEndpoint {
    public static final String NAME_SPACE = "http://math.ws.divanov";

    private final MathService mathService;

    @Autowired
    public MathWSEndpoint(MathService mathService) {
        this.mathService = mathService;
    }

    public MathService getMathService() {
        return mathService;
    }

    @PayloadRoot(namespace = NAME_SPACE, localPart = "quadraticEducationRequest")
    @ResponsePayload
    public QuadraticEducationResponse getQuadraticEducationSolution(@RequestPayload QuadraticEducationRequest request) throws QuadraticEducationException {
        return getMathService().solveQuadraticEducation(request.getA(), request.getB(), request.getC());
    }
}

