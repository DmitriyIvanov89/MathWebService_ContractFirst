package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.service.CreateResponse;
import com.divanov.mathwebservice.service.CreateGetSolutionQuadraticEducationRequest;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MathWSEndpoint {

    // TODO Refactor this method!!!

    private static final String ERROR_PARAM_A = "The leading coefficient can't be equals 0";
    private static final String ERROR_DISCRIMINANT_VALUE = "Discriminant can't be less than 0";
    private static final String NO_REAL_ROOTS = "The education has no real roots";

    @PayloadRoot(namespace = "http://math.ws.divanov", localPart = "createGetSolutionQuadraticEducationRequest")
    @ResponsePayload
    public CreateResponse createQuadraticEducationResult(@RequestPayload CreateGetSolutionQuadraticEducationRequest request) {
        CreateResponse response = new CreateResponse();

        if (request.getA() != 0) {
            // Incomplete quadratic education
            if (request.getB() == 0 && request.getC() == 0) {
                response.setFormula(generateEducationFormula(request.getA(), request.getB(), request.getC()));
                response.setX1(0.0);
                return response;
            } else if (request.getB() == 0 && request.getC() != 0) {
                response.setFormula(generateEducationFormula(request.getA(), request.getB(), request.getC()));
                if (-(request.getC() / request.getA()) > 0) {
                    response.setX1(Math.sqrt(-(request.getC() / request.getA())));
                    response.setX2(-(Math.sqrt(-(request.getC() / request.getA()))));
                    return response;
                } else {
                    throw new ArithmeticException(NO_REAL_ROOTS);
                }
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

            // custom fault message(Formula and value of D)
            throw new ArithmeticException(ERROR_DISCRIMINANT_VALUE);

        } else {
            throw new ArithmeticException(ERROR_PARAM_A);
        }
    }

    private static String generateEducationFormula(double a, double b, double c) {
        if (b == 0 && c == 0) {
            return String.format("%.1fx^2 = 0", a);
        } else if (b == 0 && c != 0) {
            return String.format("%.1fx^2 + %.1f = 0", a, c);
        } else if (b != 0 && c == 0) {
            return String.format("%.1fx^2 + %.1fx = 0", a, b);
        }
        return String.format("%.1fx^2 + %.1fx + %.1f = 0", a, b, c);
    }

}
