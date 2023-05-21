package com.divanov.mathwebservice.controller.controller;

import com.divanov.mathwebservice.gen.ObjectFactory;
import com.divanov.mathwebservice.gen.QuadraticEducationException;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import javax.xml.ws.soap.SOAPFaultException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerThirdTest {

    private ObjectFactory objectFactory;
    private static final String EXCEPTION_MESSAGE_COEFF_A = "Client received SOAP Fault from server: The leading coefficient can't be equals 0 Please see the server log to find more detail regarding exact cause of the failure.";

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        objectFactory = new ObjectFactory();
    }

    @Test
    public void whenDiscriminantMoreZero_thenReturnBothRoots() throws Exception {
        SolutionQuadraticEducation expectedResponse = createSolution("2.0x^2 + -3.0x + 1.0 = 0", 1.0, 1.0, 0.5);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/calc")
                        .param("a", "2")
                        .param("b", "-3")
                        .param("c", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.formula").value(expectedResponse.getFormula()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.discriminant").value(expectedResponse.getDiscriminant()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.x1").value(expectedResponse.getX1()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.x2").value(expectedResponse.getX2()));
    }

    @Test
    public void whenDiscriminantEqualsZero_thenReturnOnlyOneRoots() throws Exception {
        SolutionQuadraticEducation expectedResponse = createSolution("1.0x^2 + -6.0x + 9.0 = 0", 0.0, 3.0, null);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/calc")
                        .param("a", "1")
                        .param("b", "-6")
                        .param("c", "9"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.formula").value(expectedResponse.getFormula()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.discriminant").value(expectedResponse.getDiscriminant()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.x1").value(expectedResponse.getX1()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.x2").isEmpty());
    }

    @Test
    public void whenDiscriminantLessZero_thenThrowQuadraticEducationException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/calc")
                        .param("a", "5")
                        .param("b", "3")
                        .param("c", "7"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof QuadraticEducationException))
                .andExpect(result -> assertEquals("Discriminant can't be less than 0", Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }

    @Test
    public void whenAEqualsZero_thenThrowException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/calc")
                        .param("a", "0")
                        .param("b", "3")
                        .param("c", "7"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof SOAPFaultException))
                .andExpect(result -> assertEquals(EXCEPTION_MESSAGE_COEFF_A, Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }

    @Test
    public void whenRequestParamNotNumeric_thenThrowException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/calc")
                        .param("a", "5")
                        .param("b", "33")
                        .param("c", "asdfa"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NumberFormatException))
                .andExpect(result -> assertEquals("One or more parameters aren't numbers", Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }

    @Test
    public void whenRequestParamIsNull_thenThrowException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/calc")
                        .param("a", "5")
                        .param("b", "")
                        .param("c", "7"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andExpect(result -> assertEquals("Request params can't be NaN", Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }

    @Test
    public void whenOneParamIsZero_thenReturnResponse() throws Exception {
        SolutionQuadraticEducation expectedResponse = createSolution("2.0x^2 + -3.0x = 0", 0.0, 0, 1.5);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/calc")
                        .param("a", "2")
                        .param("b", "-3")
                        .param("c", "0"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.formula").value(expectedResponse.getFormula()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.discriminant").value(expectedResponse.getDiscriminant()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.x1").value(expectedResponse.getX1()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.x2").value(expectedResponse.getX2()));
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
