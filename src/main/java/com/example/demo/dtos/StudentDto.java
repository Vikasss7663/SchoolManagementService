package com.example.demo.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StudentDto {

    @NotNull(message = "Student Id cannot be null")
    @NotEmpty
    private String studentId;

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentSemester() {
        return studentSemester;
    }

    public void setStudentSemester(int studentSemester) {
        this.studentSemester = studentSemester;
    }

    public int getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(int studentYear) {
        this.studentYear = studentYear;
    }
}
