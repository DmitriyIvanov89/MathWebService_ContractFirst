package com.divanov.mathwebservice.webservice;

import com.divanov.mathwebservice.client.QuadraticEducationRequest;
import com.divanov.mathwebservice.client.QuadraticEducationResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class MathClient extends WebServiceGatewaySupport {

    public QuadraticEducationResponse getSolutionQuadraticEducation(double a, double b, double c) {
        QuadraticEducationRequest request = new QuadraticEducationRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);
        return (QuadraticEducationResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback("http://localhost:8080/services/QuadraticEducationRequest"));
    }
}
