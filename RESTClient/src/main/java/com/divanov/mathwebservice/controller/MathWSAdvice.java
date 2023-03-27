package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.ErrorResponse;
import com.divanov.mathwebservice.gen.QuadraticEducationException;
import org.apache.cxf.binding.soap.SoapFault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MathWSAdvice {

    @ExceptionHandler(QuadraticEducationException.class)
    public ResponseEntity<ErrorResponse> handleQuadraticEducationException(QuadraticEducationException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setFormula(exception.getFaultInfo().getFormula());
        errorResponse.setDiscriminant(exception.getFaultInfo().getDiscriminant());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.apache.cxf.binding.soap.SoapFault.class)
    public ResponseEntity<String> handleSoapFault(SoapFault exception) {
        return new ResponseEntity<>("Message: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
