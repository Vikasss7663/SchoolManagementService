package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {

    @Id
    private String courseId;
    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
    private int courseSemester;

    @OneToMany(mappedBy = "course")
    private Set<CourseRegistration> courseRegistrations;

    @OneToMany(mappedBy = "course")
    private Set<CourseTimeTable> courseTimeTables;  

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

    public Set<CourseRegistration> getCourseRegistrations() {
        return this.courseRegistrations;
    }

    public void setCourseRegistrations(Set<CourseRegistration> courseRegistrations) {
        this.courseRegistrations = courseRegistrations;
    }

    public Set<CourseTimeTable> getCourseTimeTables() {
        return this.courseTimeTables;
    }

    public void setCourseTimeTables(Set<CourseTimeTable> courseTimeTables) {
        this.courseTimeTables = courseTimeTables;
    } 

}
