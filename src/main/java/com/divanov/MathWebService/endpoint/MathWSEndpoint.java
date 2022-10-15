package com.divanov.MathWebService.endpoint;

import com.divanov.MathWebService.divanov.ws.math.CreateGetSolutionQuadraticEducation;
import com.divanov.MathWebService.divanov.ws.math.CreateResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MathWSEndpoint {

    @ResponsePayload
    @PayloadRoot(localPart = "createResponse", namespace = "http://math.ws.divanov")
    public CreateResponse getSolutionQuadraticEducation(@RequestPayload CreateGetSolutionQuadraticEducation request) {

        CreateResponse response = new CreateResponse();
        response.setX1(request.getA() + request.getB());
        response.setX2(request.getC());
        response.setFormula("OK");
        return response;
    }

}
