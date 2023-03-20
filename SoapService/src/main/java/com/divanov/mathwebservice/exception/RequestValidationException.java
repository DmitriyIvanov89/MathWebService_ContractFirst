package com.divanov.mathwebservice.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

/**
 * Exception in case of invalid data in payload
 */

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{" + RequestValidationException.NAMESPACE_URI + "}VALIDATION_ERROR")
public class RequestValidationException extends MathServiceException {

    private static final long serialVersionUID = 1L;
    public static final String NAMESPACE_URI = "http://math.ws.divanov";

    public RequestValidationException(String message) {
        super(message);
    }
}
