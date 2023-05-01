package com.divanov.mathwebservice.controller.controller;

import com.divanov.mathwebservice.controller.MathController;
import com.divanov.mathwebservice.gen.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MathWSControllerSecondTest {

    @Autowired
    private ObjectFactory objectFactory;

    @Autowired
    private MathController controller;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MathServiceService mathServiceService;

    private MathService mathServiceMock;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        objectFactory = new ObjectFactory();
        mathServiceMock = Mockito.mock(MathService.class);
    }

    @Test
    public void shouldReturnMathServiceMock() throws Exception {
        when(mathServiceService.getMathServiceSoap11()).thenReturn(mathServiceMock);
        MathService mathService = mathServiceService.getMathServiceSoap11();

        assertNotNull(mathService);
    }

    @Test
    public void shouldReturnCorrectResponse() throws QuadraticEducationException {
        QuadraticEducationRequestPayLoad payLoad = createPayLoad(2, -3, 1);
        SolutionQuadraticEducation solution = createSolution("2.0x^2 + -3.0x + 1.0 = 0", 1.0, 1.0, 0.5);

        when(mathServiceMock.getSolveQuadraticEducation(payLoad)).thenReturn(solution);
        when(mathServiceService.getMathServiceSoap11()).thenReturn(mathServiceMock);

        SolutionQuadraticEducation actualResponse = mathServiceService.getMathServiceSoap11().getSolveQuadraticEducation(payLoad);

        assertAll(
                () -> assertEquals(solution.getFormula(), actualResponse.getFormula()),
                () -> assertEquals(solution.getDiscriminant(), actualResponse.getDiscriminant()),
                () -> assertEquals(solution.getX1(), actualResponse.getX1()),
                () -> assertEquals(solution.getX2(), actualResponse.getX2())
        );
    }

    @Test
    public void shouldReturnCorrectResponseFromController() throws Exception {
        QuadraticEducationRequestPayLoad payLoad = createPayLoad(2, -3, 1);
        SolutionQuadraticEducation solution = createSolution("2.0x^2 + -3.0x + 1.0 = 0", 1.0, 1.0, 0.5);

        when(mathServiceMock.getSolveQuadraticEducation(payLoad)).thenReturn(solution);
        when(mathServiceService.getMathServiceSoap11()).thenReturn(mathServiceMock);

        SolutionQuadraticEducation actualResponse = mathServiceService.getMathServiceSoap11().getSolveQuadraticEducation(payLoad);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/calc?a=2&b=-3&c=1")
                        .accept(MediaType.APPLICATION_JSON))
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
