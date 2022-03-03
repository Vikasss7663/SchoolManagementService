package com.springboot.tutorial.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LocationDto {

    private int locationId;
    @NotNull(message = "Building should not be null")
    @NotEmpty
    private String building;
    @NotNull(message = "Floor should not be null")
    @NotEmpty
    private String floor;
    @NotNull(message = "Room should not be null")
    @NotEmpty
    private String room;

}