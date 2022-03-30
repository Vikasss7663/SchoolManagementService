package com.school.management.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static com.school.management.constants.ApplicationConstants.CROSS_ORIGIN_URL;


@CrossOrigin(origins = CROSS_ORIGIN_URL)
@RestController
@RequiredArgsConstructor
public class StudentManagementController {

    private final RestTemplate restTemplate;
    private final CircuitBreaker testServiceCircuitBreaker;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{route}")
    public String test(@PathVariable String route, ServerHttpRequest serverHttpRequest) {

        Optional<String> clientIdOp = Optional.ofNullable(serverHttpRequest.getHeaders().getFirst("client_id"));

        if(clientIdOp.isPresent()) {
            return testServiceCircuitBreaker.run(
                    () -> restTemplate.getForObject("http://localhost:8080/" + route, String.class),
                    (throwable) -> fallbackMethod()
            );
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String fallbackMethod() {
        return "Default Fallback Method";
    }

}