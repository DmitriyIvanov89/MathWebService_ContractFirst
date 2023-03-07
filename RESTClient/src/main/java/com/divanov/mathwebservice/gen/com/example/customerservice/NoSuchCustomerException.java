
package com.example.customerservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.5.4
 * 2023-03-06T11:26:41.131+03:00
 * Generated source version: 3.5.4
 */

@WebFault(name = "NoSuchCustomer", targetNamespace = "http://customerservice.example.com/")
public class NoSuchCustomerException extends Exception {

    private com.example.customerservice.NoSuchCustomer faultInfo;

    public NoSuchCustomerException() {
        super();
    }

    public NoSuchCustomerException(String message) {
        super(message);
    }

    public NoSuchCustomerException(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public NoSuchCustomerException(String message, com.example.customerservice.NoSuchCustomer noSuchCustomer) {
        super(message);
        this.faultInfo = noSuchCustomer;
    }

    public NoSuchCustomerException(String message, com.example.customerservice.NoSuchCustomer noSuchCustomer, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = noSuchCustomer;
    }

    public com.example.customerservice.NoSuchCustomer getFaultInfo() {
        return this.faultInfo;
    }
}
