//package com.divanov.mathwebservice.exception;
//
//import com.divanov.mathwebservice.gen.SolveQuadraticEducationExceptionDetail;
//
//import javax.xml.ws.WebFault;
//
//@WebFault
//public class SolveQuadraticEducationException extends RuntimeException {
//
//    private SolveQuadraticEducationExceptionDetail detailInfo;
//
//    public SolveQuadraticEducationException(String message) {
//        super(message);
//    }
//
//    public SolveQuadraticEducationException(SolveQuadraticEducationExceptionDetail detail) {
//        this.detailInfo = detail;
//    }
//
//    public SolveQuadraticEducationException(String message, SolveQuadraticEducationExceptionDetail detail) {
//        super(message);
//        this.detailInfo = detail;
//    }
//
//    public SolveQuadraticEducationException(String message, Throwable cause, SolveQuadraticEducationExceptionDetail detail) {
//        super(message, cause);
//        this.detailInfo = detail;
//    }
//
//    public SolveQuadraticEducationExceptionDetail getDetail() {
//        return detailInfo;
//    }
//}
