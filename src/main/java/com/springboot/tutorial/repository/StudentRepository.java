package com.springboot.tutorial.repository;

import java.util.List;

import com.springboot.tutorial.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    
    public List<Student> findBystudentSemester(int semester);

    public List<Student> findBystudentYear(int year);
    
}
