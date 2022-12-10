package com.divanov.mathwebservice.dto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.5.3
 * 2022-12-10T18:02:04.224+03:00
 * Generated source version: 3.5.3
 *
 */
@WebService(targetNamespace = "http://math.ws.divanov", name = "MathPort")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface MathPort {

    @WebMethod(operationName = "QuadraticEducation")
    @WebResult(name = "QuadraticEducationResponse", targetNamespace = "http://math.ws.divanov", partName = "QuadraticEducationResponse")
    public QuadraticEducationResponse quadraticEducation(

        @WebParam(partName = "QuadraticEducationRequest", name = "QuadraticEducationRequest", targetNamespace = "http://math.ws.divanov")
        QuadraticEducationRequest quadraticEducationRequest
    ) throws QuadraticEducationFault_Exception;
}
