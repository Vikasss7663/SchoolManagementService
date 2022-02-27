package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {

    @Id
    private String courseId;
    private String courseName;
    private int courseSemester;

    @OneToMany(mappedBy = "course")
    private Set<CourseRegistration> courseRegistrations;

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseCode(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseSemester() {
        return this.courseSemester;
    }

    public void setCourseSemester(int courseSemester) {
        this.courseSemester = courseSemester;
    }

}
