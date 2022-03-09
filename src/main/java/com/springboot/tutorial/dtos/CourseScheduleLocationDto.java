package com.springboot.tutorial.dtos;


import lombok.Data;

@Data
public class CourseScheduleLocationDto {

    private int courseId;
    private String courseName;
    private String building;
    private String floor;
    private String room;
    private String weekDay;
    private String startTime;
    private String endTime;

}
