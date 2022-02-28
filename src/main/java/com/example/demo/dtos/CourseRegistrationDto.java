package com.example.demo.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CourseRegistrationDto {
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10, message = "Student ID must be 10 characters")
    private String studentId;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10, message = "Course ID must be 10 characters")
    private String courseId;
}





