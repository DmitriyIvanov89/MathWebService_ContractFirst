package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.gen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;

public class MathClient extends WebServiceGatewaySupport {
    @Autowired
    private ObjectFactory objectFactory;

    public ObjectFactory getObjectFactory() {
        return objectFactory;
    }

    public SolveQuadraticEducationResponse getSolveQuadraticEducation(SolveQuadraticEducationRequest request) {
        SolveQuadraticEducationResponse response = getObjectFactory().createSolveQuadraticEducationResponse();

        try {
            response = (SolveQuadraticEducationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
        return response;
    }
}
