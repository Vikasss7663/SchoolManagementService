package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CourseTimeTableId implements Serializable {
   
    private String courseId;
    private int locationId;
    private int scheduleId;

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getLocationId() {
        return this.locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getScheduleId() {
        return this.scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

}
