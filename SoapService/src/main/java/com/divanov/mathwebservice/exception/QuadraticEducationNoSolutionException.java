package com.divanov.mathwebservice.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER)
public class QuadraticEducationNoSolutionException extends RuntimeException {
    public static final String NAMESPACE_URI = "http://math.ws.divanov";

    public QuadraticEducationNoSolutionException(String message) {
        super(message);
    }
}
