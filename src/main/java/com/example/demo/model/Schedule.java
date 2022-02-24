package com.example.demo.model;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schedule {
    
    @Id
    private int scheduleId;
    private String weekDay;
    private Time startTime;
    private Time endTime;

    public int getScheduleId() {
        return this.scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getWeekDay() {
        return this.weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Time getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

}
