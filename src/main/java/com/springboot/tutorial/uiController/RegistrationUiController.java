package com.springboot.tutorial.uiController;

import com.springboot.tutorial.dtos.CourseDto;
import com.springboot.tutorial.dtos.RegistrationDto;
import com.springboot.tutorial.dtos.StudentDto;
import com.springboot.tutorial.service.RegistrationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/registration")
@RequiredArgsConstructor
public class RegistrationUiController {

    private final RegistrationService service;

    // GET ( Get All Courses by Student ID)
    @GetMapping(value = "student/{id}")
    public String getCoursesByStudentId(@NonNull @PathVariable String id, Model model) {
        List<CourseDto> courses = service.getCoursesByStudentId(id);
        model.addAttribute("courses", courses);
        return "registration/registration-course";
    }

    // GET ( Get All Students by Course ID)
    @GetMapping(value = "course/{id}")
    public String getStudentsByCourseId(@NonNull @PathVariable String id, Model model) {
        List<StudentDto> students = service.getStudentsByCourseId(id);
        model.addAttribute("students", students);
        return "registration/registration-student";
    }

    // POST ( Add Student )
    @PostMapping(value = "student")
    public void addStudent(@NonNull @RequestBody RegistrationDto registrationDto) {
        service.addStudent(registrationDto);
    }

}
