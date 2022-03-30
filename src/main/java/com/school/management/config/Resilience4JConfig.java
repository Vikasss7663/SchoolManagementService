package com.school.management.config;

import com.school.management.properties.StudentManagementServiceCircuitBreakerProperties;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class Resilience4JConfig {

    private final StudentManagementServiceCircuitBreakerProperties studentManagementServiceCircuitBreakerProperties;

    @Bean("circuitBreakerFactory")
    public Customizer<Resilience4JCircuitBreakerFactory> getCircuitBreakerFactory() {

        // the circuitBreakerConfig and timeLimiterConfig objects
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(studentManagementServiceCircuitBreakerProperties.getFailureRateThreshold())
                .waitDurationInOpenState(studentManagementServiceCircuitBreakerProperties.getWaitDurationInOpenState())
                .permittedNumberOfCallsInHalfOpenState(studentManagementServiceCircuitBreakerProperties.getPermittedNumberOfCallsInHalfOpenState())
                .minimumNumberOfCalls(studentManagementServiceCircuitBreakerProperties.getMinimumNumberOfCalls())
                .slidingWindowType(studentManagementServiceCircuitBreakerProperties.getSlidingWindowType())
                .slidingWindowSize(studentManagementServiceCircuitBreakerProperties.getSlidingWindowSize())
                .build();

        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(4))
                .build();

        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .timeLimiterConfig(timeLimiterConfig)
                .circuitBreakerConfig(circuitBreakerConfig)
                .build());

    }

}
