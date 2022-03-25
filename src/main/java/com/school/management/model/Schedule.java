package com.school.management.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Schedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;
    @Column(nullable = false)
    private String weekDay;
    @Column(nullable = false)
    private String startTime;
    @Column(nullable = false)
    private String endTime;

    @OneToMany(mappedBy = "schedule")
    private Set<TimeTable> timeTables;

}
