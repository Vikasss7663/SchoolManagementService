package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Schedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;
    @Column(nullable = false)
    private String weekDay;
    @Column(nullable = false)
    private String startTime;
    @Column(nullable = false)
    private String endTime;

    @OneToMany(mappedBy = "schedule")
    private Set<CourseTimeTable> courseTimeTables;

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

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Set<CourseTimeTable> getCourseTimeTables() {
        return this.courseTimeTables;
    }

    public void setCourseTimeTables(Set<CourseTimeTable> courseTimeTables) {
        this.courseTimeTables = courseTimeTables;
    }

}
