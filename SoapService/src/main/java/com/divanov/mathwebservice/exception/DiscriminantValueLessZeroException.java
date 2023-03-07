package com.divanov.mathwebservice.exception;

import com.divanov.mathwebservice.gen.FaultDetail;

import javax.xml.ws.WebFault;

@WebFault(name = "faultDetail")
public class DiscriminantValueLessZeroException extends Exception {
    public static final long serialVersionUID = 1L;

    private FaultDetail faultInfo;

    public DiscriminantValueLessZeroException() {
        super();
    }

    public DiscriminantValueLessZeroException(String message) {
        super(message);
    }

    public DiscriminantValueLessZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiscriminantValueLessZeroException(String message, FaultDetail faultDetail) {
        super(message);
        this.faultInfo = faultDetail;
    }

    public DiscriminantValueLessZeroException(String message, Throwable cause, FaultDetail faultDetail) {
        super(message, cause);
        this.faultInfo = faultDetail;
    }

    public FaultDetail getFaultInfo() {
        return this.faultInfo;
    }
}
