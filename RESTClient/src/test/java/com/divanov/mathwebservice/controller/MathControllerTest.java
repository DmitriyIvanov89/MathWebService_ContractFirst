package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringJUnitConfig
//@ContextConfiguration(classes = MathComponentTestConfig.class)
class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MathService service;

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
}