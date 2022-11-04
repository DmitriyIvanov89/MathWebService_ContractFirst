package com.divanov.mathwebservice.exception;

import com.divanov.mathwebservice.service.QuadraticEducationFault;

public class QuadraticEducationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private QuadraticEducationFault quadraticEducationFault;

    public QuadraticEducationException(String message) {
        super(message);
    }

    public QuadraticEducationException(String message, QuadraticEducationFault quadraticEducationFault) {
        super(message);
        this.quadraticEducationFault = quadraticEducationFault;
    }

    public QuadraticEducationException(String message, Throwable cause, QuadraticEducationFault quadraticEducationFault) {
        super(message, cause);
        this.quadraticEducationFault = quadraticEducationFault;
    }

    public QuadraticEducationFault getQuadraticEducationFaultInfo() {
        return quadraticEducationFault;
    }

    public void setQuadraticEducationFaultInfo(QuadraticEducationFault quadraticEducationFault) {
        this.quadraticEducationFault = quadraticEducationFault;
    }
}
