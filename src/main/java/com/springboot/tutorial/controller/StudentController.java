package com.springboot.tutorial.controller;

import com.springboot.tutorial.dtos.CourseDto;
import com.springboot.tutorial.dtos.StudentDto;
import com.springboot.tutorial.dtos.StudentDto;
import com.springboot.tutorial.model.Course;
import com.springboot.tutorial.model.Student;
import com.springboot.tutorial.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        return "student/student-list";
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
    public String getStudent(@PathVariable int id, Model model) {
        Student student = service.getStudent(id);
        model.addAttribute("student", student);
        List<Course> courses = new ArrayList<>();
        student.getRegistrations().forEach(it -> courses.add(it.getCourse()));
        model.addAttribute("courses", courses);
        return "student/student-item";
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
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }

    // Form Add Student
    @GetMapping(value = "add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new StudentDto());
        return "student/student-add";
    }

    // Form Update Student
    @GetMapping(value = "update/{id}")
    public String updateStudentForm(Model model, @NonNull @PathVariable int id) {
        Student student = service.getStudent(id);
        model.addAttribute("student", student);
        return "student/student-add";
    }

    // Form Delete Student
    @PostMapping(value = "delete/{id}")
    public String deleteStudentForm(Model model, @PathVariable int id) {
        service.deleteStudent(id);
        return getStudents(model);
    }
    
}
