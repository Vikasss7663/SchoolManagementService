package com.springboot.tutorial.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
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

}
