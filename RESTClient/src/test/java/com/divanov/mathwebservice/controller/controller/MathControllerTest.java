package com.divanov.mathwebservice.controller.controller;

import com.divanov.mathwebservice.controller.MathController;
import com.divanov.mathwebservice.gen.ErrorResponse;
import com.divanov.mathwebservice.gen.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;;
import com.divanov.mathwebservice.gen.QuadraticEducationException;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.soap.SOAPFaultException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MathControllerTest {

    /**
     * Comparison of classes by individual fields
     */

    @Autowired
    MathController controller;

    @Autowired
    ObjectFactory objectFactory;

    @Test
    void shouldReturnCorrectResponse() throws QuadraticEducationException {
        SolutionQuadraticEducation expectedResponse = createResponse("2,0x^2 + -3,0x + 1,0 = 0",
                1.0, 1.0, 0.5);

        SolutionQuadraticEducation actualResponse = controller.getResult(2, -3, 1);

        assertAll(
                () -> assertEquals(expectedResponse.getFormula(), actualResponse.getFormula()),
                () -> assertEquals(expectedResponse.getDiscriminant(), actualResponse.getDiscriminant()),
                () -> assertEquals(expectedResponse.getX1(), actualResponse.getX1()),
                () -> assertEquals(expectedResponse.getX2(), actualResponse.getX2())
        );
    }

    @Test
    void shouldReturnResponseWithOneRoot() throws QuadraticEducationException {
        SolutionQuadraticEducation expectedResponse = createResponse("1,0x^2 + -6,0x + 9,0 = 0",
                0.0, 3.0, null);

        SolutionQuadraticEducation actualResponse = controller.getResult(1, -6, 9);

        assertAll(
                () -> assertEquals(expectedResponse.getFormula(), actualResponse.getFormula()),
                () -> assertEquals(expectedResponse.getDiscriminant(), actualResponse.getDiscriminant()),
                () -> assertEquals(expectedResponse.getX1(), actualResponse.getX1()),
                () -> assertNull(actualResponse.getX2())
        );
    }

    @Test
    void shouldReturnExceptionsWithDetails() {
        ErrorResponse expectedErrorResponse = objectFactory.createErrorResponse();
        expectedErrorResponse.setMessage("Discriminant can't be less than 0");
        expectedErrorResponse.setDiscriminant(-131.0);
        expectedErrorResponse.setFormula("5,0x^2 + 3,0x + 7,0 = 0");


        QuadraticEducationException actualException = assertThrows(
                QuadraticEducationException.class, () -> controller.getResult(5, 3, 7)
        );

        assertAll(
                () -> assertEquals(expectedErrorResponse.getMessage(), actualException.getMessage()),
                () -> assertEquals(expectedErrorResponse.getDiscriminant(), actualException.getFaultInfo().getDiscriminant()),
                () -> assertEquals(expectedErrorResponse.getFormula(), actualException.getFaultInfo().getFormula())
        );
    }

    @Test
    void shouldReturnNoRealRootsException() {
        SOAPFaultException actualException = assertThrows(
                SOAPFaultException.class, () -> controller.getResult(4, 0, 30)
        );

        assertEquals("The education has no real roots", actualException.getMessage());
    }

    @Test
    void shouldReturnInvalidADataException() {
        SOAPFaultException actualException = assertThrows(
                SOAPFaultException.class, () -> controller.getResult(0, -3, 1)
        );

        assertEquals("The leading coefficient can't be equals 0", actualException.getMessage());
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenCEqualsZero() throws QuadraticEducationException {
        SolutionQuadraticEducation expectedResponse = createResponse("2,0x^2 + -3,0x = 0", 0, 0, 1.5);
        SolutionQuadraticEducation actualResponse = controller.getResult(2, -3, 0);

        assertAll(
                () -> assertEquals(expectedResponse.getFormula(), actualResponse.getFormula()),
                () -> assertEquals(expectedResponse.getDiscriminant(), actualResponse.getDiscriminant()),
                () -> assertEquals(expectedResponse.getX1(), actualResponse.getX1()),
                () -> assertEquals(expectedResponse.getX2(), actualResponse.getX2())
        );
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenBEqualsZero() throws QuadraticEducationException {
        SolutionQuadraticEducation expectedResponse = createResponse("4,0x^2 + -9,0 = 0", 0, 1.5, -1.5);
        SolutionQuadraticEducation actualResponse = controller.getResult(4, 0, -9);

        assertAll(
                () -> assertEquals(expectedResponse.getFormula(), actualResponse.getFormula()),
                () -> assertEquals(expectedResponse.getDiscriminant(), actualResponse.getDiscriminant()),
                () -> assertEquals(expectedResponse.getX1(), actualResponse.getX1()),
                () -> assertEquals(expectedResponse.getX2(), actualResponse.getX2())
        );
    }

    private SolutionQuadraticEducation createResponse(String formula, double discriminant, double x1, Double x2) {
        SolutionQuadraticEducation response = objectFactory.createSolutionQuadraticEducation();
        response.setFormula(formula);
        response.setDiscriminant(discriminant);
        response.setX1(x1);
        response.setX2(x2);
        return response;
    }
}