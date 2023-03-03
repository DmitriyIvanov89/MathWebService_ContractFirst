package com.divanov.mathwebservice.endpoint;

<<<<<<< HEAD
import com.divanov.mathwebservice.gen.QuadraticEducationResponse;
import com.divanov.mathwebservice.gen.QuadraticEducationRequest;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.service.MathServiceImpl;
=======
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.gen.QuadraticEducationRequest;
import com.divanov.mathwebservice.gen.QuadraticEducationRequestParams;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducationResponse;
import com.divanov.mathwebservice.service.MathService;
>>>>>>> e4f4c4c9bf329cce44c475aabd189259a8d3dbc0
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

<<<<<<< HEAD
    @PayloadRoot(namespace = NAME_SPACE, localPart = "quadraticEducationRequest")
    @ResponsePayload
    public QuadraticEducationResponse getQuadraticEducationSolution(@RequestPayload QuadraticEducationRequest request) throws QuadraticEducationException {
        return mathServiceImpl.solveQuadraticEducation(request.getA(), request.getB(), request.getC());
=======
    public MathWSEndpoint() {
    }

    @PayloadRoot(namespace = NAME_SPACE, localPart = "quadraticEducationRequest")
    @ResponsePayload
    public SolutionQuadraticEducationResponse getQuadraticEducationSolution(@RequestPayload QuadraticEducationRequest request) {
        return service.getSolutionQuadraticEducation(request.getRequest().getA(), request.getRequest().getB(), request.getRequest().getC());
>>>>>>> e4f4c4c9bf329cce44c475aabd189259a8d3dbc0
    }
}
