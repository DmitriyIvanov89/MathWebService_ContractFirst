
package com.divanov.mathwebservice.dto;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.5.3
 * 2023-02-19T23:32:06.532+03:00
 * Generated source version: 3.5.3
 *
 */
public final class MathPort_MathPortSoap11_Client {

    private static final QName SERVICE_NAME = new QName("http://math.ws.divanov", "MathService");

    private MathPort_MathPortSoap11_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = MathService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        MathService ss = new MathService(wsdlURL, SERVICE_NAME);
        MathPort port = ss.getMathPortSoap11();

        {
        System.out.println("Invoking quadraticEducation...");
        com.divanov.mathwebservice.dto.QuadraticEducationRequest _quadraticEducation_quadraticEducationRequest = null;
        try {
            com.divanov.mathwebservice.dto.QuadraticEducationResponse _quadraticEducation__return = port.quadraticEducation(_quadraticEducation_quadraticEducationRequest);
            System.out.println("quadraticEducation.result=" + _quadraticEducation__return);

        } catch (QuadraticEducationFault_Exception e) {
            System.out.println("Expected exception: quadraticEducationFault has occurred.");
            System.out.println(e.toString());
        }

            }

        System.exit(0);
    }

}
