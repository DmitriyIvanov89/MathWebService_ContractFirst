package com.divanov.mathwebservice.controller.controller;

import com.divanov.mathwebservice.controller.MathController;
import com.divanov.mathwebservice.gen.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MathController.class)
public class MathWSControllerSecondTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    MathServiceService mathServiceServiceMock;
    ObjectFactory objectFactory;

    @BeforeEach
    void init() {
        objectFactory = new ObjectFactory();
    }

    @Test
    public void getResult_whenDiscriminantMoreZero_thenReturnBothRoots() throws Exception {
        SolutionQuadraticEducation expectedResponse = createSolution("2.0x^2 + -3.0x + 1.0 = 0", 1.0, 1.0, 0.5);

        when(mathServiceServiceMock.getMathServiceSoap11()).thenReturn(SolutionQuadraticEducation -> expectedResponse);

        mockMvc.perform(get("/api/calc")
                        .param("a", "2")
                        .param("b", "-3")
                        .param("c", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.formula").value(expectedResponse.getFormula()))
                .andExpect(jsonPath("$.discriminant").value(expectedResponse.getDiscriminant()))
                .andExpect(jsonPath("$.x1").value(expectedResponse.getX1()))
                .andExpect(jsonPath("$.x2").value(expectedResponse.getX2()));
    }

    @Test
    public void getResult_whenDiscriminantEqualZero_thenReturnOnlyOneRoot() throws Exception {
        SolutionQuadraticEducation expectedResponse = createSolution("1.0x^2 + -6.0x + 9.0 = 0", 0.0, 3.0, null);

        when(mathServiceServiceMock.getMathServiceSoap11()).thenReturn(SolutionQuadraticEducation -> expectedResponse);

        mockMvc.perform(get("/api/calc")
                        .param("a", "1")
                        .param("b", "-6")
                        .param("c", "9"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.formula").value(expectedResponse.getFormula()))
                .andExpect(jsonPath("$.discriminant").value(expectedResponse.getDiscriminant()))
                .andExpect(jsonPath("$.x1").value(expectedResponse.getX1()))
                .andExpect(jsonPath("$.x2").isEmpty());
    }

    @Test
    public void getResult_whenDiscriminantLessZero_thenThrowQuadraticEducationException() {


    }

    private QuadraticEducationRequestPayLoad createPayLoad(double a, double b, double c) {
        QuadraticEducationRequestPayLoad payLoad = objectFactory.createQuadraticEducationRequestPayLoad();
        payLoad.setA(a);
        payLoad.setB(b);
        payLoad.setC(c);
        return payLoad;
    }

    private SolutionQuadraticEducation createSolution(String formula, double discriminant, double x1, Double x2) {
        SolutionQuadraticEducation solutionQuadraticEducation = objectFactory.createSolutionQuadraticEducation();
        solutionQuadraticEducation.setFormula(formula);
        solutionQuadraticEducation.setDiscriminant(discriminant);
        solutionQuadraticEducation.setX1(x1);
        solutionQuadraticEducation.setX2(x2);
        return solutionQuadraticEducation;
    }
}
