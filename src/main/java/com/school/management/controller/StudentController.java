package com.school.management.controller;

import com.school.management.dtos.StudentDto;
import com.school.management.schema.student.StudentEvent;
import com.school.management.schema.student.StudentEventKey;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
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
@RequestMapping("/student")
public class StudentController {

    private final KafkaProducer<StudentEventKey, StudentEvent> producer;
    private final RestTemplate restTemplate;
    private final MeterRegistry meterRegistry;

    @GetMapping
    public List<StudentDto> getStudents() throws URISyntaxException {

        URI uri = new URI(STUDENT_BASE_URL);

        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        headers.set(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);

        HttpEntity request = new HttpEntity(headers);

        meterRegistry.counter("student.fetch.details", "outcome", "success").increment();

        ResponseEntity<StudentDto[]> result = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                StudentDto[].class);

        return Arrays.asList(result.getBody());

    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable int id) throws URISyntaxException {
        URI uri = new URI(STUDENT_BASE_URL + id);

        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        headers.set(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<StudentDto> result = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                StudentDto.class);

        return result.getBody();
    }

    @PostMapping
    public StudentDto addStudent(@RequestBody StudentDto studentDto) throws URISyntaxException {

        URI uri = new URI(STUDENT_BASE_URL);

        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        headers.set(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);

        HttpEntity<StudentDto> request = new HttpEntity(studentDto, headers);

        ResponseEntity<StudentDto> result = restTemplate.postForEntity(uri, request, StudentDto.class);

        StudentDto insertedStudent = result.getBody();

        log.debug("\n\n\n"+ insertedStudent + "\n\n\n");

        // Kafka Event Producing

        StudentEventKey key = new StudentEventKey();
        key.setStudentId(insertedStudent.getStudentId());
        key.setStudentSemester(insertedStudent.getStudentSemester());
        key.setStudentYear(insertedStudent.getStudentYear());

        StudentEvent value = new StudentEvent();
        value.setStudentId(insertedStudent.getStudentId());
        value.setStudentName(insertedStudent.getStudentName());
        value.setStudentSemester(insertedStudent.getStudentSemester());
        value.setStudentYear(insertedStudent.getStudentYear());
        value.setSchoolId(insertedStudent.getSchoolId());
        value.setSchoolName(insertedStudent.getSchoolName());

        ProducerRecord<StudentEventKey, StudentEvent> record
                = new ProducerRecord<>(TOPIC_NAME, key, value);

        producer.send(record);

        // Kafka Event Sent

        return insertedStudent;

    }

    @PutMapping
    public void updateStudent(@RequestBody StudentDto studentDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        headers.set(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);

        HttpEntity<StudentDto> request = new HttpEntity(studentDto, headers);

        restTemplate.put(STUDENT_BASE_URL, request);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {

        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        headers.set(AUTHORIZATION_KEY, AUTHORIZATION_VALUE);

        HttpEntity<StudentDto> request = new HttpEntity(headers);

        restTemplate.delete(STUDENT_BASE_URL + id, request);

    }


}
