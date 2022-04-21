package com.school.management.controller;

import com.school.management.dtos.CourseDto;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static com.school.management.constants.ApplicationConstants.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final RestTemplate restTemplate;
    private final MeterRegistry meterRegistry;
    private final CircuitBreaker courseServiceCircuitBreaker;


    @GetMapping
    public List<CourseDto> getCourses() throws URISyntaxException {

        URI uri = new URI(COURSE_BASE_URL);

        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        headers.set(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);

        HttpEntity<CourseDto> request = new HttpEntity<>(headers);

        meterRegistry.counter("course.fetch.details", "outcome", "success").increment();

//        courseServiceCircuitBreaker.run(
//                log.debug("hello"),
//                (throwable) -> {
//                    throw new NoFallbackAvailableException("No fallback available.", throwable);
//                }
//        );

        ResponseEntity<CourseDto[]> result = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                CourseDto[].class);

        return Arrays.asList(result.getBody());

    }

    @GetMapping("/{id}")
    public CourseDto getCourse(@PathVariable int id) throws URISyntaxException {
        URI uri = new URI(COURSE_BASE_URL + id);

        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        headers.set(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);

        HttpEntity<CourseDto> request = new HttpEntity<>(headers);


        meterRegistry.counter("course.fetch.details", "outcome", "success").increment();

        ResponseEntity<CourseDto> result = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                CourseDto.class);

        return result.getBody();
    }

    @PostMapping
    public CourseDto addCourse(@RequestBody CourseDto courseDto) throws URISyntaxException {

        URI uri = new URI(COURSE_BASE_URL);

        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        headers.set(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);

        HttpEntity<CourseDto> request = new HttpEntity<>(courseDto, headers);

        ResponseEntity<CourseDto> result = restTemplate.postForEntity(uri, request, CourseDto.class);

        CourseDto insertedCourse = result.getBody();

        log.debug("\n\n"+ insertedCourse + "\n\n");

        return insertedCourse;

    }

    @PutMapping
    public void updateCourse(@RequestBody CourseDto courseDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        headers.set(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);

        HttpEntity<CourseDto> request = new HttpEntity<>(courseDto, headers);

        restTemplate.put(COURSE_BASE_URL, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {

        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        headers.set(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);

        HttpEntity<CourseDto> request = new HttpEntity<>(headers);

        restTemplate.delete(COURSE_BASE_URL + id, request);

    }


}
