package com.divanov.mathwebservice.exception;

import com.divanov.mathwebservice.gen.ErrorResponse;
import com.divanov.mathwebservice.gen.ObjectFactory;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class DetailSoapFaultDefinitionExceptionResolver extends SoapFaultMappingExceptionResolver {
    private JAXBContext jaxbContext = JAXBContext.newInstance(ErrorResponse.class);
    private Marshaller marshaller = jaxbContext.createMarshaller();
    private ObjectFactory objectFactory = new ObjectFactory();

    public DetailSoapFaultDefinitionExceptionResolver() throws JAXBException {
    }

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        ErrorResponse errorResponse;
        if (ex instanceof MathServiceException) {
            errorResponse = new ErrorResponse();
            errorResponse.setMessage(ex.getMessage());
        }
    }
}
