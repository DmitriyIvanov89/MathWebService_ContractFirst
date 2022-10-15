package com.divanov.MathWebService.endpoint;

import com.divanov.MathWebService.divanov.ws.math.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MathServiceEndpoint {

    @ResponsePayload
    @PayloadRoot(localPart = "createResponse", namespace = "http://math.ws.divanov")
    public SolutionActionResult createResponse(@RequestPayload EducationParams request) {

        SolutionActionResult response = new SolutionActionResult();
        response.setX1(request.getA() + request.getC());
        return response;
    }


}
