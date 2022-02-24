package com.example.demo.controller;

import java.util.*;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

	// Dependency Injection - Singleton
	@Autowired
	private CourseService service;
    
	// GET ( Get All Courses )
	@RequestMapping(method = RequestMethod.GET)
	public List<Course> getCourses() {
		return new ArrayList<Course>(service.getCourses());
	}

	// GET ( Get All Courses By Semester )
	@RequestMapping(method = RequestMethod.GET, value = "semester={semester}")
	public List<Course> getCoursesBySemester(@PathVariable int semester) {
		return new ArrayList<Course>(service.getCoursesBySemester(semester));
	}	

	// GET ( Get Course by Id)
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Course getCourse(@PathVariable String id) {
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
							@PathVariable String id) {
		service.updateCourse(id, course);
	}
	
	// DELETE ( Delete Course )
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteCourse(@PathVariable String id) {
		service.deleteCourse(id);
	}

	// GET ( Get All Courses by Student Id)
	@RequestMapping(method = RequestMethod.GET, value = "student/{id}")
	public List<Course> getStudentsByCourseId(@PathVariable String id) {
		return service.getCoursesByStudentId(id);
	}

}
