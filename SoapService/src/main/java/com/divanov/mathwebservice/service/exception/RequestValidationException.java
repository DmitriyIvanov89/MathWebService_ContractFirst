package com.divanov.mathwebservice.service.exception;

import com.divanov.mathwebservice.service.MathService;
import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

/**
 * Exception in case of invalid data in payload
 */

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{" + MathService.NAME_SPACE + "}VALIDATION_ERROR")
public class RequestValidationException extends MathServiceException {

    public RequestValidationException(String message) {
        super(message);
    }
}
