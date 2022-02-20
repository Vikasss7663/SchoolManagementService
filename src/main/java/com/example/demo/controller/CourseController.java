package com.example.demo.controller;

import java.util.*;
import com.example.demo.Course;
import com.example.demo.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CourseController {

	// Dependency Injection - Singleton
	@Autowired
	private CourseService service;
    
	// GET ( Get All Courses )
	@RequestMapping(method = RequestMethod.GET)
	public List<Course> getCourses() {
		return service.getCourses();
	}

	// GET ( Get Course by Id)
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Course getCourse(@PathVariable int id) {
		return service.getCourse(id);
	}	

	// POST ( Add Course )
	@RequestMapping(method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course) {
		service.addCourse(course);
	}
	
	// PUT ( Update Course )
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public void updateCourse(@RequestBody Course course,
							@PathVariable int id) {
		service.updateCourse(id, course);
	}
	
	// DELETE ( Delete Course )
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteCourse(@PathVariable int id) {
		service.deleteCourse(id);
	}


	// Testing purpose
	@RequestMapping(method = RequestMethod.GET, value="welcome")
	public String welcome() {
		return "Welcome to Spring Boot Tutorial";
	}

}
