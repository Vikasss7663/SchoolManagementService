package com.springboot.tutorial.repository;

import java.util.List;

import com.springboot.tutorial.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findBycourseSemester(int courseSemester);

}
