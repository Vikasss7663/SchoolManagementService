package com.school.management.properties;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Data
@Configuration
@ConfigurationProperties("resilience4j.circuitbreaker.instances.test-service")
public class TestServiceCircuitBreakerProperties {

    private Boolean registerHealthIndicator;
    private Integer eventConsumerBufferSize;
    private Boolean automaticTransitionFromOpenToHalfOpenEnabled;
    private Integer failureRateThreshold;
    private Integer minimumNumberOfCalls;
    private Integer permittedNumberOfCallsInHalfOpenState;
    private Integer slidingWindowSize;
    private Duration waitDurationInOpenState;
    private CircuitBreakerConfig.SlidingWindowType slidingWindowType;

}


