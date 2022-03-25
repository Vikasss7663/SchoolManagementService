package com.school.management.repository;

import java.util.List;

import com.school.management.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findBycourseSemester(int courseSemester);

}
