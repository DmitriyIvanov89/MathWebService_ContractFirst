package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.gen.MathService;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationException;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationRequest;
import com.divanov.mathwebservice.gen.SolveQuadraticEducationResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class MathClient extends WebServiceGatewaySupport implements MathService {

    @Override
    public SolveQuadraticEducationResponse solveQuadraticEducation(SolveQuadraticEducationRequest solveQuadraticEducationRequest) throws SolveQuadraticEducationException {
        return (SolveQuadraticEducationResponse) getWebServiceTemplate().marshalSendAndReceive(solveQuadraticEducationRequest);
    }
}
