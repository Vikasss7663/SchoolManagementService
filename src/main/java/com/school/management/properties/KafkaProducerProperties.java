package com.school.management.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("kafka.producer")
public class KafkaProducerProperties {

    private String bootstrapServers;
    private String schemaRegistryUrl;

}
