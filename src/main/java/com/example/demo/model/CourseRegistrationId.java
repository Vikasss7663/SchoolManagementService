package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class CourseRegistrationId implements Serializable{
    
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "course_id")
    private String courseId;

    public CourseRegistrationId() {
    }

    public CourseRegistrationId(String _studentId, String _courseId) {
        studentId = _studentId;
        courseId = _courseId;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object obj)
    {

        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;
          
        CourseRegistrationId studentCourseId = (CourseRegistrationId) obj;
        
        return (studentCourseId.courseId.equals(this.courseId) && 
                studentCourseId.studentId.equals(this.studentId));

    }

}
