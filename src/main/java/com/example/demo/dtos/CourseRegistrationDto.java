package com.example.demo.dtos;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CourseRegistrationDto implements Serializable {

    @NotNull
    private String courseId;

    @NotNull
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

}





