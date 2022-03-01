package com.example.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Student {

    @Id
    private String studentId;
    @Column(nullable = false)
    private String studentName;
    @Column(nullable = false)
    private int studentSemester;
    @Column(nullable = false)
    private int studentYear;

    @OneToMany(mappedBy = "student")
    private Set<CourseRegistration> courseRegistrations;

    public Student() {}

    public Student(String studentId, String studentName, int studentSemester, int studentYear) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSemester = studentSemester;
        this.studentYear = studentYear;
    }

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
