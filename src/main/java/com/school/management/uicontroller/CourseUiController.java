package com.school.management.uicontroller;

import com.school.management.dtos.CourseDto;
import com.school.management.service.CourseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ui/course")
@RequiredArgsConstructor
public class CourseUiController {

	private static final String COURSE_ATTR = "course";
	private final CourseService service;

	// GET ( Get All Courses )
	@GetMapping
	public String getCourses(Model model) {
		List<CourseDto> courses = service.getCourses();
		model.addAttribute("courses", courses);
		return "course/course-list";
	}

	// GET ( Get All Courses By Semester )
	@GetMapping(value = "semester/{semester}")
	public List<CourseDto> getCoursesBySemester(@PathVariable int semester) {
		return new ArrayList<>(service.getCoursesBySemester(semester));
	}

	// GET ( Get Course by ID)
	@GetMapping(value = "{id}")
	public String getCourse(@PathVariable int id, Model model) {
		CourseDto courseDto = service.getCourse(id);
		model.addAttribute(COURSE_ATTR, courseDto);
		return "course/course-item";
	}

	// POST ( Add Course )
	@PostMapping
	public String addCourse(@ModelAttribute(COURSE_ATTR) CourseDto courseDto, Model model) {
		service.addCourse(courseDto);
		return "redirect:/ui/course";
	}

	// PUT ( Update Course )
	@PutMapping
	public void updateCourse(@NonNull @RequestBody CourseDto courseDto) {
		service.updateCourse(courseDto);
	}

	// DELETE ( Delete Course )
	@DeleteMapping(value = "{id}")
	public void deleteCourse(@PathVariable int id) {
		service.deleteCourse(id);
	}

	// Form Add Course
	@GetMapping(value = "add")
	public String addCourseForm(Model model) {
		model.addAttribute(COURSE_ATTR, new CourseDto());
		return "course/course-add";
	}

	// Form Update Course
	@GetMapping(value = "update/{id}")
	public String updateCourseForm(Model model, @PathVariable int id) {
		CourseDto course = service.getCourse(id);
		model.addAttribute(COURSE_ATTR, course);
		return "course/course-add";
	}

	// Form Delete Course
	@PostMapping(value = "delete/{id}")
	public String deleteCourseForm(Model model, @PathVariable int id) {
		service.deleteCourse(id);
		return getCourses(model);
	}

}