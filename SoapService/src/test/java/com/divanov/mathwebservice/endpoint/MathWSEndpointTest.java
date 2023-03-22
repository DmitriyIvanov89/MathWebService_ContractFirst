package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.service.exception.NoSolutionException;
import com.divanov.mathwebservice.service.exception.QuadraticEducationException;
import com.divanov.mathwebservice.service.gen.ErrorResponse;
import com.divanov.mathwebservice.service.gen.ObjectFactory;
import com.divanov.mathwebservice.service.gen.QuadraticEducationRequestPayLoad;
import com.divanov.mathwebservice.service.gen.SolutionQuadraticEducation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * TO DO :
 * create test with invalid validation request params
 */

@SpringJUnitConfig
@ContextConfiguration(classes = MathWSEndpointTestTestConfig.class)
class MathWSEndpointTest {
    @Autowired
    private MathWSEndpoint mathWSEndpoint;

    @Autowired
    private ObjectFactory objectFactory;

    @Test
    void shouldReturnResultWithDiscriminantGreaterThanZero() {
        assertEquals(createResponse("2,0x^2 + -3,0x + 1,0 = 0", 1.0, 1.0, 0.5),
                mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(2, -3, 1)).getValue());
    }

    @Test
    void shouldReturnResponseWithOneRoot() {
        assertEquals(createResponse("1,0x^2 + -6,0x + 9,0 = 0", 0.0, 3.0, null),
                mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(1, -6, 9)).getValue());
    }

    @Test
    void shouldThrowQuadraticEducationExceptionDiscriminantLessThanZero() {
        QuadraticEducationException expectedException = assertThrows(QuadraticEducationException.class, () -> {
            mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(5, 3, 7));
        });

        assertEquals("Discriminant can't be less than 0", expectedException.getMessage());
    }

    @Test
    void shouldReturnQuadraticEducationFaultDetail() {
        QuadraticEducationException expectedException = assertThrows(QuadraticEducationException.class, () -> {
            mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(5, 3, 7));
        });

        ErrorResponse expectedFault = objectFactory.createErrorResponse();
        expectedFault.setFormula("5,0x^2 + 3,0x + 7,0 = 0");
        expectedFault.setDiscriminant(-131.0);

        assertEquals(expectedException.getFormula(), expectedException.getFormula());
        assertEquals(expectedFault.getDiscriminant(), expectedException.getDiscriminant());
    }

    @Test
    void shouldThrowQuadraticEducationNoRealRots() {
        NoSolutionException expectedException = assertThrows(NoSolutionException.class, () -> {
            mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(4, 0, 30));
        });

        assertEquals("The education has no real roots", expectedException.getMessage());
    }

    @Test
    void shouldReturnExceptionLeadingCoefficientEqualsZero() {
        NoSolutionException expectedException = assertThrows(NoSolutionException.class, () -> {
            mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(0, 4, 3));
        });

        assertEquals("The leading coefficient can't be equals 0", expectedException.getMessage());
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenCEqualsZero() {
        assertEquals(createResponse("4,0x^2 + -7,0x = 0", 0, 0.0, 1.75),
                mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(4, -7, 0)).getValue());
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenBEqualsZero() {
        assertEquals(createResponse("4,0x^2 + -9,0 = 0", 0, 1.5, -1.5),
                mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(4, 0, -9)).getValue());
    }

    private QuadraticEducationRequestPayLoad createRequestPayLoad(double a, double b, double c) {
        QuadraticEducationRequestPayLoad payLoad = objectFactory.createQuadraticEducationRequestPayLoad();
        payLoad.setA(a);
        payLoad.setB(b);
        payLoad.setC(c);
        return payLoad;
    }

    private SolutionQuadraticEducation createResponse(String formula, double discriminant, double x1, Double x2) {
        SolutionQuadraticEducation response = objectFactory.createSolutionQuadraticEducation();
        response.setFormula(formula);
        response.setDiscriminant(discriminant);
        response.setX1(x1);
        response.setX2(x2);
        return response;
    }
}
