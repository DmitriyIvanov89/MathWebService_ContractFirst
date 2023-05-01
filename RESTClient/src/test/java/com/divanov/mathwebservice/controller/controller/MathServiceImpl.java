package com.divanov.mathwebservice.controller.controller;

import com.divanov.mathwebservice.gen.MathService;
import com.divanov.mathwebservice.gen.QuadraticEducationException;
import com.divanov.mathwebservice.gen.QuadraticEducationRequestPayLoad;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;

public class MathServiceImpl implements MathService {
    @Override
    public SolutionQuadraticEducation getSolveQuadraticEducation(QuadraticEducationRequestPayLoad getSolveQuadraticEducationRequest) throws QuadraticEducationException {
        return new SolutionQuadraticEducation();
    }
}