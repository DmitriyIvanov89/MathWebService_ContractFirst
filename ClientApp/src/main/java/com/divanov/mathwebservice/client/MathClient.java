package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.generated.QuadraticEducationRequest;
import com.divanov.mathwebservice.generated.QuadraticEducationResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class MathClient extends WebServiceGatewaySupport {

//    public QuadraticEducationResponse getSolution(double a, double b, double c) {
//
//        QuadraticEducationRequest request = new QuadraticEducationRequest();
//        request.setA(a);
//        request.setB(b);
//        request.setC(c);
//
//        return (QuadraticEducationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
//
//    }

//    public Object callWebService(String url, Object request) {
//        return getWebServiceTemplate().marshalSendAndReceive(url, request);
//    }


    public QuadraticEducationResponse createResult(String url, QuadraticEducationRequest request) {
        return (QuadraticEducationResponse) getWebServiceTemplate().marshalSendAndReceive(url, request);
    }

}
