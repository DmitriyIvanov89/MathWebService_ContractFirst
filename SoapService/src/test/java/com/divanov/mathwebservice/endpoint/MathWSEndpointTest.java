package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.dto.ObjectFactory;
import com.divanov.mathwebservice.dto.QuadraticEducationFault;
import com.divanov.mathwebservice.dto.QuadraticEducationRequest;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

/**
 * create private methods
 * createRequest() -> check tests with null params!!!
 * createExpectedResponse()
 */

@SpringJUnitConfig
@ContextConfiguration(classes = MathWSEndpointTestTestConfig.class)
class MathWSEndpointTest {
    @Autowired
    MathWSEndpoint mathWSEndpoint;

    @Autowired
    ObjectFactory objectFactory;

    QuadraticEducationRequest request;
    QuadraticEducationResponse expectedResponse;

    @BeforeEach
    void init() {
        request = objectFactory.createQuadraticEducationRequest();
        expectedResponse = objectFactory.createQuadraticEducationResponse();
    }

    @Test
    void shouldReturnResultWithDiscriminantGreaterThanZero() throws QuadraticEducationNoSolutionException {
        request.setA(2);
        request.setB(-3);
        request.setC(1);

        expectedResponse.setFormula("2,0x^2 + -3,0x + 1,0 = 0");
        expectedResponse.setDiscriminant(1.0);
        expectedResponse.setX1(1.0);
        expectedResponse.setX2(0.5);

        assertEquals(expectedResponse, mathWSEndpoint.getQuadraticEducationSolution(request));
    }

    @Test
    void shouldReturnResponseWithOneRoot() throws QuadraticEducationNoSolutionException {
        request.setA(1);
        request.setB(-6);
        request.setC(9);

        expectedResponse.setFormula("1,0x^2 + -6,0x + 9,0 = 0");
        expectedResponse.setDiscriminant(0.0);
        expectedResponse.setX1(3.0);

        assertEquals(expectedResponse, mathWSEndpoint.getQuadraticEducationSolution(request));
    }

    @Test
    void shouldThrowQuadraticEducationExceptionDiscriminantLessThanZero() {
        request.setA(5);
        request.setB(3);
        request.setC(7);

        QuadraticEducationException expectedException = assertThrows(QuadraticEducationException.class, () -> {
            mathWSEndpoint.getQuadraticEducationSolution(request);
        });

        assertEquals("Discriminant can't be less than 0", expectedException.getMessage());
    }

    @Test
    void shouldReturnQuadraticEducationFault() {
        request.setA(5);
        request.setB(3);
        request.setC(7);

        QuadraticEducationException expectedException = assertThrows(QuadraticEducationException.class, () -> {
            mathWSEndpoint.getQuadraticEducationSolution(request);
        });

        QuadraticEducationFault expectedFault = objectFactory.createQuadraticEducationFault();
        expectedFault.setFormula("5,0x^2 + 3,0x + 7,0 = 0");
        expectedFault.setDiscriminant(-131.0);

        assertEquals(expectedFault, expectedException.getQuadraticEducationFault());
    }

    @Test
    void shouldThrowQuadraticEducationNoRealRots() {
        request.setA(4);
        request.setC(30);

        QuadraticEducationNoSolutionException expectedException = assertThrows(QuadraticEducationNoSolutionException.class, () -> {
            mathWSEndpoint.getQuadraticEducationSolution(request);
        });

        assertEquals("The education has no real roots", expectedException.getMessage());
    }

    @Test
    void shouldReturnExceptionLeadingCoefficientEqualsZero() {
        request.setA(0);
        request.setB(4);
        request.setC(3);

        QuadraticEducationNoSolutionException expectedException = assertThrows(QuadraticEducationNoSolutionException.class, () -> {
            mathWSEndpoint.getQuadraticEducationSolution(request);
        });

        assertEquals("The leading coefficient can't be equals 0", expectedException.getMessage());
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenCEqualsZero() throws QuadraticEducationNoSolutionException {
        request.setA(4);
        request.setB(-7);

        expectedResponse.setFormula("4,0x^2 + -7,0x = 0");
        expectedResponse.setX1(0.0);
        expectedResponse.setX2(1.75);

        assertEquals(expectedResponse, mathWSEndpoint.getQuadraticEducationSolution(request));
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenBEqualsZero() throws QuadraticEducationNoSolutionException {
        request.setA(4);
        request.setC(-9);

        expectedResponse.setFormula("4,0x^2 + -9,0 = 0");
        expectedResponse.setX1(1.5);
        expectedResponse.setX2(-1.5);

        assertEquals(expectedResponse, mathWSEndpoint.getQuadraticEducationSolution(request));
    }
}