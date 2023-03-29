
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

    private final static QName _GetSolveQuadraticEducationRequest_QNAME = new QName("http://math.ws.divanov", "getSolveQuadraticEducationRequest");
    private final static QName _GetSolveQuadraticEducationResponse_QNAME = new QName("http://math.ws.divanov", "getSolveQuadraticEducationResponse");
    private final static QName _QuadraticEducationException_QNAME = new QName("http://math.ws.divanov", "quadraticEducationException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.divanov.mathwebservice.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QuadraticEducationRequestPayLoad }
     * 
     */
    public QuadraticEducationRequestPayLoad createQuadraticEducationRequestPayLoad() {
        return new QuadraticEducationRequestPayLoad();
    }

    /**
     * Create an instance of {@link SolutionQuadraticEducation }
     * 
     */
    public SolutionQuadraticEducation createSolutionQuadraticEducation() {
        return new SolutionQuadraticEducation();
    }

    /**
     * Create an instance of {@link ErrorResponse }
     * 
     */
    public ErrorResponse createErrorResponse() {
        return new ErrorResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuadraticEducationRequestPayLoad }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QuadraticEducationRequestPayLoad }{@code >}
     */
    @XmlElementDecl(namespace = "http://math.ws.divanov", name = "getSolveQuadraticEducationRequest")
    public JAXBElement<QuadraticEducationRequestPayLoad> createGetSolveQuadraticEducationRequest(QuadraticEducationRequestPayLoad value) {
        return new JAXBElement<QuadraticEducationRequestPayLoad>(_GetSolveQuadraticEducationRequest_QNAME, QuadraticEducationRequestPayLoad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolutionQuadraticEducation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SolutionQuadraticEducation }{@code >}
     */
    @XmlElementDecl(namespace = "http://math.ws.divanov", name = "getSolveQuadraticEducationResponse")
    public JAXBElement<SolutionQuadraticEducation> createGetSolveQuadraticEducationResponse(SolutionQuadraticEducation value) {
        return new JAXBElement<SolutionQuadraticEducation>(_GetSolveQuadraticEducationResponse_QNAME, SolutionQuadraticEducation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ErrorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://math.ws.divanov", name = "quadraticEducationException")
    public JAXBElement<ErrorResponse> createQuadraticEducationException(ErrorResponse value) {
        return new JAXBElement<ErrorResponse>(_QuadraticEducationException_QNAME, ErrorResponse.class, null, value);
    }

}