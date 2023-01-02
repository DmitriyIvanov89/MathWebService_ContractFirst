package com.divanov.mathwebservice.pojo;

public class QuadraticEducationJsonResponse {
    private String formula;
    private Double discriminant;
    private Double x1;
    private Double x2;

    public QuadraticEducationJsonResponse(String formula, Double discriminant, Double x1, Double x2) {
        this.formula = formula;
        this.discriminant = discriminant;
        this.x1 = x1;
        this.x2 = x2;
    }

    public QuadraticEducationJsonResponse() {
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Double getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(Double discriminant) {
        this.discriminant = discriminant;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    @Override
    public String toString() {
        return String.format("{formula:$s, discriminant: %f, x1: %f, x2: %f}", formula, discriminant, x1, x2);
    }
}
