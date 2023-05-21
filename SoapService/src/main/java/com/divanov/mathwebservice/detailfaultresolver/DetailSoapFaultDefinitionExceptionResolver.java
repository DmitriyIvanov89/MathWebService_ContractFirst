package com.divanov.mathwebservice.detailfaultresolver;

import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.service.gen.ErrorResponse;
import com.divanov.mathwebservice.service.gen.ObjectFactory;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class DetailSoapFaultDefinitionExceptionResolver extends SoapFaultMappingExceptionResolver {
    private final JAXBContext jaxbContext = JAXBContext.newInstance(ErrorResponse.class);
    private final Marshaller marshaller = jaxbContext.createMarshaller();
    private final ObjectFactory objectFactory = new ObjectFactory();

    public DetailSoapFaultDefinitionExceptionResolver() throws JAXBException {
    }

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        ErrorResponse errorResponse = new ErrorResponse();
        if (ex instanceof QuadraticEducationException) {
            errorResponse.setFormula(((QuadraticEducationException) ex).getFormula());
            errorResponse.setDiscriminant(((QuadraticEducationException) ex).getDiscriminant());
        }
        try {
            marshaller.marshal(objectFactory.createQuadraticEducationException(errorResponse), fault.addFaultDetail().getResult());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
