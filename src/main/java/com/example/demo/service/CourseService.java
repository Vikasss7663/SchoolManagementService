package com.example.demo.service;

import java.util.*;

import com.example.demo.model.Course;
import com.example.demo.model.CourseRegistration;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.CourseRegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getCoursesBySemester(int semester) {
        return courseRepository.findBycourseSemester(semester);
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(String id, Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getCoursesByStudentId(String studentId) {
        return courseRegistrationRepository.findCoursesByStudentId(studentId);
    }

    // TODO
    public void addStudent(CourseRegistration courseRegistration) {
        courseRegistrationRepository.save(courseRegistration);
    }

}
