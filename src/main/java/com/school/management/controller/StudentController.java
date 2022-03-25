package com.school.management.controller;

import com.school.management.dtos.StudentDto;
import com.school.management.model.Student;
import com.school.management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.school.management.constants.ApplicationConstants.CROSS_ORIGIN_URL;
import static com.school.management.constants.ApplicationConstants.TOPIC_NAME;

@CrossOrigin(origins = CROSS_ORIGIN_URL)
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;
    private final KafkaTemplate<String, StudentDto> kafkaTemplate;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendMessage(StudentDto student) {
        kafkaTemplate.send(TOPIC_NAME, student);
    }

    // GET ( Get All Students )
    @GetMapping
    public List<StudentDto> getStudents() {
        return service.getStudents();
    }

    // GET ( Get All Students By Semester )
    @GetMapping(value = "semester/{semester}")
    public List<StudentDto> getStudentsBySemester(@PathVariable int semester) {
        return service.getStudentsBySemester(semester);
    }

    // GET ( Get All Students By Year )
    @GetMapping(value = "year/{year}")
    public List<StudentDto> getStudentsByYear(@NonNull @PathVariable int year) {
        return service.getStudentsByYear(year);
    }

    // GET ( Get Student by ID)
    @GetMapping(value = "{id}")
    public StudentDto getStudent(@PathVariable int id, Model model) {
        return service.getStudent(id);
    }

    // POST ( Add Course )
    @PostMapping
    public StudentDto addStudent(@NonNull @RequestBody StudentDto studentDto) {
        StudentDto insertedStudent = service.addStudent(studentDto);
        sendMessage(insertedStudent);
        logger.debug("Inserted Student --> " + insertedStudent);
        return insertedStudent;
    }

    // PUT ( Update Student )
    @PutMapping
    public StudentDto updateStudent(@RequestBody StudentDto studentDto) {
        return service.updateStudent(studentDto);
    }

    // DELETE ( Delete Student )
    @DeleteMapping(value = "{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }
    
}
