package com.example.demo.controller;

import com.example.demo.dtos.CourseDto;
import com.example.demo.dtos.CourseRegistrationDto;
import com.example.demo.dtos.CourseScheduleLocationDto;
import com.example.demo.dtos.CourseTimeTableDto;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

	private Logger log = LoggerFactory.getLogger(CourseController.class);

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
	@GetMapping(value = "semester={semester}")
	public List<Course> getCoursesBySemester(@PathVariable int semester) {
		return new ArrayList<>(service.getCoursesBySemester(semester));
	}	

	// GET ( Get All Courses by Student ID)
	@GetMapping(value = "student/{id}")
	public List<Course> getCoursesByStudentId(@NonNull @PathVariable String id) {
		return service.getCoursesByStudentId(id);
	}

	// GET ( Get Course by ID)
	@GetMapping(value = "{id}")
	public Course getCourse(@NonNull @PathVariable String id) {
		return service.getCourse(id);
	}	


	// GET ( Get Course Schedule Location )
	@GetMapping(value = "timetable")
	public List<CourseScheduleLocationDto> getCourseScheduleLocation() {
		return service.getCourseScheduleLocation();
	}


	// POST ( Add Course )
	@PostMapping
	public void addCourse(@NonNull @RequestBody CourseDto courseDto) {
		service.addCourse(courseDto);
	}
	
	// POST ( Add Student )
	@PostMapping(value = "student")
	public void addStudent(@NonNull @RequestBody CourseRegistrationDto courseRegistrationDto) {
		service.addStudent(courseRegistrationDto);
	}

	// POST ( Add Time Table )
	@PostMapping(value = "timetable")
	public void addTimeTable(@NonNull @RequestBody CourseTimeTableDto courseTimeTableDto) {
		service.addTimeTable(courseTimeTableDto);
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
