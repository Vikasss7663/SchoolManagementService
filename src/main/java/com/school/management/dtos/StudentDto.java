package com.school.management.dtos;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class StudentDto {

    @NotNull
    private int studentId;

    @NotNull(message = "Student Name cannot be null")
    @NotEmpty
    private String studentName;

    @NotNull
    @Min(value = 1, message = "Student semester should not be less than 1")
    @Max(value = 8, message = "Student semester should not be greater than 8")
    private int studentSemester;

    @NotNull
    @Min(value = 1900, message = "Student semester should not be less than 1900")
    @Max(value = 2022, message = "Student semester should not be greater than 2022")
    private int studentYear;

    @NotNull
    private int schoolId;

    @NotNull
    @NotEmpty
    private String schoolName;

}