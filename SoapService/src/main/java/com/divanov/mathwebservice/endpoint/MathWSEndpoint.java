package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.gen.ObjectFactory;
import com.divanov.mathwebservice.gen.QuadraticEducationRequestPayLoad;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;
import com.divanov.mathwebservice.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.addressing.server.annotation.Action;

import javax.xml.bind.JAXBElement;


@Endpoint
public class MathWSEndpoint {
    private final MathService service;
    private final ObjectFactory objectFactory;

    @Autowired
    public MathWSEndpoint(MathService service) {
        this.service = service;
        this.objectFactory = new ObjectFactory();
    }

    public MathService getService() {
        return service;
    }

    @PayloadRoot(namespace = MathService.NAME_SPACE, localPart = "getSolveQuadraticEducationRequest")
    @ResponsePayload
    public JAXBElement<SolutionQuadraticEducation> getSolutionQuadraticEducation(@RequestPayload QuadraticEducationRequestPayLoad payLoad) {
        SolutionQuadraticEducation solution = getService().solveQuadraticEducation(payLoad.getA(), payLoad.getB(), payLoad.getC());
        return objectFactory.createGetSolveQuadraticEducationResponse(solution);
    }
}

