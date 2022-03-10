package com.springboot.tutorial.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column(nullable = false)
    private String studentName;
    @Column(nullable = false)
    private int studentSemester;
    @Column(nullable = false)
    private int studentYear;

    @OneToMany(mappedBy = "student")
    private Set<Registration> registrations;

    public Student() {}

    public Student(int studentId, String studentName, int studentSemester, int studentYear) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSemester = studentSemester;
        this.studentYear = studentYear;
    }

}
