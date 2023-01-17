package com.divanov.mathwebservice.service.junit;


import com.divanov.mathwebservice.dto.ObjectFactory;
import com.divanov.mathwebservice.dto.QuadraticEducationRequest;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import com.divanov.mathwebservice.exception.QuadraticEducationNoSolutionException;
import com.divanov.mathwebservice.service.MathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class SoapServiceTest {

    private MathService service;
    private QuadraticEducationRequest request;
    private QuadraticEducationResponse expectedResponse;

    @BeforeEach
    void init() {
        service = new MathService();
        ObjectFactory objectFactory = new ObjectFactory();
        request = objectFactory.createQuadraticEducationRequest();
        expectedResponse = objectFactory.createQuadraticEducationResponse();
    }

    @Test
    void shouldReturnResponseWithAllElements() throws QuadraticEducationNoSolutionException {
        request.setA(1);
        request.setB(-3);
        request.setC(2);

        expectedResponse.setFormula("1,0x^2 + -3,0x + 2,0 = 0");
        expectedResponse.setDiscriminant(1.0);
        expectedResponse.setX1(2.0);
        expectedResponse.setX2(1.0);

        assertEquals(expectedResponse, service.solveQuadraticEducation(request));
    }

}
