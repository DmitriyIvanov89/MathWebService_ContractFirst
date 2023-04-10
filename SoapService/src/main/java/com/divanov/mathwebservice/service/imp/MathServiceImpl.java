package com.divanov.mathwebservice.service.imp;

import com.divanov.mathwebservice.service.MathService;
import com.divanov.mathwebservice.exception.NoSolutionException;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.service.gen.ObjectFactory;
import com.divanov.mathwebservice.service.gen.SolutionQuadraticEducation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {
    private static final Logger log = LogManager.getLogger(MathServiceImpl.class);

    private static final String ERROR_PARAM_A = "The leading coefficient can't be equals 0";
    private static final String NO_REAL_ROOTS = "The education has no real roots";
    private static final String DISCRIMINANT_INVALID_VALUE = "Discriminant can't be less than 0";
    private final ObjectFactory objectFactory = new ObjectFactory();

    @Override
    public SolutionQuadraticEducation solveQuadraticEducation(double coefficient_A, double coefficient_B, double coefficient_C) {
        SolutionQuadraticEducation solution = objectFactory.createSolutionQuadraticEducation();
        if (coefficient_A != 0) {
            if (coefficient_B == 0 || coefficient_C == 0) {
                solveIncompleteQuadraticEducation(solution, coefficient_A, coefficient_B, coefficient_C);
            } else {
                solveCompleteQuadraticEducation(solution, coefficient_A, coefficient_B, coefficient_C);
            }
            return solution;
        }
        throw new NoSolutionException(ERROR_PARAM_A);
    }

    private void solveIncompleteQuadraticEducation(SolutionQuadraticEducation response,
                                                   double param_A,
                                                   double param_B,
                                                   double param_C) {
        response.setFormula(generateEducationFormula(param_A, param_B, param_C));
        log.debug("Start solution incomplete quadratic education: {}", response.getFormula());
        if (param_B == 0 && param_C == 0) {
            response.setX1(0.0);
        } else if (param_B == 0) {
            if (-(param_C / param_A) >= 0) {
                response.setX1(Math.sqrt(-(param_C / param_A)));
                response.setX2(-(Math.sqrt(-(param_C / param_A))));
            } else {
                throw new NoSolutionException(NO_REAL_ROOTS);
            }
        } else {
            response.setX1(0.0);
            response.setX2(-(param_B / param_A));
        }
    }

    private void solveCompleteQuadraticEducation(SolutionQuadraticEducation response,
                                                 double param_A,
                                                 double param_B,
                                                 double param_C) {
        response.setDiscriminant(Math.pow(param_B, 2) - 4 * param_A * param_C);
        response.setFormula(generateEducationFormula(param_A, param_B, param_C));
        log.debug("Start solution complete quadratic education: {}", response.getFormula());
        if (response.getDiscriminant() > 0) {
            response.setX1((-param_B + Math.sqrt(response.getDiscriminant())) / (2 * param_A));
            response.setX2((-param_B - Math.sqrt(response.getDiscriminant())) / (2 * param_A));
        } else if (response.getDiscriminant() == 0) {
            response.setX1(-param_B / (2 * param_A));
        } else {
            throw new QuadraticEducationException(DISCRIMINANT_INVALID_VALUE, response.getDiscriminant(), response.getFormula());
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

