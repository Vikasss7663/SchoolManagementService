package com.school.management.constants;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Application constants.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationConstants {

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static final String SPRING_PROFILE_TEST = "test";

    // Kafka
    public static final String TOPIC_NAME = "Kafka-Example";
    public static final String SCHEMA_REGISTRY_URL = "schema.registry.url";

    // Headers
    public static final String CONTENT_TYPE_KEY = "Content-Type";
    public static final String CONTENT_TYPE_VALUE = "application/json";
    public static final String AUTHORIZATION_KEY = "Authorization";
    public static final String AUTHORIZATION_VALUE = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJWaXNoYWwiLCJleHAiOjE2NTIwNjMzMTQsImlhdCI6MTY0OTM4NDkxNH0.D8LXszlmGl1SUlLzF-2hJNETR351Ag4q8hjxaq_p3Dj5-EamZSyAvBcd2ns1cLkmJQ_qX2IFzFH6lUjQ8f491A";

    // URLs
    public static final String CROSS_ORIGIN_URL = "http://localhost:3000";
    public static final String BASE_URL = "http://192.168.192.245:8080/";
    public static final String STUDENT_BASE_URL = "http://192.168.192.245:8080/student/";
    public static final String COURSE_BASE_URL = "http://192.168.192.245:8080/course/";
    public static final String REGISTRATION_BASE_URL = "http://192.168.192.245:8080/registration/";
    public static final String LOCATION_BASE_URL = "http://192.168.192.245:8080/location/";
    public static final String SCHEDULE_BASE_URL = "http://192.168.192.245:8080/schedule/";
    public static final String TIMETABLE_BASE_URL = "http://192.168.192.245:8080/timetable/";


}