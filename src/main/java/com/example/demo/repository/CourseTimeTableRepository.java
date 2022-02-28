package com.example.demo.repository;

import com.example.demo.model.CourseTimeTable;
import com.example.demo.model.CourseTimeTableKey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTimeTableRepository extends JpaRepository<CourseTimeTable, CourseTimeTableKey> {
    
}
