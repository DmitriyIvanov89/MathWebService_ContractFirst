package com.divanov.MathWebService.endpoint;

import com.divanov.MathWebService.divanov.ws.math.CreateGetSolutionQuadraticEducationRequest;
import com.divanov.MathWebService.divanov.ws.math.CreateResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MathWSEndpoint {

    @PayloadRoot(namespace = "http://math.ws.divanov", localPart = "createGetSolutionQuadraticEducationRequest")
    @ResponsePayload
    public CreateResponse createResponse(@RequestPayload CreateGetSolutionQuadraticEducationRequest request) {
        CreateResponse response = new CreateResponse();
        response.setFormula("Ok");
        response.setX1(request.getA() + request.getB());
        response.setX2(request.getC());
        return response;
    }

}
