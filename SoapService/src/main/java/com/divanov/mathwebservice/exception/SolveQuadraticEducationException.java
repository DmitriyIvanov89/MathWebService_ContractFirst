//package com.divanov.mathwebservice.exception;
//
//import com.divanov.mathwebservice.gen.FaultDetail;
//
//public class SolveQuadraticEducationException extends Exception {
//
//    private FaultDetail detailInfo;
//
//    public SolveQuadraticEducationException(String message) {
//        super(message);
//    }
//
//    public SolveQuadraticEducationException(FaultDetail detail) {
//        this.detailInfo = detail;
//    }
//
//    public SolveQuadraticEducationException(String message, FaultDetail detail) {
//        super(message);
//        this.detailInfo = detail;
//    }
//
//    public SolveQuadraticEducationException(String message, Throwable cause, FaultDetail detail) {
//        super(message, cause);
//        this.detailInfo = detail;
//    }
//
//    public FaultDetail getDetail() {
//        return detailInfo;
//    }
//}
