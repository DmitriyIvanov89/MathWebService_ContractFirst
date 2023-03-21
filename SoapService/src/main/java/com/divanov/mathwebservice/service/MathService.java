package com.divanov.mathwebservice.service;

import com.divanov.mathwebservice.service.gen.SolutionQuadraticEducation;

public interface MathService {
    String NAME_SPACE = "http://math.ws.divanov";
    SolutionQuadraticEducation solveQuadraticEducation(double coefficient_A, double coefficient_B, double coefficient_C);
}
