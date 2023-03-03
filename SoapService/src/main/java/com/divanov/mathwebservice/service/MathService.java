package com.divanov.mathwebservice.service;

import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.gen.QuadraticEducationResponse;

public interface MathService {
    QuadraticEducationResponse solveQuadraticEducation(double a, double b, double c) throws QuadraticEducationException;
}
