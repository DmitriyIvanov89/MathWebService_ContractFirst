
package com.divanov.mathwebservice.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Formula" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="D" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="X1" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="X2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "formula",
    "discriminant",
    "x1",
    "x2"
})
@XmlRootElement(name = "QuadraticEducationResponse")
public class QuadraticEducationResponse {

    @XmlElement(name = "Formula", required = true)
    protected String formula;
    @XmlElement(name = "D")
    protected double discriminant;
    @XmlElement(name = "X1")
    protected double x1;
    @XmlElement(name = "X2")
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
