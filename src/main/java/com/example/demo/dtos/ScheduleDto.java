package com.example.demo.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ScheduleDto {

    private int scheduleId;
    @NotNull(message = "Week Day should not be null")
    @NotEmpty
    private String weekDay;
    @NotNull(message = "Start Time should not be null")
    @NotEmpty
    private String startTime;
    @NotNull(message = "End Time should not be null")
    @NotEmpty
    private String endTime;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
