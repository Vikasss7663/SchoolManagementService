package com.school.management.config;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.distribution.DistributionStatisticConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;

public class MetricsConfig {

    static final String ENV = "environment";
    static final String APP_NAME = "application";

    @Value("${spring.application.name}")
    String appName;

    @Value("${PROFILE_ENV}")
    String profile;

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricRegistryCustomizer() {
        return meterRegistry -> {
            meterRegistry.config().commonTags(APP_NAME, appName, ENV, profile);

            // Configure our statistics with mean and 95th and 99th percentile
            meterRegistry.config().meterFilter(new MeterFilter() {
                @Override
                public DistributionStatisticConfig configure(Meter.Id id, DistributionStatisticConfig config) {
                    return DistributionStatisticConfig.builder()
                            .percentilesHistogram(true)
                            .percentiles(0.5, 0.95, 0.99)
                            .build()
                            .merge(config);
                }
            });
        };
    }


}
