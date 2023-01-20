package com.divanov.mathwebservice.validatorinterceptor;

import com.divanov.mathwebservice.exception.RequestValidationException;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.xml.sax.SAXParseException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ValidationInterceptorMathWS extends PayloadValidatingInterceptor {

    @Override
    protected boolean handleRequestValidationErrors(MessageContext messageContext, SAXParseException[] errors) {
        if (errors.length > 0) {
            String validationsErrorString = Arrays.stream(errors)
                    .map(error -> "[" + error.getLineNumber() + ", " + error.getColumnNumber() + "]: " + error.getMessage())
                    .collect(Collectors.joining(" -- "));
            throw new RequestValidationException("Xsd schema validation errors: " + validationsErrorString);
        }
        return true;
    }
}
