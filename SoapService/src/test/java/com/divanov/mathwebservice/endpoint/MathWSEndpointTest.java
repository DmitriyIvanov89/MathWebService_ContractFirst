package com.divanov.mathwebservice.endpoint;

import com.divanov.mathwebservice.exception.NoSolutionException;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.service.gen.ObjectFactory;
import com.divanov.mathwebservice.service.gen.QuadraticEducationRequestPayLoad;
import com.divanov.mathwebservice.service.gen.SolutionQuadraticEducation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MathWSEndpointTest {

    private ObjectFactory objectFactory;

    @Autowired
    private MathWSEndpoint mathWSEndpoint;

    @BeforeEach
    void init() {
        this.objectFactory = new ObjectFactory();
    }

    @Test
    void shouldReturnResultWithDiscriminantGreaterThanZero() {
        SolutionQuadraticEducation actualResponse =
                mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(2, -3, 1)).getValue();

        assertAll(
                () -> assertEquals("2,0x^2 + -3,0x + 1,0 = 0", actualResponse.getFormula()),
                () -> assertEquals(1.0, actualResponse.getDiscriminant()),
                () -> assertEquals(1.0, actualResponse.getX1()),
                () -> assertEquals(0.5, actualResponse.getX2())
        );
    }

    @Test
    void shouldReturnResponseWithOneRoot() {
        SolutionQuadraticEducation actualResponse =
                mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(1, -6, 9)).getValue();

        assertAll(
                () -> assertEquals("1,0x^2 + -6,0x + 9,0 = 0", actualResponse.getFormula()),
                () -> assertEquals(0.0, actualResponse.getDiscriminant()),
                () -> assertEquals(3.0, actualResponse.getX1()),
                () -> assertNull(actualResponse.getX2())
        );
    }

    @Test
    void shouldReturnQuadraticEducationFaultDetail() {
        QuadraticEducationException actualException = assertThrows(QuadraticEducationException.class, () -> {
            mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(5, 3, 7));
        });

        assertAll(
                () -> assertEquals("Discriminant can't be less than 0", actualException.getMessage()),
                () -> assertEquals("5,0x^2 + 3,0x + 7,0 = 0", actualException.getFormula()),
                () -> assertEquals(-131.0, actualException.getDiscriminant())
        );
    }

    @Test
    void shouldThrowQuadraticEducationNoRealRots() {
        NoSolutionException expectedException = assertThrows(NoSolutionException.class, () -> {
            mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(4, 0, 30));
        });

        assertEquals("The education has no real roots", expectedException.getMessage());
    }

    @Test
    void shouldReturnExceptionLeadingCoefficientEqualsZero() {
        NoSolutionException expectedException = assertThrows(NoSolutionException.class, () -> {
            mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(0, 4, 3));
        });

        assertEquals("The leading coefficient can't be equals 0", expectedException.getMessage());
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenCEqualsZero() {
        SolutionQuadraticEducation actualResponse =
                mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(4, -7, 0)).getValue();

        assertAll(
                () -> assertEquals("4,0x^2 + -7,0x = 0", actualResponse.getFormula()),
                () -> assertEquals(0, actualResponse.getDiscriminant()),
                () -> assertEquals(0.0, actualResponse.getX1()),
                () -> assertEquals(1.75, actualResponse.getX2())
        );
    }

    @Test
    void shouldReturnResponseIncompleteEducationWhenBEqualsZero() {
        SolutionQuadraticEducation actualResponse =
                mathWSEndpoint.getSolutionQuadraticEducation(createRequestPayLoad(4, 0, -9)).getValue();

        assertAll(
                () -> assertEquals("4,0x^2 + -9,0 = 0", actualResponse.getFormula()),
                () -> assertEquals(0, actualResponse.getDiscriminant()),
                () -> assertEquals(1.5, actualResponse.getX1()),
                () -> assertEquals(-1.5, actualResponse.getX2())
        );
    }

    private QuadraticEducationRequestPayLoad createRequestPayLoad(double a, double b, double c) {
        QuadraticEducationRequestPayLoad payLoad = objectFactory.createQuadraticEducationRequestPayLoad();
        payLoad.setA(a);
        payLoad.setB(b);
        payLoad.setC(c);
        return payLoad;
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
