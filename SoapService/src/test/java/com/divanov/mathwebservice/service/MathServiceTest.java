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
    void should_return_full_response() throws QuadraticEducationNoSolutionException {

        request.setA(2);
        request.setB(-3);
        request.setC(1);

        expectedResponse.setFormula("2,0x^2 + -3,0x + 1,0 = 0");
        expectedResponse.setDiscriminant(1);
        expectedResponse.setX1(1);
        expectedResponse.setX2(0.5);

        assertEquals(expectedResponse, service.solveQuadraticEducation(request));
    }
}

