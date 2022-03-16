package com.springboot.tutorial.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    private static final String TEST_SERVICE = "testService";
    private static final String RETRY_SERVICE = "retryService";
    private static final String ERROR_MESSAGE = "<h2>This is Test Error</h2>";
    private static final String RETRY_MESSAGE = "<h2>We are retrying</h2>";

    Logger logger = LoggerFactory.getLogger(this.getClass());

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/test")
//    @CircuitBreaker(name = TEST_SERVICE, fallbackMethod ="testFallbackMethod")
    @Retry(name = RETRY_SERVICE, fallbackMethod = "retryFallbackMethod")
    public ResponseEntity<String> test() {
        logger.debug("TestController -> Retrying....");
        String test = restTemplate.getForObject("http://localhost:9090/test/count/1", String.class);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    public ResponseEntity<String> testFallbackMethod(Exception e) {
        return new ResponseEntity<>(ERROR_MESSAGE, HttpStatus.OK);
    }

    public ResponseEntity<String> retryFallbackMethod(Exception e) {
        return new ResponseEntity<>(RETRY_MESSAGE, HttpStatus.OK);
    }

    @GetMapping("/test/count")
    public String testCount() {
        return "1001";
    }

}