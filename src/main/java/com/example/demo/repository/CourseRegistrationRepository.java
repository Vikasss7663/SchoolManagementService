package com.example.demo.repository;

import com.example.demo.model.CourseRegistration;
import com.example.demo.model.CourseRegistrationKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.example.demo.model.Course;
import com.example.demo.model.Student;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, CourseRegistrationKey> {

    @Query("SELECT c FROM Course c INNER JOIN CourseRegistration cr " +
            "ON c.courseId = cr.courseRegistrationKey.courseId " +
            "WHERE cr.courseRegistrationKey.studentId = ?1")
    List<Course> findCoursesByStudentId(String studentId);

    @Query("SELECT s FROM Student s INNER JOIN CourseRegistration cr " +
            "ON s.studentId = cr.courseRegistrationKey.studentId " +
            "WHERE cr.courseRegistrationKey.courseId = ?1")
    List<Student> findStudentsByCourseId(String courseId);

}
