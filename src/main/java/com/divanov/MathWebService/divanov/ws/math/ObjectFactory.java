//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.10.15 at 12:23:12 PM MSK 
//


package com.divanov.MathWebService.divanov.ws.math;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the divanov.ws.math package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: divanov.ws.math
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Create }
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link CreateGetSolutionQuadraticEducation }
     */
    public CreateGetSolutionQuadraticEducation createCreateGetSolutionQuadraticEducation() {
        return new CreateGetSolutionQuadraticEducation();
    }

    /**
     * Create an instance of {@link CreateResponse }
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link CreateSolutionResponse }
     */
    public CreateSolutionResponse createCreateSolutionResponse() {
        return new CreateSolutionResponse();
    }

    /**
     * Create an instance of {@link SolutionActionResult }
     */
    public SolutionActionResult createSolutionActionResult() {
        return new SolutionActionResult();
    }

    /**
     * Create an instance of {@link EducationParams }
     */
    public EducationParams createEducationParams() {
        return new EducationParams();
    }

}
