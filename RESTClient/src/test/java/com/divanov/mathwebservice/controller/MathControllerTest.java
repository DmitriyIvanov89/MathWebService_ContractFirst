package com.divanov.mathwebservice.controller;

;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;;
import com.divanov.mathwebservice.gen.QuadraticEducationException;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MathControllerTestConfig.class)
class MathControllerTest {

    /**
     * Comparison of classes by individual fields
     */

    @Autowired
    MathController controller;

    @Test
    void should_work() throws QuadraticEducationException {
        SolutionQuadraticEducation expectedResponse = new SolutionQuadraticEducation();
        expectedResponse.setFormula("2,0x^2 + -3,0x + 1,0 = 0");
        expectedResponse.setDiscriminant(1.0);
        expectedResponse.setX1(1.0);
        expectedResponse.setX2(0.5);

        SolutionQuadraticEducation actualResponse = controller.getResult(2, -3, 1);

        assertAll(
                () -> assertEquals(expectedResponse.getFormula(), actualResponse.getFormula()),
                () -> assertEquals(expectedResponse.getDiscriminant(), actualResponse.getDiscriminant()),
                () -> assertEquals(expectedResponse.getX1(), actualResponse.getX1()),
                () -> assertEquals(expectedResponse.getX2(), actualResponse.getX2())
        );
    }
}