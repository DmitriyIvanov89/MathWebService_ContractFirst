package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.exceptiondetails.ExceptionDetail;
import com.divanov.mathwebservice.gen.QuadraticEducationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.ws.soap.SOAPFaultException;

@ControllerAdvice
public class MathWSAdvice {

    @ExceptionHandler(QuadraticEducationException.class)
    public ResponseEntity<ExceptionDetail> handleQuadraticEducationException(QuadraticEducationException exception) {
        ExceptionDetail detail = new ExceptionDetail();
        detail.setMessage(exception.getMessage());
        detail.setFormula(exception.getFaultInfo().getFormula());
        detail.setDiscriminant(String.valueOf(exception.getFaultInfo().getDiscriminant()));
        return new ResponseEntity<>(detail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SOAPFaultException.class)
    public ResponseEntity<String> handleSoapFault(SOAPFaultException exception) {
        return new ResponseEntity<>("Message: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handeIllegalArgumentException(IllegalArgumentException exception) {
        return new ResponseEntity<>("Message: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> handleNumberFormatException(NumberFormatException exception) {
        return new ResponseEntity<>("Message: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
