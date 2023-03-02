package com.divanov.mathwebservice.service;

import com.divanov.mathwebservice.gen.SolutionQuadraticEducationResponse;

public interface MathService {
    SolutionQuadraticEducationResponse getSolutionQuadraticEducation(double a, double b, double c);
}
