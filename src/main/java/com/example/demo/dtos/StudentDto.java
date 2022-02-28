package com.example.demo.dtos;

import com.example.demo.model.CourseRegistration;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class StudentDto {
    @NotNull(message = "Student Name cannot be null")
    private String studentName;

    @NotNull
    @Min(value = 1, message = "Student semester should not be less than 1")
    @Max(value = 8, message = "Student semester should not be greater than 8")
    private int studentSemester;

    @NotNull
    @Min(value = 1900, message = "Student semester should not be less than 1900")
    @Max(value = 2022, message = "Student semester should not be greater than 2022")
    private int studentYear;

    private Set<CourseRegistration> courseRegistrations;
}
