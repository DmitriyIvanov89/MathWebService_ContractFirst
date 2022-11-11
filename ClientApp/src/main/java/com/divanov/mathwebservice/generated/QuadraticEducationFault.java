
package com.divanov.mathwebservice.generated;

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
 *         &lt;element name="Discriminant" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
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
    "discriminant"
})
@XmlRootElement(name = "QuadraticEducationFault")
public class QuadraticEducationFault {

    @XmlElement(name = "Formula", required = true)
    protected String formula;
    @XmlElement(name = "Discriminant")
    protected double discriminant;

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

}
