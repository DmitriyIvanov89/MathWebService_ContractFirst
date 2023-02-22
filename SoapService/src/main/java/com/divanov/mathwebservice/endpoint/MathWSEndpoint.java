package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.gen.QuadraticEducationResponse;
import com.divanov.mathwebservice.gen.QuadraticEducationRequest;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.service.MathServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MathWSEndpoint {
    private static final String NAME_SPACE = "http://math.ws.divanov";
    private final MathServiceImpl mathServiceImpl;

    @Autowired
    public MathWSEndpoint(MathServiceImpl mathServiceImpl) {
        this.mathServiceImpl = mathServiceImpl;
    }

    @PayloadRoot(namespace = NAME_SPACE, localPart = "quadraticEducationRequest")
    @ResponsePayload
    public QuadraticEducationResponse getQuadraticEducationSolution(@RequestPayload QuadraticEducationRequest request) throws QuadraticEducationException {
        return mathServiceImpl.solveQuadraticEducation(request.getA(), request.getB(), request.getC());
    }
}
