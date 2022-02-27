package com.example.demo.repository;

import com.example.demo.model.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.example.demo.model.Course;
import com.example.demo.model.Student;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {

    @Query("SELECT c FROM Course c INNER JOIN StudentCourse sc ON c.courseId = sc.studentCourseId.courseId WHERE sc.studentCourseId.studentId = ?1")
    public List<Course> findCoursesByStudentId(String studentId);

    @Query("SELECT s FROM Student s INNER JOIN StudentCourse sc ON s.studentId = sc.studentCourseId.studentId WHERE sc.studentCourseId.courseId = ?1")
    public List<Student> findStudentsByCourseId(String courseId);

}
