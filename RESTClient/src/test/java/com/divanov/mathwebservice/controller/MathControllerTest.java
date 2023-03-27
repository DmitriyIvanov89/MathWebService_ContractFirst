package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.MathServiceService;
import com.divanov.mathwebservice.gen.QuadraticEducationException;
import com.divanov.mathwebservice.gen.QuadraticEducationRequestPayLoad;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringJUnitConfig
//@ContextConfiguration(classes = MathComponentTestConfig.class)
class MathControllerTest {

    @Test
    void should_work() throws QuadraticEducationException {
        MathController controller = new MathController(new MathServiceService());
        SolutionQuadraticEducation actualResponse = controller.getResult(2, -3, 1);
        SolutionQuadraticEducation expectedResponse = new SolutionQuadraticEducation();
        expectedResponse.setFormula("2,0x^2 + -3,0x + 1,0 = 0");
        expectedResponse.setDiscriminant(1.0);
        expectedResponse.setX1(1.0);
        expectedResponse.setX2(0.5);
        assertEquals(expectedResponse, actualResponse);

    }

//    @Test
//    void shouldReturnCorrectAnswer() throws QuadraticEducationException {
//        SolutionQuadraticEducation expectedResponse = new SolutionQuadraticEducation();
//        expectedResponse.setFormula("2,0x^2 + -3,0x + 1,0 = 0");
//        expectedResponse.setDiscriminant(1.0);
//        expectedResponse.setX1(1.0);
//        expectedResponse.setX2(0.5);
//
//        Mockito.when(controller.getResult(2, -3, 1)).thenReturn(expectedResponse);
//
//        SolutionQuadraticEducation actualResponse = controller.getResult(2, -3, 1);
//        assertEquals(expectedResponse, actualResponse);
//
//    }


}