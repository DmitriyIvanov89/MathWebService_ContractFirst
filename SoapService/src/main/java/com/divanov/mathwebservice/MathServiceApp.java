package com.divanov.mathwebservice;

import com.divanov.mathwebservice.exception.DiscriminantValueLessZeroException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MathServiceApp {
    public static void main(String[] args) throws DiscriminantValueLessZeroException {
        SpringApplication.run(MathServiceApp.class, args);
    }
}