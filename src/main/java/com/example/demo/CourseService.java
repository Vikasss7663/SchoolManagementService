package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;
    
    List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        repository.findAll().forEach(courses::add);
        return courses;
    }

    public Course getCourse(int id) {
        return repository.findById(id).get();
    }

    public void addCourse(Course course) {
        repository.save(course);
    }

    public void updateCourse(int id, Course course) {
        repository.save(course);
    }

    public void deleteCourse(int id) {
        repository.deleteById(id);
    }

}
