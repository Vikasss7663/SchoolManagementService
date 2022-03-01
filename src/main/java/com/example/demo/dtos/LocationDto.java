package com.example.demo.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}