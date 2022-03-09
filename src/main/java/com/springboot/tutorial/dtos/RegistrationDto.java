package com.springboot.tutorial.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class RegistrationDto {

    private int id;

    private int courseId;

    private int studentId;

}





