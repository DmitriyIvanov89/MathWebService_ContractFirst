//package com.divanov.mathwebservice.interceptors;
//
//import com.divanov.mathwebservice.gen.SolveQuadraticEducationException;
//import org.apache.cxf.binding.soap.SoapMessage;
//import org.apache.cxf.phase.AbstractPhaseInterceptor;
//import org.apache.cxf.phase.Phase;
//
//public class MathFaultInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
//    public MathFaultInterceptor() {
//        super(Phase.POST_INVOKE);
//    }
//
//    @Override
//    public void handleMessage(SoapMessage message) {
//        Exception exception = message.getContent(Exception.class);
//        if (exception instanceof SolveQuadraticEducationException) {
//            SolveQuadraticEducationException fault = (SolveQuadraticEducationException) exception;
//        }
//    }
//}
