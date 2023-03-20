package com.divanov.mathwebservice.exception;

public class QuadraticEducationException extends MathServiceException {
    private String formula;
    private double discriminant;

    public QuadraticEducationException(String message, double discriminant, String formula) {
        super(message);
        this.formula = formula;
        this.discriminant = discriminant;
    }

    public QuadraticEducationException(String message) {
        super(message);
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public double getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(double discriminant) {
        this.discriminant = discriminant;
    }
}
