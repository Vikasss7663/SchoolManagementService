package com.school.management.controller;

import com.school.management.dtos.StudentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

import static com.school.management.constants.ApplicationConstants.*;

@Slf4j
@CrossOrigin(origins = CROSS_ORIGIN_URL)
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class StudentManagementController {

    private final RestTemplate restTemplate;
    private final CircuitBreaker testServiceCircuitBreaker;

    @GetMapping
    public String test(@PathVariable String route, ServerHttpRequest serverHttpRequest) {

        Optional<String> clientIdOp = Optional.ofNullable(serverHttpRequest.getHeaders().getFirst("client_id"));

        log.debug(String.valueOf(serverHttpRequest.getHeaders()));

        if(clientIdOp.isPresent()) {
            return "Test Controller";
        } else {
            return "Client Id Not Present";
        }
    }

    public String fallbackMethod() {
        return "Default Fallback Method";
    }




}