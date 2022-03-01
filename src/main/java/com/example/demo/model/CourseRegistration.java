package com.example.demo.model;

import javax.persistence.*;


@Entity
public class CourseRegistration {

    @EmbeddedId
    private CourseRegistrationKey courseRegistrationKey;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    public CourseRegistrationKey getCourseRegistrationKey() {
        return courseRegistrationKey;
    }

    public void setCourseRegistrationKey(CourseRegistrationKey courseRegistrationKey) {
        this.courseRegistrationKey = courseRegistrationKey;
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





