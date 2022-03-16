package com.springboot.tutorial.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private int courseId;
    
    @NotNull(message = "Course Name cannot be null")
    @NotEmpty
    private String courseName;
    
    @NotNull(message = "Semester should not be null")
    @Min(value = 1, message = "Semester should not be less than 1")
    @Max(value = 8, message = "Semester should not be greater than 8")
    private int courseSemester;

}
