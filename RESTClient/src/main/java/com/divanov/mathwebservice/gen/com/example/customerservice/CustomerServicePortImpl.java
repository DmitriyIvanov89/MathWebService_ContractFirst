
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.example.customerservice;

import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.4
 * 2023-03-06T11:26:41.159+03:00
 * Generated source version: 3.5.4
 *
 */

@javax.jws.WebService(
                      serviceName = "CustomerServiceService",
                      portName = "CustomerServicePort",
                      targetNamespace = "http://customerservice.example.com/",
                      wsdlLocation = "file:/C:/Users/dmitriy.a.ivanov/Downloads/MyRepos/MathWebService_ContractFirst/RESTClient/src/main/resources/test.wsdl",
                      endpointInterface = "com.example.customerservice.CustomerService")

public class CustomerServicePortImpl implements CustomerService {

    private static final Logger LOG = Logger.getLogger(CustomerServicePortImpl.class.getName());

    /* (non-Javadoc)
     * @see com.example.customerservice.CustomerService#updateCustomer(com.example.customerservice.Customer customer)*
     */
    public void updateCustomer(com.example.customerservice.Customer customer) {
        LOG.info("Executing operation updateCustomer");
        System.out.println(customer);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.example.customerservice.CustomerService#getCustomersByName(java.lang.String name)*
     */
    public java.util.List<com.example.customerservice.Customer> getCustomersByName(java.lang.String name) throws NoSuchCustomerException   {
        LOG.info("Executing operation getCustomersByName");
        System.out.println(name);
        try {
            java.util.List<com.example.customerservice.Customer> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new NoSuchCustomerException("NoSuchCustomerException...");
    }

}
