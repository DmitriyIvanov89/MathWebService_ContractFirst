//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.10.15 at 12:23:12 PM MSK 
//


package com.divanov.MathWebService.divanov.ws.math;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateSolutionResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CreateSolutionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="solutionActionResult" type="{http://math.ws.divanov}SolutionActionResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateSolutionResponse", propOrder = {
        "solutionActionResult"
})
public class CreateSolutionResponse {

    protected SolutionActionResult solutionActionResult;

    /**
     * Gets the value of the solutionActionResult property.
     *
     * @return possible object is
     * {@link SolutionActionResult }
     */
    public SolutionActionResult getSolutionActionResult() {
        return solutionActionResult;
    }

    /**
     * Sets the value of the solutionActionResult property.
     *
     * @param value allowed object is
     *              {@link SolutionActionResult }
     */
    public void setSolutionActionResult(SolutionActionResult value) {
        this.solutionActionResult = value;
    }

}
