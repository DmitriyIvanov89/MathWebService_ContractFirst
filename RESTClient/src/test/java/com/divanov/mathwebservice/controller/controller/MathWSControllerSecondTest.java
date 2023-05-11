package com.divanov.mathwebservice.controller.controller;

import com.divanov.mathwebservice.controller.MathController;
import com.divanov.mathwebservice.gen.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MathWSControllerSecondTest {
    @Autowired
    private ObjectFactory objectFactory;
    @MockBean
    private MathServiceService mathServiceServiceMock;
    private MathService mathServiceMock;
    private MockMvc mockMvc;
    private MathController controller;

    @BeforeEach
    public void init() {
        mathServiceServiceMock = Mockito.mock(MathServiceService.class);
        mathServiceMock = mathServiceServiceMock.getMathServiceSoap11();
        controller = new MathController(mathServiceServiceMock);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void shouldReturnCorrectResponseFromController() throws Exception {
        QuadraticEducationRequestPayLoad requestPayLoad = createPayLoad(2, -3, 1);
        SolutionQuadraticEducation expectedResponse = createSolution("2.0x^2 + -3.0x + 1.0 = 0", 1.0, 1.0, 0.5);

        Mockito.doReturn(expectedResponse)
                .when(mathServiceServiceMock.getMathServiceSoap11())
                .getSolveQuadraticEducation(requestPayLoad);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/calc")
                        .param("a", "2")
                        .param("b", "-3")
                        .param("c", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private QuadraticEducationRequestPayLoad createPayLoad(double a, double b, double c) {
        QuadraticEducationRequestPayLoad payLoad = objectFactory.createQuadraticEducationRequestPayLoad();
        payLoad.setA(a);
        payLoad.setB(b);
        payLoad.setC(c);
        return payLoad;
    }

    private SolutionQuadraticEducation createSolution(String formula, double discriminant, double x1, double x2) {
        SolutionQuadraticEducation solutionQuadraticEducation = objectFactory.createSolutionQuadraticEducation();
        solutionQuadraticEducation.setFormula(formula);
        solutionQuadraticEducation.setDiscriminant(discriminant);
        solutionQuadraticEducation.setX1(x1);
        solutionQuadraticEducation.setX2(x2);
        return solutionQuadraticEducation;
    }
}
