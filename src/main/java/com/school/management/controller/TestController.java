package com.school.management.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static com.school.management.constants.ApplicationConstants.CROSS_ORIGIN_URL;
import static com.school.management.constants.ApplicationConstants.TOPIC_NAME;


@CrossOrigin(origins = CROSS_ORIGIN_URL)
@RestController
@RequiredArgsConstructor
public class TestController {

    private RestTemplate restTemplate;
    private final CircuitBreaker testServiceCircuitBreaker;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test/{count}")
    public String test(@PathVariable int count) {

        restTemplate = new RestTemplate();

        return testServiceCircuitBreaker.run(
                () -> restTemplate.getForObject("http://localhost:9090/test/count/"+count, String.class),
                (throwable) -> fallbackMethod()
        );

    }

    public String fallbackMethod() {
        return "Default Fallback Method";
    }

    @GetMapping("/test/count/1")
    public String testCount() {
        return "1001";
    }


}