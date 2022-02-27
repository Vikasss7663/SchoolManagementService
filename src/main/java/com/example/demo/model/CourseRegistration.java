package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CourseRegistration {

    @EmbeddedId
    private CourseRegistrationId courseRegistrationId;

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
    
    public CourseRegistration(CourseRegistrationId _courseRegistrationId) {
        courseRegistrationId = _courseRegistrationId;
    }
    
    public CourseRegistrationId getCourseRegistrationId() {
        return this.courseRegistrationId;
    }

    public void setCourseRegistrationId(CourseRegistrationId courseRegistrationId) {
        this.courseRegistrationId = courseRegistrationId;
    }

}





