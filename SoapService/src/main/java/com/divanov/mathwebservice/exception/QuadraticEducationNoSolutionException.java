package com.divanov.mathwebservice.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{" + QuadraticEducationNoSolutionException.NAMESPACE_URI + "}QuadraticEducationNoSolutionException")
public class QuadraticEducationNoSolutionException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String NAMESPACE_URI = "http://math.ws.divanov";

    public QuadraticEducationNoSolutionException(String message) {
        super(message);
    }
}
