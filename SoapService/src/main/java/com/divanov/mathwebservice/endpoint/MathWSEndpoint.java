package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.dto.QuadraticEducationRequest;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MathWSEndpoint {
    public static final String NAME_SPACE = "http://math.ws.divanov";

    private MathService service;

    @Autowired
    public MathWSEndpoint(MathService service) {
        this.service = service;
    }

    public MathWSEndpoint() {
    }

    @PayloadRoot(namespace = NAME_SPACE, localPart = "quadraticEducationRequest")
    @ResponsePayload
    public QuadraticEducationResponse getQuadraticEducationSolution(@RequestPayload QuadraticEducationRequest request) throws QuadraticEducationException {
        return service.solveQuadraticEducation(request.getA(), request.getB(), request.getC());
    }
}
