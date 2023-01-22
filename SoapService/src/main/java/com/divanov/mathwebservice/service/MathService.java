package com.divanov.mathwebservice.service;

import com.divanov.mathwebservice.dto.QuadraticEducationRequest;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;

public interface MathService {
    public QuadraticEducationResponse solveQuadraticEducation(QuadraticEducationRequest request) throws QuadraticEducationNoSolutionException;
}
