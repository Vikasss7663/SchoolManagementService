package com.springboot.tutorial.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class RegistrationDto {

    private int id;

    @NotNull(message = "Course Id can not be null")
    @NotEmpty
    private String courseId;

    @NotNull(message = "Student Id can not be null")
    @NotEmpty
    private String studentId;

}





