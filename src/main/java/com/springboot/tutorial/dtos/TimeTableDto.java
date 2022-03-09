package com.springboot.tutorial.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TimeTableDto {

    private int id;
    private int courseId;
    private int locationId;
    private int scheduleId;

}





