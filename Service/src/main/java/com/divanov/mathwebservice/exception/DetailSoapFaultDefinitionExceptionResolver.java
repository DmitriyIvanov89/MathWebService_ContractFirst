package com.divanov.mathwebservice.exception;

import com.divanov.mathwebservice.service.QuadraticEducationFault;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import javax.xml.namespace.QName;

public class DetailSoapFaultDefinitionExceptionResolver extends SoapFaultMappingExceptionResolver {

    private static final QName FORMULA = new QName("Formula");
    private static final QName DISCRIMINANT = new QName("Discriminant");

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        if (ex instanceof QuadraticEducationException) {
            QuadraticEducationFault quadraticEducationFault = ((QuadraticEducationException) ex).getQuadraticEducationFaultInfo();
            SoapFaultDetail soapFaultDetail = fault.addFaultDetail();
            soapFaultDetail.addFaultDetailElement(FORMULA).addText(quadraticEducationFault.getFormula());
            soapFaultDetail.addFaultDetailElement(DISCRIMINANT).addText(String.valueOf(quadraticEducationFault.getDiscriminant()));
        }
    }
}
