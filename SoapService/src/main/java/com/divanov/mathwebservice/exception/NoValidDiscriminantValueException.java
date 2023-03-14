package com.divanov.mathwebservice.exception;

import com.divanov.mathwebservice.gen.DiscriminantFaultValueInfo;

import javax.xml.ws.WebFault;

@WebFault(name = "NoValidDiscriminantValue", targetNamespace = "http://math.ws.divanov")
public class NoValidDiscriminantValueException extends Exception {

    private NoValidDiscriminantValue detailInfo;

    public NoValidDiscriminantValueException(String message) {
        super(message);
    }

    public NoValidDiscriminantValueException(NoValidDiscriminantValue detail) {
        this.detailInfo = detail;
    }

    public NoValidDiscriminantValueException(String message, NoValidDiscriminantValue detail) {
        super(message);
        this.detailInfo = detail;
    }

    public NoValidDiscriminantValueException(String message, Throwable cause, NoValidDiscriminantValue detail) {
        super(message, cause);
        this.detailInfo = detail;
    }

    public NoValidDiscriminantValue getDetail() {
        return detailInfo;
    }
}
