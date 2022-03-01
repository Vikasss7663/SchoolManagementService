package com.example.demo.model;

import javax.persistence.*;

@Entity
public class CourseTimeTable {

    @EmbeddedId
    private CourseTimeTableKey courseTimeTableKey;

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

    public CourseTimeTableKey getCourseTimeTableKey() {
        return courseTimeTableKey;
    }

    public void setCourseTimeTableKey(CourseTimeTableKey courseTimeTableKey) {
        this.courseTimeTableKey = courseTimeTableKey;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}