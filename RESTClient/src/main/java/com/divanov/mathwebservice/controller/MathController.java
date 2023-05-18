package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.gen.*;
import com.divanov.mathwebservice.gen.SolutionQuadraticEducation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@RestController
@RequestMapping("/api")
public class MathController {
    private final Logger log = LogManager.getLogger(MathController.class);
    private final ObjectFactory objectFactory;
    private final MathServiceService service;

    @Autowired
    public MathController(MathServiceService service) {
        this.service = service;
        objectFactory = new ObjectFactory();
    }

    @GetMapping(value = "/calc")
    @ResponseBody
    public SolutionQuadraticEducation getResult(@RequestParam(name = "a") String a,
                                                @RequestParam(name = "b") String b,
                                                @RequestParam(name = "c") String c) throws QuadraticEducationException {

        if (a.isEmpty() || b.isEmpty() || c.isEmpty()) {
            throw new IllegalArgumentException("Request params can't be NaN");
        }

        QuadraticEducationRequestPayLoad payLoad = objectFactory.createQuadraticEducationRequestPayLoad();
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        try {
            payLoad.setA(format.parse(a).doubleValue());
            payLoad.setB(format.parse(b).doubleValue());
            payLoad.setC(format.parse(c).doubleValue());
        } catch (ParseException ex) {
            log.error("Wrong request parameters: a - {}, b - {}, c - {}", a, b, c);
            throw new NumberFormatException("One or more parameters aren't numbers");
        }

        log.info("Start processing request with params: a - {}, b - {}, c - {}", payLoad.getA(), payLoad.getB(), payLoad.getC());

        SolutionQuadraticEducation response = service.getMathServiceSoap11().getSolveQuadraticEducation(payLoad);

        if (response == null) {
            log.error("Response is nan");
            throw new RuntimeException("Response is Nan");
        }

        return response;
    }
}
