package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.config.MathWSConfig;
import com.divanov.mathwebservice.dto.ObjectFactory;
import com.divanov.mathwebservice.dto.QuadraticEducationRequest;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;
import com.divanov.mathwebservice.service.MathService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = MathWSConfig.class)
class MathWSEndpointTest {

    @Autowired
    MathService service;

    @Test
    void should_work() {
        // create test request
        ObjectFactory factory = new ObjectFactory();
        QuadraticEducationRequest request = factory.createQuadraticEducationRequest();
        request.setA(2);
        request.setB(-3);
        request.setC(1);

        //create test response
        QuadraticEducationResponse expectedResponse = factory.createQuadraticEducationResponse();
        expectedResponse.setFormula("2,0x^2 + -3,0x + 1,0 = 0");
        expectedResponse.setDiscriminant(1);
        expectedResponse.setX1(1);
        expectedResponse.setX2(0.5);

        QuadraticEducationResponse actualResponse = null;

        try {
            actualResponse = service.solveQuadraticEducation(request);
        } catch (QuadraticEducationNoSolutionException e) {
            throw new RuntimeException(e);
        }

        assertEquals(expectedResponse, actualResponse);
    }

}