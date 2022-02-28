package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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

    public CourseRegistration() {
    }
    
    public CourseRegistration(CourseRegistrationKey _courseRegistrationKey) {
        courseRegistrationKey = _courseRegistrationKey;
    }
    
    public CourseRegistrationKey getCourseRegistrationKey() {
        return this.courseRegistrationKey;
    }

    public void setCourseRegistrationKey(CourseRegistrationKey courseRegistrationKey) {
        this.courseRegistrationKey = courseRegistrationKey;
    }

}





