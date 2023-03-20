package com.divanov.mathwebservice.config;

import com.divanov.mathwebservice.exception.DetailSoapFaultDefinitionExceptionResolver;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
import com.divanov.mathwebservice.validatorinterceptor.ValidationInterceptorMathWS;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableWs
public class MathWSConfig extends WsConfigurerAdapter {

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        ValidationInterceptorMathWS validatingInterceptor = new ValidationInterceptorMathWS();
        validatingInterceptor.setValidateRequest(true);
        validatingInterceptor.setXsdSchema(mathSchema());
        interceptors.add(validatingInterceptor);
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServletServletRegistrationBean(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/*");
    }

    @Bean(name = "math")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("MathService");
        wsdl11Definition.setSchema(schema);
        wsdl11Definition.setFaultSuffix("commonFault");
        wsdl11Definition.setLocationUri("/services/MathServiceEndpoint");
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema mathSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/mathWS.xsd"));
    }

    @Bean
    public SoapFaultMappingExceptionResolver exceptionResolver() throws JAXBException {
        SoapFaultMappingExceptionResolver exceptionResolver = new DetailSoapFaultDefinitionExceptionResolver();

        SoapFaultDefinition faultDefinition = new SoapFaultDefinition();
        faultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
        exceptionResolver.setDefaultFault(faultDefinition);

        Properties errorMappings = new Properties();
        errorMappings.setProperty(Exception.class.getName(), SoapFaultDefinition.SERVER.toString());
        errorMappings.setProperty(QuadraticEducationException.class.getName(), SoapFaultDefinition.CLIENT.toString());
        exceptionResolver.setExceptionMappings(errorMappings);
        exceptionResolver.setOrder(1);
        return exceptionResolver;
    }
}
