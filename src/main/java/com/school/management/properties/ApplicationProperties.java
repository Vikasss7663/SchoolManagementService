package com.school.management.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("application.access-level")
public class ApplicationProperties {

    private String student;
    private String course;
    private String schedule;

    @Override
    public String toString() {
        return "Student: " + student + "\nCourse: " + course + "\nSchedule: " + schedule;
    }

}
