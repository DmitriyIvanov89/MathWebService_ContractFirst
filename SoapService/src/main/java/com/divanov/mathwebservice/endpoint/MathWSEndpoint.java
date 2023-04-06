package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.service.gen.ObjectFactory;
import com.divanov.mathwebservice.service.gen.QuadraticEducationRequestPayLoad;
import com.divanov.mathwebservice.service.gen.SolutionQuadraticEducation;
import com.divanov.mathwebservice.service.MathService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;


@Endpoint
public class MathWSEndpoint {
    private static final Logger log = LogManager.getLogger(MathWSEndpoint.class);

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

        log.debug("Received request with params:a: {}, b: {}, c{}", payLoad.getA(), payLoad.getB(), payLoad.getC());

        SolutionQuadraticEducation solution = getService().solveQuadraticEducation(payLoad.getA(), payLoad.getB(), payLoad.getC());

        log.info("Send response:formula - {}, discriminant - {}", solution.getFormula(), solution.getDiscriminant());
        log.warn("Send response:formula - {}, discriminant - {}", solution.getFormula(), solution.getDiscriminant());
        log.error("Send response:formula - {}, discriminant - {}", solution.getFormula(), solution.getDiscriminant());
        log.fatal("Send response:formula - {}, discriminant - {}", solution.getFormula(), solution.getDiscriminant());

        return objectFactory.createGetSolveQuadraticEducationResponse(solution);
    }
}

