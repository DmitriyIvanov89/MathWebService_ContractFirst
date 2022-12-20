package com.divanov.mathwebservice.client;

import com.divanov.mathwebservice.dto.QuadraticEducationResponse;
import com.divanov.mathwebservice.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

public class MathClient {
    private final static String CALC_URL = "/api/calc";

    @Autowired
    WebClient webClient;

    public QuadraticEducationResponse getQuadraticEducationResult(double a, double b, double c) {
        try {
            return webClient
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path(CALC_URL)
                            .queryParam("a", a)
                            .queryParam("b", b)
                            .queryParam("c", c)
                            .build())
                    .retrieve()
                    .bodyToMono(QuadraticEducationResponse.class)
                    .block();
        } catch (WebClientResponseException we) {
            throw new ServiceException(we.getMessage(), we.getRawStatusCode());
        }
    }

    /**
     * This method is described in
     * <a href="https://careydevelopment.us/blog/spring-webflux-how-to-handle-errors-with-webclient">...</a>
     */

    private Mono<ClientResponse> logBody(ClientResponse response) {
        if (response.statusCode().is4xxClientError() || response.statusCode().is5xxServerError()) {
            return response.bodyToMono(String.class)
                    .flatMap(body -> {
                        return Mono.error(new ServiceException(body, response.rawStatusCode()));
                    });
        } else {
            return Mono.just(response);
        }
    }
}
