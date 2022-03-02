package com.example.demo.controller;

import com.example.demo.dtos.RegistrationDto;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.service.RegistrationService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    // GET ( Get All Courses by Student ID)
    @GetMapping(value = "student/{id}")
    public List<Course> getCoursesByStudentId(@NonNull @PathVariable String id) {
        return service.getCoursesByStudentId(id);
    }

    // GET ( Get All Students by Course ID)
    @GetMapping(value = "course/{id}")
    public List<Student> getStudentsByCourseId(@org.springframework.lang.NonNull @PathVariable String id) {
        return service.getStudentsByCourseId(id);
    }

    // POST ( Add Student )
    @PostMapping(value = "student")
    public void addStudent(@NonNull @RequestBody RegistrationDto registrationDto) {
        service.addStudent(registrationDto);
    }

}
