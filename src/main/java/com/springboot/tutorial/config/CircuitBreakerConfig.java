package com.springboot.tutorial.config;

import com.springboot.tutorial.properties.CourseServiceCircuitBreakerProperties;
import com.springboot.tutorial.properties.TestServiceCircuitBreakerProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@EnableRetry
@RequiredArgsConstructor
public class CircuitBreakerConfig {

    private final CircuitBreakerFactory circuitBreakerFactory;

    @Bean("testServiceCircuitBreaker")
    public CircuitBreaker getTestServiceCircuitBreaker() {

        return circuitBreakerFactory.create("testServiceCircuitBreaker");

    }

    @Bean("courseServiceCircuitBreaker")
    public CircuitBreaker getCourseServiceCircuitBreaker() {

        return circuitBreakerFactory.create("courseServiceCircuitBreaker");

    }


}
