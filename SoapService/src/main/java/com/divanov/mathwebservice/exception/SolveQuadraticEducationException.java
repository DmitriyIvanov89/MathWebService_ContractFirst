package com.divanov.mathwebservice.exception;

import com.divanov.mathwebservice.gen.FaultDetail;

import javax.xml.ws.WebFault;

@WebFault(name = "faultDetail")
public class SolveQuadraticEducationException extends Exception {

    private FaultDetail detail;

    public SolveQuadraticEducationException(String message) {
        super(message);
    }

    public SolveQuadraticEducationException(FaultDetail detail) {
        this.detail = detail;
    }

    public SolveQuadraticEducationException(String message, FaultDetail detail) {
        super(message);
        this.detail = detail;
    }

    public SolveQuadraticEducationException(String message, Throwable cause, FaultDetail detail) {
        super(message, cause);
        this.detail = detail;
    }

    public FaultDetail getDetail() {
        return detail;
    }

    public void setDetail(FaultDetail detail) {
        this.detail = detail;
    }
}
