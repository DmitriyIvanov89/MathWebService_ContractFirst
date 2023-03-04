package com.divanov.mathwebservice.service;

import com.divanov.mathwebservice.exception.SolveQuadraticEducationException;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationResponse;

public interface IMathService {
    SolveQuadraticEducationResponse solveQuadraticEducation(double a,
                                                            double b,
                                                            double c) throws SolveQuadraticEducationException;
}