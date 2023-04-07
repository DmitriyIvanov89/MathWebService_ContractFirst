package com.divanov.mathwebservice.interceptors;

import com.divanov.mathwebservice.exception.RequestValidationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ValidationInterceptorMathWS extends PayloadValidatingInterceptor {
    private static final Logger log = LogManager.getLogger(ValidationInterceptorMathWS.class);
    private static final String LOG_ERROR_MESSAGE = "Xsd schema validation errors: {}";

    @Override
    protected boolean handleRequestValidationErrors(MessageContext messageContext, SAXParseException[] errors) {
        if (errors.length > 0) {
            String validationsErrorString = Arrays.stream(errors)
                    .map(SAXException::getMessage)
                    .collect(Collectors.joining(" -- "));
            log.error(LOG_ERROR_MESSAGE, validationsErrorString);
            throw new RequestValidationException("Xsd schema validation errors: " + validationsErrorString);
        }
        return true;
    }
}
