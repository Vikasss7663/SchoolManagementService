package com.springboot.tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;


@Entity
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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseSemester() {
        return courseSemester;
    }

    public void setCourseSemester(int courseSemester) {
        this.courseSemester = courseSemester;
    }

}
