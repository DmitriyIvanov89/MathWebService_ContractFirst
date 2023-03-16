package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.gen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;

import javax.xml.bind.JAXBElement;
import java.sql.PreparedStatement;

public class MathClient extends WebServiceGatewaySupport {
    @Autowired
    private ObjectFactory objectFactory;

    public ObjectFactory getObjectFactory() {
        return objectFactory;
    }

    public JAXBElement<SolveQuadraticEducationResponse> getSolveQuadraticEducation(JAXBElement<SolveQuadraticEducationRequest> request) {
        JAXBElement<SolveQuadraticEducationResponse> response = null;

        try {
            response = (JAXBElement<SolveQuadraticEducationResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
        } catch (SoapFaultClientException e) {
            System.err.println(e.getFaultCode());
            System.err.println(e.getFaultStringOrReason());
            System.err.println(e.getSoapFault().getFaultDetail().getResult().toString());
        }
        return response;
    }
}
