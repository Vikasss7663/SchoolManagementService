package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, String> {
    
    
    @Query("SELECT s FROM Student s WHERE s.studentSemester = ?1")
    public List<Student> findStudentsBySemester(int semester);

    @Query("SELECT s FROM Student s WHERE s.studentYear = ?1")
    public List<Student> findStudentsByYear(int year);
    
}
