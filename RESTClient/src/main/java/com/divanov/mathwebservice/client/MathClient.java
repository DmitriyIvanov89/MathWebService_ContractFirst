package com.divanov.mathwebservice.client;

public class MathClient {
//    private final static String QUADRATIC_EDUCATION_RESOURCE= "/api/calc";
//
//    @Autowired
//    WebClient webClient;
//
//    public QuadraticEducationResponse getQuadraticEducationResult(double a, double b, double c) {
//        try {
//            return webClient
//                    .get()
//                    .uri(uriBuilder -> uriBuilder
//                            .path(QUADRATIC_EDUCATION_RESOURCE)
//                            .queryParam("a", a)
//                            .queryParam("b", b)
//                            .queryParam("c", c)
//                            .build())
//                    .retrieve()
//                    .bodyToMono(QuadraticEducationResponse.class)
//                    .block();
//        } catch (WebClientResponseException we) {
//            throw new ServiceException(we.getMessage(), we.getRawStatusCode());
//        }
//    }
//
//    /**
//     * This method is described in
//     * <a href="https://careydevelopment.us/blog/spring-webflux-how-to-handle-errors-with-webclient">...</a>
//     */
//
//    private Mono<ClientResponse> logBody(ClientResponse response) {
//        if (response.statusCode().is4xxClientError() || response.statusCode().is5xxServerError()) {
//            return response.bodyToMono(String.class)
//                    .flatMap(body -> {
//                        return Mono.error(new ServiceException(body, response.rawStatusCode()));
//                    });
//        } else {
//            return Mono.just(response);
//        }
//    }
}
