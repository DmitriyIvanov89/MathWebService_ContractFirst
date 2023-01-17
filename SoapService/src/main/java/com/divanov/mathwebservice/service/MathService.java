package com.divanov.mathwebservice.service;

import com.divanov.mathwebservice.dto.QuadraticEducationFault;
import com.divanov.mathwebservice.dto.QuadraticEducationRequest;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;
import org.springframework.stereotype.Component;

@Component
public class MathService {
    private static final String ERROR_PARAM_A = "The leading coefficient can't be equals 0";
    private static final String ERROR_DISCRIMINANT_VALUE = "Discriminant can't be less than 0";
    private static final String NO_REAL_ROOTS = "The education has no real roots";

    public QuadraticEducationResponse solveQuadraticEducation(QuadraticEducationRequest request) throws QuadraticEducationNoSolutionException {
        QuadraticEducationResponse response = new QuadraticEducationResponse();

        if (request.getA() != 0) {

            // Incomplete quadratic education
            if (request.getB() == 0 && request.getC() == 0) {
                response.setFormula(generateEducationFormula(request.getA(), request.getB(), request.getC()));
                response.setX1(0.0);
                return response;
            } else if (request.getB() == 0 && request.getC() != 0) {
                response.setFormula(generateEducationFormula(request.getA(), request.getB(), request.getC()));
                if (-(request.getC() / request.getA()) >= 0) {
                    response.setX1(Math.sqrt(-(request.getC() / request.getA())));
                    response.setX2(-(Math.sqrt(-(request.getC() / request.getA()))));
                    return response;
                } else {
                    throw new QuadraticEducationNoSolutionException(NO_REAL_ROOTS);
                }
            } else if (request.getC() == 0 && request.getB() != 0) {
                response.setFormula(generateEducationFormula(request.getA(), request.getB(), request.getC()));
                response.setX1(0.0);
                response.setX2(-(request.getB() / request.getA()));
                return response;
            }

            // Complete quadratic education
            response.setDiscriminant(Math.pow(request.getB(), 2) - 4 * request.getA() * request.getC());
            if (response.getDiscriminant() > 0) {
                response.setFormula(generateEducationFormula(request.getA(), request.getB(), request.getC()));
                response.setX1((-request.getB() + Math.sqrt(response.getDiscriminant())) / (2 * request.getA()));
                response.setX2((-request.getB() - Math.sqrt(response.getDiscriminant())) / (2 * request.getA()));
                return response;
            } else if (response.getDiscriminant() == 0) {
                response.setFormula(generateEducationFormula(request.getA(), request.getB(), request.getC()));
                response.setX1(-request.getB() / (2 * request.getA()));
                return response;
            }

            QuadraticEducationFault quadraticEducationFault = new QuadraticEducationFault();
            quadraticEducationFault.setFormula(generateEducationFormula(request.getA(), request.getB(), request.getC()));
            quadraticEducationFault.setDiscriminant(response.getDiscriminant());
            throw new QuadraticEducationException(ERROR_DISCRIMINANT_VALUE, quadraticEducationFault);

        } else {

            // Different exception
            throw new QuadraticEducationNoSolutionException(ERROR_PARAM_A);
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
