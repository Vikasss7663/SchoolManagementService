package com.school.management.repository;

import com.school.management.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    @Query(value = "SELECT c.course_id, c.course_name, c.course_semester FROM course as c " +
            "INNER JOIN registration as r ON c.course_id = r.course_id WHERE r.student_id = ?1", nativeQuery = true)
    List<Tuple> findCoursesByStudentId(String studentId);

    @Query(value = "SELECT s.student_id, s.student_name, s.student_semester, s.student_year FROM student as s " +
            "INNER JOIN registration as r ON s.student_id = r.student_id WHERE r.course_id = ?1", nativeQuery = true)
    List<Tuple> findStudentsByCourseId(String courseId);

}
