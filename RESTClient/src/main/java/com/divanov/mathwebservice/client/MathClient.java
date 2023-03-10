package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.gen.*;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class MathClient extends WebServiceGatewaySupport {
    @Autowired
    private ObjectFactory objectFactory;

    public SolveQuadraticEducationResponse getSolveQuadraticEducation(SolveQuadraticEducationRequest request) {
        return (SolveQuadraticEducationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
