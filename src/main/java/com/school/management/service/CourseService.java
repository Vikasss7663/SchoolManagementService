package com.school.management.service;

import java.util.*;

import com.school.management.dtos.CourseDto;
import com.school.management.repository.CourseRepository;
import com.school.management.model.Course;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @CircuitBreaker(name = "courseService", fallbackMethod = "getCoursesFallback")
    public List<CourseDto> getCourses() {
        List<CourseDto> courseDtos = new ArrayList<>();
        courseRepository.findAll().forEach(it -> courseDtos.add(getCourseDtoInstance(it)));
        return courseDtos;
    }

    @CircuitBreaker(name = "courseService", fallbackMethod = "getCourseBySemesterFallback")
    public List<CourseDto> getCoursesBySemester(int semester) {
        List<CourseDto> courseDtos = new ArrayList<>();
        courseRepository.findBycourseSemester(semester).forEach(it -> courseDtos.add(getCourseDtoInstance(it)));
        return courseDtos;
    }

    @CircuitBreaker(name = "courseService", fallbackMethod = "getCourseFallback")
    public CourseDto getCourse(int id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(this::getCourseDtoInstance).orElseGet(CourseDto::new);
    }

    @CircuitBreaker(name = "courseService", fallbackMethod = "addCourseFallback")
    public ResponseEntity<String> addCourse(CourseDto courseDto) {
        Course course = getCourseInstanceFromDto(courseDto);
        courseRepository.save(course);
        return new ResponseEntity<>("Course Added", HttpStatus.OK);
    }

    @CircuitBreaker(name = "courseService", fallbackMethod = "updateCourseFallback")
    public ResponseEntity<String> updateCourse(CourseDto courseDto) {
        Course course = getCourseInstanceFromDto(courseDto);
        courseRepository.save(course);
        return new ResponseEntity<>("Course Updated", HttpStatus.OK);
    }

    @CircuitBreaker(name = "courseService", fallbackMethod = "deleteCourseFallback")
    public ResponseEntity<String> deleteCourse(int id) {
        courseRepository.deleteById(id);
        return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
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

    public List<CourseDto> getCoursesFallback(Exception e) {
        return Arrays.asList(
                new CourseDto(1, "Dummy Course - 1", 8),
                new CourseDto(2, "Dummy Course - 2", 8),
                new CourseDto(3, "Dummy Course - 3", 8)
        );
    }

    public List<CourseDto> getCourseBySemesterFallback(Exception e) {
        return Arrays.asList(
                new CourseDto(1, "Dummy Course By Semester", 1)
        );
    }

    public CourseDto getCourseFallback(Exception e) {
        return new CourseDto(1, "Dummy Course By Id", 2);
    }

    public ResponseEntity<String> addCourseFallback(Exception e) {
        return new ResponseEntity<>("Course Not Added", HttpStatus.OK);
    }

    public ResponseEntity<String> updateCourseFallback(Exception e) {
        return new ResponseEntity<>("Course Not Updated", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteCourseFallback(Exception e) {
        return new ResponseEntity<>("Course Not Deleted", HttpStatus.OK);
    }

}
