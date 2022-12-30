package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.dto.ObjectFactory;
import com.divanov.mathwebservice.dto.QuadraticEducationRequest;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class MathClient extends WebServiceGatewaySupport {

    public QuadraticEducationResponse getQuadraticEducationSolution(double a, double b, double c) {
        ObjectFactory objectFactory = new ObjectFactory();
        QuadraticEducationRequest request = objectFactory.createQuadraticEducationRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);
        return (QuadraticEducationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
