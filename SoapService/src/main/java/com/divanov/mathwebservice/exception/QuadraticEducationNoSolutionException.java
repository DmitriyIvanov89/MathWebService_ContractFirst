package com.divanov.mathwebservice.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
<<<<<<< HEAD
        customFaultCode = "{" + QuadraticEducationNoSolutionException.NAMESPACE_URI + "}QuadraticEducationNoSolutionException")
public class QuadraticEducationNoSolutionException extends QuadraticEducationException {
=======
        customFaultCode = "{" + QuadraticEducationNoSolutionException.NAMESPACE_URI + "}NO_SOLUTION")
public class QuadraticEducationNoSolutionException extends RuntimeException {
>>>>>>> e4f4c4c9bf329cce44c475aabd189259a8d3dbc0

    private static final long serialVersionUID = 1L;
    public static final String NAMESPACE_URI = "http://math.ws.divanov";

    public QuadraticEducationNoSolutionException(String message) {
        super(message);
    }
}
