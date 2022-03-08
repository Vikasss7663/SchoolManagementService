package com.springboot.tutorial.controller;

import com.springboot.tutorial.dtos.CourseDto;
import com.springboot.tutorial.dtos.StudentDto;
import com.springboot.tutorial.dtos.StudentDto;
import com.springboot.tutorial.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    // GET ( Get All Students )
    @GetMapping
    public String getStudents(Model model) {
        List<StudentDto> students = service.getStudents();
        model.addAttribute("student", new StudentDto());
        model.addAttribute("students", students);
        return "student";
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

    // POST ( Add Course )
    @PostMapping
    public String addStudent(@ModelAttribute("student") StudentDto studentDto, Model model) {
        service.addStudent(studentDto);
        return getStudents(model);
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

    // Form Add Student
    @GetMapping(value = "add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new StudentDto());
        return "student-add";
    }

    // Form Update Student
    @GetMapping(value = "update/{id}")
    public String updateStudentForm(Model model, @NonNull @PathVariable String id) {
        StudentDto student = service.getStudent(id);
        model.addAttribute("student", student);
        return "student-add";
    }

    // Form Delete Student
    @PostMapping(value = "delete/{id}")
    public String deleteStudentForm(Model model, @NonNull @PathVariable String id) {
        service.deleteStudent(id);
        return getStudents(model);
    }
    
}
