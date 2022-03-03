package com.springboot.tutorial.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TimeTableDto {

    private int id;
    @NotNull(message = "Course Id can not be null")
    @NotEmpty
    private String courseId;
    private int locationId;
    private int scheduleId;

}





