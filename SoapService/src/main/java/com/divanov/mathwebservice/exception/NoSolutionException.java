package com.divanov.mathwebservice.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{" + NoSolutionException.NAMESPACE_URI + "} NO_SOLUTION_EXCEPTION")
public class NoSolutionException extends MathServiceException {

    public static final String NAMESPACE_URI = "http://math.ws.divanov";

    public NoSolutionException(String message) {
        super(message);
    }
}
