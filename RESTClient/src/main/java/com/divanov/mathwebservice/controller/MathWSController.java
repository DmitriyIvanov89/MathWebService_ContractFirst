package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.client.MathClient;
import com.divanov.mathwebservice.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calc")
public class MathWSController {

    @Autowired
    private MathClient mathClient;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public QuadraticEducationResponse getResult(@RequestParam double a,
                                                @RequestParam double b,
                                                @RequestParam double c) {

        return mathClient.getQuadraticEducationSolution(a, b, c);
    }
}