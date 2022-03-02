package com.springboot.tutorial.dtos;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RegistrationDto implements Serializable {

    private int id;

    @NotNull
    private String courseId;

    @NotNull
    private String studentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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





