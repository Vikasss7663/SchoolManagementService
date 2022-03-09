package com.springboot.tutorial.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campaign_seq_gen")
    @SequenceGenerator(name = "campaign_seq_gen", sequenceName = "seq_course", allocationSize = 10)
    private int courseId;
    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
    private int courseSemester;

    @OneToMany(mappedBy = "course")
    private Set<Registration> registrations;

    @OneToMany(mappedBy = "course")
    private Set<TimeTable> timeTables;

    public Course() { }

    public Course(int courseId, String courseName, int courseSemester) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseSemester = courseSemester;
    }

}
