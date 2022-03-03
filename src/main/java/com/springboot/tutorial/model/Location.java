package com.springboot.tutorial.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
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
    private Set<TimeTable> timeTables;

}