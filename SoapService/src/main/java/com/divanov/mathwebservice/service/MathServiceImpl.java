package com.divanov.mathwebservice.service;

import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;
import com.divanov.mathwebservice.exception.SolveQuadraticEducationException;
import com.divanov.mathwebservice.gen.ObjectFactory;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationExceptionDetail;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationRequest;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements IMathService {
    private static final String ERROR_PARAM_A = "The leading coefficient can't be equals 0";
    private static final String ERROR_DISCRIMINANT_VALUE = "Discriminant can't be less than 0";
    private static final String NO_REAL_ROOTS = "The education has no real roots";
    private ObjectFactory objectFactory;

    @Autowired
    public MathServiceImpl(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    public ObjectFactory getObjectFactory() {
        return objectFactory;
    }

    public MathServiceImpl() {
    }

    @Override
    public SolveQuadraticEducationResponse solveQuadraticEducation(SolveQuadraticEducationRequest request) {
        SolveQuadraticEducationResponse response = getObjectFactory().createSolveQuadraticEducationResponse();
        if (request.getA() != 0) {
            if (request.getB() == 0 || request.getC() == 0) {
                solveIncompleteQuadraticEducation(response, request.getA(), request.getB(), request.getC());
            } else {
                solveCompleteQuadraticEducation(response, request.getA(), request.getB(), request.getC());
            }
            return response;
        }
        throw new QuadraticEducationNoSolutionException(ERROR_PARAM_A);
    }

    private void solveIncompleteQuadraticEducation(SolveQuadraticEducationResponse response,
                                                   double param_A,
                                                   double param_B,
                                                   double param_C) {
        response.setFormula(generateEducationFormula(param_A, param_B, param_C));
        if (param_B == 0 && param_C == 0) {
            response.setX1(0.0);
        } else if (param_B == 0) {
            if (-(param_C / param_A) >= 0) {
                response.setX1(Math.sqrt(-(param_C / param_A)));
                response.setX2(-(Math.sqrt(-(param_C / param_A))));
            } else {
                throw new QuadraticEducationNoSolutionException(NO_REAL_ROOTS);
            }
        } else {
            response.setX1(0.0);
            response.setX2(-(param_B / param_A));
        }
    }

    private void solveCompleteQuadraticEducation(SolveQuadraticEducationResponse response,
                                                 double param_A,
                                                 double param_B,
                                                 double param_C) {
        response.setDiscriminant(Math.pow(param_B, 2) - 4 * param_A * param_C);
        response.setFormula(generateEducationFormula(param_A, param_B, param_C));
        if (response.getDiscriminant() > 0) {
            response.setX1((-param_B + Math.sqrt(response.getDiscriminant())) / (2 * param_A));
            response.setX2((-param_B - Math.sqrt(response.getDiscriminant())) / (2 * param_A));
        } else if (response.getDiscriminant() == 0) {
            response.setX1(-param_B / (2 * param_A));
        } else {
            SolveQuadraticEducationExceptionDetail detail = getObjectFactory().createSolveQuadraticEducationExceptionDetail();
            detail.setFormula(response.getFormula());
            detail.setDiscriminant(response.getDiscriminant());
            throw new SolveQuadraticEducationException(ERROR_DISCRIMINANT_VALUE, detail);
        }
    }

    private static String generateEducationFormula(double a, double b, double c) {
        if (b == 0 && c == 0) {
            return String.format("%.1fx^2 = 0", a);
        } else if (b == 0) {
            return String.format("%.1fx^2 + %.1f = 0", a, c);
        } else if (c == 0) {
            return String.format("%.1fx^2 + %.1fx = 0", a, b);
        }
        return String.format("%.1fx^2 + %.1fx + %.1f = 0", a, b, c);
    }
}