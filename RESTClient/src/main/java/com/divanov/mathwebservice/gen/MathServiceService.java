package com.divanov.mathwebservice.gen;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.5.4
 * 2023-03-30T14:07:14.186+03:00
 * Generated source version: 3.5.4
 *
 */
@WebServiceClient(name = "MathServiceService",
                  wsdlLocation = "file:/C:/Users/dmitriy.a.ivanov/Downloads/MyRepos/MathWebService_ContractFirst/RESTClient/src/main/resources/myService.wsdl",
                  targetNamespace = "http://math.ws.divanov")
public class MathServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://math.ws.divanov", "MathServiceService");
    public final static QName MathServiceSoap11 = new QName("http://math.ws.divanov", "MathServiceSoap11");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/dmitriy.a.ivanov/Downloads/MyRepos/MathWebService_ContractFirst/RESTClient/src/main/resources/myService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MathServiceService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/dmitriy.a.ivanov/Downloads/MyRepos/MathWebService_ContractFirst/RESTClient/src/main/resources/myService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public MathServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MathServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MathServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public MathServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public MathServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public MathServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns MathService
     */
    @WebEndpoint(name = "MathServiceSoap11")
    public MathService getMathServiceSoap11() {
        return super.getPort(MathServiceSoap11, MathService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MathService
     */
    @WebEndpoint(name = "MathServiceSoap11")
    public MathService getMathServiceSoap11(WebServiceFeature... features) {
        return super.getPort(MathServiceSoap11, MathService.class, features);
    }

}
