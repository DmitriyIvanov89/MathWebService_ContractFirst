package com.divanov.mathwebservice.exceptiondetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetail {
    private String message;
    private String formula;
    private String discriminant;
}
