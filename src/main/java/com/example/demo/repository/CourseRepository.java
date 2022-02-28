package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {

    public List<Course> findBycourseSemester(int courseSemester);

}
