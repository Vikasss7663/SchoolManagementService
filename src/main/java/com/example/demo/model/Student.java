package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Student {
    
    @Id
    private String studentId;
    private String studentName;
    private int studentSemester;
    private int studentYear;

    @OneToMany(mappedBy = "student")
    private Set<CourseRegistration> courseRegistrations;

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentSemester() {
        return this.studentSemester;
    }

    public void setStudentSemester(int studentSemester) {
        this.studentSemester = studentSemester;
    }

    public int getStudentYear() {
        return this.studentYear;
    }

    public void setStudentYear(int studentYear) {
        this.studentYear = studentYear;
    }

}
