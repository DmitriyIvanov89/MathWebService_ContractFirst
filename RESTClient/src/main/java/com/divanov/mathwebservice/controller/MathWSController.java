package com.divanov.mathwebservice.controller;
<<<<<<< HEAD
//
//import com.divanov.mathwebservice.client.MathClient;
//import com.divanov.mathwebservice.dto.*;
//import org.springframework.beans.factory.annotation.Autowired;
=======

import com.divanov.mathwebservice.client.MathPortSoap11Impl;
<<<<<<< HEAD
import com.divanov.mathwebservice.generated.*;
=======
import com.divanov.mathwebservice.dto.*;
>>>>>>> fc3d050d9d5a7fa00c535335ff69abfa8e297c78
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> e4f4c4c9bf329cce44c475aabd189259a8d3dbc0
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calc")
public class MathWSController {

//    @Autowired
<<<<<<< HEAD
<<<<<<< HEAD
//    private MathClient mathClient;
//
//    @GetMapping
//    public QuadraticEducationResponse getResult(@RequestParam double a,
//                                                @RequestParam double b,
//                                                @RequestParam double c) {
//
//        return mathClient.getQuadraticEducationSolution(a, b, c);
=======
=======
>>>>>>> fc3d050d9d5a7fa00c535335ff69abfa8e297c78
//    private MathClient mathPortSoap11;

    @Autowired
    private MathPortSoap11Impl mathPortSoap11;

    @Autowired
    private ObjectFactory objectFactory;

    @GetMapping
    public QuadraticEducationResponse getResult(@RequestParam double a,
                                                @RequestParam double b,
                                                @RequestParam double c) throws QuadraticEducationFault_Exception {
        QuadraticEducationRequest request = objectFactory.createQuadraticEducationRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);

        return mathPortSoap11.quadraticEducation(request);
//        return client.quadraticEducation(request);

    }

//    @ExceptionHandler(QuadraticEducationFault_Exception.class)
//    public ResponseEntity<String> handleQuadraticEducationFaultException(QuadraticEducationFault_Exception exception) {
//        return ResponseEntity
//                .status(HttpStatus.CONFLICT)
//                .body(exception.getMessage());
<<<<<<< HEAD
>>>>>>> e4f4c4c9bf329cce44c475aabd189259a8d3dbc0
=======
>>>>>>> fc3d050d9d5a7fa00c535335ff69abfa8e297c78
//    }
}