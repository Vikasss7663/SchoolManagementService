package com.example.demo;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CourseService {
    
    List<Course> courses = new ArrayList<>(
        Arrays.asList(
            new Course(1, "C Programming"),
            new Course(2, "Java Programming"),
            new Course(3, "Python Programming")
        )
    );

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourse(int id) {
        return courses.stream().filter(t -> t.getCourseId() == id)
                        .findFirst().get();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updateCourse(int id, Course course) {
        for(int i=0;i<courses.size();i++) {
            if(courses.get(i).getCourseId() == id) {
                courses.set(i, course);
                return;
            }
        }
    }

    public void deleteCourse(int id) {
        for(int i=0;i<courses.size();i++) {
            if(courses.get(i).getCourseId() == id) {
                courses.remove(i);
                return;
            }
        }
    }

}
