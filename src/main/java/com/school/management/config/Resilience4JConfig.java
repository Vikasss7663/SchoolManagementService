package com.school.management.config;

import com.school.management.properties.CourseServiceCircuitBreakerProperties;
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

    private final CourseServiceCircuitBreakerProperties courseServiceCircuitBreakerProperties;

    @Bean("circuitBreakerFactory")
    public Customizer<Resilience4JCircuitBreakerFactory> getCircuitBreakerFactory() {

        // the circuitBreakerConfig and timeLimiterConfig objects
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(courseServiceCircuitBreakerProperties.getFailureRateThreshold())
                .waitDurationInOpenState(courseServiceCircuitBreakerProperties.getWaitDurationInOpenState())
                .permittedNumberOfCallsInHalfOpenState(courseServiceCircuitBreakerProperties.getPermittedNumberOfCallsInHalfOpenState())
                .minimumNumberOfCalls(courseServiceCircuitBreakerProperties.getMinimumNumberOfCalls())
                .slidingWindowType(courseServiceCircuitBreakerProperties.getSlidingWindowType())
                .slidingWindowSize(courseServiceCircuitBreakerProperties.getSlidingWindowSize())
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
