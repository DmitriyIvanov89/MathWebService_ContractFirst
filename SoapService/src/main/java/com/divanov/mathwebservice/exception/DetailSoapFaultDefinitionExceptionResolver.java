package com.divanov.mathwebservice.exception;

//import com.divanov.mathwebservice.dto.QuadraticEducationFault;
//import org.springframework.ws.soap.SoapFault;
//import org.springframework.ws.soap.SoapFaultDetail;
//import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import javax.xml.namespace.QName;

public class DetailSoapFaultDefinitionExceptionResolver {

//    private static final QName FORMULA = new QName("formula");
//    private static final QName DISCRIMINANT = new QName("discriminant");
//
//    @Override
//    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
//        if (ex instanceof QuadraticEducationException) {
//            QuadraticEducationFault quadraticEducationFault = ((QuadraticEducationException) ex).getFaultInfo();
//            SoapFaultDetail soapFaultDetail = fault.addFaultDetail();
//            soapFaultDetail.addFaultDetailElement(FORMULA).addText(quadraticEducationFault.getFormula());
//            soapFaultDetail.addFaultDetailElement(DISCRIMINANT).addText(String.valueOf(quadraticEducationFault.getDiscriminant()));
//        }
//    }
}
