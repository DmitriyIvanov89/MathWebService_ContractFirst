
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.divanov.mathwebservice.dto;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.5.3
 * 2022-12-28T22:21:14.303+03:00
 * Generated source version: 3.5.3
 */

@javax.jws.WebService(
        serviceName = "MathService",
        portName = "MathPortSoap11",
        targetNamespace = "http://math.ws.divanov",
        wsdlLocation = "http://localhost:8080/services/MathService.wsdl",
        endpointInterface = "com.divanov.mathwebservice.dto.MathPort")

public class MathPortSoap11Impl implements MathPort {

    public com.divanov.mathwebservice.dto.QuadraticEducationResponse quadraticEducation(QuadraticEducationRequest quadraticEducationRequest)
            throws QuadraticEducationFault_Exception {
        try {
            com.divanov.mathwebservice.dto.QuadraticEducationResponse response = null;
            return response;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new QuadraticEducationFault_Exception("QuadraticEducationFault...");
    }

}