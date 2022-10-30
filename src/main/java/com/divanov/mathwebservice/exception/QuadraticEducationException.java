package com.divanov.mathwebservice.exception;

import com.divanov.mathwebservice.service.QuadraticEducationFaultInfo;

public class QuadraticEducationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private QuadraticEducationFaultInfo quadraticEducationFaultInfo;

    public QuadraticEducationException(String message) {
        super(message);
    }

    public QuadraticEducationException(String message, QuadraticEducationFaultInfo quadraticEducationFaultInfo) {
        super(message);
        this.quadraticEducationFaultInfo = quadraticEducationFaultInfo;
    }

    public QuadraticEducationException(String message, Throwable cause, QuadraticEducationFaultInfo quadraticEducationFaultInfo) {
        super(message, cause);
        this.quadraticEducationFaultInfo = quadraticEducationFaultInfo;
    }

    public QuadraticEducationFaultInfo getQuadraticEducationFaultInfo() {
        return quadraticEducationFaultInfo;
    }

    public void setQuadraticEducationFaultInfo(QuadraticEducationFaultInfo quadraticEducationFaultInfo) {
        this.quadraticEducationFaultInfo = quadraticEducationFaultInfo;
    }
}
