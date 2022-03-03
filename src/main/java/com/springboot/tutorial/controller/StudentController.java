package com.springboot.tutorial.controller;

import com.springboot.tutorial.dtos.StudentDto;
import com.springboot.tutorial.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    // GET ( Get All Students )
    @GetMapping
    public List<StudentDto> getStudents() {
        return new ArrayList<>(service.getStudents());
    }

    // GET ( Get All Students By Semester )
    @GetMapping(value = "semester/{semester}")
    public List<StudentDto> getStudentsBySemester(@PathVariable int semester) {
        return new ArrayList<>(service.getStudentsBySemester(semester));
    }

    // GET ( Get All Students By Year )
    @GetMapping(value = "year/{year}")
    public List<StudentDto> getStudentsByYear(@NonNull @PathVariable int year) {
        return new ArrayList<>(service.getStudentsByYear(year));
    }

    // GET ( Get Student by ID)
    @GetMapping(value = "{id}")
    public StudentDto getStudent(@NonNull @PathVariable String id) {
        return service.getStudent(id);
    }

    // POST ( Add Student )
    @PostMapping
    public void addStudent(@NonNull @RequestBody StudentDto studentDto) {
        service.addStudent(studentDto);
    }

    // PUT ( Update Student )
    @PutMapping
    public void updateStudent(@RequestBody StudentDto studentDto) {
        service.updateStudent(studentDto);
    }

    // DELETE ( Delete Student )
    @DeleteMapping(value = "{id}")
    public void deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
    }
}
