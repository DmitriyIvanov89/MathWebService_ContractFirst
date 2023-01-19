package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.dto.QuadraticEducationRequest;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import com.divanov.mathwebservice.service.exception.QuadraticEducationNoSolutionException;;
import com.divanov.mathwebservice.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MathWSEndpoint {
    private static final String NAME_SPACE = "http://math.ws.divanov";
    private final MathService mathService;

    @Autowired
    public MathWSEndpoint(MathService mathService) {
        this.mathService = mathService;
    }

    @PayloadRoot(namespace = NAME_SPACE, localPart = "QuadraticEducationRequest")
    @ResponsePayload
    public QuadraticEducationResponse getQuadraticEducationSolution(@RequestPayload QuadraticEducationRequest request) throws QuadraticEducationNoSolutionException {
        return mathService.solveQuadraticEducation(request);
    }
}
