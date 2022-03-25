package com.school.management.uicontroller;

import com.school.management.dtos.CourseDto;
import com.school.management.dtos.RegistrationDto;
import com.school.management.dtos.StudentDto;
import com.school.management.service.RegistrationService;
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
    @PostMapping
    public String addStudent(@ModelAttribute("registration") RegistrationDto registrationDto, Model model) {
        service.addStudent(registrationDto);
        return "registration/registration-add";
    }

    // Form Register Student & Course
    @GetMapping(value = "add")
    public String addRegistrationForm(Model model) {
        model.addAttribute("registration", new RegistrationDto());
        return "registration/registration-add";
    }

}
