package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RegistrationKey implements Serializable {

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "course_id")
    private String courseId;

    public RegistrationKey() {
    }

    public RegistrationKey(String courseId, String studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
