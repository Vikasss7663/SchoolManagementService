package com.example.demo.repository;

import com.example.demo.model.Registration;
import com.example.demo.model.RegistrationKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.example.demo.model.Course;
import com.example.demo.model.Student;

public interface RegistrationRepository extends JpaRepository<Registration, RegistrationKey> {

    @Query("SELECT c FROM Course c INNER JOIN Registration r " +
            "ON c.courseId = r.registrationKey.courseId " +
            "WHERE r.registrationKey.studentId = ?1")
    List<Course> findCoursesByStudentId(String studentId);

    @Query("SELECT s FROM Student s INNER JOIN Registration r " +
            "ON s.studentId = r.registrationKey.studentId " +
            "WHERE r.registrationKey.courseId = ?1")
    List<Student> findStudentsByCourseId(String courseId);

}
