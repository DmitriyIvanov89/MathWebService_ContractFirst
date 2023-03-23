package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.ErrorFault;
import com.divanov.mathwebservice.gen.QuadraticEducationException;
import org.apache.cxf.binding.soap.SoapFault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MathWSAdvice {

    @ExceptionHandler(QuadraticEducationException.class)
    public ResponseEntity<ErrorFault> handleQuadraticEducationException(QuadraticEducationException exception) {
        ErrorFault errorFault = new ErrorFault();
        errorFault.setMessage(exception.getMessage());
        errorFault.setFormula(exception.getFaultInfo().getFormula());
        errorFault.setDiscriminant(exception.getFaultInfo().getDiscriminant());
        return new ResponseEntity<>(errorFault, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.apache.cxf.binding.soap.SoapFault.class)
    public ResponseEntity<String> handleSoapFault(SoapFault exception) {
        return new ResponseEntity<>("Message: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
