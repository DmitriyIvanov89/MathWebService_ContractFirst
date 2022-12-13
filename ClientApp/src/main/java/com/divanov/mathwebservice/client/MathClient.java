package com.divanov.mathwebservice.client;

;
import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class MathClient {
    private static final String URL_CALC = "/api/calc";

    @Autowired
    WebClient webClient;

    public QuadraticEducationResponse getQuadraticEducationResult(double a, double b, double c) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(URL_CALC)
                        .queryParam("a", a)
                        .queryParam("b", b)
                        .queryParam("c", c)
                        .build())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Service not found")))
                .onStatus(HttpStatus::is5xxServerError, error -> Mono.error(new RuntimeException("Server is not responding")))
                .bodyToMono(QuadraticEducationResponse.class)
                .block();
    }
}
