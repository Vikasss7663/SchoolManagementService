package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, String> {
    
    @Query("SELECT c FROM Course c INNER JOIN StudentCourse sc ON c.courseId = sc.courseId WHERE sc.studentId = ?1")
    public List<Course> findCoursesByStudentId(String studentId);

    @Query("SELECT c FROM Course c WHERE c.courseSemester = ?1")
    public List<Course> findCoursesBySemester(int courseSemester);

}
