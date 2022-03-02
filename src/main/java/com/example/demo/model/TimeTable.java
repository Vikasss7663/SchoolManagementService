package com.example.demo.model;

import javax.persistence.*;

@Entity
public class TimeTable {

    @EmbeddedId
    private TimeTableKey timeTableKey;

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

    public TimeTableKey getCourseTimeTableKey() {
        return timeTableKey;
    }

    public void setCourseTimeTableKey(TimeTableKey timeTableKey) {
        this.timeTableKey = timeTableKey;
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