package com.springboot.tutorial.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TimeTableDto {

    private int id;
    @NotNull
    @NotEmpty
    private String courseId;
    private int locationId;
    private int scheduleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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





