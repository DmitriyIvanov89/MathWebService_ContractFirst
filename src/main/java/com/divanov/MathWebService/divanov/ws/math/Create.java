//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.10.15 at 12:23:12 PM MSK 
//


package com.divanov.MathWebService.divanov.ws.math;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="request" type="{http://math.ws.divanov}CreateGetSolutionQuadraticEducation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "request"
})
@XmlRootElement(name = "create")
public class Create {

    protected CreateGetSolutionQuadraticEducation request;

    /**
     * Gets the value of the request property.
     *
     * @return possible object is
     * {@link CreateGetSolutionQuadraticEducation }
     */
    public CreateGetSolutionQuadraticEducation getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     *
     * @param value allowed object is
     *              {@link CreateGetSolutionQuadraticEducation }
     */
    public void setRequest(CreateGetSolutionQuadraticEducation value) {
        this.request = value;
    }

}
