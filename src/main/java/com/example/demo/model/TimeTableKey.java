package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TimeTableKey implements Serializable {

    @Column(name = "course_id")
    private String courseId;
    @Column(name = "location_id")
    private int locationId;
    @Column(name = "schedule_id")
    private int scheduleId;

    public TimeTableKey() { }

    public TimeTableKey(String courseId, int locationId, int scheduleId) {
        this.courseId = courseId;
        this.locationId = locationId;
        this.scheduleId = scheduleId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
}
