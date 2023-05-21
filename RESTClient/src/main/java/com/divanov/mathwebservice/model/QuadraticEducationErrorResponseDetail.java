package com.divanov.mathwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuadraticEducationErrorResponseDetail {
    private String message;
    private String formula;
    private String discriminant;
}
