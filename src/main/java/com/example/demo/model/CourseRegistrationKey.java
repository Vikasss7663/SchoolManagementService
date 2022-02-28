package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class CourseRegistrationKey implements Serializable{
    
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "course_id")
    private String courseId;

    public CourseRegistrationKey() {
    }

    public CourseRegistrationKey(String _studentId, String _courseId) {
        studentId = _studentId;
        courseId = _courseId;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

}
