package com.divanov.mathwebservice.service;

import com.divanov.mathwebservice.gen.SolveQuadraticEducationResponse;

public interface MathService {
    String NAME_SPACE = "http://math.ws.divanov";
    SolveQuadraticEducationResponse solveQuadraticEducation(double coefficient_A, double coefficient_B, double coefficient_C);
}
