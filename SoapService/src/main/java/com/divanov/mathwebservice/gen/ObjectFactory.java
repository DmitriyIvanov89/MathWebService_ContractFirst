//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.07 at 10:32:46 AM MSK 
//


package com.divanov.mathwebservice.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.divanov.mathwebservice.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SolveQuadraticEducationException_QNAME = new QName("http://math.ws.divanov", "solveQuadraticEducationException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.divanov.mathwebservice.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolveQuadraticEducationRequest }
     * 
     */
    public SolveQuadraticEducationRequest createSolveQuadraticEducationRequest() {
        return new SolveQuadraticEducationRequest();
    }

    /**
     * Create an instance of {@link SolveQuadraticEducationResponse }
     * 
     */
    public SolveQuadraticEducationResponse createSolveQuadraticEducationResponse() {
        return new SolveQuadraticEducationResponse();
    }

    /**
     * Create an instance of {@link SolveQuadraticEducationExceptionDetail }
     * 
     */
    public SolveQuadraticEducationExceptionDetail createSolveQuadraticEducationExceptionDetail() {
        return new SolveQuadraticEducationExceptionDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolveQuadraticEducationExceptionDetail }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SolveQuadraticEducationExceptionDetail }{@code >}
     */
    @XmlElementDecl(namespace = "http://math.ws.divanov", name = "solveQuadraticEducationException")
    public JAXBElement<SolveQuadraticEducationExceptionDetail> createSolveQuadraticEducationException(SolveQuadraticEducationExceptionDetail value) {
        return new JAXBElement<SolveQuadraticEducationExceptionDetail>(_SolveQuadraticEducationException_QNAME, SolveQuadraticEducationExceptionDetail.class, null, value);
    }

}
