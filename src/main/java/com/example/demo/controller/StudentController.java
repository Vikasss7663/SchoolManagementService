package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.dtos.CourseRegistrationDto;
import com.example.demo.dtos.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    // Dependency Injection - Singleton
    @Autowired
    private StudentService service;

    // GET ( Get All Students )
    @GetMapping
    public List<Student> getStudents() {
        return new ArrayList<>(service.getStudents());
    }

    // GET ( Get All Students By Semester )
    @GetMapping(value = "semester={semester}")
    public List<Student> getStudentsBySemester(@PathVariable int semester) {
        return new ArrayList<>(service.getStudentsBySemester(semester));
    }

    // GET ( Get All Students By Year )
    @GetMapping(value = "year={year}")
    public List<Student> getStudentsByYear(@NonNull @PathVariable int year) {
        return new ArrayList<>(service.getStudentsByYear(year));
    }

    // GET ( Get All Students by Course Id)
    @GetMapping(value = "course/{id}")
    public List<Student> getStudentsByCourseId(@NonNull @PathVariable String id) {
        return service.getStudentsByCourseId(id);
    }

    // GET ( Get Student by Id)
    @GetMapping(value = "{id}")
    public Student getStudent(@NonNull @PathVariable String id) {
        return service.getStudent(id);
    }

    // POST ( Add Student )
    @PostMapping
    public void addStudent(@NonNull @RequestBody StudentDto student) {
        service.addStudent(student);
    }

    // POST ( Add Course )
    @PostMapping(value = "course")
    public void addCourse(@NonNull @RequestBody CourseRegistrationDto courseRegistration) {
        service.addCourse(courseRegistration);
    }

    // PUT ( Update Student )
    @PutMapping(value = "{id}")
    public void updateStudent(@RequestBody Student student,
                              @PathVariable int id) {
        service.updateStudent(id, student);
    }

    // DELETE ( Delete Student )
    @DeleteMapping(value = "{id}")
    public void deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
    }
}
