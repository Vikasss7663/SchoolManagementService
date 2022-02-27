package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

public class CourseTmeTable {

    @EmbeddedId
    private CourseTimeTableId courseTimeTableId;

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


    public CourseTimeTableId getCourseTimeTableId() {
        return this.courseTimeTableId;
    }

    public void setCourseTimeTableId(CourseTimeTableId courseTimeTableId) {
        this.courseTimeTableId = courseTimeTableId;
    }

    
}