package com.divanov.mathwebservice.exception;

import com.divanov.mathwebservice.service.MathService;
import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{" + MathService.NAME_SPACE + "} NO_SOLUTION_EXCEPTION")
public class NoSolutionException extends MathServiceException {

    public NoSolutionException(String message) {
        super(message);
    }
}
