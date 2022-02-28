package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CourseTimeTable {

    @EmbeddedId
    private CourseTimeTableKey courseTimeTableId;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @MapsId("locationId")
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @MapsId("scheduleId")
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;


    public CourseTimeTableKey getCourseTimeTableId() {
        return this.courseTimeTableId;
    }

    public void setCourseTimeTableId(CourseTimeTableKey courseTimeTableId) {
        this.courseTimeTableId = courseTimeTableId;
    }

    
}