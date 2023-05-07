package com.divanov.mathwebservice.controller.controller;

import com.divanov.mathwebservice.controller.MathController;
import com.divanov.mathwebservice.gen.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.xml.xpath.XPath;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.web.servlet.function.ServerResponse.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MathWSControllerSecondTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectFactory objectFactory;

    @MockBean
    private MathServiceService mathServiceService;

    private MathController controller;

    private MathService mathServiceMock;


    @Before
    public void init() {
        objectFactory = new ObjectFactory();
        mathServiceMock = Mockito.mock(MathService.class);
        when(mathServiceService.getMathServiceSoap11()).thenReturn(mathServiceMock);
        controller = new MathController(mathServiceService);
    }

    @Test
    public void shouldReturnCorrectResponseFromController() throws Exception {
        QuadraticEducationRequestPayLoad payLoad = createPayLoad(2, -3, 1);
        SolutionQuadraticEducation solution = createSolution("2.0x^2 + -3.0x + 1.0 = 0", 1.0, 1.0, 0.5);

        when(mathServiceMock.getSolveQuadraticEducation(payLoad)).thenReturn(solution);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/calc")
                        .contentType(MediaType.TEXT_XML)
                        .param("a", "2")
                        .param("b", "-3")
                        .param("c", "1")
                        .content("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:math=\"http://math.ws.divanov\">\n" +
                                "    <soapenv:Header/>\n" +
                                "    <soapenv:Body>\n" +
                                "        <math:getSolveQuadraticEducationRequest>\n" +
                                "            <math:a>2</math:a>\n" +
                                "            <math:b>-3</math:b>\n" +
                                "            <math:c>1</math:c>\n" +
                                "        </math:getSolveQuadraticEducationRequest>\n" +
                                "    </soapenv:Body>\n" +
                                "</soapenv:Envelope>"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().xml("<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                        "    <SOAP-ENV:Header/>\n" +
                        "    <SOAP-ENV:Body>\n" +
                        "        <ns2:getSolveQuadraticEducationResponse xmlns:ns2=\"http://math.ws.divanov\">\n" +
                        "            <ns2:formula>2.0x^2 + -3.0x + 1.0 = 0</ns2:formula>\n" +
                        "            <ns2:discriminant>1.0</ns2:discriminant>\n" +
                        "            <ns2:x1>1.0</ns2:x1>\n" +
                        "            <ns2:x2>0.5</ns2:x2>\n" +
                        "        </ns2:getSolveQuadraticEducationResponse>\n" +
                        "    </SOAP-ENV:Body>\n" +
                        "</SOAP-ENV:Envelope>"));
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
