package com.divanov.mathwebservice.service;

<<<<<<< HEAD
import com.divanov.mathwebservice.gen.ObjectFactory;
import com.divanov.mathwebservice.gen.QuadraticEducationFault;
import com.divanov.mathwebservice.gen.QuadraticEducationResponse;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
=======
import com.divanov.mathwebservice.gen.*;
>>>>>>> e4f4c4c9bf329cce44c475aabd189259a8d3dbc0
import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {
    private static final String ERROR_PARAM_A = "The leading coefficient can't be equals 0";
    private static final String ERROR_DISCRIMINANT_VALUE = "Discriminant can't be less than 0";
    private static final String NO_REAL_ROOTS = "The education has no real roots";
    private ObjectFactory objectFactory;

<<<<<<< HEAD
    public QuadraticEducationResponse solveQuadraticEducation(double param_A, double param_B, double param_C) throws QuadraticEducationException {
        QuadraticEducationResponse response = objectFactory.createQuadraticEducationResponse();
        if (param_A != 0) {
            if (param_B == 0 || param_C == 0) {
                solveIncompleteQuadraticEducation(response, param_A, param_B, param_C);
            } else {
                solveCompleteQuadraticEducation(response, param_A, param_B, param_C);
            }
            return response;
        }
        throw new QuadraticEducationNoSolutionException(ERROR_PARAM_A);
=======
    @Autowired
    public MathServiceImpl(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
>>>>>>> e4f4c4c9bf329cce44c475aabd189259a8d3dbc0
    }

    public MathServiceImpl() {
    }

    @Override
    public SolutionQuadraticEducationResponse getSolutionQuadraticEducation(double param_A, double param_B, double param_C) {
        SolutionQuadraticEducationResponse response = objectFactory.createSolutionQuadraticEducationResponse();
        QuadraticEducationResponse responseDetail = objectFactory.createQuadraticEducationResponse();
        ResponseInfo responseInfo = objectFactory.createResponseInfo();

        if (param_A == 0) {
            System.err.println("Throw new QuadraticEducationNoSolutionException");
            throw new QuadraticEducationNoSolutionException(ERROR_PARAM_A);
        }
        if (param_B == 0 || param_C == 0) {
            solveIncompleteQuadraticEducation(response, param_A, param_B, param_C);
        } else {
            solveCompleteQuadraticEducation(response, param_A, param_B, param_C);
        }
        return response;
    }

    private void solveIncompleteQuadraticEducation(SolutionQuadraticEducationResponse response,
                                                   double param_A,
                                                   double param_B,
                                                   double param_C) {
        if (param_B == 0 && param_C == 0) {
            response.getResponse().getInfo().setFormula(generateEducationFormula(param_A, param_B, param_C));
            response.getResponse().setX1(0.0);
        } else if (param_B == 0) {
            response.getResponse().getInfo().setFormula(generateEducationFormula(param_A, param_B, param_C));
            if (-(param_C / param_A) >= 0) {
                response.getResponse().setX1(Math.sqrt(-(param_C / param_A)));
                response.getResponse().setX2(-(Math.sqrt(-(param_C / param_A))));
            } else {
                System.err.println("Throw new QuadraticEducationNoSolutionException");
                throw new QuadraticEducationNoSolutionException(NO_REAL_ROOTS);
            }
        } else {
            response.getResponse().getInfo().setFormula(generateEducationFormula(param_A, param_B, param_C));
            response.getResponse().setX1(0.0);
            response.getResponse().setX2(-(param_B / param_A));
        }
    }

    private void solveCompleteQuadraticEducation(SolutionQuadraticEducationResponse response,
                                                 double param_A,
                                                 double param_B,
<<<<<<< HEAD
                                                 double param_C) throws QuadraticEducationException {
        response.setDiscriminant(Math.pow(param_B, 2) - 4 * param_A * param_C);
        if (response.getDiscriminant() > 0) {
            response.setFormula(generateEducationFormula(param_A, param_B, param_C));
            response.setX1((-param_B + Math.sqrt(response.getDiscriminant())) / (2 * param_A));
            response.setX2((-param_B - Math.sqrt(response.getDiscriminant())) / (2 * param_A));
=======
                                                 double param_C) {
        response.getResponse().getInfo().setDiscriminant(Math.pow(param_B, 2) - 4 * param_A * param_C);
        if (response.getResponse().getInfo().getDiscriminant() > 0) {
            response.getResponse().getInfo().setFormula(generateEducationFormula(param_A, param_B, param_C));
            response.getResponse().setX1((-param_B + Math.sqrt(response.getResponse().getInfo().getDiscriminant())) / (2 * param_A));
            response.getResponse().setX2((-param_B - Math.sqrt(response.getResponse().getInfo().getDiscriminant())) / (2 * param_A));
>>>>>>> e4f4c4c9bf329cce44c475aabd189259a8d3dbc0
            return;
        } else if (response.getResponse().getInfo().getDiscriminant() == 0) {
            response.getResponse().getInfo().setFormula(generateEducationFormula(param_A, param_B, param_C));
            response.getResponse().setX1(-param_B / (2 * param_A));
            return;
        }
        System.err.println("Throw new QuadraticEducationException");
        response.getResponse().getInfo().setFormula(generateEducationFormula(param_A, param_B, param_C));
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
