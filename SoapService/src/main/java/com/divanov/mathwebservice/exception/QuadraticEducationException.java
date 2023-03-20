package com.divanov.mathwebservice.exception;

import java.text.MessageFormat;

public class QuadraticEducationException extends MathServiceException {
    public QuadraticEducationException(double discriminant) {
        super(MessageFormat.format("Invalid discriminant value {0}", discriminant));
    }

    public QuadraticEducationException(String message) {
        super(message);
    }
}
