
package com.divanov.mathwebservice.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solutionQuadraticEducation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solutionQuadraticEducation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="formula" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="discriminant" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="x1" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="x2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solutionQuadraticEducation", propOrder = {
    "formula",
    "discriminant",
    "x1",
    "x2"
})
public class SolutionQuadraticEducation {

    @XmlElement(required = true)
    protected String formula;
    protected double discriminant;
    protected double x1;
    protected Double x2;

    /**
     * Gets the value of the formula property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormula() {
        return formula;
    }

    /**
     * Sets the value of the formula property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormula(String value) {
        this.formula = value;
    }

    /**
     * Gets the value of the discriminant property.
     * 
     */
    public double getDiscriminant() {
        return discriminant;
    }

    /**
     * Sets the value of the discriminant property.
     * 
     */
    public void setDiscriminant(double value) {
        this.discriminant = value;
    }

    /**
     * Gets the value of the x1 property.
     * 
     */
    public double getX1() {
        return x1;
    }

    /**
     * Sets the value of the x1 property.
     * 
     */
    public void setX1(double value) {
        this.x1 = value;
    }

    /**
     * Gets the value of the x2 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getX2() {
        return x2;
    }

    /**
     * Sets the value of the x2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setX2(Double value) {
        this.x2 = value;
    }

}
