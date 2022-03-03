package com.springboot.tutorial.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;


@Entity
@Getter
@Setter
public class Course {

    @Id
    private String courseId;
    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
    private int courseSemester;

    @OneToMany(mappedBy = "course")
    private Set<Registration> registrations;

    @OneToMany(mappedBy = "course")
    private Set<TimeTable> timeTables;

    public Course() { }
    public Course(String courseId, String courseName, int courseSemester) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseSemester = courseSemester;
    }

}