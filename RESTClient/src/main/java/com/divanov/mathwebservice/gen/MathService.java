package com.divanov.mathwebservice.gen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.5.4
 * 2023-03-30T22:29:28.855+03:00
 * Generated source version: 3.5.4
 *
 */
@WebService(targetNamespace = "http://math.ws.divanov", name = "MathService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface MathService {

    @WebMethod
    @WebResult(name = "getSolveQuadraticEducationResponse", targetNamespace = "http://math.ws.divanov", partName = "getSolveQuadraticEducationResponse")
    public SolutionQuadraticEducation getSolveQuadraticEducation(

        @WebParam(partName = "getSolveQuadraticEducationRequest", name = "getSolveQuadraticEducationRequest", targetNamespace = "http://math.ws.divanov")
        QuadraticEducationRequestPayLoad getSolveQuadraticEducationRequest
    ) throws QuadraticEducationException;
}
