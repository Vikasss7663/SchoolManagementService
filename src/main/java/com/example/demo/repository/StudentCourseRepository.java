package com.example.demo.repository;

import com.example.demo.model.StudentCourse;
import com.example.demo.model.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.example.demo.model.Course;
import com.example.demo.model.Student;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {


    @Query("SELECT c FROM Course c INNER JOIN StudentCourse sc ON c.courseId = sc.courseId WHERE sc.studentId = ?1")
    public List<Course> findCoursesByStudentId(String studentId);

    @Query("SELECT s FROM Student s INNER JOIN StudentCourse sc ON s.studentId = sc.studentId WHERE sc.courseId = ?1")
    public List<Student> findStudentsByCourseId(String courseId);


}
