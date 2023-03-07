package com.divanov.mathwebservice.service;

import com.divanov.mathwebservice.exception.DiscriminantValueLessZeroException;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationRequest;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationResponse;

public interface IMathService {
    SolveQuadraticEducationResponse solveQuadraticEducation(SolveQuadraticEducationRequest request) throws DiscriminantValueLessZeroException;
}
