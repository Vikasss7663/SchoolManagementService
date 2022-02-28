package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Student;
import com.example.demo.model.CourseRegistration;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    // Dependency Injection - Singleton
	@Autowired
	private StudentService service;
    
	// GET ( Get All Students )
	@RequestMapping(method = RequestMethod.GET)
	public List<Student> getStudents() {
		return new ArrayList<Student>(service.getStudents());
	}

	// GET ( Get All Students By Semester )
	@RequestMapping(method = RequestMethod.GET, value = "semester={semester}")
	public List<Student> getStudentsBySemester(@PathVariable int semester) {
		return new ArrayList<Student>(service.getStudentsBySemester(semester));
	}	

	// GET ( Get All Students By Year )
	@RequestMapping(method = RequestMethod.GET, value = "year={year}")
	public List<Student> getStudentsByYear(@NonNull @PathVariable int year) {
		return new ArrayList<Student>(service.getStudentsByYear(year));
	}

	// GET ( Get All Students by Course Id)
	@RequestMapping(method = RequestMethod.GET, value = "course/{id}")
	public List<Student> getStudentsByCourseId(@PathVariable String id) {
		return service.getStudentsByCourseId(id);
	}

	// GET ( Get Student by Id)
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Student getStudent(@PathVariable String id) {
		return service.getStudent(id);
	}	

	// POST ( Add Student )
	@RequestMapping(method = RequestMethod.POST)
	public void addStudent(@RequestBody Student student) {
		service.addStudent(student);
	}

	// POST ( Add Course )
	@RequestMapping(method = RequestMethod.POST, value = "course")
	public void addCourse(@RequestBody CourseRegistration courseRegistration) {
		service.addCourse(courseRegistration);
	}
	
	// PUT ( Update Student )
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public void updateStudent(@RequestBody Student student,
							@PathVariable int id) {
		service.updateStudent(id, student);
	}
	
	// DELETE ( Delete Student )
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteStudent(@PathVariable String id) {
		service.deleteStudent(id);
	}

    
}