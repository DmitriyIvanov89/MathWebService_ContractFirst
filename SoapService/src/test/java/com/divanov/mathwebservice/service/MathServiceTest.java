package com.divanov.mathwebservice.service;

import com.divanov.mathwebservice.dto.ObjectFactory;
import com.divanov.mathwebservice.dto.QuadraticEducationRequest;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = MathServiceTestConfig.class)
class MathServiceTest {

    @Autowired
    MathService service;

    @Autowired
    ObjectFactory factory;

    QuadraticEducationRequest request;
    QuadraticEducationResponse expectedResponse;

    @BeforeEach
    void createMessages() {
        request = factory.createQuadraticEducationRequest();
        expectedResponse = factory.createQuadraticEducationResponse();
    }

    @Test
    void shouldReturnResponseWithAllElements() throws QuadraticEducationNoSolutionException {
        request.setA(2);
        request.setB(-3);
        request.setC(1);

        expectedResponse.setFormula("2,0x^2 + -3,0x + 1,0 = 0");
        expectedResponse.setDiscriminant(1);
        expectedResponse.setX1(1);
        expectedResponse.setX2(0.5);

        assertEquals(expectedResponse, service.solveQuadraticEducation(request));
    }

    @Test
    void shouldReturnResponseWithOneRoot() throws QuadraticEducationNoSolutionException {
        request.setA(1);
        request.setB(-6);
        request.setC(9);

        expectedResponse.setFormula("1,0x^2 + -6,0x + 9,0 = 0");
        expectedResponse.setDiscriminant(0.0);
        expectedResponse.setX1(3.0);

        assertEquals(expectedResponse, service.solveQuadraticEducation(request));
    }

    @Test
    void shouldThrowQuadraticEducationExceptionDiscriminantLessThanZero() {
        request.setA(5);
        request.setB(3);
        request.setC(7);

        Exception expectedException = assertThrows(QuadraticEducationException.class, () -> {
            service.solveQuadraticEducation(request);
        });

        assertEquals("Discriminant can't be less than 0", expectedException.getMessage());
    }

    @Test
    void shouldThrowQuadraticEducationNoRealRots() {
        request.setA(4);
        request.setC(30);

        Exception expectedException = assertThrows(QuadraticEducationNoSolutionException.class, () -> {
            service.solveQuadraticEducation(request);
        });

        assertEquals("The education has no real roots", expectedException.getMessage());
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenCEqualsZero() throws QuadraticEducationNoSolutionException {
        request.setA(4);
        request.setB(-7);

        expectedResponse.setFormula("4,0x^2 + -7,0x = 0");
        expectedResponse.setX1(0.0);
        expectedResponse.setX2(1.75);

        assertEquals(expectedResponse, service.solveQuadraticEducation(request));
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenBEqualsZero() throws QuadraticEducationNoSolutionException {
        request.setA(4);
        request.setC(-9);

        expectedResponse.setFormula("4,0x^2 + -9,0 = 0");
        expectedResponse.setX1(1.5);
        expectedResponse.setX2(-1.5);

        assertEquals(expectedResponse, service.solveQuadraticEducation(request));
    }
}

