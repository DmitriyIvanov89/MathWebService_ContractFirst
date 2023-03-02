package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.gen.QuadraticEducationRequest;
import com.divanov.mathwebservice.gen.QuadraticEducationRequestParams;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducationResponse;
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
    public SolutionQuadraticEducationResponse getQuadraticEducationSolution(@RequestPayload QuadraticEducationRequest request) {
        return service.getSolutionQuadraticEducation(request.getRequest().getA(), request.getRequest().getB(), request.getRequest().getC());
    }
}
