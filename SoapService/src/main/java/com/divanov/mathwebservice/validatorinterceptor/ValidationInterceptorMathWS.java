package com.divanov.mathwebservice.validatorinterceptor;

import com.divanov.mathwebservice.service.exception.RequestValidationException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ValidationInterceptorMathWS extends PayloadValidatingInterceptor {
    private static final Logger log = LogManager.getRootLogger();

    @Override
    protected boolean handleRequestValidationErrors(MessageContext messageContext, SAXParseException[] errors) {
        if (errors.length > 0) {
            log.info("start logger");
            String validationsErrorString = Arrays.stream(errors)
                    .map(SAXException::getMessage)
                    .collect(Collectors.joining(" -- "));
            throw new RequestValidationException("Xsd schema validation errors: " + validationsErrorString);
        }
        return true;
    }
}
