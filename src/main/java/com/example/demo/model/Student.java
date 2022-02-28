package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Student {
    @Id
    private UUID studentId;
    @Column(nullable = false)
    private String studentName;
    @Column(nullable = false)
    private int studentSemester;
    @Column(nullable = false)
    private int studentYear;

    @OneToMany(mappedBy = "student")
    private Set<CourseRegistration> courseRegistrations;
}
