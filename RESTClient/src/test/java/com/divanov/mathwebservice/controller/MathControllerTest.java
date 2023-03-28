package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;;
import com.divanov.mathwebservice.gen.QuadraticEducationException;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
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

    private SolutionQuadraticEducation createResponse(String formula, double discriminant, double x1, Double x2) {
        SolutionQuadraticEducation response = objectFactory.createSolutionQuadraticEducation();
        response.setFormula(formula);
        response.setDiscriminant(discriminant);
        response.setX1(x1);
        response.setX2(x2);
        return response;
    }
}