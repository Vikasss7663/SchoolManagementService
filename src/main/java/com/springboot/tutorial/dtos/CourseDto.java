package com.springboot.tutorial.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CourseDto implements Serializable {

    @NotNull(message = "Course Id cannot be null")
    @NotEmpty
    private String courseId;
    
    @NotNull(message = "Course Name cannot be null")
    @NotEmpty
    private String courseName;
    
    @NotNull(message = "Semester should not be null")
    @Min(value = 1, message = "Semester should not be less than 1")
    @Max(value = 8, message = "Semester should not be greater than 8")
    private int courseSemester;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseSemester() {
        return courseSemester;
    }

    public void setCourseSemester(int courseSemester) {
        this.courseSemester = courseSemester;
    }
}
