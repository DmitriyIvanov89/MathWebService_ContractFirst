package com.divanov.mathwebservice.controller.controller;

import com.divanov.mathwebservice.controller.MathController;
import com.divanov.mathwebservice.gen.ObjectFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;;
import com.divanov.mathwebservice.gen.QuadraticEducationException;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.soap.SOAPFaultException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MathControllerTest {

    private ObjectFactory objectFactory;
    private static final String EXCEPTION_MESSAGE_NO_REAL_ROOT = "Client received SOAP Fault from server: The education has no real roots Please see the server log to find more detail regarding exact cause of the failure.";
    private static final String EXCEPTION_MESSAGE_COEFF_A = "Client received SOAP Fault from server: The leading coefficient can't be equals 0 Please see the server log to find more detail regarding exact cause of the failure.";

    @Autowired
    MathController controller;

    @BeforeEach
    void init() {
        this.objectFactory = new ObjectFactory();
    }

    @Test
    void shouldReturnCorrectResponse() throws QuadraticEducationException {
        SolutionQuadraticEducation actualResponse = controller.getResult(2, -3, 1);

        assertAll(
                () -> assertEquals("2.0x^2 + -3.0x + 1.0 = 0", actualResponse.getFormula()),
                () -> assertEquals(1.0, actualResponse.getDiscriminant()),
                () -> assertEquals(1.0, actualResponse.getX1()),
                () -> assertEquals(0.5, actualResponse.getX2())
        );
    }

    @Test
    void shouldReturnResponseWithOneRoot() throws QuadraticEducationException {
        SolutionQuadraticEducation actualResponse = controller.getResult(1, -6, 9);

        assertAll(
                () -> assertEquals("1.0x^2 + -6.0x + 9.0 = 0", actualResponse.getFormula()),
                () -> assertEquals(0.0, actualResponse.getDiscriminant()),
                () -> assertEquals(3.0, actualResponse.getX1()),
                () -> assertNull(actualResponse.getX2())
        );
    }

    @Test
    void shouldReturnExceptionsWithDetails() {
        QuadraticEducationException actualException = assertThrows(
                QuadraticEducationException.class, () -> controller.getResult(5, 3, 7)
        );

        assertAll(
                () -> assertEquals("Discriminant can't be less than 0", actualException.getMessage()),
                () -> assertEquals("5.0x^2 + 3.0x + 7.0 = 0", actualException.getFaultInfo().getFormula()),
                () -> assertEquals(-131.0, actualException.getFaultInfo().getDiscriminant())
        );
    }

    @Test
    void shouldReturnNoRealRootsException() {
        SOAPFaultException actualException = assertThrows(
                SOAPFaultException.class, () -> controller.getResult(4, 0, 30)
        );

        assertEquals(EXCEPTION_MESSAGE_NO_REAL_ROOT, actualException.getMessage());
    }

    @Test
    void shouldReturnInvalidADataException() {
        SOAPFaultException actualException = assertThrows(
                SOAPFaultException.class, () -> controller.getResult(0, -3, 1)
        );

        assertEquals(EXCEPTION_MESSAGE_COEFF_A, actualException.getMessage());
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenCEqualsZero() throws QuadraticEducationException {
        SolutionQuadraticEducation actualResponse = controller.getResult(2, -3, 0);

        assertAll(
                () -> assertEquals("2.0x^2 + -3.0x = 0", actualResponse.getFormula()),
                () -> assertEquals(0, actualResponse.getDiscriminant()),
                () -> assertEquals(0, actualResponse.getX1()),
                () -> assertEquals(1.5, actualResponse.getX2())
        );
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenBEqualsZero() throws QuadraticEducationException {
        SolutionQuadraticEducation actualResponse = controller.getResult(4, 0, -9);

        assertAll(
                () -> assertEquals("4.0x^2 + -9.0 = 0", actualResponse.getFormula()),
                () -> assertEquals(0, actualResponse.getDiscriminant()),
                () -> assertEquals(1.5, actualResponse.getX1()),
                () -> assertEquals(-1.5, actualResponse.getX2())
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