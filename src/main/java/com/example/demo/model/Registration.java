package com.example.demo.model;

import javax.persistence.*;


@Entity
public class Registration {

    @EmbeddedId
    private RegistrationKey registrationKey;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    public RegistrationKey getRegistrationKey() {
        return registrationKey;
    }

    public void setRegistrationKey(RegistrationKey registrationKey) {
        this.registrationKey = registrationKey;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}





