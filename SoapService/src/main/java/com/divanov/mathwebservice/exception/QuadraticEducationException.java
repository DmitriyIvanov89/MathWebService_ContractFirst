package com.divanov.mathwebservice.exception;

import com.divanov.mathwebservice.dto.QuadraticEducationFault;

import javax.xml.ws.WebFault;

@WebFault(name = "quadraticEducationFault", targetNamespace = "http://math.ws.divanov")
public class QuadraticEducationException extends Exception {

    private static final long serialVersionUID = -6647544772732631037L;
    private QuadraticEducationFault quadraticEducationFault;

    public QuadraticEducationException(String message) {
        super(message);
    }

    public QuadraticEducationException(QuadraticEducationFault quadraticEducationFault) {
        this.quadraticEducationFault = quadraticEducationFault;
    }

    public QuadraticEducationException(String message, QuadraticEducationFault quadraticEducationFault) {
        super(message);
        this.quadraticEducationFault = quadraticEducationFault;
    }

    public QuadraticEducationException(String message, Throwable cause, QuadraticEducationFault quadraticEducationFault) {
        super(message, cause);
        this.quadraticEducationFault = quadraticEducationFault;
    }

    public QuadraticEducationFault getQuadraticEducationFault() {
        return quadraticEducationFault;
    }

    public void setQuadraticEducationFault(QuadraticEducationFault quadraticEducationFault) {
        this.quadraticEducationFault = quadraticEducationFault;
    }
}
