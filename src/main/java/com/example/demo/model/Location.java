package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;
    @Column(nullable = false)
    private String building;
    @Column(nullable = false)
    private String floor;
    @Column(nullable = false)
    private String room;

    @OneToMany(mappedBy = "location")
    private Set<CourseTimeTable> courseTimeTables; 

    public int getLocationId() {
        return this.locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getBuilding() {
        return this.building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return this.floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Set<CourseTimeTable> getCourseTimeTables() {
        return this.courseTimeTables;
    }

    public void setCourseTimeTables(Set<CourseTimeTable> courseTimeTables) {
        this.courseTimeTables = courseTimeTables;
    }

}