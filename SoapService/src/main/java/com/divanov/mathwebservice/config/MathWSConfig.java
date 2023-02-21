package com.divanov.mathwebservice.config;

import com.divanov.mathwebservice.dto.ObjectFactory;
import com.divanov.mathwebservice.endpoint.MathWSEndpoint;
import com.divanov.mathwebservice.validatorinterceptor.ValidationInterceptorMathWS;
import com.divanov.mathwebservice.exception.DetailSoapFaultDefinitionExceptionResolver;
import com.divanov.mathwebservice.exception.QuadraticEducationException;
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

import java.util.List;
import java.util.Properties;

@EnableWs
@Configuration
public class MathWSConfig extends WsConfigurerAdapter {

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        ValidationInterceptorMathWS validatingInterceptor = new ValidationInterceptorMathWS();
        validatingInterceptor.setValidateRequest(true);
        validatingInterceptor.setXsdSchema(schema());
        interceptors.add(validatingInterceptor);
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServletServletRegistrationBean(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/services/*");
    }

    @Bean(name = "MathService")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema generalSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setServiceName("MathService");
        wsdl11Definition.setPortTypeName("MathPort");
        wsdl11Definition.setTargetNamespace(MathWSEndpoint.NAME_SPACE);
        wsdl11Definition.setLocationUri("/services/MathServiceEndpoint");
        wsdl11Definition.setSchema(schema());
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema schema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/mathWS.xsd"));
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }

    @Bean
    public SoapFaultMappingExceptionResolver exceptionResolver() {
        SoapFaultMappingExceptionResolver exceptionResolver = new DetailSoapFaultDefinitionExceptionResolver();

        SoapFaultDefinition faultDefinition = new SoapFaultDefinition();
        faultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
        exceptionResolver.setDefaultFault(faultDefinition);

        Properties errorMappings = new Properties();
        errorMappings.setProperty(Exception.class.getName(), SoapFaultDefinition.SERVER.toString());
        errorMappings.setProperty(QuadraticEducationException.class.getName(), SoapFaultDefinition.SERVER.toString());
        exceptionResolver.setExceptionMappings(errorMappings);
        exceptionResolver.setOrder(1);
        return exceptionResolver;
    }
}
