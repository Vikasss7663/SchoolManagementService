package com.springboot.tutorial.controller;

import com.springboot.tutorial.dtos.CourseDto;
import com.springboot.tutorial.service.CourseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.springboot.tutorial.constants.ApplicationConstants.CROSS_ORIGIN_URL;

@CrossOrigin(origins = CROSS_ORIGIN_URL)
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

	private final CourseService service;

	// GET ( Get All Courses )
	@GetMapping
	public List<CourseDto> getCourses() {
		return service.getCourses();
	}

	// GET ( Get All Courses By Semester )
	@GetMapping(value = "semester/{semester}")
	public List<CourseDto> getCoursesBySemester(@PathVariable int semester) {
		return new ArrayList<>(service.getCoursesBySemester(semester));
	}

	// GET ( Get Course by ID)
	@GetMapping(value = "{id}")
	public CourseDto getCourse(@PathVariable int id) {
		return service.getCourse(id);
	}

	// POST ( Add Course )
	@PostMapping
	public ResponseEntity<String> addCourse(@NonNull @RequestBody CourseDto courseDto) {
		return service.addCourse(courseDto);
	}

	// PUT ( Update Course )
	@PutMapping
	public ResponseEntity<String> updateCourse(@NonNull @RequestBody CourseDto courseDto) {
		return service.updateCourse(courseDto);
	}
	
	// DELETE ( Delete Course )
	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable int id) {
		return service.deleteCourse(id);
	}

}