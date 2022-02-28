package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CourseRegistrationKey implements Serializable {
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "course_id")
    private String courseId;
}
