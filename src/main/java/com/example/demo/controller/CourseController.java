package com.example.demo.controller;

import com.example.demo.dtos.CourseDto;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

	private final Logger log = LoggerFactory.getLogger(CourseController.class);

	private final CourseService service;

	public CourseController(CourseService service) {
		this.service = service;
	}

	@GetMapping(value = "test")
	public String test() {
		log.debug("controller -> CourseController -> This is a Test Logger");
		return "This is a Test Message";
	}

	// GET ( Get All Courses )
	@GetMapping
	public List<Course> getCourses() {
		return new ArrayList<>(service.getCourses());
	}

	// GET ( Get All Courses By Semester )
	@GetMapping(value = "semester/{semester}")
	public List<Course> getCoursesBySemester(@PathVariable int semester) {
		return new ArrayList<>(service.getCoursesBySemester(semester));
	}

	// GET ( Get Course by ID)
	@GetMapping(value = "{id}")
	public Course getCourse(@NonNull @PathVariable String id) {
		return service.getCourse(id);
	}


	// POST ( Add Course )
	@PostMapping
	public void addCourse(@NonNull @RequestBody CourseDto courseDto) {
		service.addCourse(courseDto);
	}



	// PUT ( Update Course )
	@PutMapping
	public void updateCourse(@NonNull @RequestBody CourseDto courseDto) {
		service.updateCourse(courseDto);
	}
	
	// DELETE ( Delete Course )
	@DeleteMapping(value = "{id}")
	public void deleteCourse(@NonNull @PathVariable String id) {
		service.deleteCourse(id);
	}

}
