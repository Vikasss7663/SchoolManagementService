package com.springboot.tutorial.service;

import java.util.*;

import com.springboot.tutorial.dtos.CourseDto;

import com.springboot.tutorial.model.Course;
import com.springboot.tutorial.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<CourseDto> getCourses() {
        List<CourseDto> courseDtos = new ArrayList<>();
        courseRepository.findAll().forEach(it -> courseDtos.add(getCourseDtoInstance(it)));
        return courseDtos;
    }

    public List<CourseDto> getCoursesBySemester(int semester) {
        List<CourseDto> courseDtos = new ArrayList<>();
        courseRepository.findBycourseSemester(semester).forEach(it -> courseDtos.add(getCourseDtoInstance(it)));
        return courseDtos;
    }

    public CourseDto getCourse(String id) {
        return getCourseDtoInstance(courseRepository.findById(id).get());
    }

    public void addCourse(CourseDto courseDto) {
        Course course = getCourseInstanceFromDto(courseDto);
        courseRepository.save(course);
    }

    public void updateCourse(CourseDto courseDto) {
        Course course = getCourseInstanceFromDto(courseDto);
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    private Course getCourseInstanceFromDto(CourseDto courseDto) {
        Course course = new Course();
        course.setCourseId(courseDto.getCourseId());
        course.setCourseName(courseDto.getCourseName());
        course.setCourseSemester(courseDto.getCourseSemester());
        return course;
    }

    private CourseDto getCourseDtoInstance(Course course) {
        if(course == null) return new CourseDto();
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(course.getCourseId());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setCourseSemester(course.getCourseSemester());
        return courseDto;
    }

}