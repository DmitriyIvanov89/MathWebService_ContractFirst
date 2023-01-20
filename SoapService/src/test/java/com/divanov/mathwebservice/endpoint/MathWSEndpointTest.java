package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.dto.ObjectFactory;
import com.divanov.mathwebservice.dto.QuadraticEducationFault;
import com.divanov.mathwebservice.dto.QuadraticEducationRequest;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;
import com.divanov.mathwebservice.exception.RequestValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@ContextConfiguration(classes = MathWSEndpointTestTestConfig.class)
class MathWSEndpointTest {
    @Autowired
    MathWSEndpoint mathWSEndpoint;

    @Autowired
    ObjectFactory objectFactory;

    @Test
    void shouldReturnResultWithDiscriminantGreaterThanZero() throws QuadraticEducationNoSolutionException {
        assertEquals(createResponse("2,0x^2 + -3,0x + 1,0 = 0", 1.0, 1.0, 0.5),
                mathWSEndpoint.getQuadraticEducationSolution(createRequest(2, -3, 1)));
    }

    @Test
    void shouldReturnResponseWithOneRoot() throws QuadraticEducationNoSolutionException {
        assertEquals(createResponse("1,0x^2 + -6,0x + 9,0 = 0", 0.0, 3.0, null),
                mathWSEndpoint.getQuadraticEducationSolution(createRequest(1, -6, 9)));
    }

    @Test
    void shouldThrowQuadraticEducationExceptionDiscriminantLessThanZero() {
        QuadraticEducationException expectedException = assertThrows(QuadraticEducationException.class, () -> {
            mathWSEndpoint.getQuadraticEducationSolution(createRequest(5, 3, 7));
        });

        assertEquals("Discriminant can't be less than 0", expectedException.getMessage());
    }

    @Test
    void shouldReturnQuadraticEducationFault() {
        QuadraticEducationException expectedException = assertThrows(QuadraticEducationException.class, () -> {
            mathWSEndpoint.getQuadraticEducationSolution(createRequest(5, 3, 7));
        });

        QuadraticEducationFault expectedFault = objectFactory.createQuadraticEducationFault();
        expectedFault.setFormula("5,0x^2 + 3,0x + 7,0 = 0");
        expectedFault.setDiscriminant(-131.0);

        assertEquals(expectedFault, expectedException.getQuadraticEducationFault());
    }

    @Test
    void shouldThrowQuadraticEducationNoRealRots() {
        QuadraticEducationNoSolutionException expectedException = assertThrows(QuadraticEducationNoSolutionException.class, () -> {
            mathWSEndpoint.getQuadraticEducationSolution(createRequest(4, 0, 30));
        });

        assertEquals("The education has no real roots", expectedException.getMessage());
    }

    @Test
    void shouldReturnExceptionLeadingCoefficientEqualsZero() {
        QuadraticEducationNoSolutionException expectedException = assertThrows(QuadraticEducationNoSolutionException.class, () -> {
            mathWSEndpoint.getQuadraticEducationSolution(createRequest(0, 4, 3));
        });

        assertEquals("The leading coefficient can't be equals 0", expectedException.getMessage());
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenCEqualsZero() throws QuadraticEducationNoSolutionException {
        assertEquals(createResponse("4,0x^2 + -7,0x = 0", 0, 0.0, 1.75),
                mathWSEndpoint.getQuadraticEducationSolution(createRequest(4, -7, 0)));
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenBEqualsZero() throws QuadraticEducationNoSolutionException {
        assertEquals(createResponse("4,0x^2 + -9,0 = 0", 0, 1.5, -1.5),
                mathWSEndpoint.getQuadraticEducationSolution(createRequest(4, 0, -9)));
    }

//    @Test
//    void shouldReturnValidationException() {
//        RequestValidationException expectedException = assertThrows(RequestValidationException.class, () ->
//                mathWSEndpoint.getQuadraticEducationSolution(createRequest()));
//
//        assertEquals("Xsd schema validation errors: [-1, -1]: cvc-datatype-valid.1.2.1: 'as$' is not a valid value for 'double'. -- [-1, -1]: cvc-type.3.1.3: The value 'as$' of element 'math:B' is not valid.",
//                expectedException.getMessage());
//    }

    private QuadraticEducationRequest createRequest(double a, double b, double c) {
        QuadraticEducationRequest request = objectFactory.createQuadraticEducationRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);
        return request;
    }

    private QuadraticEducationResponse createResponse(String formula, double discriminant, double x1, Double x2) {
        QuadraticEducationResponse response = objectFactory.createQuadraticEducationResponse();
        response.setFormula(formula);
        response.setDiscriminant(discriminant);
        response.setX1(x1);
        response.setX2(x2);
        return response;
    }
}