
package com.divanov.mathwebservice.gen;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.5.4
 * 2023-03-29T22:16:35.806+03:00
 * Generated source version: 3.5.4
 */

@WebFault(name = "quadraticEducationException", targetNamespace = "http://math.ws.divanov")
public class QuadraticEducationException extends Exception {

    private com.divanov.mathwebservice.gen.ErrorResponse faultInfo;

    public QuadraticEducationException() {
        super();
    }

    public QuadraticEducationException(String message) {
        super(message);
    }

    public QuadraticEducationException(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public QuadraticEducationException(String message, com.divanov.mathwebservice.gen.ErrorResponse quadraticEducationException) {
        super(message);
        this.faultInfo = quadraticEducationException;
    }

    public QuadraticEducationException(String message, com.divanov.mathwebservice.gen.ErrorResponse quadraticEducationException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = quadraticEducationException;
    }

    public com.divanov.mathwebservice.gen.ErrorResponse getFaultInfo() {
        return this.faultInfo;
    }
}
