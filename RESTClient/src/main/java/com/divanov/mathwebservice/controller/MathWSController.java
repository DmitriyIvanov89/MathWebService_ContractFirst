package com.divanov.mathwebservice.controller;

import com.divanov.mathwebservice.client.MathPortSoap11Impl;
<<<<<<< HEAD
import com.divanov.mathwebservice.generated.*;
=======
>>>>>>> 6cd713248a87e914ee87c21dae6e24827b296e01
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calc")
public class MathWSController {

//    @Autowired
//    private MathPortSoap11Impl mathPortSoap11;
//
//    @Autowired
//    private ObjectFactory objectFactory;
//
//    @GetMapping
//    public QuadraticEducationResponse getResult(@RequestParam double a,
//                                                @RequestParam double b,
//                                                @RequestParam double c) throws QuadraticEducationFault_Exception {
//        QuadraticEducationRequest request = objectFactory.createQuadraticEducationRequest();
//        request.setA(a);
//        request.setB(b);
//        request.setC(c);
//
//        return mathPortSoap11.quadraticEducation(request);
//    }
}