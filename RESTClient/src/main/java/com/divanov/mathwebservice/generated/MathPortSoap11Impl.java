
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.divanov.mathwebservice.generated;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.5.3
 * 2023-02-27T22:19:30.667+03:00
 * Generated source version: 3.5.3
 *
 */

@javax.jws.WebService(
                      serviceName = "MathService",
                      portName = "MathPortSoap11",
                      targetNamespace = "http://math.ws.divanov",
                      wsdlLocation = "http://localhost:8080/services/MathService.wsdl",
                      endpointInterface = "com.divanov.mathwebservice.generated.MathPort")

public class MathPortSoap11Impl implements MathPort {

    private static final Logger LOG = Logger.getLogger(MathPortSoap11Impl.class.getName());

    /* (non-Javadoc)
     * @see com.divanov.mathwebservice.generated.MathPort#quadraticEducation(com.divanov.mathwebservice.generated.QuadraticEducationRequest quadraticEducationRequest)*
     */
    public com.divanov.mathwebservice.generated.QuadraticEducationResponse quadraticEducation(QuadraticEducationRequest quadraticEducationRequest) throws QuadraticEducationFault_Exception   {
        LOG.info("Executing operation quadraticEducation");
        System.out.println(quadraticEducationRequest);
        try {
            com.divanov.mathwebservice.generated.QuadraticEducationResponse _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new QuadraticEducationFault_Exception("quadraticEducationFault...");
    }

}
