package com.divanov.mathwebservice.client;
;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

public class MathClient {

    @Autowired
    WebClient webClient;

    public QuadraticEducationResponse createResult(double a, double b, double c) {

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/calc")
                        .queryParam("a", a)
                        .queryParam("b", b)
                        .queryParam("c", c)
                        .build())
                .retrieve()
//                .onStatus(HttpStatus.NOT_FOUND::equals,
//                        clientResponse -> Mono.empty())
                .bodyToMono(QuadraticEducationResponse.class)
                .block();
    }
}
