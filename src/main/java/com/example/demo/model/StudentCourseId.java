package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentCourseId implements Serializable{
    
    private String studentId;
    private String courseId;

}
