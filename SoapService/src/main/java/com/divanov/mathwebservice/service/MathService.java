package com.divanov.mathwebservice.service;

<<<<<<< HEAD
import com.divanov.mathwebservice.gen.QuadraticEducationResponse;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;

public interface MathService {
    QuadraticEducationResponse solveQuadraticEducation(double a, double b, double c) throws QuadraticEducationException;
=======
import com.divanov.mathwebservice.gen.SolutionQuadraticEducationResponse;

public interface MathService {
    SolutionQuadraticEducationResponse getSolutionQuadraticEducation(double a, double b, double c);
>>>>>>> e4f4c4c9bf329cce44c475aabd189259a8d3dbc0
}
