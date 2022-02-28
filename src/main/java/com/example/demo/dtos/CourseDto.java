package com.example.demo.dtos;

import com.example.demo.model.CourseRegistration;
import com.example.demo.model.CourseTimeTable;
import lombok.Data;

import java.util.Set;

@Data
public class CourseDto {
    private String courseName;
    private int courseSemester;
    private Set<CourseRegistration> courseRegistrations;
    private Set<CourseTimeTable> courseTimeTables;
}
