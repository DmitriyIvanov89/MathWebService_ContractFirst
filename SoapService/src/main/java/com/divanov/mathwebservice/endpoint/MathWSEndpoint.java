package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.exception.SolveQuadraticEducationException;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationRequest;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationResponse;
import com.divanov.mathwebservice.service.MathServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MathWSEndpoint {
    public static final String NAME_SPACE = "http://math.ws.divanov";

    private final MathServiceImpl mathServiceImpl;

    @Autowired
    public MathWSEndpoint(MathServiceImpl mathServiceImpl) {
        this.mathServiceImpl = mathServiceImpl;
    }

    public MathServiceImpl getMathServiceImpl() {
        return mathServiceImpl;
    }

    @PayloadRoot(namespace = NAME_SPACE, localPart = "solveQuadraticEducationRequest")
    @ResponsePayload
    public SolveQuadraticEducationResponse getQuadraticEducationSolution(@RequestPayload SolveQuadraticEducationRequest request) throws SolveQuadraticEducationException {
        return mathServiceImpl.solveQuadraticEducation(request);
    }
}

