package com.divanov.mathwebservice.exceptionresolver;

import com.divanov.mathwebservice.gen.FaultDetail;
import com.divanov.mathwebservice.gen.ObjectFactory;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.AbstractEndpointExceptionResolver;
import org.springframework.ws.soap.SoapBody;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.client.SoapFaultClientException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import java.util.Locale;

public class SolveQuadraticEducationExceptionResolver extends AbstractEndpointExceptionResolver {
    @Autowired
    private ObjectFactory objectFactory;
    private final Marshaller marshaller;

    public SolveQuadraticEducationExceptionResolver() throws JAXBException {
        final JAXBContext jaxbContext = JAXBContext.newInstance(FaultDetail.class);
        this.marshaller = jaxbContext.createMarshaller();
    }

    @Override
    protected boolean resolveExceptionInternal(MessageContext messageContext, Object endpoint, Exception exception) {
        if (exception instanceof SolveQuadraticEducationException) {
            final SolveQuadraticEducationException solveQuadraticEducationException = (SolveQuadraticEducationException) exception;

            final FaultDetail detail = new FaultDetail();
            detail.setFormula(solveQuadraticEducationException.getFaultInfo().getFormula());
            detail.setD(solveQuadraticEducationException.getFaultInfo().getD());

            final SoapMessage response = (SoapMessage) messageContext.getResponse();
            final SoapBody soapBody = response.getSoapBody();

            final SoapFault soapFault = soapBody.addClientOrSenderFault(solveQuadraticEducationException.getMessage(), Locale.ENGLISH);

            final SoapFaultDetail faultDetail = soapFault.addFaultDetail();
            final Result result = faultDetail.getResult();

            try {
                marshaller.marshal(objectFactory.createSolveQuadraticEducationException(detail), result);
                return true;
            } catch (JAXBException e) {
                System.err.println(e.getMessage());
            }
        }
        return false;
    }
}
