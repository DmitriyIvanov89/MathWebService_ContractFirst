package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.gen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class MathClient extends WebServiceGatewaySupport {
    @Autowired
    private ObjectFactory objectFactory;

    public ObjectFactory getObjectFactory() {
        return objectFactory;
    }

    public JAXBElement<SolveQuadraticEducationResponse> getSolveQuadraticEducation(JAXBElement<SolveQuadraticEducationRequest> request) {
        JAXBElement<SolveQuadraticEducationResponse> response = (JAXBElement<SolveQuadraticEducationResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
        return response;
    }
}
