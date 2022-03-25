package com.springboot.tutorial.controller;

import com.springboot.tutorial.dtos.CourseDto;
import com.springboot.tutorial.dtos.RegistrationDto;
import com.springboot.tutorial.dtos.StudentDto;
import com.springboot.tutorial.service.RegistrationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.springboot.tutorial.constants.ApplicationConstants.CROSS_ORIGIN_URL;

@CrossOrigin(origins = CROSS_ORIGIN_URL)
@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService service;

    // GET ( Get All Courses by Student ID)
    @GetMapping(value = "student/{id}")
    public List<CourseDto> getCoursesByStudentId(@NonNull @PathVariable String id) {
        return service.getCoursesByStudentId(id);
    }

    // GET ( Get All Students by Course ID)
    @GetMapping(value = "course/{id}")
    public List<StudentDto> getStudentsByCourseId(@NonNull @PathVariable String id) {
        return service.getStudentsByCourseId(id);
    }

    // POST ( Add Student )
    @PostMapping(value = "student")
    public void addStudent(@NonNull @RequestBody RegistrationDto registrationDto) {
        service.addStudent(registrationDto);
    }

}
