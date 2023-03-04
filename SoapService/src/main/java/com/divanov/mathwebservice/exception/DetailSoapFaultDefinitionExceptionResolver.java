package com.divanov.mathwebservice.exception;


import com.divanov.mathwebservice.gen.FaultDetail;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import javax.xml.namespace.QName;

public class DetailSoapFaultDefinitionExceptionResolver extends SoapFaultMappingExceptionResolver {

    private static final QName FORMULA = new QName("formula");
    private static final QName DISCRIMINANT = new QName("discriminant");

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        if (ex instanceof SolveQuadraticEducationException) {
            FaultDetail detail = ((SolveQuadraticEducationException) ex).getDetail();
            SoapFaultDetail soapFaultDetail = fault.addFaultDetail();
            soapFaultDetail.addFaultDetailElement(FORMULA).addText(detail.getFormula());
            soapFaultDetail.addFaultDetailElement(DISCRIMINANT).addText(String.valueOf(detail.getDiscriminant()));
        }
    }
}
